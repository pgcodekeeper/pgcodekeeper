package cz.startnet.utils.pgdiff.formatter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
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

public class Formatter {

    private final List<FormatItem> changes = new ArrayList<>();

    private final int start;
    private final int stop;

    private boolean removeTrailingWhitespace;
    private boolean addWhitespaceBeforeOp;
    private boolean addWhitespaceAfterOp;

    private int whitespaceCount = -1;

    public Formatter(int offset, int lenght) {
        this.start = offset;
        this.stop = offset + lenght;
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
        Lexer lexer = new SQLLexer(new ANTLRInputStream(definition));

        FormatItem space = null;
        boolean needSpace = false;
        List<FormatItem> tabs = new ArrayList<>();

        for (Token t : lexer.getAllTokens()) {
            int tokenStart = offset + t.getStartIndex();
            int lenght = t.getText().length();
            int type = t.getType();

            if (type == SQLLexer.Tab || type == SQLLexer.Space || type == SQLLexer.New_Line) {
                if (type == SQLLexer.Tab && whitespaceCount >= 0) {
                    FormatItem item = new FormatItem(tokenStart, lenght,
                            String.format("%1$" + whitespaceCount + 's', ""));
                    if (removeTrailingWhitespace) {
                        tabs.add(item); //
                    } else {
                        addChange(item);
                    }
                }

                if (removeTrailingWhitespace) {
                    if (type != SQLLexer.New_Line) {
                        space = appendSpace(space, tokenStart, lenght);
                    } else if (space != null) {
                        space.setText("");
                        addChange(space);
                        tabs.clear();
                        space = null;
                    }
                }

                needSpace = false;
                continue;
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
                    addSpace(tokenStart);
                }
                needSpace = addWhitespaceAfterOp;
                break;
            default:
                if (needSpace) {
                    addSpace(tokenStart);
                    needSpace = false;
                }
            }

            space = null;
        }
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

    private void addChange(FormatItem space) {
        if (space.getStart() > start && space.getStart() < stop) {
            space.moveEndToStop(stop);
            getChanges().add(space);
        }
    }

    private void addSpace(int tokenStart) {
        if (tokenStart > start && tokenStart < stop) {
            getChanges().add(new FormatItem(tokenStart, 0, " "));
        }
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
}
