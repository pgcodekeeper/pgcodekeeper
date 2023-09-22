package ru.taximaxim.codekeeper.core;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ru.taximaxim.codekeeper.core.loader.LibraryLoader;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

class LibDiffTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "lib_test_with_ignore",
            "no_same_objects",
            "with_same_objects"
    })
    void runDiffWithIgnore(String fileNameTemplate) throws IOException, InterruptedException, URISyntaxException {
        runDiff(fileNameTemplate, List.of(fileNameTemplate + FILES_POSTFIX.LIBRARY_SQL), true);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "lib_test",
            "no_same_objects",
            "with_same_objects"
    })
    void runDiffNoIgnore(String fileNameTemplate) throws IOException, InterruptedException, URISyntaxException {
        runDiff(fileNameTemplate, List.of(fileNameTemplate + FILES_POSTFIX.LIBRARY_SQL), false);
    }

    @Test
    void runDiffMultipleLib() throws IOException, InterruptedException, URISyntaxException {
        List<String> libList = List.of("multiple_libs_lib1.sql", "multiple_libs_lib2.sql", "multiple_libs_lib3.sql");
        runDiff("multiple_libs", libList, true);
    }

    void runDiff(String fileNameTemplate, List<String> libList, boolean isIgnorePrivileges)
            throws IOException, InterruptedException, URISyntaxException {
        PgDiffArguments args = new PgDiffArguments();
        args.setIgnorePrivileges(isIgnorePrivileges);
        List<String> libs = new ArrayList<>();
        for (String lib : libList) {
            libs.add(TestUtils.getPathToResource(lib, getClass()).toString());
        }
        PgDatabase dbOld = new PgDatabase();
        PgDatabase dbNew = TestUtils.loadTestDump(fileNameTemplate + FILES_POSTFIX.NEW_SQL, getClass(), args);
        LibraryLoader loader = new LibraryLoader(dbNew, null, null);

        loader.loadLibraries(args, isIgnorePrivileges, libs);

        String script = new PgDiff(args).diffDatabaseSchemas(dbOld, dbNew, null);

        TestUtils.compareResult(script, fileNameTemplate, getClass());
    }
}
