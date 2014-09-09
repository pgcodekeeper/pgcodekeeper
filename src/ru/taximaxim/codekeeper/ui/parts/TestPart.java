
package ru.taximaxim.codekeeper.ui.parts;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class TestPart {
    
    @PostConstruct
    private void createUI(final Composite parent) {
        parent.setLayout(new FormLayout());
        
        Button btn = new Button(parent, SWT.PUSH);
        btn.setText("qwe"); //$NON-NLS-1$
        
        FormData data = new FormData();
        data.left = data.top = new FormAttachment(5);
        btn.setLayoutData(data);
        
        final Text txt = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
        data = new FormData();
        data.left = new FormAttachment(5);
        data.right = new FormAttachment(95);
        data.bottom = new FormAttachment(95);
        data.top = new FormAttachment(btn, 5);
        txt.setLayoutData(data);
        
        btn.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent ev) {
                
                txt.setText(txt.getText() + "\n"); //$NON-NLS-1$
            }
        });
    }
}
