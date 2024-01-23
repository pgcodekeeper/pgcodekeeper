/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

import java.util.Arrays;
import java.util.List;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Vex_bContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.Vex;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.ModPair;

/**
 * For use with value expressions that have predefined namespace.
 * @author levsha_aa
 */
public class ValueExprWithNmspc extends AbstractExprWithNmspc<VexContext> {

    private final ValueExpr vex;

    public ValueExprWithNmspc(MetaContainer meta) {
        super(meta);
        vex = new ValueExpr(this);
    }

    @Override
    public List<ModPair<String, String>> analyze(VexContext vex) {
        return analyze(new Vex(vex));
    }

    public List<ModPair<String, String>> analyze(Vex_bContext vex) {
        return analyze(new Vex(vex));
    }

    public List<ModPair<String, String>> analyze(Vex vex) {
        return Arrays.asList(this.vex.analyze(vex));
    }
}
