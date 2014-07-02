package ru.taximaxim.codekeeper.ui.prefs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * Extends {@link FileFieldEditor} to check whether an executable
 * can be found in PATH system variable and if it can be executed.
 * 
 * @author Alexander Levsha
 */
public class ExecutableFileFieldEditor extends FileFieldEditor {

    public ExecutableFileFieldEditor(String name, String labelText,
            Composite parent) {
        // always create without enforcing absolute paths
        super(name, labelText, false, VALIDATE_ON_KEY_STROKE, parent);
    }
    
    @Override
    protected boolean checkState() {
        File f = null;
        
        if(!super.checkState()) {
            // we cannot search filepaths in %PATH%,
            // only filenames are allowed in this case
            // always block '/' because on Windows File.separator will be '\'
            // but '/' will work as well
            if(getStringValue().contains(File.separator)
                    || getStringValue().indexOf('/') != -1) {
                return false;
            }
            
            String pathSep = Pattern.quote(File.pathSeparator);
            
            List<String> pathExts = new ArrayList<>(16);
            // since we always try to search with extension add empty one too
            pathExts.add(""); //$NON-NLS-1$
            
            String pathext = System.getenv("PATHEXT"); //$NON-NLS-1$
            if(pathext != null) {
                for(String ext : pathext.split(pathSep)) {
                    pathExts.add(ext);
                }
            }
            
            String envVarPath = System.getenv("PATH"); //$NON-NLS-1$
            for(String subVarPath : envVarPath.split(pathSep)) {
                for(String ext : pathExts) {
                    File fTry = new File(subVarPath, getStringValue() + ext);
                    if(fTry.isFile()) {
                        f = fTry;
                        break;
                    }
                }
            }
            
            if(f == null) {
                return false;
            }
        } else {
            f = new File(getStringValue());
        }
        
        if(!f.canExecute()) {
            showErrorMessage(
                    Messages.ExecutableFileFieldEditor_value_must_be_file_with_execute_permission_set);
            return false;
        }
        
        clearErrorMessage();
        return true;
    }
}
