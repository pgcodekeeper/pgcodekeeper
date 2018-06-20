package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgFtsConfiguration;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class FtsConfigurationsReader extends JdbcReader {

    public static class FtsConfigurationsReaderFactory extends JdbcReaderFactory {

        public FtsConfigurationsReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
            super(hasHelperMask, helperFunction, queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new FtsConfigurationsReader(this, loader);
        }
    }

    protected FtsConfigurationsReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSetWrapper res, PgSchema schema)
            throws SQLException, WrapperAccessException {
        String name = res.getString("cfgname");
        PgFtsConfiguration config = new PgFtsConfiguration(name, "");

        String parserSchema = res.getString("prsnspname");
        String parserName = res.getString("prsname");
        config.setParser(PgDiffUtils.getQuotedName(parserSchema) + '.' + PgDiffUtils.getQuotedName(parserName));
        config.addDep(new GenericColumn(parserSchema, parserName, DbObjType.FTS_PARSER));

        String[] fragments = res.getArray("tokennames", String.class);
        String[] dictSchemas = res.getArray("dictschemas", String.class);
        String[] dictionaries = res.getArray("dictnames", String.class);

        if (fragments != null) {
            Map<String, List<String>> dictMap = new HashMap<>();

            for (int i = 0; i < fragments.length; i ++) {
                String fragment = fragments[i];
                String dictSchema = dictSchemas[i];
                String dictName = dictionaries[i];

                List<String> dicts = dictMap.get(fragment);
                if (dicts == null) {
                    dicts = new ArrayList<>();
                    dictMap.put(fragment, dicts);
                }
                dicts.add(PgDiffUtils.getQuotedName(dictSchema) + '.' + PgDiffUtils.getQuotedName(dictName));

                config.addDep(new GenericColumn(dictSchema, dictName, DbObjType.FTS_DICTIONARY));
            }

            dictMap.forEach(config::addDictionary);
        }

        loader.setOwner(config, res.getLong("cfgowner"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            config.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        schema.addFtsConfiguration(config);
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.FTS_CONFIGURATION;
    }
}
