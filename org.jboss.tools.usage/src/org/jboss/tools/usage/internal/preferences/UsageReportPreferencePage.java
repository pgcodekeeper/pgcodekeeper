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
package org.jboss.tools.usage.internal.preferences;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.jboss.tools.usage.branding.IUsageBranding;
import org.jboss.tools.usage.event.UsageEventType;
import org.jboss.tools.usage.googleanalytics.IJBossToolsEclipseEnvironment;
import org.jboss.tools.usage.googleanalytics.eclipse.IEclipseUserAgent;
import org.jboss.tools.usage.internal.JBossToolsUsageActivator;
import org.jboss.tools.usage.internal.event.EventRegister;
import org.jboss.tools.usage.util.StatusUtils;
import org.jboss.tools.usage.util.StringUtils;
import org.osgi.service.prefs.BackingStoreException;

/**
 * @author Andre Dietisheim
 */
public class UsageReportPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private static final DateFormat DATE_FORMAT = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,
			DateFormat.SHORT);
	private IUsageBranding branding;

	public UsageReportPreferencePage() {
		super(GRID);
		this.branding = JBossToolsUsageActivator.getDefault().getUsageBranding();
	}

	@Override
	protected Control createContents(Composite parent) {
		Control control = super.createContents(parent);
		createReportingData((Composite) control);
		return control;
	}

	private void createReportingData(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(PreferencesMessages.UsageReportPreferencePage_ReportedValues);
		GridDataFactory.fillDefaults().grab(true, true).hint(SWT.FILL, SWT.FILL).applyTo(group);
		FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 4;
		fillLayout.marginWidth = 8;
		group.setLayout(fillLayout);
		StyledText text = new StyledText(group, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		text.setEditable(false);
		IJBossToolsEclipseEnvironment eclipseEnvironment = JBossToolsUsageActivator.getDefault()
				.getJBossToolsEclipseEnvironment();
		if (eclipseEnvironment == null) {
			text.setText("usage reporting facility is disabled");
		} else {
			createText(eclipseEnvironment, text);
		}
	}

	private void createText(IJBossToolsEclipseEnvironment eclipseEnvironment, StyledText text) {
		List<StyleRange> styles = new ArrayList<StyleRange>();
		StringBuilder builder = new StringBuilder();

		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_JBossToolsVersion,
				eclipseEnvironment.getJBossToolsVersion(), builder, styles);
		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_JBossToolsComponents,
				eclipseEnvironment.getKeyword(), builder, styles);
		builder.append(StringUtils.getLineSeparator());

		IEclipseUserAgent eclipseUserAgent = eclipseEnvironment.getEclipseUserAgent();
		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_ProductId,
				eclipseUserAgent.getApplicationName(), builder, styles);

		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_ProductVersion,
				eclipseUserAgent.getApplicationVersion(), builder, styles);
		builder.append(StringUtils.getLineSeparator());

		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_OperatingSystem, eclipseUserAgent.getOS(),
				builder, styles);
		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_OperatingSystemVersion,
				eclipseUserAgent.getOSVersion(), builder, styles);
		if (eclipseEnvironment.isLinuxDistro()) {
			appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_LinuxDistro,
					eclipseEnvironment.getUserDefined(), builder, styles);
		}
		builder.append(StringUtils.getLineSeparator());

		// JVM
		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_JvmName, eclipseEnvironment.getJavaVmName(),
				builder, styles);
		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_JvmArchitecture, eclipseEnvironment.getJavaBitVersion(),
				builder, styles);
		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_JvmVersion, eclipseEnvironment.getFlashVersion(),
				builder, styles);
		builder.append(StringUtils.getLineSeparator());
		//

		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_Locale, eclipseUserAgent.getBrowserLanguage(),
				builder, styles);
		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_ScreenColors,
				eclipseEnvironment.getScreenColorDepth(), builder, styles);
		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_ScreenResolution,
				eclipseEnvironment.getScreenResolution(), builder, styles);
		builder.append(StringUtils.getLineSeparator());

//		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_ProductOwner,
//				eclipseEnvironment.getHostname(), builder, styles);
//		builder.append(StringUtils.getLineSeparator());

		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_NumberOfUsageHits,
				String.valueOf(eclipseEnvironment.getVisitCount()), builder,
				styles);
		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_FirstUsageHit,
				getFormattedDate(eclipseEnvironment.getFirstVisit()), builder, styles);
		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_LastUsageHit,
				getFormattedDate(eclipseEnvironment.getLastVisit()), builder, styles);
		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_CurrentUsageHit,
				getFormattedDate(eclipseEnvironment.getCurrentVisit()), builder,
				styles);
//		appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_JBossCentralEnabled,
//				eclipseEnvironment.getCentralEnabledValue(), builder,
//				styles);

		builder.append(StringUtils.getLineSeparator());
		appendEvents(builder, styles);

		text.setText(builder.toString());

		for (StyleRange style : styles) {
			text.setStyleRange(style);
		}
	}

	private void appendEvents(StringBuilder builder, List<StyleRange> styles) {
		UsageEventType[] events = EventRegister.getInstance().getRegisteredEventTypes();
		if(events.length>0) {
			appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_Events, "", builder, styles);
			builder.append(StringUtils.getLineSeparator());
			for (UsageEventType event : events) {
				appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_EventComponent, event.getComponentName(), builder, styles);
				appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_EventVersion, event.getComponentVersion(), builder, styles);
				appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_EventCategory, event.getCategoryName(), builder, styles);
				appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_EventAction, event.getActionName(), builder, styles);
				if(event.getLabelDescription()!=null) {
					appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_EventLabel, event.getLabelDescription(), builder, styles);
					if(event.getValueDescription()!=null) {
						appendLabeledValue(PreferencesMessages.UsageReportPreferencePage_EventValue, event.getValueDescription(), builder, styles);
					}
				}
				builder.append(StringUtils.getLineSeparator());
			}
		}
	}

	/**
	 * Appends a labeled value to the given string builder and adds a bold font
	 * style range to the given styles.
	 * 
	 * @param label
	 *            the label to append
	 * @param value
	 *            the value to append
	 * @param builder
	 *            the builder to append the strings (label, value) to
	 * @param styles
	 *            the styles list to add the style range to
	 */
	private void appendLabeledValue(String label, String value, StringBuilder builder, List<StyleRange> styles) {
		StyleRange styleRange = startLabelStyleRange(builder);
		builder.append(label);
		finishLabelStyleRange(builder, styleRange);
		builder.append(value)
				.append(StringUtils.getLineSeparator());
		styles.add(styleRange);
	}

	private StyleRange startLabelStyleRange(StringBuilder builder) {
		StyleRange styleRange = new StyleRange();
		styleRange.start = builder.length();
		styleRange.fontStyle = SWT.BOLD;
		return styleRange;
	}

	private StyleRange finishLabelStyleRange(StringBuilder builder, StyleRange styleRange) {
		styleRange.length = builder.length() - styleRange.start;
		return styleRange;
	}

	public void createFieldEditors() {
		addField(new BooleanFieldEditor(
					IUsageReportPreferenceConstants.USAGEREPORT_ENABLED_ID
					, branding.getPreferencesAllowReportingCheckboxLabel()
					, getFieldEditorParent()));
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(UsageReportPreferences.createPreferenceStore());
		setDescription(branding.getPreferencesDescription());
	}

	@Override
	public boolean performOk() {
		try {
			UsageReportPreferences.flush();
		} catch (BackingStoreException e) {
			IStatus status = StatusUtils.getErrorStatus(JBossToolsUsageActivator.PLUGIN_ID,
					PreferencesMessages.UsageReportPreferencePage_Error_Saving, e);
			JBossToolsUsageActivator.getDefault().getLog().log(status);
		}
		return super.performOk();
	}

	private String getFormattedDate(String timeStamp) {
		try {

			Date date = new Date(Long.parseLong(timeStamp));
			if (date != null) {
				return DATE_FORMAT.format(date);
			}
		} catch (NumberFormatException e) {
		}
		return ""; //$NON-NLS-1$
	}
}