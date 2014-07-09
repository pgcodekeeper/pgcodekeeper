package ru.taximaxim.codekeeper.ui.prefs;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * @author botov_av
 * Generate manage ignore objects preference page for main properties
 */
public class IgnoreObjectsPrefPage extends FieldEditorPreferencePage implements
        IWorkbenchPreferencePage {
    public IgnoreObjectsPrefPage() {
    }

    private String preference;
    private ListViewer listIgnoreObjs;
    private Text addingValue;
    private List<String> ignoreObjects = new ArrayList<String>();

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(UIScopedPreferenceStore.get());
    }

    @Override
    protected void createFieldEditors() {
        preference = getPreferenceStore().getString(
                UIConsts.PREF_IGNORE_OBJECTS);

        if (!preference.isEmpty()) {
            ignoreObjects = XMLStringBuild.getListFromXMLString(preference);
            listIgnoreObjs.refresh(false);
        }
    }

    @Override
    protected Control createContents(Composite parent) {

        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        composite.setLayout(gridLayout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.grabExcessVerticalSpace = true;
        composite.setLayoutData(gd);
        
        addingValue = new Text(composite, SWT.NONE);
        addingValue.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        Button btnAddIgnore = new Button(composite, SWT.PUSH);
        btnAddIgnore.setText(Messages.ignoreObjectsPrefPage_add_ignore);
        btnAddIgnore.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String newValue = addingValue.getText().trim();
                if (!newValue.isEmpty()) {
                    if (!ignoreObjects.contains(newValue)) {
                        ignoreObjects.add(newValue);
                        addingValue.setText(""); //$NON-NLS-1$
                        listIgnoreObjs.refresh(false);
                    }
                }
            }
        });
        
        listIgnoreObjs = new ListViewer(composite);
        gd = new GridData(GridData.FILL_BOTH);
        gd.horizontalSpan = 2;
        listIgnoreObjs.getList().setLayoutData(gd);
        
        initIgnoreList();

        Button btnDelIgnore = new Button(composite, SWT.PUSH);
        btnDelIgnore.setText(Messages.ignoreObjectsPrefPage_delete_ignore);
        new Label(composite, SWT.NONE);
        btnDelIgnore.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection selection = (IStructuredSelection) listIgnoreObjs
                        .getSelection();
                String ignoreObj = (String) selection.getFirstElement();
                if (ignoreObj == null) {
                    return;
                }

                ignoreObjects.remove(ignoreObj);

                listIgnoreObjs.refresh(false);
            }
        });
        
        createFieldEditors();
        
        return composite;
    }

    @Override
    protected void performDefaults() {
        preference = getPreferenceStore().getDefaultString(
                UIConsts.PREF_IGNORE_OBJECTS);
    }

    @Override
    public boolean performOk() {
        preference = XMLStringBuild.getXMLStringFromList(ignoreObjects);
        if (getPreferenceStore() != null) {
            getPreferenceStore().setValue(UIConsts.PREF_IGNORE_OBJECTS,
                    preference);
        }
        return true;
    }

    private void initIgnoreList() {
        listIgnoreObjs.setContentProvider(new IStructuredContentProvider() {
            public Object[] getElements(Object inputElement) {
                return ignoreObjects.toArray();
            }

            @Override
            public void dispose() {
                // do nothing
            }

            @Override
            public void inputChanged(Viewer viewer, Object oldInput,
                    Object newInput) {
                // do nothing
            }
        });

        listIgnoreObjs.setLabelProvider(new ILabelProvider() {

            @Override
            public void addListener(ILabelProviderListener listener) {
                // do nothing
            }

            @Override
            public void dispose() {
                // do nothing
            }

            @Override
            public boolean isLabelProperty(Object element, String property) {
                return false;
            }

            @Override
            public void removeListener(ILabelProviderListener listener) {
                // do nothing
            }

            @Override
            public Image getImage(Object element) {
                return null;
            }

            @Override
            public String getText(Object element) {
                return (String) element;
            }
        });

        listIgnoreObjs.setSorter(new ViewerSorter() {
            public int compare(Viewer viewer, Object e1, Object e2) {
                return ((String) e1).compareTo((String) e2);
            }

        });

        listIgnoreObjs.setInput(ignoreObjects);
    }
}

class XMLStringBuild {
    private static final String TAG = "ignored_objects"; //$NON-NLS-1$
    private static final String ELEMENT_LVL = "obj"; //$NON-NLS-1$

    private static Document createNewXml() {
        try {
            Document xml = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();
            Element root = xml.createElement(TAG);
            xml.appendChild(root);
            return xml;
        } catch (ParserConfigurationException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public static String getXMLStringFromList(List<String> listToConvert) {

        Document xml = createNewXml();
        Element element = xml.getDocumentElement();

        for (String listElement : listToConvert) {
            Element eNewComment = xml.createElement(ELEMENT_LVL);
            eNewComment.setTextContent(listElement);
            element.insertBefore(eNewComment, element.getFirstChild());
        }
        return getStringFromXML(xml);
    }

    public static List<String> getListFromXMLString(String xmlString) {
        Document xml = readFromString(xmlString);

        List<String> elements = new ArrayList<>();
        NodeList nlElement = ((Element) xml.getElementsByTagName(TAG).item(0))
                .getElementsByTagName(ELEMENT_LVL);
        for (int i = 0; i < nlElement.getLength(); ++i) {
            Node element = nlElement.item(i);
            if (element.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            elements.add(i, element.getTextContent());
        }

        return elements;
    }

    private static Document readFromString(String xmlString) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();            
            Document xml = builder.parse(new InputSource(
                    new StringReader(xmlString)));
            xml.getDocumentElement().normalize();

            if (!xml.getDocumentElement().getNodeName().equals(TAG)) {
                throw new IOException();
            }
            return xml;
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            throw new IllegalStateException(
                    Messages.ignoreObjectsPrefPage_Exception_thrown_during_parse_ignore_objects_preferences,
                    ex);
        }
    }

    private static String getStringFromXML(Document doc) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer
                    .setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no"); //$NON-NLS-1$
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            return writer.getBuffer().toString().replaceAll("\n|\r", ""); //$NON-NLS-1$ //$NON-NLS-2$
        } catch (TransformerException e) {
            return ""; //$NON-NLS-1$
        }
    }

}