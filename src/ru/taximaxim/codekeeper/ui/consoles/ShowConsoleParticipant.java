package ru.taximaxim.codekeeper.ui.consoles;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsolePageParticipant;
import org.eclipse.ui.part.IPageBookViewPage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ShowConsoleParticipant implements IConsolePageParticipant {

    ShowConsoleAction action;
    IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
    
    @Override
    public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
        return null;
    }

    @Override
    public void init(IPageBookViewPage page, IConsole console) {
        if (action== null) {
            action = new ShowConsoleAction(prefs);
        }
        page.getSite().getActionBars().getToolBarManager()
                .appendToGroup(IConsoleConstants.OUTPUT_GROUP, action);
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
    
    private static class ShowConsoleAction extends Action implements IPropertyChangeListener {
        
        private IPreferenceStore prefs;
        
        ShowConsoleAction(IPreferenceStore prefs) {
            super(Messages.generalPrefPage_show_console_when_program_write_to_console);
            this.prefs = prefs;
            
            setToolTipText(Messages.generalPrefPage_show_console_when_program_write_to_console);
            setImageDescriptor(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(FILE.ICONWRITEOUTCONSOLE)));
            setChecked(prefs.getBoolean(PREF.FORCE_SHOW_CONSOLE));
        }

        @Override
        public void propertyChange(PropertyChangeEvent event) {
            if (event.getProperty().equals(PREF.FORCE_SHOW_CONSOLE)
                    && !event.getOldValue().equals(event.getNewValue())) {
                setChecked((boolean)event.getNewValue()); 
            }
        }

        @Override
        public void run() {
            prefs.setValue(PREF.FORCE_SHOW_CONSOLE, isChecked());
        }
    }
}