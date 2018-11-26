package cz.startnet.utils.pgdiff.libraries;

import java.net.URI;
import java.net.URISyntaxException;

public class PgLibrary {

    private final String path;
    private final PgLibrarySource source;
    private boolean isIgnorePriv;

    public PgLibrary(String path) {
        this(path, true);
    }

    public PgLibrary(String path, boolean hasPriv) {
        this.path = path;
        this.source = getSource(path);
        this.isIgnorePriv = hasPriv;
    }

    public String getPath() {
        return path;
    }

    public PgLibrarySource getSource() {
        return source;
    }

    public boolean isIgnorePriv() {
        return isIgnorePriv;
    }

    public void setIgnorePriv(boolean isIgnorePriv) {
        this.isIgnorePriv = isIgnorePriv;
    }

    public static PgLibrarySource getSource(String libPath) {
        if (libPath.startsWith("jdbc:")) {
            return PgLibrarySource.JDBC;
        }
        try {
            URI uri = new URI(libPath);
            if (uri.getScheme() != null) {
                return PgLibrarySource.URL;
            }
        } catch (URISyntaxException e) {
            // not URI, try to folder or file
        }
        return PgLibrarySource.LOCAL;
    }
}