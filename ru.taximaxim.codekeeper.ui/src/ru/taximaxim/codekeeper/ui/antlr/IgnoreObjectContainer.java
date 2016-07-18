package ru.taximaxim.codekeeper.ui.antlr;

import java.util.LinkedList;
import java.util.List;

import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.IgnoredObject;

public class IgnoreObjectContainer {

    private boolean black = true;
    private List<IgnoredObject> ignoredObjects = new LinkedList<>();

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    /**
     * @return the ignoredObjects
     */
    public List<IgnoredObject> getIgnoredObjects() {
        return ignoredObjects;
    }

    /**
     * @param ignoredObject the ignoredObject to add
     */
    public void addIgnoredObject(IgnoredObject ignoredObject) {
        this.ignoredObjects.add(ignoredObject);
    }

}
