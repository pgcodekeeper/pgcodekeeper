package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgFtsDictionary;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class FtsDictionariesReader extends JdbcReader {

    public FtsDictionariesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_FTS_DICTIONARIES_PER_SCHEMA, loader);
    }

    @Override
    protected void processResult(ResultSet res, PgSchema schema) throws SQLException {
        String name = res.getString("dictname");
        PgFtsDictionary dic = new PgFtsDictionary(name, "");

        String options = res.getString("dictinitoption");
        if (options != null) {
            ParserAbstract.fillOptionParams(options.replace(" = ", "=").split(", "), dic::addOption, false, false, true);
        }

        loader.setOwner(dic, res.getLong("dictowner"));

        String tmplname = res.getString("tmplname");
        String templateSchema = res.getString("tmplnspname");

        if ("pg_catalog".equals(templateSchema)) {
            dic.setTemplate(PgDiffUtils.getQuotedName(tmplname));
        } else {
            if (schema.getName().equals(templateSchema)) {
                dic.setTemplate(PgDiffUtils.getQuotedName(tmplname));
            } else {
                dic.setTemplate(PgDiffUtils.getQuotedName(templateSchema) + '.' + PgDiffUtils.getQuotedName(tmplname));
            }
            dic.addDep(new GenericColumn(templateSchema, tmplname, DbObjType.FTS_TEMPLATE));
        }

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            dic.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        schema.addFtsDictionary(dic);
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.FTS_DICTIONARY;
    }
}
