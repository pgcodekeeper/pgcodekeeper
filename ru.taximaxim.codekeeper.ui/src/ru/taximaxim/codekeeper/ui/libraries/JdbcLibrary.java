package ru.taximaxim.codekeeper.ui.libraries;

import java.util.Objects;

import org.eclipse.swt.graphics.Image;

import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class JdbcLibrary extends AbstractLibrary {

    private final String url;

    JdbcLibrary(AbstractLibrary parent, String url) {
        super(parent, null, JdbcConnector.dbNameFromUrl(url));
        this.url = url;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public Image getImage() {
        return Activator.getRegisteredImage(FILE.ICONDATABASE);
    }

    @Override
    public String getLibPath() {
        return url;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof JdbcLibrary && super.equals(obj)) {
            JdbcLibrary lib = (JdbcLibrary) obj;
            return Objects.equals(url, lib.url);
        }

        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }
}
