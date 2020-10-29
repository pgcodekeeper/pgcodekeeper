package cz.startnet.utils.pgdiff.loader;

import org.junit.Assert;
import org.junit.Test;

import cz.startnet.utils.pgdiff.PgDiffUtils;

public class JdbcLoaderTest {

    @Test
    public void functionDollars() {
        String def = "asdad$_XXXXXXX_XXXXXXXasdaasdsad";
        Assert.assertEquals("Function dollars fail",
                PgDiffUtils.quoteStringDollar(def),
                "$_XXXXXXX_XXXXXXX_$" + def + "$_XXXXXXX_XXXXXXX_$");
    }
}
