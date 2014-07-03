
package ru.taximaxim.codekeeper.ui.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.localizations.Messages;


public class TestPart {
    
    @Inject
    @Preference(UIConsts.PREF_PGDUMP_CUSTOM_PARAMS)
    private String prefPgdumpPath;
    
    @Inject
    @Named(IServiceConstants.ACTIVE_SHELL)
    private Shell shell_;
    
    private Text txt;
    
    @PostConstruct
    private void createUI(final Composite parent) {
        final Shell shell = parent.getShell();
        
        parent.setLayout(new FormLayout());
        Button btn = new Button(parent, SWT.PUSH);
        btn.setText(Messages.testPart_qwe);
        
        FormData data = new FormData();
        data.left = data.top = new FormAttachment(5);
        btn.setLayoutData(data);
        
        btn.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                
                txt.setText(txt.getText() + "\n" //$NON-NLS-1$
                        + prefPgdumpPath + "\n" //$NON-NLS-1$
                        + shell);
                txt.setText(txt.getText() + "\n" //$NON-NLS-1$
                        + shell.getDisplay());
                
                txt.setText(txt.getText() + "\n" //$NON-NLS-1$
                        + shell_);
                
                
            }
        });
        
        txt = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
        data = new FormData();
        data.left = new FormAttachment(5);
        data.right = new FormAttachment(95);
        data.bottom = new FormAttachment(95);
        data.top = new FormAttachment(btn, 5);
        txt.setLayoutData(data);
    }
}
