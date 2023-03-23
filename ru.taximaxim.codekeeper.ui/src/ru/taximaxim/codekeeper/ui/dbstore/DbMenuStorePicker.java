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
package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.File;
import java.util.List;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Menu;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbMenuStorePicker extends AbstractStorePicker implements IStorePicker {

    private final Link lnkDb;

    private Boolean isMsSql;
    private Object selection;
    private final ListenerList<Runnable> runnableListeners = new ListenerList<>();

    public DbMenuStorePicker(Composite parent, boolean useFileSources, boolean useDirSources) {
        super(parent, useFileSources, useDirSources);
        lnkDb = new Link(parent, SWT.NONE);
        updateTextLbl();
        Runnable menuRunnable = () -> {
            Menu oldMenu = lnkDb.getMenu();
            if (oldMenu != null) {
                oldMenu.dispose();
            }

            List<DbInfo> store = DbInfo.readStoreFromXml();
            MenuManager menuMgr = new MenuManager();
            DBStoreMenu dbMenu = new DBStoreMenu(menuMgr,
                    DbMenuStorePicker.this.useFileSources,
                    DbMenuStorePicker.this.useDirSources, isMsSql, parent.getShell(), selection);
            dbMenu.fillDbMenu(store);
            dbMenu.addSelectionListener(this::setSelection);
            lnkDb.setMenu(menuMgr.createContextMenu(lnkDb));
        };

        lnkDb.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
            menuRunnable.run();
            lnkDb.getMenu().setVisible(true);
        }));
        lnkDb.addMenuDetectListener(e -> menuRunnable.run());
    }

    @Override
    public Control getControl() {
        return lnkDb;
    }

    @Override
    public void setSelection(Object selection) {
        this.selection = selection;
        updateTextLbl();
        notifyListeners();
        parent.layout();
    }

    @Override
    public Object getSelection() {
        return selection;
    }

    public void updateTextLbl() {
        String text;
        String toolTip;
        if (selection != null) {
            text = (selection instanceof DbInfo) ? ((DbInfo) selection).getName() : ((File) selection).getName();
            text = escapeLink(text);
            toolTip = text;
        } else {
            text = Messages.LabelPicker_choice_db;
            toolTip = null;
        }
        lnkDb.setText("<a>" + text + "</a>"); //$NON-NLS-1$ //$NON-NLS-2$
        lnkDb.setToolTipText(toolTip);
    }

    private String escapeLink(String s) {
        String text = s;
        text = text.replace("&", "&&"); //$NON-NLS-1$ //$NON-NLS-2$
        text = text.replace("<", "\\<"); //$NON-NLS-1$ //$NON-NLS-2$
        text = text.replace(">", "\\>"); //$NON-NLS-1$ //$NON-NLS-2$
        if (text.endsWith("\\")) { //$NON-NLS-1$
            text += ' ';
        }
        return text;
    }

    @Override
    public void addSelectionListener(Runnable runnable) {
        runnableListeners.add(runnable);
    }

    protected void notifyListeners() {
        if (triggerEvent) {
            for (Runnable runnable : runnableListeners) {
                runnable.run();
            }
        }
    }

    @Override
    public void filter(Boolean isMsSql) {
        this.isMsSql = isMsSql;
        DbInfo dbInfo = getDbInfo();
        if (isMsSql != null && dbInfo != null && dbInfo.isMsSql() != isMsSql) {
            clearSelection();
        }
    }
}