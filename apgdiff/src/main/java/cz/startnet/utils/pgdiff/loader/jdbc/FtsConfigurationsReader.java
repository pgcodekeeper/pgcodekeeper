package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.SQLException;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
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

        String parserSchema = res.getString(NAMESPACE_NSPNAME);
        String parserName = res.getString("prsname");
        config.setParser(parserSchema + '.' + parserName);
        config.addDep(new GenericColumn(parserSchema, parserName, DbObjType.FTS_PARSER));

        String[] fragments = res.getArray("tokennames", String.class);
        String[] dictionaries = res.getArray("dictnames", String.class);

        if (fragments != null) {
            for (int i = 0; i < fragments.length; i ++) {
                String dict = dictionaries[i];
                QNameParser parser = new QNameParser(dict);

                String dictSchema = parser.getSchemaName("pg_catalog");
                config.addDictionary(fragments[i], dict);
                config.addDep(new GenericColumn(dictSchema, parser.getFirstName(), DbObjType.FTS_DICTIONARY));
            }
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
