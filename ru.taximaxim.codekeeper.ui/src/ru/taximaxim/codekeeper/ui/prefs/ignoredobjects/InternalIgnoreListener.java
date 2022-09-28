package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import ru.taximaxim.codekeeper.core.model.difftree.IgnoreList;

public interface InternalIgnoreListener {

    void internalListUpdated(IgnoreList newList);
}
