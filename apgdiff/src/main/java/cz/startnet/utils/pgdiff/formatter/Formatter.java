package cz.startnet.utils.pgdiff.formatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.formatter.Formatter.IndentDirection;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLLexer;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Case_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Character_stringContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_funct_paramsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.DeclarationsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Exception_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_actions_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_blockContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.If_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Loop_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_createContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;

public class Formatter {

    enum IndentDirection {
        REDUCE, INCREACE, REDUCE_AND_INCREACE, REDUCE_TWICE
    }

    private final List<FormatItem> changes = new ArrayList<>();

    private final int start;
    private final int stop;

    private boolean removeTrailingWhitespace;
    private boolean addWhitespaceBeforeOp;
    private boolean addWhitespaceAfterOp;

    private int whitespaceCount = -1;
    private int indentSize;

    public Formatter(int offset, int lenght) {
        this.start = offset;
        this.stop = offset + lenght;
    }

    public List<FormatItem> getChanges() {
        return changes;
    }

    public void setRemoveTrailingWhitespace(boolean removeTrailingWhitespace) {
        this.removeTrailingWhitespace = removeTrailingWhitespace;
    }

    public void setWhitespaceCount(int whitespaceCount) {
        this.whitespaceCount  = whitespaceCount;
    }

    public void setAddWhitespaceBeforeOp(boolean addWhitespaceBeforeOp) {
        this.addWhitespaceBeforeOp = addWhitespaceBeforeOp;
    }

    public void setAddWhitespaceAfterOp(boolean addWhitespaceAfterOp) {
        this.addWhitespaceAfterOp = addWhitespaceAfterOp;
    }

    public void setIndentSize(int indentSize) {
        this.indentSize = indentSize;
    }

    public void formatString(String source, boolean isMsSql) {

        if (isMsSql) {
            return;
        }

        Lexer lexer = new SQLLexer(new ANTLRInputStream(source));
        SQLParser parser = new SQLParser(new CommonTokenStream(lexer));

        SqlContext root = parser.sql();
        for (StatementContext st : root.statement()) {
            if (st.stop.getStopIndex() > start || st.start.getStartIndex() < stop) {
                fillFunction(st);
            }
        }
    }

    private void fillFunction(StatementContext st) {
        Schema_statementContext schema = st.schema_statement();
        if (schema == null) {
            return;
        }

        Schema_createContext create = schema.schema_create();
        if (create == null) {
            return;
        }

        Create_function_statementContext function = create.create_function_statement();
        if (function == null || function.PROCEDURE() != null) {
            return;
        }

        Create_funct_paramsContext body = function.funct_body;
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

        if (!"PLPGSQL".equalsIgnoreCase(language) || funcDef == null ) {
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

        parseDefsToFormat(definition, codeStart.getSymbol().getStartIndex());
    }

    private void parseDefsToFormat(String definition, int offset) {
        Map<Token, IndentDirection> indents = new HashMap<>();

        Lexer lexer = new SQLLexer(new ANTLRInputStream(definition));
        CommonTokenStream stream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(stream);
        parser.addParseListener(new CustomParseTreeListener(indents));
        parser.plpgsql_function();

        List<Token> tokens = stream.getTokens();
        List<FormatItem> tabs = new ArrayList<>();

        int currentIndent = 0;
        int spaceSize = 0;
        FormatItem space = null;
        boolean needSpace = false;
        boolean firstTokenInLine = true;

        for (Token t : tokens) {
            int tokenStart = offset + t.getStartIndex();
            int lenght = t.getText().length();
            int type = t.getType();

            if (type == SQLLexer.Tab) {
                if (whitespaceCount >= 0) {
                    FormatItem item = new FormatItem(tokenStart, lenght,
                            String.format("%1$" + whitespaceCount + 's', ""));
                    if (removeTrailingWhitespace) {
                        tabs.add(item);
                    } else {
                        addChange(item);
                    }

                    spaceSize += whitespaceCount;
                } else {
                    spaceSize++;
                }

                space = appendSpace(space, tokenStart, lenght);
            } else if (type == SQLLexer.Space) {
                space = appendSpace(space, tokenStart, lenght);
                spaceSize++;
            } else if (type == SQLLexer.New_Line) {
                if (space != null && removeTrailingWhitespace) {
                    space.setText("");
                    addChange(space);
                    tabs.clear();
                }
                spaceSize = 0;
                space = null;
                firstTokenInLine = true;
            }

            if (type == SQLLexer.Tab || type == SQLLexer.Space || type == SQLLexer.New_Line) {
                needSpace = false;
                continue;
            }

            IndentDirection direction = indents.get(t);
            if (direction != null) {
                switch (direction) {
                case INCREACE:
                    writeIndent(firstTokenInLine, currentIndent++, spaceSize, tokenStart);
                    break;
                case REDUCE:
                    writeIndent(firstTokenInLine, --currentIndent, spaceSize, tokenStart);
                    break;
                case REDUCE_TWICE:
                    currentIndent = currentIndent - 2;
                    writeIndent(firstTokenInLine, currentIndent, spaceSize, tokenStart);
                    break;
                case REDUCE_AND_INCREACE:
                    writeIndent(firstTokenInLine, currentIndent - 1, spaceSize, tokenStart);
                    break;
                }
                firstTokenInLine = false;
            }

            if (firstTokenInLine) {
                writeIndent(firstTokenInLine, currentIndent, spaceSize, tokenStart);
                firstTokenInLine = false;
            }

            tabs.forEach(this::addChange);
            tabs.clear();

            switch (type) {
            case SQLLexer.EQUAL:
            case SQLLexer.NOT_EQUAL:
            case SQLLexer.LTH:
            case SQLLexer.LEQ:
            case SQLLexer.GTH:
            case SQLLexer.GEQ:
            case SQLLexer.PLUS:
            case SQLLexer.MINUS:
            case SQLLexer.MULTIPLY:
            case SQLLexer.DIVIDE:
            case SQLLexer.MODULAR:
            case SQLLexer.EXP:
            case SQLLexer.EQUAL_GTH:
            case SQLLexer.COLON_EQUAL:
            case SQLLexer.LESS_LESS:
            case SQLLexer.GREATER_GREATER:
            case SQLLexer.OP_CHARS:
                if (addWhitespaceBeforeOp && space == null) {
                    addChange(new FormatItem(tokenStart, 0, " "));
                }
                needSpace = addWhitespaceAfterOp;
                break;
            default:
                if (needSpace) {
                    addChange(new FormatItem(tokenStart, 0, " "));
                    needSpace = false;
                }
            }

            space = null;
        }
    }

    private void writeIndent(boolean firstTokenInLine, int currentIndent,
            int spaceSize, int tokenStart) {
        if (!firstTokenInLine) {
            return;
        }

        int minIndent = currentIndent * indentSize;
        int diffIndent = spaceSize % indentSize;

        int lenght;

        if (spaceSize < minIndent) {
            lenght = minIndent - spaceSize;
        } else if (diffIndent > 0) {
            lenght = indentSize - diffIndent;
        } else {
            return;
        }

        addChange(new FormatItem(tokenStart, 0,
                String.format("%1$" + lenght + 's', "")));
    }

    private FormatItem appendSpace(FormatItem space, int tokenStart, int lenght) {
        FormatItem item;
        if (space == null) {
            item = new FormatItem(tokenStart, lenght, "");
        } else {
            item = space;
            item.appendLenght(lenght);
        }
        return item;
    }

    private void addChange(FormatItem change) {
        if (change.getStart() > start && change.getStart() < stop) {
            change.moveEndToStop(stop);
            changes.add(change);
        }
    }
}

class CustomParseTreeListener implements ParseTreeListener {

    private final Map<Token, IndentDirection> indents;

    public CustomParseTreeListener(Map<Token, IndentDirection> indents) {
        this.indents = indents;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        //no imp
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        //no imp
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        //no imp
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if (ctx instanceof Function_blockContext) {
            exitFunctionBlock((Function_blockContext) ctx);
        } else if (ctx instanceof If_statementContext) {
            exitIfStatement((If_statementContext) ctx);
        } else if (ctx instanceof Loop_statementContext) {
            exitLoopStatement((Loop_statementContext) ctx);
        } else if (ctx instanceof Case_statementContext) {
            exitCaseStatement((Case_statementContext) ctx);
        }
    }

    private void exitFunctionBlock(Function_blockContext block) {
        DeclarationsContext declare = block.declarations();

        if (declare != null) {
            indents.put(declare.DECLARE().getSymbol(), IndentDirection.INCREACE);
        }

        indents.put(block.BEGIN().getSymbol(),
                declare == null ? IndentDirection.INCREACE : IndentDirection.REDUCE_AND_INCREACE);

        Exception_statementContext exception = block.exception_statement();
        if (exception != null) {
            indents.put(exception.EXCEPTION().getSymbol(), IndentDirection.REDUCE_AND_INCREACE);

            List<TerminalNode> whens = exception.WHEN();
            for (int i = 0; i < whens.size(); i++) {
                indents.put(whens.get(i).getSymbol(),
                        i == 0 ? IndentDirection.INCREACE : IndentDirection.REDUCE_AND_INCREACE);
            }
        }

        indents.put(block.END().getSymbol(),
                exception == null ? IndentDirection.REDUCE : IndentDirection.REDUCE_TWICE);
    }

    private void exitIfStatement(If_statementContext ctx) {
        indents.put(ctx.IF().get(0).getSymbol(), IndentDirection.INCREACE);

        for (TerminalNode node : ctx.ELSIF()) {
            indents.put(node.getSymbol(), IndentDirection.REDUCE_AND_INCREACE);
        }
        for (TerminalNode node : ctx.ELSEIF()) {
            indents.put(node.getSymbol(), IndentDirection.REDUCE_AND_INCREACE);
        }
        TerminalNode elseCtx = ctx.ELSE();
        if (elseCtx != null) {
            indents.put(elseCtx.getSymbol(), IndentDirection.REDUCE_AND_INCREACE);
        }

        indents.put(ctx.END().getSymbol(), IndentDirection.REDUCE);
    }

    private void exitLoopStatement(Loop_statementContext ctx) {
        List<TerminalNode> loops = ctx.LOOP();
        if (!loops.isEmpty()) {
            indents.put(loops.get(0).getSymbol(), IndentDirection.INCREACE);
            indents.put(ctx.END().getSymbol(), IndentDirection.REDUCE);
        }
    }

    private void exitCaseStatement(Case_statementContext ctx) {
        indents.put(ctx.CASE().get(0).getSymbol(), IndentDirection.INCREACE);

        List<TerminalNode> whens = ctx.WHEN();
        for (int i = 0; i < whens.size(); i++) {
            Token t = whens.get(i).getSymbol();
            indents.put(t, i == 0 ? IndentDirection.INCREACE :
                IndentDirection.REDUCE_AND_INCREACE);
        }

        TerminalNode elseCtx = ctx.ELSE();
        if (elseCtx != null) {
            indents.put(elseCtx.getSymbol(), IndentDirection.REDUCE_AND_INCREACE);
        }

        indents.put(ctx.END().getSymbol(), IndentDirection.REDUCE_TWICE);
    }
}
