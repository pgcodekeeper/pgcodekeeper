/*******************************************************************************
 * Copyright (c) 2010 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.usage.internal.reporting;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.jboss.tools.usage.branding.IUsageBranding;
import org.jboss.tools.usage.internal.JBossToolsUsageActivator;
import org.jboss.tools.usage.util.BrowserUtil;

/**
 * @author Andre Dietisheim
 */
public class UsageReportEnablementDialog extends Dialog {

	private boolean reportEnabled;
	private IUsageBranding branding;
	//private ForceActiveShellAdapter forceActiveShellAdapter = new ForceActiveShellAdapter();
	
	public UsageReportEnablementDialog(IShellProvider parentShell, IUsageBranding branding) {
		super(parentShell);
		this.branding = branding;
	}
	
	public UsageReportEnablementDialog(Shell parentShell, IUsageBranding branding) {
		super(parentShell);
		this.branding = branding;
	}

	protected void buttonPressed(int buttonId) {
		this.reportEnabled = (buttonId == IDialogConstants.OK_ID);
		if (IDialogConstants.NO_ID == buttonId) {
			noPressed();
		}
		super.buttonPressed(buttonId);
	}

	/**
	 * Notifies that the no button of this dialog has been pressed.
	 * <p>
	 * The <code>Dialog</code> implementation of this framework method sets this
	 * dialog's return code to <code>Window.OK</code> and closes the dialog.
	 * </p>
	 */
	protected void noPressed() {
		setReturnCode(OK);
		close();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(branding.getStartupAllowReportingTitle());
		//forceActiveShellAdapter.attachTo(shell);
	}

	@Override
	public boolean close() {
		//forceActiveShellAdapter.removeFrom(getShell());
		return super.close();
		
	}

	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.YES_LABEL, false);
		createButton(parent, IDialogConstants.NO_ID, IDialogConstants.NO_LABEL, false);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		createUsageReportingWidgets(parent, composite);
		applyDialogFont(composite);

		return composite;
	}

	private void createUsageReportingWidgets(Composite parent, Composite composite) {
		// message
		Link link = new Link(composite, SWT.WRAP);
		link.setFont(parent.getFont());

		link.setText(branding.getStartupAllowReportingMessage());
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BrowserUtil.checkedCreateExternalBrowser(
							branding.getStartupAllowReportingDetailLink(),
							JBossToolsUsageActivator.PLUGIN_ID,
							JBossToolsUsageActivator.getDefault().getLog());
			}
		});
		GridDataFactory.fillDefaults()
					.align(SWT.FILL, SWT.CENTER)
					.grab(true, false)
					.hint(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH, SWT.DEFAULT)
					.applyTo(link);
	}

	public boolean isReportEnabled() {
		return reportEnabled;
	}

//	private class ForceActiveShellAdapter extends ShellAdapter {
//
//		public void shellDeactivated(ShellEvent e) {
//			Shell shell = getShell();
//			if (shell != null
//					&& !shell.isDisposed())
//			shell.forceActive();
//		}
//		
//		private void attachTo(Shell shell) {
//			if (shell != null
//					&& !shell.isDisposed()) {
//				shell.addShellListener(this);
//			}
//		}
//
//		private void removeFrom(Shell shell) {
//			if (shell != null
//					&& !shell.isDisposed()) {
//				shell.removeShellListener(this);
//			}
//		}
//	}
}
