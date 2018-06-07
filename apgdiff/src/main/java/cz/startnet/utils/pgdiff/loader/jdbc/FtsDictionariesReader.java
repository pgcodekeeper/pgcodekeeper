package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.SQLException;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgFtsDictionary;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class FtsDictionariesReader extends JdbcReader {

    public static class FtsDictionariesReaderFactory extends JdbcReaderFactory {

        public FtsDictionariesReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
            super(hasHelperMask, helperFunction, queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new FtsDictionariesReader(this, loader);
        }
    }

    protected FtsDictionariesReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSetWrapper res, PgSchema schema)
            throws SQLException, WrapperAccessException {
        String name = res.getString("dictname");
        PgFtsDictionary dic = new PgFtsDictionary(name, "");

        String options = res.getString("dictinitoption");
        if (options != null) {
            ParserAbstract.fillOptionParams(options.replace(" = ", "=").split(", "), dic::addOption, false, false, true);
        }

        loader.setOwner(dic, res.getLong("dictowner"));

        String tmplname = res.getString("tmplname");
        String templateSchema = res.getString(NAMESPACE_NSPNAME);
        dic.setTemplate(templateSchema + '.' + tmplname);
        dic.addDep(new GenericColumn(templateSchema, tmplname, DbObjType.FTS_TEMPLATE));

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
