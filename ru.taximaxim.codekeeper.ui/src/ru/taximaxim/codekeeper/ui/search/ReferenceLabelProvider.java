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
package ru.taximaxim.codekeeper.ui.search;

import java.text.MessageFormat;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class ReferenceLabelProvider extends LabelProvider implements IStyledLabelProvider {

    private static final String LINE_NUMBER = "{0}: "; //$NON-NLS-1$

    private static final String HIGHLIGHT_COLOR_NAME = "org.eclipse.search.ui.match.highlight"; //$NON-NLS-1$

    private static final Styler HIGHLIGHT_STYLE = StyledString.createColorRegistryStyler(null, HIGHLIGHT_COLOR_NAME);

    private final WorkbenchLabelProvider workbenchProvider = new WorkbenchLabelProvider();

    @Override
    public String getText(Object object) {
        return getStyledText(object).getString();
    }

    @Override
    public Image getImage(Object element) {
        if (element instanceof PgObjLocation) {
            return Activator.getRegisteredImage(FILE.ICONSEARCHLINE);
        }

        return workbenchProvider.getImage(element);
    }

    @Override
    public StyledString getStyledText(Object element) {
        if (!(element instanceof PgObjLocation)) {
            return workbenchProvider.getStyledText(element);
        }

        PgObjLocation loc = (PgObjLocation) element;
        StyledString text = new StyledString();
        String lineNumber = MessageFormat.format(LINE_NUMBER, loc.getLineNumber());
        text.append(lineNumber, StyledString.QUALIFIER_STYLER);
        text.append(loc.getSql());

        int offset = loc.getCharPositionInLine() + lineNumber.length();
        int length = loc.getObjLength();
        if (offset < 0 || offset + length > text.length()) {
            return new StyledString();
        }

        text.setStyle(offset, length, HIGHLIGHT_STYLE);
        return text;
    }

    @Override
    public void dispose() {
        super.dispose();
        workbenchProvider.dispose();
    }
}
