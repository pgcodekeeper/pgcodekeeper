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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.jboss.tools.usage.internal.branding.IUsageBranding;

/**
 * @author Andre Dietisheim
 */
public class UsageReportEnablementDialog extends Dialog {

	private boolean reportEnabled;
	private final IUsageBranding branding;

	public UsageReportEnablementDialog(IShellProvider parentShell, IUsageBranding branding) {
		super(parentShell);
		this.branding = branding;
	}

	public UsageReportEnablementDialog(Shell parentShell, IUsageBranding branding) {
		super(parentShell);
		this.branding = branding;
	}

	@Override
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

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(branding.getStartupAllowReportingTitle());
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.YES_LABEL, false);
		createButton(parent, IDialogConstants.NO_ID, IDialogConstants.NO_LABEL, false);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		createUsageReportingWidgets(composite);
		applyDialogFont(composite);

		return composite;
	}

	private void createUsageReportingWidgets(Composite composite) {
		// message
		Label link = new Label(composite, SWT.WRAP);
		link.setText(branding.getStartupAllowReportingMessage());

		GridDataFactory.fillDefaults()
		.align(SWT.FILL, SWT.CENTER)
		.grab(true, false)
		.hint(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH, SWT.DEFAULT)
		.applyTo(link);
	}

	public boolean isReportEnabled() {
		return reportEnabled;
	}
}
