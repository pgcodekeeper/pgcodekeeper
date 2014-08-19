package cz.startnet.utils.pgdiff;

public class PgDiffFragmentTest extends PgDiffTest {

    public PgDiffFragmentTest(String fileNameTemplate, boolean addDefaults,
            boolean addTransaction, boolean ignoreFunctionWhitespace,
            boolean ignoreStartWith) {
        super(fileNameTemplate, addDefaults, addTransaction,
                ignoreFunctionWhitespace, ignoreStartWith);
    }
}
