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
package ru.taximaxim.codekeeper.ui.consoles;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsolePageParticipant;
import org.eclipse.ui.part.IPageBookViewPage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ShowConsoleParticipant implements IConsolePageParticipant {

    private final IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
    private ShowConsoleAction action;
    private Control pageControl;
    private CodekeeperConsole console;

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        return null;
    }

    @Override
    public void init(IPageBookViewPage page, IConsole console) {
        action = new ShowConsoleAction();
        this.console = (CodekeeperConsole) console;
        IToolBarManager toolBarMgr = page.getSite().getActionBars().getToolBarManager();
        toolBarMgr.appendToGroup(IConsoleConstants.OUTPUT_GROUP, action);
        pageControl = page.getControl();
        prefs.addPropertyChangeListener(action);

        toolBarMgr.appendToGroup(IConsoleConstants.LAUNCH_GROUP, new TerminateAction());

        toolBarMgr.appendToGroup(IConsoleConstants.LAUNCH_GROUP, new RemoveAction());

        toolBarMgr.appendToGroup(IConsoleConstants.LAUNCH_GROUP, new RemoveAllAction());
    }

    @Override
    public void dispose() {
        prefs.removePropertyChangeListener(action);
    }

    @Override
    public void activated() {
        // no imp
    }

    @Override
    public void deactivated() {
        // no imp
    }

    private class ShowConsoleAction extends Action implements IPropertyChangeListener {

        public ShowConsoleAction() {
            super(Messages.generalPrefPage_show_console_when_program_write_to_console);

            setImageDescriptor(Activator.getRegisteredDescriptor(ProjectIcon.WRITEOUT_CONSOLE));
            setChecked(prefs.getBoolean(PREF.FORCE_SHOW_CONSOLE));
        }

        @Override
        public void propertyChange(final PropertyChangeEvent event) {
            if (event.getNewValue() != null
                    && PREF.FORCE_SHOW_CONSOLE.equals(event.getProperty())
                    && !Objects.equals(event.getOldValue(), event.getNewValue())) {
                UiSync.exec(pageControl, (Runnable) () -> {
                    if (!pageControl.isDisposed()) {
                        setChecked((boolean) event.getNewValue());
                    }
                });
            }
        }

        @Override
        public void run() {
            prefs.setValue(PREF.FORCE_SHOW_CONSOLE, isChecked());
        }
    }

    private class TerminateAction extends Action {

        public TerminateAction() {
            super(Messages.ShowConsoleParticipant_terminate);
            setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
                    .getImageDescriptor(ISharedImages.IMG_ELCL_STOP));

            final IPropertyChangeListener listener = e -> update();
            console.addListener(listener);
            pageControl.addDisposeListener(e -> console.deleteListener(listener));

            update();
        }

        private void update() {
            UiSync.exec(pageControl, () -> setEnabled(!console.isTerminated()));
        }

        @Override
        public void run() {
            console.cancel();
        }
    }

    private class RemoveAction extends Action {

        public RemoveAction() {
            super(Messages.ShowConsoleParticipant_remove);
            setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
                    .getImageDescriptor(ISharedImages.IMG_ELCL_REMOVE));

            final IPropertyChangeListener listener = e -> update();
            console.addListener(listener);
            pageControl.addDisposeListener(e -> console.deleteListener(listener));

            update();
        }

        private void update() {
            UiSync.exec(pageControl, () -> setEnabled(console.isTerminated()));
        }

        @Override
        public void run() {
            ConsolePlugin.getDefault().getConsoleManager()
            .removeConsoles(new IConsole[] { console });
        }
    }

    private class RemoveAllAction extends Action {

        public RemoveAllAction() {
            super(Messages.ShowConsoleParticipant_remove_all);
            setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
                    .getImageDescriptor(ISharedImages.IMG_ELCL_REMOVEALL));

            final IPropertyChangeListener listener = e -> update();
            console.addListener(listener);
            pageControl.addDisposeListener(e -> console.deleteListener(listener));

            update();
        }

        private void update() {
            UiSync.exec(pageControl, () -> setEnabled(console.isTerminated()));
        }

        @Override
        public void run() {
            IConsoleManager conMan = ConsolePlugin.getDefault().getConsoleManager();
            List<IConsole> toDelete = new ArrayList<>();
            for (IConsole c : conMan.getConsoles()) {
                if (c instanceof CodekeeperConsole && ((CodekeeperConsole) c).isTerminated())  {
                    toDelete.add(c);
                }
            }

            conMan.removeConsoles(toDelete.toArray(new IConsole[toDelete.size()]));
        }
    }
}