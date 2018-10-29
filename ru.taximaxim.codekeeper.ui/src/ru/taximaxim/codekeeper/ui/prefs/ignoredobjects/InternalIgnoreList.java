package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Platform;

import ru.taximaxim.codekeeper.apgdiff.ignoreparser.IgnoreParser;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public final class InternalIgnoreList {

    private static final ListenerList<InternalIgnoreListener> LISTENERS = new ListenerList<>();

    public static void addListener(InternalIgnoreListener listener) {
        LISTENERS.add(listener);
    }

    public static void removeListener(InternalIgnoreListener listener) {
        LISTENERS.remove(listener);
    }

    static void notifyListeners(IgnoreList newList) {
        for (InternalIgnoreListener listener : LISTENERS) {
            listener.internalListUpdated(newList);
        }
    }

    /**
     * Reads internal ignore list and handles any errors that arise using {@link ExceptionNotifier}.
     *
     * @return internal ignore list or an empty list if an error occurred.
     */
    public static IgnoreList readInternalList() {
        IgnoreList list = new IgnoreList();
        Path listFile = getInternalIgnoreFile();
        if (listFile != null) {
            readAppendList(listFile, list);
        }
        return list;
    }

    public static IgnoreList readAppendList(Path listFile, IgnoreList appendTo) {
        return readAppendList(listFile, appendTo, false);
    }

    /**
     * Append to given ignore list new ignore list from given path
     *
     * @param listFile path to the black-white list file
     * @param appendTo existing {@link IgnoreList} to fill with new entries
     * @param showNotFound if false this method treats {@link FileNotFoundException} as not-an-error,
     * since both internal and project's <code>.pgcodekeeperignore</code> files may be absent
     * @return <code>appendTo</code> {@link IgnoreList} filled with entries read from <code>listFile</code>
     */
    public static IgnoreList readAppendList(Path listFile, IgnoreList appendTo, boolean showNotFound) {
        try {
            new IgnoreParser(appendTo).parse(listFile);
        } catch (FileNotFoundException | NoSuchFileException ex) {
            if (showNotFound) {
                ExceptionNotifier.notifyDefault(MessageFormat.format(
                        Messages.IgnoredObjectsPrefPage_error_getting_ignores_list, listFile), ex);
            }
        } catch (IOException ex) {
            ExceptionNotifier.notifyDefault(MessageFormat.format(
                    Messages.IgnoredObjectsPrefPage_error_getting_ignores_list, listFile), ex);
        }
        return appendTo;
    }

    /**
     * Returns path to %workspace%/.metadata/.plugins/%this_plugin%/.pgcodekeeperignore.<br>
     *
     * @return path
     */
    static Path getInternalIgnoreFile() {
        return Paths.get(Platform.getStateLocation(Activator.getContext().getBundle())
                .append(FILE.IGNORED_OBJECTS).toString());
    }

    private InternalIgnoreList() {
    }
}
