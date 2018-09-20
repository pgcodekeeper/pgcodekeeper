package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_assemblyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Assembly_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.TableAbstract;
import cz.startnet.utils.pgdiff.schema.MsAssembly;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class AlterMsAssembly extends TableAbstract {

    private final Alter_assemblyContext ctx;

    public AlterMsAssembly(Alter_assemblyContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        MsAssembly assembly = getSafe(db::getAssembly, ctx.name);

        List<Assembly_optionContext> options = ctx.assembly_option();
        if (options != null) {
            for (Assembly_optionContext option : options) {
                if (option.VISIBILITY() != null) {
                    assembly.setVisible(option.ON() != null);
                }
            }
        }

        return null;
    }
}
