package ru.taximaxim.codekeeper.ui.libraries;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;

public abstract class CacheableLibrary extends AbstractLibrary {

    private final String libPath;

    CacheableLibrary(AbstractLibrary parent, Path path, String name, String fullName) {
        super(parent, path, name);
        this.libPath = fullName;
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
        // do not refresh nested libs, they're not nested in UI tree
        new UiLibraryLoader(false).readLib(this, path.toString());
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

    public boolean exists() {
        return Files.exists(getPath());
    }

    @Override
    public String getLibPath() {
        return libPath;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof CacheableLibrary && super.equals(obj)) {
            CacheableLibrary lib = (CacheableLibrary) obj;
            return Objects.equals(libPath, lib.libPath);
        }

        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((libPath == null) ? 0 : libPath.hashCode());
        return result;
    }
}
