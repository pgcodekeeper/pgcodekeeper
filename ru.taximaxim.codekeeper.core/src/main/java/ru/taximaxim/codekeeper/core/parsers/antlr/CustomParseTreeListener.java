/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.parsers.antlr;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.core.runtime.IProgressMonitor;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.MonitorCancelledRuntimeException;

final class CustomParseTreeListener implements ParseTreeListener {
    private final int monitoringLevel;
    private final IProgressMonitor monitor;

    public CustomParseTreeListener(int monitoringLevel, IProgressMonitor monitor) {
        this.monitoringLevel = monitoringLevel;
        this.monitor = monitor;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        // no imp
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        // no imp
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if (ctx.depth() <= monitoringLevel) {
            monitor.worked(1);
            try {
                PgDiffUtils.checkCancelled(monitor);
            } catch (InterruptedException e) {
                throw new MonitorCancelledRuntimeException();
            }
        }
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        // no imp
    }
}
