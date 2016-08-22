package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.LinkedList;

import javax.xml.transform.TransformerException;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.XML_TAGS;
import ru.taximaxim.codekeeper.ui.XmlStringList;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class IgnoredObjectsPrefPage extends PreferencePage
implements IWorkbenchPreferencePage {

    private IgnoredObjectPrefListEditor listEditor;

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    private void updateList() {
        String preference = getPreferenceStore().getString(PREF.IGNORE_OBJECTS);

        LinkedList<IgnoredObject> list = new LinkedList<>();
        if (!preference.isEmpty()) {
            XmlStringList xml = new XmlStringList(XML_TAGS.IGNORED_OBJS_ROOT, XML_TAGS.IGNORED_OBJS_ELEMENT);
            try {
                list = IgnoredObject.parsePrefs(xml.deserializeList(new StringReader(preference)));
            } catch (IOException | SAXException ex) {
                ExceptionNotifier.notifyDefault(Messages.IgnoredObjectsPrefPage_error_getting_ignores_list, ex);
            }
        }
        listEditor.setInputList(list);
    }

    @Override
    protected Control createContents(Composite parent) {
        GridLayout gridLayout = new GridLayout();
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        parent.setLayout(gridLayout);
        parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        new Label(parent, SWT.NONE).setText(Messages.IgnoredObjectsPrefPage_these_objects_are_ignored_info);

        listEditor = new IgnoredObjectPrefListEditor(parent, true, true);

        updateList();

        return parent;
    }

    @Override
    protected void performDefaults() {
        super.performDefaults();
        updateList();
    }

    @Override
    public boolean performOk() {
        if (getPreferenceStore() != null) {
            StringWriter sw = new StringWriter();
            XmlStringList xml = new XmlStringList(XML_TAGS.IGNORED_OBJS_ROOT, XML_TAGS.IGNORED_OBJS_ELEMENT);
            try {
                xml.serializeList(listEditor.getList(), true, sw);
            } catch (IOException | TransformerException ex) {
                ExceptionNotifier.notifyDefault(Messages.IgnoredObjectsPrefPage_error_saving_ignores_list, ex);
            }
            getPreferenceStore().setValue(PREF.IGNORE_OBJECTS, sw.toString());
        }
        return true;
    }
}