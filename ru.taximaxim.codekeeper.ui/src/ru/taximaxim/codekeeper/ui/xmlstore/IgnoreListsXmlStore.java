package ru.taximaxim.codekeeper.ui.xmlstore;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class IgnoreListsXmlStore {

    private final Path storeFilePath;
    private final IgnoreListsPathsStore store = new IgnoreListsPathsStore();

    public IgnoreListsXmlStore(Path storeFilePath) {
        this.storeFilePath = storeFilePath;
    }

    public void addNewIgnoreListPath(Path ignoreListPath) {
        store.getIgnoreListsPaths().add(ignoreListPath.toString());
    }

    public void writeIgnoreListsPathsToXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(IgnoreListsPathsStore.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(store, storeFilePath.toFile());
        } catch(JAXBException e) {
            // TODO add notification
            e.printStackTrace();
        }
    }

    /**
     *
     * @return collection with ignoreLists paths
     */
    public List<String> readIgnoreListsPathsFromXML() {
        try {
            JAXBContext jaxbContext2 = JAXBContext.newInstance(IgnoreListsPathsStore.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext2.createUnmarshaller();

            return ((IgnoreListsPathsStore)jaxbUnmarshaller.unmarshal(storeFilePath.toFile()))
                    .getIgnoreListsPaths();
        } catch(JAXBException e) {
            // TODO add notification
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}

@XmlRootElement(name = "IgnoreListsPathsStore")
@XmlAccessorType(XmlAccessType.NONE)
class IgnoreListsPathsStore {

    @XmlElement(name="IgnoreListPath")
    private List<String> ignoreListsPaths = new ArrayList<>();

    public List<String> getIgnoreListsPaths() {
        return ignoreListsPaths;
    }

    public void setIgnoreListsPaths(List<String> ignoreListsPaths) {
        this.ignoreListsPaths = ignoreListsPaths;
    }
}
