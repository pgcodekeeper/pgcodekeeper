package ru.taximaxim.codekeeper.ui.libraries;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import org.eclipse.swt.graphics.Image;

import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class ZipLibrary extends AbstractLibrary {

    private boolean isZipped;

    ZipLibrary(AbstractLibrary parent, Path path) {
        super(parent, path);
    }

    public boolean isZipped() {
        return isZipped;
    }

    public void setZipped(boolean isZipped) {
        this.isZipped = isZipped;
    }

    @Override
    public List<AbstractLibrary> getChildren() {
        if (isZipped) {
            return Collections.emptyList();
        }

        return super.getChildren();
    }

    @Override
    public boolean hasChildren() {
        return !isZipped && super.hasChildren();
    }

    @Override
    public String getLabel() {
        StringBuilder sb = new StringBuilder(name);
        if (isZipped) {
            sb.append(" [not unzipped]"); //$NON-NLS-1$
        }

        if (getParent() instanceof LibraryContainer) {
            sb.append(" - ").append(path.getParent()); //$NON-NLS-1$
        }

        return sb.toString();
    }

    @Override
    public Image getImage() {
        return Activator.getRegisteredImage(FILE.ZIP);
    }

    public void clearCache() throws IOException {
        children.clear();
        Path unZipped = FileUtils.getUnzippedFilePath(LibraryUtils.META_PATH, path);
        if (Files.exists(unZipped)) {
            FileUtils.deleteRecursive(unZipped);
            setZipped(true);
        }
    }

    public void reload() throws IOException {
        children.clear();
        LibraryUtils.readZip(this, path);
    }
}
