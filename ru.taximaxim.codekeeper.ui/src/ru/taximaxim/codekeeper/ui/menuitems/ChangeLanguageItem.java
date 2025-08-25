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
package ru.taximaxim.codekeeper.ui.menuitems;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineLayoutData;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.pgcodekeeper.core.DatabaseType;

import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public class ChangeLanguageItem extends ContributionItem {

    /**
     * Mouse right click event
     */
    private static final int RIGHT_CLICK = 3;
    /**
     * Left and right margin used in CLabel.
     */
    private static final int INDENT = 3 * 2;
    /**
     * Default number of characters that should fit into the item.
     */
    private static final int WIDTH_IN_CHARS = 14;

    private CLabel fLabel;
    private int width = -1;
    private int height = -1;

    private final LanguageAction msAction = new LanguageAction(DatabaseType.MS, IAction.AS_RADIO_BUTTON);
    private final LanguageAction pgAction = new LanguageAction(DatabaseType.PG, IAction.AS_RADIO_BUTTON);
    private final LanguageAction chAction = new LanguageAction(DatabaseType.CH, IAction.AS_RADIO_BUTTON);

    private SQLEditor editor;

    public ChangeLanguageItem() {
        super("unknown ID"); //$NON-NLS-1$
        setVisible(true);
    }

    public void setActiveEditor(SQLEditor editor) {
        this.editor = editor;
    }

    @Override
    public void fill(Composite parent) {
        Label sep = new Label(parent, SWT.SEPARATOR);
        fLabel = new CLabel(parent, SWT.SHADOW_NONE);

        if (editor != null && !ProjectUtils.isInProject(editor.getEditorInput())) {
            createContextMenu(fLabel);
            fLabel.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseDown(MouseEvent e) {
                    if (e.button == RIGHT_CLICK) {
                        fLabel.getMenu().setVisible(true);
                    }
                }
            });
        }

        StatusLineLayoutData data = new StatusLineLayoutData();
        data.widthHint = getWidthHint(parent);
        fLabel.setLayoutData(data);

        data = new StatusLineLayoutData();
        data.heightHint = getHeightHint(parent);
        sep.setLayoutData(data);

        if (editor == null) {
            return;
        }

        updateLabel(editor.getDbType());
    }

    /**
     * Returns the width hint for this label.
     */
    private int getWidthHint(Composite control) {
        if (width < 0) {
            PixelConverter pc = new PixelConverter(control);
            width = pc.convertWidthInCharsToPixels(WIDTH_IN_CHARS) + INDENT;
        }
        return width;
    }

    /**
     * Returns the height hint for this label.
     */
    private int getHeightHint(Composite control) {
        if (height < 0) {
            PixelConverter pc = new PixelConverter(control);
            height = pc.convertHeightInCharsToPixels(8);
        }
        return height;
    }

    private void createContextMenu(Composite control) {
        MenuManager contextMenu = new MenuManager();
        contextMenu.add(pgAction);
        contextMenu.add(msAction);
        contextMenu.add(chAction);
        control.setMenu(contextMenu.createContextMenu(control));
    }

    private void updateLabel(DatabaseType type) {
        if (fLabel == null || fLabel.isDisposed()) {
            return;
        }

        fLabel.setForeground(fLabel.getParent().getForeground());
        fLabel.setText(type.getDbTypeName());
        pgAction.setChecked(type);
        msAction.setChecked(type);
        chAction.setChecked(type);
    }

    private final class LanguageAction extends Action {

        private DatabaseType type;

        private LanguageAction(DatabaseType type, int style) {
            super(type.getDbTypeName(), style);
            this.type = type;
        }

        @Override
        public void run() {
            editor.changeLanguage(type);
            updateLabel(type);
        }

        private void setChecked(DatabaseType type) {
            super.setChecked(this.type == type);
        }
    }
}
