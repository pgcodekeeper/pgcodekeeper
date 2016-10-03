package ru.taximaxim.codekeeper.ui.consoles;

import java.util.Objects;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsolePageParticipant;
import org.eclipse.ui.part.IPageBookViewPage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ShowConsoleParticipant implements IConsolePageParticipant {

    private final IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
    private ShowConsoleAction action;
    private Control pageControl;

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        return null;
    }

    @Override
    public void init(IPageBookViewPage page, IConsole console) {
        action = new ShowConsoleAction();
        page.getSite().getActionBars().getToolBarManager()
        .appendToGroup(IConsoleConstants.OUTPUT_GROUP, action);
        pageControl = page.getControl();
        prefs.addPropertyChangeListener(action);
    }

    @Override
    public void dispose() {
        prefs.removePropertyChangeListener(action);
    }

    @Override
    public void activated() {
    }

    @Override
    public void deactivated() {
    }

    private class ShowConsoleAction extends Action implements IPropertyChangeListener {

        public ShowConsoleAction() {
            super(Messages.generalPrefPage_show_console_when_program_write_to_console);

            setToolTipText(Messages.generalPrefPage_show_console_when_program_write_to_console);
            setImageDescriptor(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(FILE.ICONWRITEOUTCONSOLE)));
            setChecked(prefs.getBoolean(PREF.FORCE_SHOW_CONSOLE));
        }

        @Override
        public void propertyChange(final PropertyChangeEvent event) {
            if (event.getNewValue() != null
                    && PREF.FORCE_SHOW_CONSOLE.equals(event.getProperty())
                    && !Objects.equals(event.getOldValue(), event.getNewValue())) {
                UiSync.exec(pageControl, new Runnable() {

                    @Override
                    public void run() {
                        if (!pageControl.isDisposed()) {
                            setChecked((boolean) event.getNewValue());
                        }
                    }
                });
            }
        }

        @Override
        public void run() {
            prefs.setValue(PREF.FORCE_SHOW_CONSOLE, isChecked());
        }
    }
}