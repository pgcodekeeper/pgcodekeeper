package cz.startnet.utils.pgdiff.formatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import cz.startnet.utils.pgdiff.formatter.FormatConfiguration.IndentType;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLLexer;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;

public class StatementFormatter {

    private final int start;
    private final int stop;
    /**
     * function definition's offset into the function CREATE statement string <br>
     * all other offsets are statement-string-based
     */
    private final int defOffset;
    private final List<? extends Token> tokens;
    private final FormatConfiguration config;
    /**
     * tab replacement string if tabs are forbidden; null otherwise
     */
    private final String tabReplace;

    private int currentIndent = 1;
    /**
     * position of token following last non-whitespace or newline token
     */
    private int lastTokenOffset;
    /**
     * whether indent of the current line has characters mismatched with indent setting
     */
    private boolean isMixedIndent;
    /**
     * whether a space is needed after an operator
     */
    private boolean needSpace;
    /**
     * whether current token is first non-whitespace token on the line
     */
    private boolean firstTokenInLine = true;
    /**
     * intermediate indent instructions found by parser
     */
    private final Map<Token, IndentDirection> indents = new HashMap<>();
    /**
     * unaryOps and other operator-like tokens found by parser
     */
    private final Set<Token> unaryOps = new HashSet<>();
    /**
     * pending tab replacements, can either be applied or overridden by other whitespace changes
     */
    private final List<FormatItem> tabs = new ArrayList<>();
    /**
     * accumulated formatting change operations
     */
    private final List<FormatItem> changes = new ArrayList<>();

    public StatementFormatter(int start, int stop, String functionDefinition,
            int defOffset, String language, FormatConfiguration config) {
        this.start = start;
        this.stop = stop;
        this.defOffset = defOffset;
        this.config = config;
        this.tabReplace = config.getIndentType() == IndentType.WHITESPACE ?
                config.createIndent(config.getIndentSize()) : null;
        this.tokens = analyzeDefinition(functionDefinition, language);
    }

    public List<FormatItem> getChanges() {
        return changes;
    }

    public void format() {
        lastTokenOffset = defOffset;

        for (Token t : tokens) {
            int tokenStart = defOffset + t.getStartIndex();
            int length = t.getStopIndex() - t.getStartIndex() + 1;
            int type = t.getType();

            if (type == SQLLexer.New_Line) {
                removeTrailingWhitespace(tokenStart);
                needSpace = false;

                isMixedIndent = false;
                firstTokenInLine = true;
                lastTokenOffset = tokenStart + length;
                continue;
            }

            if (type == SQLLexer.Tab || type == SQLLexer.Space) {
                processSpaces(type, tokenStart, length);
                needSpace = false;
                continue;
            }

            if (tokenStart > stop) {
                // ignore all after stop, but try to remove partial trailing space
                tabs.forEach(this::addChange);
                return;
            }

            if (type == SQLLexer.EOF) {
                removeTrailingWhitespace(tokenStart);
                return;
            }

            if (IndentType.DISABLE != config.getIndentType()) {
                processIndents(indents.get(t), tokenStart);
            }

            tabs.forEach(this::addChange);
            tabs.clear();

            if (config.isAddWhitespaceAfterOp() || config.isAddWhitespaceBeforeOp()) {
                proccessOperators(type, tokenStart, t);
            }

            isMixedIndent = false;
            firstTokenInLine = false;
            lastTokenOffset = tokenStart + length;
        }
    }

    private List<? extends Token> analyzeDefinition(String definition, String language) {
        Lexer lexer = new SQLLexer(new ANTLRInputStream(definition));
        if (IndentType.DISABLE == config.getIndentType()
                && !config.isAddWhitespaceAfterOp()
                && !config.isAddWhitespaceBeforeOp()) {
            // fast-path when no parser is required for advanced structure detection
            return lexer.getAllTokens();
        }
        CommonTokenStream stream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(stream);

        ParserRuleContext ctx;
        if ("SQL".equalsIgnoreCase(language)) {
            ctx = parser.sql();
            currentIndent = 0;
        } else {
            AntlrUtils.removeIntoStatements(parser);
            ctx = parser.plpgsql_function();
        }
        ParseTreeListener listener = new FormatParseTreeListener(stream, indents, unaryOps);
        ParseTreeWalker.DEFAULT.walk(listener, ctx);
        return stream.getTokens();
    }

    private void processSpaces(int type, int tokenStart, int length) {
        if (type == SQLLexer.Tab && config.getIndentType() == IndentType.WHITESPACE
                || type == SQLLexer.Space && config.getIndentType() == IndentType.TAB) {
            isMixedIndent = true;
        }

        if (type == SQLLexer.Tab && tabReplace != null) {
            tabs.add(new FormatItem(tokenStart, length, tabReplace));
        }
    }

    private void removeTrailingWhitespace(int tokenStart) {
        if (config.isRemoveTrailingWhitespace() && tokenStart > lastTokenOffset) {
            addChange(new FormatItem(lastTokenOffset, tokenStart - lastTokenOffset, ""));
            tabs.clear();
        }
    }

    private void processIndents(IndentDirection direction, int tokenStart) {
        if (direction != null) {
            switch (direction) {
            case BLOCK_START:
                writeIndent(true, currentIndent++, tokenStart);
                break;
            case BLOCK_LINE:
                writeIndent(true, currentIndent - 1, tokenStart);
                break;
            case BLOCK_STOP:
                writeIndent(false, --currentIndent, tokenStart);
                break;
            case REDUCE_TWICE:
                writeIndent(false, --currentIndent, tokenStart);
                currentIndent--;
                break;
            }
        } else if (firstTokenInLine) {
            writeIndent(false, currentIndent, tokenStart);
        }
    }

    private void proccessOperators(int type, int tokenStart, Token t) {
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
        case SQLLexer.HASH_SIGN:
        case SQLLexer.OP_CHARS:
            if (unaryOps.contains(t)) {
                return;
            }

            if (config.isAddWhitespaceBeforeOp() && lastTokenOffset == tokenStart) {
                addChange(new FormatItem(tokenStart, 0, " "));
            }
            needSpace = config.isAddWhitespaceAfterOp();
            break;
        default:
            if (needSpace) {
                addChange(new FormatItem(tokenStart, 0, " "));
                needSpace = false;
            }
        }
    }

    private void writeIndent(boolean needNewLine, int indent, int tokenStart) {
        if (!firstTokenInLine) {
            if (!needNewLine) {
                return;
            }
            addChange(new FormatItem(lastTokenOffset, 0, System.lineSeparator()));
        }

        int expectedIndent = indent * (config.getIndentType() == IndentType.TAB ?
                1 : config.getIndentSize());
        int spaceSize = tokenStart - lastTokenOffset;

        if (spaceSize != expectedIndent || isMixedIndent) {
            addChange(new FormatItem(lastTokenOffset, spaceSize,
                    config.createIndent(expectedIndent)));
        }
        tabs.clear();
    }

    private void addChange(FormatItem item) {
        int itemStart = item.getStart();
        int length = item.getLength();
        String text = item.getText();

        if (start <= itemStart && itemStart < stop) {
            if (itemStart + length > stop && text.isEmpty()) {
                // partial trailing whitespace
                changes.add(new FormatItem(itemStart, stop - itemStart, text));
            } else {
                changes.add(item);
            }
        }
    }
}