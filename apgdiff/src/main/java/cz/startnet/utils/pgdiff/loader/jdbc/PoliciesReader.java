package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgEventType;
import cz.startnet.utils.pgdiff.schema.PgPolicy;
import cz.startnet.utils.pgdiff.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PoliciesReader extends JdbcReader {

    public PoliciesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_POLICIES, loader);
    }

    @Override
    protected void processResult(ResultSet result, AbstractSchema schema) throws SQLException {
        String contName = result.getString(CLASS_RELNAME);
        PgStatementContainer c = schema.getStatementContainer(contName);
        if (c != null) {
            c.addPolicy(getPolicy(result, schema, contName));
        }
    }

    private PgPolicy getPolicy(ResultSet res, AbstractSchema schema, String tableName) throws SQLException {
        String schemaName = schema.getName();
        String policyName = res.getString("polname");
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, policyName, DbObjType.POLICY));

        PgPolicy p = new PgPolicy(policyName);

        switch (res.getString("polcmd")) {
        case "r":
            p.setEvent(PgEventType.SELECT);
            break;
        case "w":
            p.setEvent(PgEventType.UPDATE);
            break;
        case "a":
            p.setEvent(PgEventType.INSERT);
            break;
        case "d":
            p.setEvent(PgEventType.DELETE);
            break;
        }

        String[] roles = getColArray(res, "polroles");
        if (roles != null) {
            for (String role : roles) {
                p.addRole(role);
            }
        }

        if (SupportedVersion.VERSION_10.isLE(loader.version)) {
            p.setPermissive(res.getBoolean("polpermissive"));
        }

        PgDatabase db = schema.getDatabase();

        String using = res.getString("polqual");
        if (using != null) {
            p.setUsing('(' + using + ')');
            loader.submitAntlrTask(using, parser -> parser.vex_eof().vex().get(0),
                    ctx -> db.addAnalysisLauncher(new VexAnalysisLauncher(p, ctx, loader.getCurrentLocation())));
        }

        String check = res.getString("polwithcheck");
        if (check != null) {
            p.setCheck('(' + check + ')');
            loader.submitAntlrTask(check, parser -> parser.vex_eof().vex().get(0),
                    ctx -> db.addAnalysisLauncher(new VexAnalysisLauncher(p, ctx, loader.getCurrentLocation())));
        }

        loader.setAuthor(p, res);

        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            p.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        return p;
    }
}
