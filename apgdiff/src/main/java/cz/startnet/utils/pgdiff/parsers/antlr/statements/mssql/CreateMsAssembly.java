package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Locale;
import java.util.regex.Pattern;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Assembly_permissionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_assemblyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.MsAssembly;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateMsAssembly extends ParserAbstract {

    private static final Pattern BINARY_NEWLINE = Pattern.compile("\\\\\\r?\\n");
    private static final int BINARY_LINE_LENGTH = 256;

    private final Create_assemblyContext ctx;

    public CreateMsAssembly(Create_assemblyContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        MsAssembly ass = new MsAssembly(ctx.assembly_name.getText(), getFullCtxText(ctx.getParent()));
        IdContext owner = ctx.owner_name;
        if (owner != null) {
            ass.setOwner(owner.getText());
        }

        for (ExpressionContext binary : ctx.expression()) {
            ass.addBinary(formatBinary(getFullCtxText(binary)));
        }

        Assembly_permissionContext permission = ctx.assembly_permission();
        if (permission != null) {
            ass.setPermission(getFullCtxText(permission).toUpperCase());
        }

        db.addAssembly(ass);
        return ass;
    }

    public static String formatBinary(String hex) {
        if (!hex.startsWith("0x")) {
            return hex;
        }
        hex = hex.toLowerCase(Locale.ENGLISH);
        if (hex.indexOf('\\') != -1) {
            hex = BINARY_NEWLINE.matcher(hex).replaceAll("");
        }
        StringBuilder sb = new StringBuilder(hex.length() + hex.length()/(BINARY_LINE_LENGTH/2));
        sb.append("0x");
        int i = 2;
        do {
            int end = i + BINARY_LINE_LENGTH;
            if (end > hex.length()) {
                end = hex.length();
            }
            sb.append(hex, i, end)
            .append("\\\n");
            i = end;
        } while (i < hex.length());
        // remove trailing newline
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}
