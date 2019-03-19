package cz.startnet.utils.pgdiff.schema;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgFtsDictionary extends PgStatementWithSearchPath
implements PgOptionContainer {

    private String template;
    private final Map<String, String> options = new LinkedHashMap<>();

    public PgFtsDictionary(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FTS_DICTIONARY;
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema)getParent();
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSql = new StringBuilder();
        sbSql.append("CREATE TEXT SEARCH DICTIONARY ")
        .append(getQualifiedName());
        sbSql.append(" (\n\tTEMPLATE = ").append(template);

        options.forEach((k,v) -> sbSql.append(",\n\t").append(k).append(" = ").append(v));
        sbSql.append(" );");

        appendOwnerSQL(sbSql);

        if (comment != null && !comment.isEmpty()) {
            sbSql.append("\n\n");
            appendCommentSql(sbSql);
        }

        return sbSql.toString();
    }

    @Override
    protected StringBuilder appendCommentSql(StringBuilder sb) {
        sb.append("COMMENT ON TEXT SEARCH DICTIONARY ");
        sb.append(getQualifiedName());
        return sb.append(" IS ")
                .append(comment == null || comment.isEmpty() ? "NULL" : comment)
                .append(';');
    }

    @Override
    public String getDropSQL() {
        return "DROP TEXT SEARCH DICTIONARY " + getQualifiedName() + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgFtsDictionary newDictionary;
        if (newCondition instanceof PgFtsDictionary) {
            newDictionary = (PgFtsDictionary) newCondition;
            if (!newDictionary.getTemplate().equals(template)) {
                isNeedDepcies.set(true);
                return true;
            }
        } else {
            return false;
        }

        compareOptions(newDictionary, sb);

        if (!Objects.equals(getComment(), newCondition.getComment())) {
            sb.append("\n\n");
            newCondition.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    @Override
    public void appendOptions(PgOptionContainer newContainer, StringBuilder setOptions,
            StringBuilder resetOptions, StringBuilder sb) {
        sb.append("\n\nALTER TEXT SEARCH DICTIONARY ");
        sb.append(getQualifiedName());
        sb.append("\n\t(");

        if (setOptions.length() > 0) {
            sb.append(setOptions);
        }

        if (resetOptions.length() > 0) {
            sb.append(resetOptions);
        }

        sb.setLength(sb.length() - 2);
        sb.append(");");
    }

    public void setTemplate(final String template) {
        this.template = template;
        resetHash();
    }

    public String getTemplate() {
        return template;
    }

    @Override
    public void addOption(String option, String value) {
        options.put(option, value);
        resetHash();
    }

    @Override
    public Map<String, String> getOptions() {
        return options;
    }

    @Override
    public PgFtsDictionary shallowCopy() {
        PgFtsDictionary dictDst = new PgFtsDictionary(getName());
        copyBaseFields(dictDst);
        dictDst.setTemplate(getTemplate());
        dictDst.options.putAll(options);
        return dictDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgFtsDictionary && super.compare(obj)) {
            PgFtsDictionary dictionary = (PgFtsDictionary) obj;
            return Objects.equals(template, dictionary.template)
                    && options.equals(dictionary.options);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(template);
        hasher.put(options);
    }
}
