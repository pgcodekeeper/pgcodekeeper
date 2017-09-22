package ru.taximaxim.codekeeper.ui.prefs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.Platform;
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

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.USAGE_REPORT_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.reports.EclipseEnvironment;
import ru.taximaxim.codekeeper.ui.reports.EventRegister;
import ru.taximaxim.codekeeper.ui.reports.UsageEventType;

public class UsageReportPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    private static final DateFormat DATE_FORMAT = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,
            DateFormat.SHORT);

    public UsageReportPreferencePage() {
        super(GRID);
    }

    @Override
    protected Control createContents(Composite parent) {
        Control control = super.createContents(parent);
        createReportingData((Composite) control);
        return control;
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
        setDescription(Messages.UsageReportPreferencePage_Description);
    }

    @Override
    public void createFieldEditors() {
        addField(new BooleanFieldEditor(USAGE_REPORT_PREF.USAGEREPORT_ENABLED_ID,
                Messages.UsageReportPreferencePage_AllowReporting, getFieldEditorParent()));
    }


    private void createReportingData(Composite parent) {
        Group group = new Group(parent, SWT.NONE);
        group.setText(Messages.UsageReportPreferencePage_ReportedValues);
        GridDataFactory.fillDefaults().grab(true, true).hint(SWT.FILL, SWT.FILL).applyTo(group);
        FillLayout fillLayout = new FillLayout();
        fillLayout.marginHeight = 4;
        fillLayout.marginWidth = 8;
        group.setLayout(fillLayout);
        StyledText text = new StyledText(group, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
        text.setEditable(false);
        EclipseEnvironment eclipseEnvironment = Activator.getDefault()
                .getEclipseEnvironment();
        createText(eclipseEnvironment, text);

    }

    private void createText(EclipseEnvironment eclipseEnvironment, StyledText text) {
        List<StyleRange> styles = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        appendLabeledValue(Messages.UsageReportPreferencePage_Version,
                Activator.getDefault().getBundle().getVersion().toString(), builder, styles);
        appendLabeledValue(Messages.UsageReportPreferencePage_Components,
                eclipseEnvironment.getKeyword(), builder, styles);
        builder.append(UIConsts._NL);

        appendLabeledValue(Messages.UsageReportPreferencePage_ProductId,
                eclipseEnvironment.getApplicationName(), builder, styles);

        appendLabeledValue(Messages.UsageReportPreferencePage_ProductVersion,
                eclipseEnvironment.getApplicationVersion(), builder, styles);
        appendLabeledValue(Messages.UsageReportPreferencePage_OperatingSystem, Platform.getOS(),
                builder, styles);
        appendLabeledValue(Messages.UsageReportPreferencePage_OperatingSystemVersion,
                eclipseEnvironment.getOSVersion(), builder, styles);
        appendLabeledValue(Messages.UsageReportPreferencePage_JvmName, eclipseEnvironment.getJavaVmName(),
                builder, styles);
        builder.append(UIConsts._NL);

        appendLabeledValue(Messages.UsageReportPreferencePage_NumberOfUsageHits,
                String.valueOf(eclipseEnvironment.getVisitCount()), builder,
                styles);
        appendLabeledValue(Messages.UsageReportPreferencePage_FirstUsageHit,
                getFormattedDate(eclipseEnvironment.getFirstVisit()), builder, styles);
        appendLabeledValue(Messages.UsageReportPreferencePage_LastUsageHit,
                getFormattedDate(eclipseEnvironment.getLastVisit()), builder, styles);
        appendLabeledValue(Messages.UsageReportPreferencePage_CurrentUsageHit,
                getFormattedDate(eclipseEnvironment.getCurrentVisit()), builder,
                styles);

        builder.append(UIConsts._NL);
        appendEvents(builder, styles);

        text.setText(builder.toString());

        for (StyleRange style : styles) {
            text.setStyleRange(style);
        }
    }

    private void appendEvents(StringBuilder builder, List<StyleRange> styles) {
        UsageEventType[] events = EventRegister.getInstance().getRegisteredEventTypes();
        if (events.length > 0) {
            appendLabeledValue(Messages.UsageReportPreferencePage_Events, "", builder, styles);
            builder.append(UIConsts._NL);
            for (UsageEventType event : events) {
                appendLabeledValue(Messages.UsageReportPreferencePage_EventComponent, event.getComponentName(), builder, styles);
                appendLabeledValue(Messages.UsageReportPreferencePage_EventVersion, event.getComponentVersion(), builder, styles);
                appendLabeledValue(Messages.UsageReportPreferencePage_EventAction, event.getActionName(), builder, styles);
                if(event.getValueDescription() != null) {
                    appendLabeledValue(Messages.UsageReportPreferencePage_EventValue, event.getValueDescription(), builder, styles);
                }

                builder.append(UIConsts._NL);
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
        StyleRange styleRange = new StyleRange();
        styleRange.start = builder.length();
        styleRange.fontStyle = SWT.BOLD;
        builder.append(label);
        styleRange.length = builder.length() - styleRange.start;
        builder.append(value).append(UIConsts._NL);
        styles.add(styleRange);
    }




    private String getFormattedDate(String timeStamp) {
        try {
            return DATE_FORMAT.format(new Date(Long.parseLong(timeStamp)));
        } catch (NumberFormatException e) {

        }
        return ""; //$NON-NLS-1$
    }
}