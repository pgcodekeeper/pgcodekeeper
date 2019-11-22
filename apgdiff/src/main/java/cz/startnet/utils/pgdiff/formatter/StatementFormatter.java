package cz.startnet.utils.pgdiff.formatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

import cz.startnet.utils.pgdiff.formatter.FormatConfiguration.IndentType;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLLexer;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;

public class StatementFormatter {

    private final int start;
    private final int stop;

    private int currentIndent = 1;
    private int lastTokenOffset;
    private boolean isMixedIndent;
    private boolean needSpace;
    private boolean firstTokenInLine = true;

    private final Map<Token, IndentDirection> indents = new HashMap<>();
    private final List<FormatItem> tabs = new ArrayList<>();
    private final List<FormatItem> changes = new ArrayList<>();
    private final FormatConfiguration config;

    public StatementFormatter(int start, int stop, FormatConfiguration config) {
        this.start = start;
        this.stop = stop;
        this.config = config;
    }

    public List<FormatItem> getChanges() {
        return changes;
    }

    public void parseDefsToFormat(String definition, String language, int offset) {
        lastTokenOffset = offset;

        for (Token t : getTokensFromDefinition(definition, language)) {
            int tokenStart = offset + t.getStartIndex();
            int lenght = t.getStopIndex() - t.getStartIndex() + 1;
            int type = t.getType();

            if (type == SQLLexer.Tab || type == SQLLexer.Space
                    || type == SQLLexer.New_Line) {
                processSpaces(type, tokenStart, lenght);
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
                proccessOperators(type, tokenStart);
            }

            isMixedIndent = false;
            firstTokenInLine = false;
            lastTokenOffset = tokenStart + lenght;
        }
    }

    private List<Token> getTokensFromDefinition(String definition, String language) {
        Lexer lexer = new SQLLexer(new ANTLRInputStream(definition));
        CommonTokenStream stream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(stream);
        parser.addParseListener(new FormatParseTreeListener(indents));
        if ("SQL".equalsIgnoreCase(language)) {
            parser.sql();
            currentIndent = 0;
        } else {
            parser.plpgsql_function();
        }

        return stream.getTokens();
    }

    private void processSpaces(int type, int tokenStart, int lenght) {
        if (type == SQLLexer.New_Line) {
            removeTrailingWhitespace(tokenStart);
            isMixedIndent = false;
            firstTokenInLine = true;
            lastTokenOffset = tokenStart + lenght;
            return;
        }

        if (type == SQLLexer.Tab && config.getIndentType() == IndentType.WHITESPACE
                || type == SQLLexer.Space && config.getIndentType() == IndentType.TAB) {
            isMixedIndent = true;
        }

        if (type == SQLLexer.Tab && config.getWhitespaceCount() >= 0) {
            tabs.add(new FormatItem(tokenStart, lenght, config.getTabReplace()));
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

    private void proccessOperators(int type, int tokenStart) {
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
            if (needNewLine) {
                addChange(new FormatItem(lastTokenOffset, 0, System.lineSeparator()));
            } else {
                return;
            }
        }

        int expectedIndent = indent * config.getIndentSize();
        int spaceSize = tokenStart - lastTokenOffset;

        if (spaceSize != expectedIndent || isMixedIndent) {
            addChange(new FormatItem(lastTokenOffset, spaceSize, createText(expectedIndent)));
        }
        tabs.clear();
    }

    private String createText(int expectedIndent) {
        if (expectedIndent <= 0) {
            return "";
        }

        char [] chars  = new char[expectedIndent];
        Arrays.fill(chars, config.getIndentType() == IndentType.TAB ? '\t' : ' ');

        return new String(chars);
    }

    private void addChange(FormatItem item) {
        int itemStart = item.getStart();
        int lenght = item.getLength();
        String text = item.getText();

        if (start <= itemStart && itemStart < stop) {
            if (itemStart + lenght > stop && text.isEmpty()) {
                // partial trailing whitespace
                changes.add(new FormatItem(itemStart, stop - itemStart, text));
            } else {
                changes.add(item);
            }
        }
    }
}