package ru.taximaxim.codekeeper.ui.xmlstore;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import ru.taximaxim.codekeeper.ui.properties.PgLibrary;

public class DependenciesXmlStore extends XmlStore<PgLibrary> {

    public static final String FILE_NAME = ".dependencies"; //$NON-NLS-1$

    private static final String ENTRY = "dependency"; //$NON-NLS-1$
    private static final String PATH = "path"; //$NON-NLS-1$
    private static final String IGNORE_PRIV = "ignorePriv"; //$NON-NLS-1$
    private static final String ROOT_TAG = "dependencies"; //$NON-NLS-1$

    private final File file;

    public DependenciesXmlStore(File file) {
        super(file.getName(), ROOT_TAG);
        this.file = file;
    }

    public DependenciesXmlStore(IProject project) {
        this(new File(project.getLocation().toFile(), FILE_NAME));
    }

    @Override
    protected File getXmlFile() {
        return file;
    }

    @Override
    protected PgLibrary parseElement(Node node) {
        NamedNodeMap attr = node.getAttributes();
        return new PgLibrary(attr.getNamedItem(PATH).getTextContent(),
                Boolean.parseBoolean(attr.getNamedItem(IGNORE_PRIV).getTextContent()));
    }

    @Override
    protected void appendChildren(Document xml, Element root, List<PgLibrary> list) {
        for (PgLibrary dep : list) {
            Element newElement = xml.createElement(ENTRY);
            newElement.setAttribute(IGNORE_PRIV, Boolean.toString(dep.isIgnorePriv()));
            newElement.setAttribute(PATH, dep.getPath());
            root.appendChild(newElement);
        }
    }
}
