package cz.startnet.utils.pgdiff.formatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLLexer;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Character_stringContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_funct_paramsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_actions_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_createContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;

public class FileFormatter {

    private final int start;
    private final int stop;

    private final FormatConfiguration config;

    public FileFormatter(int offset, int lenght, FormatConfiguration config) {
        this.start = offset;
        this.stop = offset + lenght;
        this.config = config;
    }

    public List<FormatItem> formatString(String source, boolean isMsSql) {
        if (isMsSql) {
            return Collections.emptyList();
        }

        List<FormatItem> changes = new ArrayList<>();

        Lexer lexer = new SQLLexer(new ANTLRInputStream(source));
        SQLParser parser = new SQLParser(new CommonTokenStream(lexer));

        SqlContext root = parser.sql();
        for (StatementContext st : root.statement()) {
            if (start <= st.stop.getStopIndex() || st.start.getStartIndex() < stop) {
                fillChanges(st, changes);
            }
        }

        return changes;
    }

    private void fillChanges(StatementContext st, List<FormatItem> changes) {
        Schema_statementContext schema = st.schema_statement();
        if (schema == null) {
            return;
        }

        Schema_createContext create = schema.schema_create();
        if (create == null) {
            return;
        }

        Create_function_statementContext function = create.create_function_statement();
        if (function == null) {
            return;
        }

        Create_funct_paramsContext body = function.create_funct_params();
        if (body == null) {
            return;
        }

        String language = null;
        Function_defContext funcDef = null;

        for (Function_actions_commonContext action : body.function_actions_common()) {
            if (action.LANGUAGE() != null) {
                language = action.lang_name.getText();
            } else if (action.AS() != null) {
                funcDef = action.function_def();
            }
        }

        if ((!"PLPGSQL".equalsIgnoreCase(language) && !"SQL".equalsIgnoreCase(language)) || funcDef == null) {
            return;
        }

        String definition;
        List<Character_stringContext> funcContent = funcDef.character_string();

        TerminalNode codeStart = funcContent.get(0).Character_String_Literal();
        if (codeStart != null) {
            // TODO support special escaping schemes (maybe in the util itself)
            definition = PgDiffUtils.unquoteQuotedString(codeStart.getText());
        } else {
            List<TerminalNode> dollarText = funcContent.get(0).Text_between_Dollar();
            codeStart = dollarText.get(0);
            definition = dollarText.stream().map(TerminalNode::getText).collect(Collectors.joining());
        }

        StatementFormatter sf = new StatementFormatter(start, stop, config);
        sf.parseDefsToFormat(definition, language, codeStart.getSymbol().getStartIndex());
        changes.addAll(sf.getChanges());
    }
}