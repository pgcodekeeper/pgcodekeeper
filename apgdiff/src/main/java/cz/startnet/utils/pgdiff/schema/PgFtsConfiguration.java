package cz.startnet.utils.pgdiff.schema;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgFtsConfiguration extends PgStatementWithSearchPath {

    private static final String ALTER_CONFIGURATION = "\n\nALTER TEXT SEARCH CONFIGURATION ";

    private String parser;
    /**key - fragment, value - dictionaries */
    private final Map<String, String> dictionariesMap = new HashMap<>();


    public PgFtsConfiguration(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FTS_CONFIGURATION;
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema)getParent();
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sbSql = new StringBuilder();
        sbSql.append("CREATE TEXT SEARCH CONFIGURATION ")
        .append(getQualifiedName()).append(" (\n\t");
        sbSql.append("PARSER = ").append(parser).append(" );");

        dictionariesMap.forEach((fragment, dictionaries) -> {
            sbSql.append(ALTER_CONFIGURATION).append(getQualifiedName());
            sbSql.append("\n\tADD MAPPING FOR ").append(fragment)
            .append("\n\tWITH ").append(dictionaries).append(";");
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
        sb.append(getQualifiedName());
        return sb.append(" IS ").append(comment).append(';');
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

        compareOptions(newConf, sb);

        if (!Objects.equals(getOwner(), newConf.getOwner())) {
            newConf.alterOwnerSQL(sb);
        }

        if (!Objects.equals(getComment(), newCondition.getComment())) {
            sb.append("\n\n");
            newCondition.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    public void compareOptions(PgFtsConfiguration newConf, StringBuilder sb) {
        Map <String, String> oldMap = dictionariesMap;
        Map <String, String> newMap = newConf.dictionariesMap;

        if (oldMap.isEmpty() && newMap.isEmpty()) {
            return;
        }

        oldMap.forEach((fragment, dictionaries) -> {
            String newDictionaries = newMap.get(fragment);

            if (newDictionaries == null) {
                sb.append(ALTER_CONFIGURATION)
                .append(getQualifiedName())
                .append("\n\tDROP MAPPING FOR ").append(fragment).append(';');
            } else if (!dictionaries.equals(newDictionaries)) {
                sb.append(ALTER_CONFIGURATION)
                .append(getQualifiedName())
                .append("\n\tALTER MAPPING FOR ").append(fragment)
                .append("\n\tWITH ").append(newDictionaries).append(";");
            }
        });

        newMap.forEach((fragment, dictionaries) -> {
            if (!oldMap.containsKey(fragment)) {
                sb.append(ALTER_CONFIGURATION)
                .append(getQualifiedName())
                .append("\n\tADD MAPPING FOR ").append(fragment)
                .append("\n\tWITH ").append(dictionaries).append(";");
            }
        });
    }

    @Override
    public PgFtsConfiguration shallowCopy() {
        PgFtsConfiguration confDst = new PgFtsConfiguration(getName());
        copyBaseFields(confDst);
        confDst.setParser(getParser());
        confDst.dictionariesMap.putAll(dictionariesMap);
        return confDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgFtsConfiguration && super.compare(obj)) {
            PgFtsConfiguration config = (PgFtsConfiguration) obj;
            return Objects.equals(parser, config.getParser())
                    && dictionariesMap.equals(config.dictionariesMap);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(parser);
        hasher.put(dictionariesMap);
    }

    public String getParser() {
        return parser;
    }

    public void setParser(final String parser) {
        this.parser = parser;
        resetHash();
    }

    public void addDictionary(String fragment, List<String> dictionaries) {
        dictionariesMap.put(fragment, String.join(", ", dictionaries));
        resetHash();
    }

    public Map<String, String> getDictionariesMap() {
        return Collections.unmodifiableMap(dictionariesMap);
    }
}
