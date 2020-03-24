package cz.startnet.utils.pgdiff.loader;

import org.junit.Assert;
import org.junit.Test;

import cz.startnet.utils.pgdiff.loader.jdbc.FunctionsReader;

public class JdbcLoaderTest {

    @Test
    public void functionDollars() {
        String def = "asdad$_XXXXXXX_XXXXXXXasdaasdsad";
        Assert.assertEquals("Function dollars fail",
                FunctionsReader.getStringLiteralDollarQuote(def),
                "$_XXXXXXX_XXXXXXX_$");
    }
}
