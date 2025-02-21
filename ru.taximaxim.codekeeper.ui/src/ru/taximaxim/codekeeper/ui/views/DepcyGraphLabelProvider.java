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
package ru.taximaxim.codekeeper.ui.views;

import java.util.Collections;
import java.util.Set;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Control;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;

import ru.taximaxim.codekeeper.core.schema.IConstraintFk;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

class DepcyGraphLabelProvider extends LabelProvider implements IEntityStyleProvider{

    private static final RGB RGB_LBLUE = new RGB(216, 228, 248);
    private static final RGB RGB_LGREEN = new RGB(204, 255, 204);
    private static final RGB RGB_DBLUE = new RGB(1, 70, 122);

    private final Color colorHighlight;
    private final Color colorLBlue;
    private final Color colorLGreen;
    private final Color colorDBlue;

    private boolean isSource = true;
    private Set<?> currentRootSet = Collections.emptySet();

    void setCurrentRootSet(Set<?> currentRootSet) {
        this.currentRootSet = currentRootSet;
    }

    public DepcyGraphLabelProvider(Control owner) {
        LocalResourceManager lrm = new LocalResourceManager(JFaceResources.getResources(), owner);

        colorHighlight = owner.getDisplay().getSystemColor(SWT.COLOR_YELLOW);
        colorLBlue = lrm.createColor(RGB_LBLUE);
        colorLGreen = lrm.createColor(RGB_LGREEN);
        colorDBlue = lrm.createColor(RGB_DBLUE);
    }

    public void setIsSource(boolean isSource) {
        this.isSource = isSource;
    }

    @Override
    public String getText(Object element) {
        if (element instanceof PgStatement st) {
            switch (st.getStatementType()) {
            case CAST:
                return "CAST " + st.getBareName(); //$NON-NLS-1$
            case USER_MAPPING:
                return "USER_MAPPING " + st.getBareName(); //$NON-NLS-1$
            case COLUMN:
                return "COL " + st.getBareName(); //$NON-NLS-1$
            case CONSTRAINT:
                if (st instanceof IConstraintFk) {
                    return "FK " + st.getBareName(); //$NON-NLS-1$
                }
                return "CONSTR " + st.getBareName(); //$NON-NLS-1$
            case DATABASE:
                return "DB"; //$NON-NLS-1$
            case DOMAIN:
                return "DOM " + st.getBareName(); //$NON-NLS-1$
            case EXTENSION:
                return "EXT " + st.getBareName(); //$NON-NLS-1$
            case EVENT_TRIGGER:
                return "EVT " + st.getBareName(); //$NON-NLS-1$
            case FOREIGN_DATA_WRAPPER:
                return "FDW " + st.getBareName(); //$NON-NLS-1$
            case SERVER:
                return "SRV " + st.getBareName(); //$NON-NLS-1$
            case COLLATION:
                return "COLL " + st.getBareName(); //$NON-NLS-1$
            case FUNCTION:
                return "FUNC " + st.getBareName(); //$NON-NLS-1$
            case PROCEDURE:
                return "PROC " + st.getBareName(); //$NON-NLS-1$
            case AGGREGATE:
                return "AGGR " + st.getBareName(); //$NON-NLS-1$
            case OPERATOR:
                return "OPER " + st.getBareName(); //$NON-NLS-1$
            case INDEX:
                return "IDX " + st.getBareName(); //$NON-NLS-1$
            case SCHEMA:
                return st.getBareName();
            case ASSEMBLY:
                return "ASSEM " + st.getBareName(); //$NON-NLS-1$
            case USER:
                return "USER " + st.getBareName(); //$NON-NLS-1$
            case ROLE:
                return "ROLE " + st.getBareName(); //$NON-NLS-1$
            case SEQUENCE:
                return "SEQ " + st.getBareName(); //$NON-NLS-1$
            case TABLE:
                return "TBL " + st.getBareName(); //$NON-NLS-1$
            case TRIGGER:
                return "TRG " + st.getBareName(); //$NON-NLS-1$
            case STATISTICS:
                return "STAT " + st.getBareName(); //$NON-NLS-1$
            case RULE:
                return "RULE " + st.getBareName(); //$NON-NLS-1$
            case POLICY:
                return "POLICY " + st.getBareName(); //$NON-NLS-1$
            case TYPE:
                return "TYPE " + st.getBareName(); //$NON-NLS-1$
            case VIEW:
                return "VIEW " + st.getBareName(); //$NON-NLS-1$
            case FTS_PARSER:
                return "PARSER " + st.getBareName(); //$NON-NLS-1$
            case FTS_TEMPLATE:
                return "TEMP " + st.getBareName(); //$NON-NLS-1$
            case FTS_CONFIGURATION:
                return "CONF " + st.getBareName(); //$NON-NLS-1$
            case FTS_DICTIONARY, DICTIONARY:
                return "DICT "  + st.getBareName(); //$NON-NLS-1$
            }
            return st.getClass() + " " + st.getBareName(); //$NON-NLS-1$
        }
        if (element instanceof EntityConnectionData) {
            return ""; //$NON-NLS-1$
        }
        return "error"; //$NON-NLS-1$
    }

    @Override
    public Color getNodeHighlightColor(Object entity) {
        return colorHighlight;
    }

    @Override
    public Color getBorderColor(Object entity) {
        return currentRootSet.contains(entity) ? ColorConstants.black : ColorConstants.lightGray;
    }

    @Override
    public Color getBorderHighlightColor(Object entity) {
        return ColorConstants.blue;
    }

    @Override
    public int getBorderWidth(Object entity) {
        return currentRootSet.contains(entity) ? 2 : 1;
    }

    @Override
    public Color getBackgroundColour(Object entity) {
        return isSource ? colorLBlue : colorLGreen;
    }

    @Override
    public Color getForegroundColour(Object entity) {
        return currentRootSet.contains(entity) ? ColorConstants.black : colorDBlue;
    }

    @Override
    public IFigure getTooltip(Object entity) {
        if (entity instanceof PgStatement st) {
            TextFlow text = new TextFlow(st.getName());
            FlowPage page = new FlowPage();
            page.add(text);
            return page;
        }

        return null;
    }

    @Override
    public boolean fisheyeNode(Object entity) {
        return false;
    }
}
