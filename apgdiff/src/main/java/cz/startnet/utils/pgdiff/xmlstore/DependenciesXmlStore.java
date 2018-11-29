package cz.startnet.utils.pgdiff.xmlstore;

import java.nio.file.Path;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import cz.startnet.utils.pgdiff.libraries.PgLibrary;

public class DependenciesXmlStore extends XmlStore<PgLibrary> {

    public static final String FILE_NAME = ".dependencies"; //$NON-NLS-1$

    private static final String ENTRY = "dependency"; //$NON-NLS-1$
    private static final String PATH = "path"; //$NON-NLS-1$
    private static final String IGNORE_PRIV = "ignorePriv"; //$NON-NLS-1$
    private static final String ROOT_TAG = "dependencies"; //$NON-NLS-1$

    private final Path xmlPath;

    public DependenciesXmlStore(Path path) {
        super(path.getFileName().toString(), ROOT_TAG);
        this.xmlPath = path;
    }

    @Override
    protected Path getXmlFile() {
        return xmlPath;
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
