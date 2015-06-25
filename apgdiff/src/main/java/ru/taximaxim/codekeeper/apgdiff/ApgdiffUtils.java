package ru.taximaxim.codekeeper.apgdiff;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.URIUtil;

public class ApgdiffUtils {

    /**
     * @param url url should NOT be URL-encoded
     */
    public static File getFileFromOsgiRes(URL url) throws URISyntaxException, IOException {
        return new File(
                URIUtil.toURI(url.getProtocol().equals("file") ?
                        url : FileLocator.toFileURL(url)));
    }

    private ApgdiffUtils() {
    }
}
