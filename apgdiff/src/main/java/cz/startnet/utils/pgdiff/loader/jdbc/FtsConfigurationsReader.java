package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgFtsConfiguration;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class FtsConfigurationsReader extends JdbcReader {

    public FtsConfigurationsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_FTS_CONFIGURATIONS, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String name = res.getString("cfgname");
        PgFtsConfiguration config = new PgFtsConfiguration(name);

        String parserSchema = res.getString("prsnspname");
        String parserName = res.getString("prsname");
        config.setParser(PgDiffUtils.getQuotedName(parserSchema) + '.' + PgDiffUtils.getQuotedName(parserName));
        config.addDep(new GenericColumn(parserSchema, parserName, DbObjType.FTS_PARSER));

        String[] fragments = getColArray(res, "tokennames");
        String[] dictSchemas = getColArray(res, "dictschemas");
        String[] dictionaries = getColArray(res, "dictnames");

        if (fragments != null) {
            Map<String, List<String>> dictMap = new HashMap<>();

            for (int i = 0; i < fragments.length; i ++) {
                String fragment = fragments[i];
                String dictSchema = dictSchemas[i];
                String dictName = dictionaries[i];

                if (!ApgdiffConsts.PG_CATALOG.equals(dictSchema)) {
                    config.addDep(new GenericColumn(dictSchema, dictName, DbObjType.FTS_DICTIONARY));
                }

                String dName = PgDiffUtils.getQuotedName(dictSchema) + '.'
                        + PgDiffUtils.getQuotedName(dictName);

                dictMap.computeIfAbsent(fragment, k -> new ArrayList<>()).add(dName);
            }

            dictMap.forEach(config::addDictionary);
        }

        loader.setOwner(config, res.getLong("cfgowner"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            config.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        loader.setAuthor(config, res);
        schema.addFtsConfiguration(config);
    }
}
