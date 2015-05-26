/*******************************************************************************
 * Copyright (c) 2014 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.usage.internal.reporting;

import java.lang.reflect.Field;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.jboss.tools.usage.event.UsageEventType;
import org.jboss.tools.usage.event.UsageReporter;
import org.jboss.tools.usage.internal.JBossToolsUsageActivator;
import org.jboss.tools.usage.util.StringUtils;

/**
 * @author Alexey Kazakov
 */
public class WizardListener implements Listener {

	private UsageEventType finishButtonType;
	public static final String FINISH_BUTTON_FIELD_NAME = "finishButton";
	public static final String CANCEL_BUTTON_FIELD_NAME = "cancelButton";

	public WizardListener(UsageEventType finishButtonType) {
		this.finishButtonType = finishButtonType;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	@Override
	public void handleEvent(Event event) {
		try {
			final IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
			if(window!=null) {
				Shell workbenchShell = window.getShell();
				Shell[] existedShells = workbench.getDisplay().getShells();
				for (Shell shell : existedShells) {
					if(shell!=workbenchShell) {
						Object data = shell.getData();
						if(data instanceof WizardDialog) {
							WizardDialog dialog = (WizardDialog)data;
							IWizardPage page = dialog.getCurrentPage();
							if(page !=null) {
								// Wizard is open
								Button finishButton = getButton(dialog, FINISH_BUTTON_FIELD_NAME);
								if(finishButton !=null) {
									finishButton.addSelectionListener(new ButtonListener(dialog, finishButtonType));
	//								Button cancelButton = getButton(dialog, CANCEL_BUTTON_FIELD_NAME);
	//								if(cancelButton!=null) {
	//									cancelButton.addSelectionListener(new ButtonListener(dialog, cancelButtonType));
	//								}
								}
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// Catch all Exceptions to make sure, in case of bugs, Usage doesn't prevent JBT from working
			JBossToolsUsageActivator.getDefault().getLogger().error(e, true);
		}
	}

	private Button getButton(WizardDialog dialog, String fieldName) {
		Object button = null;
		try {
			Field field = WizardDialog.class.getDeclaredField(fieldName);
			field.setAccessible(true);
			button = field.get(dialog);
			if(button instanceof Button) {
				return (Button)button;
			}
		} catch (NoSuchFieldException e) {
			JBossToolsUsageActivator.getDefault().getLogger().error(e);
		} catch (SecurityException e) {
			JBossToolsUsageActivator.getDefault().getLogger().error(e);
		} catch (IllegalArgumentException e) {
			JBossToolsUsageActivator.getDefault().getLogger().error(e);
		} catch (IllegalAccessException e) {
			JBossToolsUsageActivator.getDefault().getLogger().error(e);
		}
		return null;
	}

	private static class ButtonListener implements SelectionListener {

		private WizardDialog dialog;
		private UsageEventType type;

		public ButtonListener(WizardDialog dialog, UsageEventType type) {
			this.dialog = dialog;
			this.type = type;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			IWizardPage page = dialog.getCurrentPage();
			if(page!=null) {
				IWizard wizard  = page.getWizard();
				if(wizard!=null) {
					String className = StringUtils.compressClassName(wizard.getClass().getName());
	//				String title = wizard.getWindowTitle();
					// Count the event
					UsageReporter.getInstance().countEvent(type.event(className));
				}
			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}
	}
}