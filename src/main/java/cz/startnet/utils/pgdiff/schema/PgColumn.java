/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Stores column information.
 *
 * @author fordfrog
 */
public class PgColumn extends PgStatement {

    private static final Pattern PATTERN_NULL = Pattern.compile(
            "^(.+)[\\s]+NULL$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN_NOT_NULL = Pattern.compile(
            "^(.+)[\\s]+NOT[\\s]+NULL$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN_DEFAULT = Pattern.compile(
            "^(.+)[\\s]+DEFAULT[\\s]+(.+)$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN_SEQUENCE = Pattern.compile(
            "^(nextval|setval)\\('(.+)'::.+\\)$", Pattern.CASE_INSENSITIVE);
    
    private Integer statistics;
    private String defaultValue;
    private String type;
    private boolean nullValue = true;
    private String storage;
    private String comment;

    public PgColumn(String name) {
        super(name, null);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
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
        final StringBuilder sbDefinition = new StringBuilder(100);
        
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
            return seqMatcher.group(2).trim();
        }
        return null;
    }
    
    @Override
    public String getCreationSQL() {
        return null;
    }
    
    @Override
    public String getFullCreationSQL() {
        return null;
    }
    
    @Override
    public String getDropSQL() {
        return null;
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
                    && Objects.equals(storage, col.getStorage());
        }
        
        return eq;
    }
    
    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((defaultValue == null) ? 0 : defaultValue.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (nullValue ? 1231 : 1237);
        result = prime * result + ((statistics == null) ? 0 : statistics.hashCode());
        result = prime * result + ((storage == null) ? 0 : storage.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        return colDst;
    }
    
    @Override
    public PgColumn deepCopy() {
        return shallowCopy();
    }
}
