package ru.taximaxim.codekeeper.core.parsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.dfa.DFA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser;

/**
 * Tests for plpgsql function bodies.
 *
 * @author galiev_mr
 * @since 5.9.0
 */
class PlpgParserTest {

    @ParameterizedTest
    @CsvSource({
        "plpgsql, 21",
    })
    void parse(final String fileNameTemplate, int allowedAmbiguity) throws IOException {
        List<Object> errors = new ArrayList<>();
        AtomicInteger ambiguity = new AtomicInteger();

        String sql = TestUtils.inputStreamToString(PlpgParserTest.class
                .getResourceAsStream(fileNameTemplate + ".sql"));

        SQLParser parser = AntlrParser
                .makeBasicParser(SQLParser.class, sql, fileNameTemplate, errors);
        AntlrUtils.removeIntoStatements(parser);
        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
        parser.addErrorListener(new BaseErrorListener() {

            @Override
            public void reportAmbiguity(Parser p, DFA dfa, int start,
                    int stop, boolean exact, BitSet set, ATNConfigSet conf) {
                ambiguity.incrementAndGet();
            }
        });

        parser.plpgsql_function_test_list();

        int count = ambiguity.intValue();
        Assertions.assertTrue(errors.isEmpty(), "File: " + fileNameTemplate + " - ANTLR Error");
        Assertions.assertEquals(allowedAmbiguity, count,
                "File: " + fileNameTemplate + " - ANTLR Ambiguity " + count + " expected " + allowedAmbiguity);
    }
}
