/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffScript;
import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Stores column information.
 *
 * @author fordfrog
 */
public class PgColumn extends PgStatementWithSearchPath {

    private static final Pattern PATTERN_NULL = Pattern.compile(
            "^(.+)[\\s]+NULL$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN_NOT_NULL = Pattern.compile(
            "^(.+)[\\s]+NOT[\\s]+NULL$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN_DEFAULT = Pattern.compile(
            "^(.+)[\\s]+DEFAULT[\\s]+(.+)$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN_SEQUENCE = Pattern.compile(
            "^(?:nextval|setval)\\('(?:(?<schema>[\\w&&[^0-9]]\\w*|\"[^\"]+\")\\s*\\.\\s*)?"
            + "(?:(?<seq>[\\w&&[^0-9]]\\w*|\"[^\"]+\"))'(?:[\\s]*::[\\s]*[\\w]+)\\)$",
            Pattern.CASE_INSENSITIVE);
    private static final String ALTER_TABLE = "ALTER TABLE ";
    private static final String ALTER_COLUMN = "\n\tALTER COLUMN ";
    
    private Integer statistics;
    private String defaultValue;
    private String type;
    private boolean nullValue = true;
    private String storage;
    private List<GenericColumn> functions = new ArrayList<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.COLUMN;
    }
    
    public PgColumn(String name) {
        super(name, null);
    }

    public void setDefaultValue(final String defaultValue) {
        this.defaultValue = defaultValue;
        resetHash();
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * Returns full definition of the column.
     *
     * @param addDefaults whether default value should be added in case NOT NULL
     *                    constraint is specified but no default value is set
     *
     * @return full definition of the column
     */
    public String getFullDefinition(final boolean addDefaults, 
            StringBuilder separateDefault) {
        final StringBuilder sbDefinition = new StringBuilder();
        
        String cName = PgDiffUtils.getQuotedName(name);
        sbDefinition.append(cName);
        sbDefinition.append(' ');
        sbDefinition.append(type);

        if (defaultValue != null && !defaultValue.isEmpty()) {
            StringBuilder sbDefault = sbDefinition;
            if (separateDefault != null && nullValue) {
                sbDefault = separateDefault;
                sbDefault.append(cName);
                sbDefault.append(" SET");
            }
            sbDefault.append(" DEFAULT ");
            sbDefault.append(defaultValue);
        } else if (!nullValue && addDefaults) {
            final String defaultColValue = PgColumnUtils.getDefaultValue(type);

            if (defaultColValue != null) {
                sbDefinition.append(" DEFAULT ");
                sbDefinition.append(defaultColValue);
            }
        }

        if (!nullValue) {
            sbDefinition.append(" NOT NULL");
        }

        return sbDefinition.toString();
    }

    public void setNullValue(final boolean nullValue) {
        this.nullValue = nullValue;
        resetHash();
    }

    public boolean getNullValue() {
        return nullValue;
    }

    public void setStatistics(final Integer statistics) {
        this.statistics = statistics;
        resetHash();
    }

    public Integer getStatistics() {
        return statistics;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(final String storage) {
        this.storage = storage;
        resetHash();
    }

    public void setType(final String type) {
        this.type = type;
        resetHash();
    }

    public String getType() {
        return type;
    }

    public void addFunction(GenericColumn func) {
        this.functions.add(func);
    }
    
    public List<GenericColumn> getFunction() {
       return functions; 
    }

    public void parseDefinition(final String definition, StringBuilder seqName) {
        String string = definition;

        Matcher matcher = PATTERN_NOT_NULL.matcher(string);

        if (matcher.matches()) {
            string = matcher.group(1).trim();
            setNullValue(false);
        } else {
            matcher = PATTERN_NULL.matcher(string);

            if (matcher.matches()) {
                string = matcher.group(1).trim();
                setNullValue(true);
            }
        }

        matcher = PATTERN_DEFAULT.matcher(string);

        if (matcher.matches()) {
            string = matcher.group(1).trim();
            String seqNameStr = parseSequence(matcher.group(2).trim());
            if (seqNameStr != null && !seqNameStr.isEmpty()) {
                seqName.append(seqNameStr);
            }
            setDefaultValue(matcher.group(2).trim());
        }

        setType(string);
    }
    
    public String parseSequence(String definition) {
        Matcher seqMatcher = PATTERN_SEQUENCE.matcher(definition);
        if (seqMatcher.matches()) {
            return seqMatcher.group("schema") == null ? 
                    seqMatcher.group("seq") : seqMatcher.group("schema") + "." + seqMatcher.group("seq");
        }
        return null;
    }
    
    @Override
    public String getCreationSQL() {
        StringBuilder defaultStatement = new StringBuilder();
        StringBuilder sbSQL = new StringBuilder();
        sbSQL.append(getAlterTable())
                .append("\n\tADD COLUMN ")
                .append(getFullDefinition(false, defaultStatement))
                .append(';');
        if (defaultStatement.length() > 0) {
            sbSQL.append("\n\n")
                    .append(getAlterTable())
                    .append(ALTER_COLUMN)
                    .append(defaultStatement)
                    .append(';');
        }
        appendPrivileges(sbSQL);
        
        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }
        return sbSQL.toString();
    }

    private String getAlterTable() {
        return ALTER_TABLE + this.getParent().getName();
    }
    
    @Override
    public String getDropSQL() {
        return getAlterTable() + "\n\tDROP COLUMN "
                + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgColumn newColumn;
        if (newCondition instanceof PgColumn) {
            newColumn = (PgColumn) newCondition;
        } else {
            return false;
        }
        PgDiffScript script = new PgDiffScript();
        PgColumn oldColumn = this;
        final Integer oldStat = oldColumn.getStatistics();
        final Integer newStat = newColumn.getStatistics();
        Integer newStatValue = null;

        if (newStat != null && (oldStat == null || !newStat.equals(oldStat))) {
            newStatValue = newStat;
        } else if (oldStat != null && newStat == null) {
            newStatValue = Integer.valueOf(-1);
        }

        if (newStatValue != null) {
            script.addStatement(ALTER_TABLE + "ONLY "
                    + PgDiffUtils.getQuotedName(this.getParent().getName())
                    + ALTER_COLUMN + PgDiffUtils.getQuotedName(getName())
                    + " SET STATISTICS " + newStatValue + ';');
        }
        final String oldStorage =
                (oldColumn.getStorage() == null ||oldColumn.getStorage().isEmpty()) ?
                        null : oldColumn.getStorage();
        final String newStorage =
                (newColumn.getStorage() == null || newColumn .getStorage().isEmpty()) ?
                        null : newColumn.getStorage();

        if (newStorage == null && oldStorage != null) {
            script.addStatement(MessageFormat.format(
                    Messages.Storage_WarningUnableToDetermineStorageType,
                    newColumn.getParent().getName(), newColumn.getName()));
        }

        if (newStorage != null && !newStorage.equalsIgnoreCase(oldStorage)) {
            script.addStatement(ALTER_TABLE
                    + "ONLY "
                    + PgDiffUtils.getQuotedName(newColumn.getParent().getName())
                    + ALTER_COLUMN
                    + PgDiffUtils.getQuotedName(newColumn.getName())
                    + " SET STORAGE " + newStorage + ';');
        }

        if (!oldColumn.getType().equals(newColumn.getType())) {
            isNeedDepcies.set(true);

            script.addStatement(getAlterTable()
                    + ALTER_COLUMN
                    + newColumn.getName()
                    + " TYPE "
                    + newColumn.getType()
                    + "; /* "
                    + MessageFormat.format(Messages.Table_TypeParameterChange,
                            newColumn.getParent().getName(),
                            oldColumn.getType(), newColumn.getType()) + " */");
        }

        final String oldDefault = (oldColumn.getDefaultValue() == null) ? ""
                : oldColumn.getDefaultValue();
        final String newDefault = (newColumn.getDefaultValue() == null) ? ""
                : newColumn.getDefaultValue();

        if (!oldDefault.equals(newDefault)) {
            if (newDefault.isEmpty()) {
                script.addStatement(getAlterTable() + ALTER_COLUMN
                        + newColumn.getName() + " DROP DEFAULT;");
            } else {
                script.addStatement(getAlterTable() + ALTER_COLUMN
                        + newColumn.getName() + " SET DEFAULT " + newDefault
                        + ';');
                // Если колонка изменила, только если присутсвуют ссылки на
                // функцию, иначе она не будет создаваться перед изменением
                // колонки
                if (!newColumn.functions.isEmpty()) {
                    isNeedDepcies.set(true);
                }
            }
        }

        if (oldColumn.getNullValue() != newColumn.getNullValue()) {
            if (newColumn.getNullValue()) {
                script.addStatement(getAlterTable() + ALTER_COLUMN
                        + newColumn.getName() + " DROP NOT NULL;");
            } else {
                script.addStatement(getAlterTable() + ALTER_COLUMN
                        + newColumn.getName() + " SET NOT NULL;");
            }
        }
        
        if (!oldColumn.getGrants().equals(newColumn.getGrants())
                || !oldColumn.getRevokes().equals(newColumn.getRevokes())) {
            script.addStatement(newColumn.getPrivilegesSQL());
        }
        
        PgDiff.diffComments(oldColumn, newColumn, script);
        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        script.printStatements(writer);
        sb.append(diffInput.toString().trim());
        return sb.length() > startLength;
    }
    
    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;
        
        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgColumn) {
            PgColumn col = (PgColumn) obj;
            
            eq = Objects.equals(name, col.getName())
                    && Objects.equals(type, col.getType())
                    && nullValue == col.getNullValue()
                    && Objects.equals(defaultValue, col.getDefaultValue())
                    && Objects.equals(statistics, col.getStatistics())
                    && Objects.equals(storage, col.getStorage())
                    && Objects.equals(comment, col.getComment())
                    && grants.equals(col.grants)
                    && revokes.equals(col.revokes);
        }
        
        return eq;
    }
    
    @Override
    public int computeHash() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + ((defaultValue == null) ? 0 : defaultValue.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (nullValue ? itrue : ifalse);
        result = prime * result + ((statistics == null) ? 0 : statistics.hashCode());
        result = prime * result + ((storage == null) ? 0 : storage.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((grants == null) ? 0 : grants.hashCode());
        result = prime * result + ((revokes == null) ? 0 : revokes.hashCode());
        return result;
    }
    
    @Override
    public PgColumn shallowCopy() {
        PgColumn colDst = new PgColumn(getName()); 
        colDst.setDefaultValue(getDefaultValue());
        colDst.setNullValue(getNullValue());
        colDst.setStatistics(getStatistics());
        colDst.setStorage(getStorage());
        colDst.setType(getType());
        colDst.setComment(getComment());
        for (PgPrivilege priv : grants) {
            colDst.addPrivilege(priv.shallowCopy());
        }
        for (PgPrivilege priv : revokes) {
            colDst.addPrivilege(priv.shallowCopy());
        }
        for (GenericColumn f : functions) {
            colDst.addFunction(f);
        }
        return colDst;
    }
    
    @Override
    public PgColumn deepCopy() {
        return shallowCopy();
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent().getParent();
    }

}
