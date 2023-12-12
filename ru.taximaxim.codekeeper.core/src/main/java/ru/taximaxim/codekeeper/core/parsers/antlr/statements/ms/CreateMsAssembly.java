/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Assembly_permissionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Create_assemblyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.ms.MsAssembly;

public class CreateMsAssembly extends MsParserAbstract {

    private static final Pattern BINARY_NEWLINE = Pattern.compile("\\\\\\r?\\n");
    private static final int BINARY_LINE_LENGTH = 256;

    private final Create_assemblyContext ctx;

    public CreateMsAssembly(Create_assemblyContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdContext nameCtx = ctx.assembly_name;
        MsAssembly ass = new MsAssembly(ctx.assembly_name.getText());
        IdContext owner = ctx.owner_name;
        if (owner != null && !db.getArguments().isIgnorePrivileges()) {
            ass.setOwner(owner.getText());
        }

        for (ExpressionContext binary : ctx.expression()) {
            ass.addBinary(formatBinary(getFullCtxText(binary)));
        }

        Assembly_permissionContext permission = ctx.assembly_permission();
        if (permission != null) {
            ass.setPermission(getFullCtxText(permission).toUpperCase(Locale.ROOT));
        }

        addSafe(db, ass, Arrays.asList(nameCtx));
    }

    public static String formatBinary(String hex) {
        if (!hex.startsWith("0x")) {
            return hex;
        }
        hex = hex.toLowerCase(Locale.ROOT);
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

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.ASSEMBLY, ctx.assembly_name);
    }
}
