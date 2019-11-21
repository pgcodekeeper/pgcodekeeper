package cz.startnet.utils.pgdiff.formatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLLexer;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;

public class StatementFormatter {

    private final int start;
    private final int stop;

    private boolean removeTrailingWhitespace;
    private boolean addWhitespaceBeforeOp;
    private boolean addWhitespaceAfterOp;

    private int indentSize;
    private int whitespaceCount;
    private String tabReplace = "";

    private int currentIndent = 1;
    private int spaceSize;
    private int lastTokenOffset;
    private boolean needSpace;
    private boolean firstTokenInLine = true;

    private final Map<Token, IndentDirection> indents = new HashMap<>();
    private final List<FormatItem> tabs = new ArrayList<>();
    private final List<FormatItem> changes = new ArrayList<>();

    public StatementFormatter(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    public List<FormatItem> getChanges() {
        return changes;
    }

    public void setRemoveTrailingWhitespace(boolean removeTrailingWhitespace) {
        this.removeTrailingWhitespace = removeTrailingWhitespace;
    }

    public void setWhitespaceCount(int whitespaceCount) {
        this.whitespaceCount = whitespaceCount;
        if (whitespaceCount > 0) {
            tabReplace = String.format("%1$" + whitespaceCount + 's', "");
        }
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

    public void parseDefsToFormat(String definition, int offset) {
        lastTokenOffset = offset;

        for (Token t : getTokensFromDefinition(definition)) {
            int tokenStart = offset + t.getStartIndex();
            int lenght = t.getStopIndex() - t.getStartIndex() + 1;
            int type = t.getType();

            if (type == SQLLexer.Tab || type == SQLLexer.Space
                    || type == SQLLexer.New_Line) {
                processSpaces(type, tokenStart, lenght);
                needSpace = false;
                continue;
            }

            if (tokenStart > stop || type == SQLLexer.EOF) {
                // ignore all after stop, but try to remove partial trailing space.
                // tokens before start are not ignored, because need right indent level
                tabs.forEach(this::addChange);
                return;
            }

            processIndents(indents.get(t), tokenStart);

            tabs.forEach(this::addChange);
            tabs.clear();

            if (addWhitespaceAfterOp || addWhitespaceBeforeOp) {
                proccessOperators(type, tokenStart);
            }

            spaceSize = 0;
            firstTokenInLine = false;
            lastTokenOffset = tokenStart + lenght;
        }
    }

    private List<Token> getTokensFromDefinition(String definition) {
        Lexer lexer = new SQLLexer(new ANTLRInputStream(definition));
        CommonTokenStream stream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(stream);
        parser.addParseListener(new FormatParseTreeListener(indents));
        parser.plpgsql_function();

        return stream.getTokens();
    }

    private void processSpaces(int type, int tokenStart, int lenght) {
        if (type == SQLLexer.New_Line) {
            if (tokenStart > lastTokenOffset && removeTrailingWhitespace) {
                addChange(new FormatItem(lastTokenOffset,
                        tokenStart - lastTokenOffset, ""));
                tabs.clear();
            }
            spaceSize = 0;
            firstTokenInLine = true;
            lastTokenOffset = tokenStart + lenght;
        } else if (type == SQLLexer.Tab && whitespaceCount >= 0) {
            FormatItem item = new FormatItem(tokenStart, lenght, tabReplace);
            if (removeTrailingWhitespace) {
                tabs.add(item);
            } else {
                addChange(item);
            }

            spaceSize += whitespaceCount;
        } else {
            spaceSize++;
        }
    }

    private void processIndents(IndentDirection direction, int tokenStart) {
        if (direction != null) {
            switch (direction) {
            case BLOCK_START:
                writeIndent(true, currentIndent++, tokenStart);
                break;
            case BLOCK_STOP:
                writeIndent(false, --currentIndent, tokenStart);
                break;
            case BLOCK_LINE:
                writeIndent(true, currentIndent - 1, tokenStart);
                break;
            case REDUCE_TWICE:
                currentIndent--;
                writeIndent(false, currentIndent--, tokenStart);
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
            if (addWhitespaceBeforeOp && lastTokenOffset == tokenStart) {
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
    }

    private void writeIndent(boolean needNewLine, int indent, int tokenStart) {
        if (!firstTokenInLine) {
            if (needNewLine) {
                addChange(new FormatItem(lastTokenOffset, 0, System.lineSeparator()));
            } else {
                return;
            }
        }

        int expectedIndent = indent * indentSize;
        if (spaceSize != expectedIndent) {
            String text = expectedIndent > 0 ? String.format("%1$" + expectedIndent + 's', "") : "";
            addChange(new FormatItem(lastTokenOffset, tokenStart - lastTokenOffset, text));
            tabs.clear();
        }
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