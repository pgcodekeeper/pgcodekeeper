package ru.taximaxim.codekeeper.ui.prefs;

import java.io.File;
import java.util.regex.Pattern;

import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.swt.widgets.Composite;

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
		super(name, labelText, false, parent);
	}
	
	@Override
	protected boolean checkState() {
		File f = null;
		
		if(!super.checkState()) {
		    // TODO check general logic, messages showing
			String envVarPath = System.getenv("PATH");
			for(String subVarPath :
					envVarPath.split(Pattern.quote(File.pathSeparator))) {
			    // TODO try with PATHEXTs too
				File fTry = new File(subVarPath, getStringValue());
				if(fTry.isFile()) {
					f = fTry;
					break;
				}
			}
			
			if(f == null) {
				return false;
			} else {
				clearErrorMessage();
			}
		} else {
			f = new File(getStringValue());
		}
		
		if(!f.canExecute()) {
			showErrorMessage(
					"Value must be a file with execute permission set");
			return false;
		}
		
		return true;
	}
}
