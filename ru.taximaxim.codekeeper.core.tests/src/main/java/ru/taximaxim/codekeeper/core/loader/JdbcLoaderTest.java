package ru.taximaxim.codekeeper.core.loader;

import org.junit.Assert;
import org.junit.Test;

import ru.taximaxim.codekeeper.core.PgDiffUtils;

public class JdbcLoaderTest {

    @Test
    public void functionDollars() {
        String def = "asdad$_XXXXXXX_XXXXXXXasdaasdsad";
        Assert.assertEquals("Function dollars fail",
                PgDiffUtils.quoteStringDollar(def),
                "$_XXXXXXX_XXXXXXX_$" + def + "$_XXXXXXX_XXXXXXX_$");
    }
}
