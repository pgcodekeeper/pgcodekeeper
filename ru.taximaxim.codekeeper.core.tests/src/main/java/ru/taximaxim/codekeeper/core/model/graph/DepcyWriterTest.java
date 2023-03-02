package ru.taximaxim.codekeeper.core.model.graph;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class DepcyWriterTest {

    private static final String DEPS_POSTFIX = "_deps.txt";
    private static final String DEPS_REVERSE_POSTFIX = "_deps_reverse.txt";

    @ParameterizedTest
    @CsvSource({
        "table, public.t1",
        "regex, public\\.t.",
        "view, public.v1",
    })
    void compareDirectGraph(String fileName, String objectName) throws IOException, InterruptedException {
        compareGraph(fileName, DEPS_POSTFIX, objectName, false);
    }

    @ParameterizedTest
    @CsvSource({
        "table, public.t1",
        "regex, public\\.t.",
        "view, public.v1",
    })
    void compareReverseGraph(String fileName, String objectName) throws IOException, InterruptedException {
        compareGraph(fileName, DEPS_REVERSE_POSTFIX, objectName, true);
    }

    void compareGraph(String fileName, String expectedPostfix, String objectName, boolean isReverse)
            throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        PgDatabase db = TestUtils.loadTestDump(fileName + ".sql", getClass(), args);

        StringWriter out = new StringWriter();
        PrintWriter writer = new PrintWriter(out);

        new DepcyWriter(db, 10, writer, isReverse, Collections.emptyList(), false).write(List.of(objectName));
        writer.flush();

        String expected = TestUtils.readResource(fileName + expectedPostfix, getClass());

        Assertions.assertEquals(expected.trim(), out.toString().trim());
    }
}
