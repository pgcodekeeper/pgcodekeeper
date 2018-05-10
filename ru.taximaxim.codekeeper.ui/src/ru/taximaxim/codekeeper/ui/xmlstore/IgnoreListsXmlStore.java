package ru.taximaxim.codekeeper.ui.xmlstore;

import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class IgnoreListsXmlStore {

    private final Path storeFilePath;
    private final IgnoreListsPathsStore store = new IgnoreListsPathsStore();

    public IgnoreListsXmlStore(Path storeFilePath) {
        this.storeFilePath = storeFilePath;
    }

    public void setIgnoreListsPaths(Set<Path> ignoreListsPaths) {
        ignoreListsPaths.forEach(ignoreListPath -> store.getIgnoreListsPaths()
                .add(ignoreListPath.toString()));
    }

    public void writeIgnoreListsPathsToXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(IgnoreListsPathsStore.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(store, storeFilePath.toFile());
        } catch(JAXBException ex) {
            ExceptionNotifier.notifyDefault(MessageFormat.format(
                    Messages.IgnoreListProperties_error_file, storeFilePath), ex);
        }
    }

    public Set<String> readIgnoreListsPathsFromXML() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(IgnoreListsPathsStore.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return ((IgnoreListsPathsStore)jaxbUnmarshaller.unmarshal(storeFilePath.toFile()))
                    .getIgnoreListsPaths();
        } catch(JAXBException ex) {
            ExceptionNotifier.notifyDefault(MessageFormat.format(
                    Messages.IgnoreListProperties_error_file, storeFilePath), ex);
        }
        return Collections.emptySet();
    }
}

@XmlRootElement(name = "IgnoreListsPathsStore")
@XmlAccessorType(XmlAccessType.NONE)
class IgnoreListsPathsStore {

    @XmlElement(name="IgnoreListPath")
    private Set<String> ignoreListsPaths = new LinkedHashSet<>();

    public Set<String> getIgnoreListsPaths() {
        return ignoreListsPaths;
    }

    public void setIgnoreListsPaths(Set<String> ignoreListsPaths) {
        this.ignoreListsPaths = ignoreListsPaths;
    }
}
