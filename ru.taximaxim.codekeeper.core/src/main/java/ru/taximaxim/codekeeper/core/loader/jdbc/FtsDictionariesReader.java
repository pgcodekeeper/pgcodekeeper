package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgFtsDictionary;

public class FtsDictionariesReader extends JdbcReader {

    public FtsDictionariesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_FTS_DICTIONARIES, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String name = res.getString("dictname");
        PgFtsDictionary dic = new PgFtsDictionary(name);

        String options = res.getString("dictinitoption");
        if (options != null) {
            ParserAbstract.fillOptionParams(options.replace(" = ", "=").split(", "), dic::addOption, false, false, true);
        }

        loader.setOwner(dic, res.getLong("dictowner"));

        String tmplname = res.getString("tmplname");
        String templateSchema = res.getString("tmplnspname");

        if (!Utils.isPgSystemSchema(templateSchema)) {
            dic.addDep(new GenericColumn(templateSchema, tmplname, DbObjType.FTS_TEMPLATE));
        }

        dic.setTemplate(PgDiffUtils.getQuotedName(templateSchema) + '.'
                + PgDiffUtils.getQuotedName(tmplname));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            dic.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        loader.setAuthor(dic, res);
        schema.addFtsDictionary(dic);
    }

    @Override
    protected String getClassId() {
        return "pg_ts_dict";
    }
}
