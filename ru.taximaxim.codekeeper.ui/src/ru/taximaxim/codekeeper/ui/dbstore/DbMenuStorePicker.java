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
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Menu;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.CONN_TYPE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_STORE_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.xmlstore.ConnectioTypeXMLStore;
import ru.taximaxim.codekeeper.ui.xmlstore.DbXmlStore;

public final class DbMenuStorePicker extends AbstractStorePicker implements IStorePicker, IPropertyChangeListener {

    private final Runnable menuRunnable;

    private final Link lnkDb;

    private DatabaseType dbType;
    private Object selection;
    private final ListenerList<Runnable> runnableListeners = new ListenerList<>();

    private final ResourceManager resourceManager = new LocalResourceManager(JFaceResources.getResources());

    public DbMenuStorePicker(Composite parent, boolean useFileSources, boolean useDirSources) {
        super(parent, useFileSources, useDirSources);
        Activator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
        lnkDb = new Link(parent, SWT.NONE);
        updateTextLbl();
        menuRunnable = () -> {
            Menu oldMenu = lnkDb.getMenu();
            if (oldMenu != null) {
                oldMenu.dispose();
            }

            List<DbInfo> store = DbXmlStore.getStore();
            MenuManager menuMgr = new MenuManager();
            DBStoreMenu dbMenu = new DBStoreMenu(menuMgr,
                    this.useFileSources, this.useDirSources, dbType, parent.getShell(), selection);
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

    public void updateSelection() {
        if (selection instanceof DbInfo) {
            List<DbInfo> store = DbXmlStore.getStore();
            if (store.contains(selection)) {
                var newSelection = store.get(store.indexOf(selection));
                if (dbType == null || newSelection.getDbType() == dbType) {
                    setSelection(newSelection);
                    return;
                }
            }
            clearSelection();
        }
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
        if (lnkDb.isDisposed()) {
            return;
        }

        String text = Messages.LabelPicker_choice_db;
        String toolTip = null;
        String conType = null;

        if (selection != null) {
            if (selection instanceof DbInfo) {
                text = ((DbInfo) selection).getName();
                conType = ((DbInfo) selection).getConType();
            } else {
                text = ((File) selection).getName();
            }
            text = escapeLink(text);
            toolTip = text;
        }
        setBackground(conType);
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
    public void filter(DatabaseType dbType) {
        this.dbType = dbType;
        DbInfo dbInfo = getDbInfo();
        if (dbType != null && dbInfo != null && dbInfo.getDbType() != dbType) {
            clearSelection();
        }
    }

    private void setBackground() {
        if (!lnkDb.isDisposed() && selection instanceof DbInfo) {
            setBackground(((DbInfo) selection).getConType());
        }
    }

    private void setBackground(String conType) {
        if (conType != null && !conType.isBlank()) {
            for (ConnectionTypeInfo t : ConnectioTypeXMLStore.readStoreFromXml()) {
                if (conType.equals(t.getName())) {
                    lnkDb.setBackground(resourceManager.createColor(StringConverter.asRGB(t.getColor())));
                    return;
                }
            }
        }

        lnkDb.setBackground(null);
    }

    @Override
    public void dispose() {
        Activator.getDefault().getPreferenceStore().removePropertyChangeListener(this);
        resourceManager.dispose();
        super.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        String propertyName = event.getProperty();
        if (DB_STORE_PREF.LAST_DB_STORE_CHANGE_TIME.equals(propertyName)) {
            updateSelection();
        } else if (CONN_TYPE_PREF.LAST_CONN_TYPE_CHANGE_TIME.equals(propertyName)) {
            setBackground();
        }
    }
}