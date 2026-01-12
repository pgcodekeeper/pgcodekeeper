/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.comparetools;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SqlSourceViewer;

public class SqlMergeViewer extends TextMergeViewer {

    public SqlMergeViewer(Composite parent, int style, CompareConfiguration conf) {
        super(parent, style, conf);
        // add initial input in order to avoid problems when disposing the viewer later
        updateContent(null, null, null);
    }

    @Override
    protected void configureTextViewer(TextViewer textViewer) {
        // viewer configures itself
    }

    @Override
    protected SourceViewer createSourceViewer(Composite parent,
            int textOrientation) {
        return new SqlSourceViewer(parent, textOrientation);
    }

    @Override
    public String getTitle() {
        return Messages.SqlMergeViewer_compare_label;
    }
}
