
package ru.taximaxim.codekeeper.ui.parts;

import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.UIConsts;

import javax.annotation.PostConstruct;


public class TestPart {
	
	@Inject
	@Preference(value=UIConsts.PREF_SVN_EXE_PATH)
	private String prefSvnPath;
	
	Text txt;
	
	@PostConstruct
	public void createUI(Composite parent) {
		parent.setLayout(new FormLayout());
		Button btn = new Button(parent, SWT.PUSH);
		btn.setText("qwe");
		
		FormData data = new FormData();
		data.left = data.top = new FormAttachment(5);
		btn.setLayoutData(data);
		
		btn.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				txt.setText(txt.getText() + "\n" + prefSvnPath);
			}
		});
		
		txt = new Text(parent, SWT.MULTI);
		data = new FormData();
		data.left = new FormAttachment(5);
		data.right = new FormAttachment(95);
		data.bottom = new FormAttachment(95);
		data.top = new FormAttachment(btn, 5);
		txt.setLayoutData(data);
	}
	
	@Focus
	public void onFocus() {
	}
}