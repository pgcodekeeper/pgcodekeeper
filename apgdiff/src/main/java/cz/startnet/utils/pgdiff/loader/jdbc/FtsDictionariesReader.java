package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgFtsDictionary;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

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

        if (ApgdiffConsts.PG_CATALOG.equals(templateSchema)) {
            dic.setTemplate(PgDiffUtils.getQuotedName(tmplname));
        } else {
            dic.setTemplate(PgDiffUtils.getQuotedName(templateSchema) + '.'
                    + PgDiffUtils.getQuotedName(tmplname));
            dic.addDep(new GenericColumn(templateSchema, tmplname, DbObjType.FTS_TEMPLATE));
        }

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            dic.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        loader.setAuthor(dic, res);
        schema.addFtsDictionary(dic);
    }
}
