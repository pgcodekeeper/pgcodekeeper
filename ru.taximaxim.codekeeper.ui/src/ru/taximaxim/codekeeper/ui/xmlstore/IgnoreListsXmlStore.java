package ru.taximaxim.codekeeper.ui.xmlstore;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class IgnoreListsXmlStore extends XmlStore<String> {

    private static final String ROOT_TAG = "IgnoreListsPathsStore";
    private static final String ENTRY = "IgnoreListPath";

    private final File file;

    public IgnoreListsXmlStore(File file) {
        super(file.getName(), ROOT_TAG);
        this.file = file;
    }

    public IgnoreListsXmlStore(IProject proj) {
        this(new File(new File(proj.getLocation().toFile(), ".settings"), FILE.IGNORE_LISTS_STORE));
    }

    @Override
    public File getXmlFile() {
        return file;
    }

    @Override
    protected String parseElement(Node node) {
        return node.getTextContent();
    }

    @Override
    protected void appendChildren(Document xml, Element root,
            List<String> list) {
        for (String path : list) {
            Element newElement = xml.createElement(ENTRY);
            newElement.setTextContent(path);
            root.appendChild(newElement);
        }
    }
}