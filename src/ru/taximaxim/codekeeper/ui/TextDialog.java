package ru.taximaxim.codekeeper.ui;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TextDialog extends MessageDialog {
	
	final private String text;
	
	final int type;
	
	public TextDialog(Shell parentShell, int type,String title, String message,
	        String text) {
	    super(parentShell, title, null, message, type, new String[] {
	            IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL
	    }, 0);
		
		this.text = text;
		this.type = type;
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
	    if(type == QUESTION_WITH_CANCEL) {
    	    createButton(parent, IDialogConstants.YES_ID,
    	            IDialogConstants.YES_LABEL, true);
    	    createButton(parent, IDialogConstants.NO_ID,
    	            IDialogConstants.NO_LABEL, false);
    	    createButton(parent, IDialogConstants.CANCEL_ID,
    	            IDialogConstants.CANCEL_LABEL, false);
	    } else {
	        super.createButtonsForButtonBar(parent);
	    }
	}
	
	@Override
	protected Control createCustomArea(Composite parent) {
	    Text txt = new Text(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
                | SWT.READ_ONLY | SWT.MULTI);
        txt.setText(text);
        
        txt.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
        txt.setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
        
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.widthHint = 600;
        gd.heightHint = 400;
        txt.setLayoutData(gd);
        
        return txt;
	}
}