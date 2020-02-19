package ru.taximaxim.codekeeper.ui.libraries;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;

public abstract class CacheableLibrary extends AbstractLibrary {

    CacheableLibrary(AbstractLibrary parent, Path path, String name) {
        super(parent, path, name);
    }

    public void clear() throws IOException {
        clearAllChildren(children);
        children.clear();
        if (exists()) {
            FileUtils.deleteRecursive(getPath());
        }
    }

    public void refresh() throws IOException {
        children.clear();
        LibraryUtils.readDir(this, getPath());
    }

    private void clearAllChildren(List<AbstractLibrary> children) throws IOException {
        for (AbstractLibrary child : children) {
            clearAllChildren(child.getChildren());
            if (child instanceof CacheableLibrary) {
                CacheableLibrary lib = (CacheableLibrary) child;
                if (lib.exists()) {
                    FileUtils.deleteRecursive(lib.getPath());
                }
            }
        }
    }
}
