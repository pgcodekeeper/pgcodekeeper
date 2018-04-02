package ru.taximaxim.codekeeper.ui.xmlstore;

import java.io.File;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import ru.taximaxim.codekeeper.ui.properties.DepType;
import ru.taximaxim.codekeeper.ui.properties.Dependency;

public class DependenciesXmlStore extends XmlStore<Dependency> {

    private static final String ENTRY = "dependency"; //$NON-NLS-1$
    private static final String PATH = "path"; //$NON-NLS-1$
    private static final String KIND = "kind"; //$NON-NLS-1$
    private static final String IGNORE_PRIV = "ignorePriv"; //$NON-NLS-1$

    private final File file;

    public DependenciesXmlStore(File file, String rootTag) {
        super(file.getName(), rootTag);
        this.file = file;
    }

    @Override
    protected File getXmlFile() {
        return file;
    }

    @Override
    protected Dependency parseElement(Node node) {
        NamedNodeMap attr = node.getAttributes();
        return new Dependency(attr.getNamedItem(PATH).getTextContent(),
                DepType.valueOf(attr.getNamedItem(KIND).getTextContent()),
                Boolean.parseBoolean(attr.getNamedItem(IGNORE_PRIV).getTextContent()));
    }

    @Override
    protected void appendChildren(Document xml, Element root, List<Dependency> list) {
        for (Dependency dep : list) {
            Element newElement = xml.createElement(ENTRY);
            newElement.setAttribute(IGNORE_PRIV, Boolean.toString(dep.isIgnorePriv()));
            newElement.setAttribute(KIND, dep.getType().name());
            newElement.setAttribute(PATH, dep.getPath());
            root.appendChild(newElement);
        }
    }
}
