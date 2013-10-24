 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.parts.ProjectPartDescriptor;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.ProjectLoaderParser;
import ru.taximaxim.codekeeper.ui.pgdbproject.ProjectSyncChecker;

public class ProjSyncSrc {
	
	@Inject
	@Named(IServiceConstants.ACTIVE_PART)
	MPart part;
	
	@Execute
	public void execute(
			@Named(IServiceConstants.ACTIVE_SHELL)
			Shell shell,
			@Named(UIConsts.PREF_STORE)
			IPreferenceStore prefStore) 
					throws InvocationTargetException, IOException {
		ProjectPartDescriptor partImpl = ((ProjectPartDescriptor) part.getObject());
		try {
			if(sync(partImpl.getProject(), shell, prefStore)) {
				partImpl.reload();
			}
		} catch(CancellationException ex) {
			MessageBox mb = new MessageBox(shell, SWT.ICON_CANCEL);
			mb.setText("Sync operation");
			mb.setMessage("Sync operation cancelled.");
			mb.open();
		}
	}
	
	/**
	 * @throws CancellationException
	 * @return true if the project was changed
	 */
	public static boolean sync(PgDbProject proj, Shell shell,
		IPreferenceStore mainPrefStore) throws InvocationTargetException {

		String syncDump = null;
		if(UIConsts.PROJ_SOURCE_TYPE_DUMP.equals(
				proj.getString(UIConsts.PROJ_PREF_SOURCE))) {
			FileDialog dialogDump = new FileDialog(shell);
			dialogDump.setText("Synchronizing:"
					+ " Dump file is chosen as project source."
					+ " Select a file to sync with.");
			
			syncDump = dialogDump.open();
			if(syncDump == null) {
				throw new CancellationException();
			}
		}

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
		ProjectSyncChecker projChecker = new ProjectSyncChecker(mainPrefStore,
				proj, syncDump);
		try {
			dialog.run(true, false, projChecker);
		} catch(InterruptedException ex) {
			// assume run() was called as non cancelable
			throw new IllegalStateException(
					"Project creator thread cancelled. Shouldn't happen!", ex);
		}
		
		String diff = projChecker.getDiff();
		if(diff.isEmpty()) {
			return false;
		}
		
		if(new TextDialog(shell, diff, "Found differences in the project."
				+ " Want to sync it with source?\n\n"
				+ "Diff from the project to its schema source:")
				.open() != Dialog.OK) {
			throw new CancellationException();
		}
		
		dialog = new ProgressMonitorDialog(shell);
		ProjectLoaderParser reload = 
				new ProjectLoaderParser(mainPrefStore, proj, syncDump);
		try {
			dialog.run(true, false, reload);
		} catch(InterruptedException ex) {
			// assume run() was called as non cancelable
			throw new IllegalStateException(
					"Project reload thread cancelled. Shouldn't happen!", ex);
		}
		
		return true;
	}
	
	@CanExecute
	public boolean canExecute() {
		if(part.getElementId().equals(UIConsts.PROJ_PART_DESCR_ID)) {
			return true;
		}
		
		return false;
	}
}

class TextDialog extends Dialog {
	
	final private String text, message;
	
	public TextDialog(Shell parentShell, String text, String message) {
		super(parentShell);
		
		this.text = text;
		this.message = message;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		
		new Label(container, SWT.NONE).setText(message);
		
		Text txt = new Text(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.READ_ONLY | SWT.MULTI);
		
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.widthHint = 600;
		gd.heightHint = 400;
		txt.setLayoutData(gd);
		
		txt.setFont(new Font(parent.getShell().getDisplay(), new FontData[] {
			new FontData("Monospace", 10, SWT.NORMAL),
			new FontData("Courier New", 10, SWT.NORMAL),
			new FontData("Courier", 10, SWT.NORMAL)
		}));
		txt.setText(text);
		
		applyDialogFont(container);
		return container;
	}
}