/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms;

import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.SourceStatement;

public abstract class BatchContextProcessor extends MsParserAbstract {

    private final ParserRuleContext batchCtx;
    private final CommonTokenStream stream;

    protected BatchContextProcessor(PgDatabase db, ParserRuleContext batchCtx,
            CommonTokenStream stream) {
        super(db);
        this.batchCtx = batchCtx;
        this.stream = stream;
    }

    /**
     * @return the context, after which the second source part starts
     */
    protected abstract ParserRuleContext getDelimiterCtx();

    protected void setSourceParts(SourceStatement st) {
        boolean isKeepNewLines = db.getArguments().isKeepNewlines();
        String first = ParserAbstract.getHiddenLeftCtxText(batchCtx, stream);
        st.setFirstPart(isKeepNewLines ? first : first.replace("\r", ""));

        List<Token> endTokens = stream.getHiddenTokensToRight(batchCtx.getStop().getTokenIndex());
        Token stopToken = endTokens != null ? endTokens.get(endTokens.size() - 1) : batchCtx.getStop();
        int stop = stopToken.getStopIndex();
        int start = getDelimiterCtx().getStop().getStopIndex() + 1;
        String second = stopToken.getInputStream().getText(Interval.of(start, stop));
        st.setSecondPart(isKeepNewLines ? second : second.replace("\r", ""));
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        String act = getStmtAction();
        List<Token> startTokens = stream.getHiddenTokensToLeft(ctx.getStart().getTokenIndex());
        List<Token> stopTokens = stream.getHiddenTokensToRight(ctx.getStop().getTokenIndex());
        Token start = startTokens != null ? startTokens.get(0) : ctx.getStart();
        Token stop = stopTokens != null ? stopTokens.get(stopTokens.size() - 1) : ctx.getStop();
        String sql = getFullCtxText(start, stop);
        String action = act != null ? act : ctx.getStart().getText().toUpperCase(Locale.ROOT);
        int offset = start.getStartIndex();
        int lineNumber = start.getLine();
        int charPositionInLine = start.getCharPositionInLine();

        PgObjLocation loc = new PgObjLocation.Builder()
                .setAction(action)
                .setOffset(offset)
                .setLineNumber(lineNumber)
                .setCharPositionInLine(charPositionInLine)
                .setSql(sql)
                .build();

        db.addReference(fileName, loc);
        return loc;
    }
}
