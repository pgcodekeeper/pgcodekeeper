package cz.startnet.utils.pgdiff.schema;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgFtsDictionary extends PgStatementWithSearchPath
implements PgOptionContainer {

    private String template;
    private final Map<String, String> options = new LinkedHashMap<>();

    public PgFtsDictionary(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FTS_DICTIONARY;
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)getParent();
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSql = new StringBuilder();
        sbSql.append("CREATE TEXT SEARCH DICTIONARY ").append(getQualifiedName());
        sbSql.append(" (\n\tTEMPLATE = ").append(template);

        for (Map.Entry<String, String> entry : options.entrySet()) {
            sbSql.append(",\n\t").append(entry.getKey()).append(" = ").append(entry.getValue());
        }

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
        sb.append(PgDiffUtils.getQuotedName(getName()));
        return sb.append(" IS ")
                .append(comment == null || comment.isEmpty() ? "NULL" : comment)
                .append(';');
    }

    @Override
    protected StringBuilder appendOwnerSQL(StringBuilder sb) {
        return owner == null ? sb
                : sb.append("\n\nALTER TEXT SEARCH DICTIONARY ").append(getQualifiedName())
                .append(" OWNER TO ").append(PgDiffUtils.getQuotedName(owner)).append(';');
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
        PgFtsDictionary dictionary = new PgFtsDictionary(getName(), getRawStatement());
        dictionary.setComment(getComment());
        dictionary.setTemplate(getTemplate());
        dictionary.options.putAll(getOptions());
        dictionary.deps.addAll(deps);
        dictionary.setOwner(getOwner());
        return dictionary;
    }

    @Override
    public PgFtsDictionary deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if(obj instanceof PgFtsDictionary) {
            PgFtsDictionary dictionary = (PgFtsDictionary) obj;
            eq = Objects.equals(name, dictionary.name)
                    && Objects.equals(template, dictionary.template)
                    && Objects.equals(owner, dictionary.getOwner())
                    && Objects.equals(comment, dictionary.getComment())
                    && Objects.equals(options, dictionary.getOptions());
        }

        return eq;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(owner);
        hasher.put(template);
        hasher.put(options);
        hasher.put(comment);
    }
}
