package ru.taximaxim.codekeeper.core.loader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.taximaxim.codekeeper.core.PgDiffUtils;

class JdbcLoaderTest {

    @Test
    void functionDollars() {
        String def = "asdad$_XXXXXXX_XXXXXXXasdaasdsad";
        Assertions.assertEquals(
                PgDiffUtils.quoteStringDollar(def),
                "$_XXXXXXX_XXXXXXX_$" + def + "$_XXXXXXX_XXXXXXX_$", "Function dollars fail");
    }
}
