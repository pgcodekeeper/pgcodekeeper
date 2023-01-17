package ru.taximaxim.codekeeper.core.parsers.antlr;

public class QNameParserWrapper {

    private final QNameParser<?> parser;

    private QNameParserWrapper(QNameParser<?> parser) {
        this.parser = parser;
    }

    public static QNameParserWrapper parsePg(String fullName) {
        return new QNameParserWrapper(QNameParser.parsePg(fullName));
    }

    public String getFirstName() {
        return parser.getFirstName();
    }

    public String getSecondName() {
        return parser.getSecondName();
    }

    public String getSchemaName() {
        return parser.getSchemaName();
    }

    public String getThirdName() {
        return parser.getThirdName();
    }

    public boolean hasErrors() {
        return parser.hasErrors();
    }
}
