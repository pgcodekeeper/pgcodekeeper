package cz.startnet.utils.pgdiff.schema;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgForeignDataWrapper extends PgStatement implements PgForeignOptionContainer{
    private String handler;
    private String validator;
    private final Map<String, String> options = new LinkedHashMap<>();

    public PgForeignDataWrapper(String name) {
        super(name);
    }

    @Override
    public String getAlterHeader() {
        return "\n\nALTER FOREIGN DATA WRAPPER " + getQualifiedName();
    }

    @Override
    public Map<String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public void addOption(String key, String value) {
        options.put(key, value);
        resetHash();
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
        resetHash();
    }

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {
        this.validator = validator;
        resetHash();
    }

    @Override
    protected String getTypeName() {
        return "FOREIGN DATA WRAPPER";
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FOREIGN_DATA_WRAPPER;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(handler);
        hasher.put(validator);
        hasher.put(options);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgForeignDataWrapper && super.compare(obj)) {
            PgForeignDataWrapper FDataWrap = (PgForeignDataWrapper) obj;
            return Objects.equals(handler, FDataWrap.getHandler())
                    && Objects.equals(validator, FDataWrap.getValidator())
                    && Objects.equals(options, FDataWrap.getOptions());
        }
        return false;
    }

    @Override
    public PgDatabase getDatabase() {
        return (PgDatabase)getParent();
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CREATE FOREIGN DATA WRAPPER ");
        sb.append(PgDiffUtils.getQuotedName(getName()));
        if (getHandler() != null) {
            sb.append(" HANDLER ").append(getHandler());
        }
        if (getValidator() != null) {
            sb.append(" VALIDATOR ").append(getValidator());
        }
        if (!options.isEmpty()) {
            sb.append(" OPTIONS (");
            for (Entry <String, String> entry : options.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                sb.append(PgDiffUtils.getQuotedName(key))
                .append(' ')
                .append(value)
                .append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(")");
        }
        sb.append(";");

        appendOwnerSQL(sb);

        if (comment != null && !comment.isEmpty()) {
            sb.append("\n\n");
            appendCommentSql(sb);
        }
        return sb.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP FOREIGN DATA WRAPPER " + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgForeignDataWrapper newForeign = (PgForeignDataWrapper) newCondition;

        if (!Objects.equals(newForeign.getHandler(), getHandler())) {
            sb.append(getAlterHeader());
            sb.append(" HANDLER ").append(newForeign.getHandler())
            .append(';');
        }

        if (!Objects.equals(newForeign.getValidator(), getValidator())) {
            sb.append(getAlterHeader());
            sb.append(" VALIDATOR ").append(newForeign.getValidator())
            .append(';');
        }

        if (!Objects.equals(newForeign.getOptions(), getOptions())) {
            compareOptions(newForeign, sb);
        }

        if (!Objects.equals(newForeign.getOwner(), getOwner())) {
            newForeign.appendOwnerSQL(sb);
        }

        if (!Objects.equals(newForeign.getComment(), getComment())) {
            sb.append("\n\n");
            newForeign.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    @Override
    public PgStatement shallowCopy() {
        PgForeignDataWrapper copyFwd = new PgForeignDataWrapper(getName());
        copyBaseFields(copyFwd);
        copyFwd.setHandler(getHandler());
        copyFwd.setValidator(getValidator());
        copyFwd.options.putAll(options);
        return copyFwd;
    }
}
