package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgFtsConfiguration extends PgStatementWithSearchPath {

    private String parser;
    /**key - fragment, value - dictionaries */
    private final Map<String, List<String>> dictionariesMap = new HashMap<>();


    public PgFtsConfiguration(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FTS_CONFIGURATION;
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)getParent();
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sbSql = new StringBuilder();
        sbSql.append("CREATE TEXT SEARCH CONFIGURATION ").append(getQualifiedName()).append(" (\n\t");
        sbSql.append("PARSER = ").append(parser).append(" );");

        dictionariesMap.forEach((fragment, dictionaries) -> {
            sbSql.append("\n\nALTER TEXT SEARCH CONFIGURATION ").append(getQualifiedName());
            sbSql.append("\n\tADD MAPPING FOR ").append(fragment)
            .append("\n\tWITH ").append(String.join(", ", dictionaries)).append(";");
        });

        appendOwnerSQL(sbSql);

        if (comment != null && !comment.isEmpty()) {
            sbSql.append("\n\n");
            appendCommentSql(sbSql);
        }

        return sbSql.toString();
    }

    @Override
    protected StringBuilder appendCommentSql(StringBuilder sb) {
        sb.append("COMMENT ON TEXT SEARCH CONFIGURATION ");
        sb.append(PgDiffUtils.getQuotedName(getName()));
        return sb.append(" IS ").append(comment).append(';');
    }

    @Override
    protected StringBuilder appendOwnerSQL(StringBuilder sb) {
        return owner == null ? sb
                : sb.append("\n\nALTER TEXT SEARCH CONFIGURATION ").append(getQualifiedName())
                .append(" OWNER TO ").append(PgDiffUtils.getQuotedName(owner)).append(';');
    }

    @Override
    public String getDropSQL() {
        return "DROP TEXT SEARCH CONFIGURATION " + getQualifiedName() + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgFtsConfiguration newConf;
        if (newCondition instanceof PgFtsConfiguration) {
            newConf = (PgFtsConfiguration) newCondition;
            if (!newConf.getParser().equals(parser)) {
                isNeedDepcies.set(true);
                return true;
            }
        } else {
            return false;
        }

        if (!Objects.equals(getComment(), newCondition.getComment())) {
            sb.append("\n\n");
            newCondition.appendCommentSql(sb);
        }

        compareOptions(newConf, sb);
        return sb.length() > startLength;
    }

    public void compareOptions(PgFtsConfiguration newConf, StringBuilder sb) {
        Map <String, List<String>> oldMap = dictionariesMap;
        Map <String, List<String>> newMap = newConf.dictionariesMap;

        if (oldMap.isEmpty() && newMap.isEmpty()) {
            return;
        }

        oldMap.forEach((fragment, dictionaries) -> {
            List<String> newDictionaries = newMap.get(fragment);

            if (newDictionaries == null) {
                sb.append("\n\nALTER TEXT SEARCH CONFIGURATION ").append(getQualifiedName())
                .append("\n\tDROP MAPPING FOR ").append(fragment).append(';');
            } else if (!dictionaries.equals(newDictionaries)) {
                sb.append("\n\nALTER TEXT SEARCH CONFIGURATION ").append(getQualifiedName())
                .append("\n\tALTER MAPPING FOR ").append(fragment)
                .append("\n\tWITH ").append(String.join(", ", newDictionaries)).append(";");
            }
        });

        newMap.forEach((fragment, dictionaries) -> {
            if (!oldMap.containsKey(fragment)) {
                sb.append("\n\nALTER TEXT SEARCH CONFIGURATION ").append(getQualifiedName())
                .append("\n\tADD MAPPING FOR ").append(fragment)
                .append("\n\tWITH ").append(String.join(", ", dictionaries)).append(";");
            }
        });
    }

    @Override
    public PgFtsConfiguration shallowCopy() {
        PgFtsConfiguration conf = new PgFtsConfiguration(getName(), getRawStatement());
        conf.setComment(getComment());
        conf.setParser(getParser());
        conf.deps.addAll(deps);
        conf.setOwner(getOwner());
        conf.dictionariesMap.putAll(getDictionariesMap());
        return conf;
    }

    @Override
    public PgFtsConfiguration deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if(obj instanceof PgFtsConfiguration) {
            PgFtsConfiguration config = (PgFtsConfiguration) obj;
            eq = Objects.equals(name, config.name)
                    && Objects.equals(parser, config.getParser())
                    && Objects.equals(owner, config.getOwner())
                    && Objects.equals(comment, config.getComment())
                    && Objects.equals(dictionariesMap, config.dictionariesMap);
        }

        return eq;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((parser == null) ? 0 : parser.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + dictionariesMap.hashCode();
        return result;
    }

    public String getParser() {
        return parser;
    }

    public void setParser(final String parser) {
        this.parser = parser;
        resetHash();
    }

    public void addDictionary(String fragment, String dictionary) {
        List<String> dictionaries = dictionariesMap.get(fragment);
        if (dictionaries == null) {
            dictionaries = new ArrayList<>();
            dictionariesMap.put(fragment, dictionaries);
        }
        dictionaries.add(dictionary);
        resetHash();
    }

    public Map<String, List<String>> getDictionariesMap() {
        return dictionariesMap;
    }
}
