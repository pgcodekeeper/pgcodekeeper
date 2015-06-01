package ru.taximaxim.codekeeper.apgdiff;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

import org.eclipse.core.runtime.FileLocator;

public class ApgdiffUtils {

    public static File getFileFromOsgiRes(URL url) throws URISyntaxException, IOException{
        URI uri;
        if (!url.getProtocol().equals("file")){
            url = FileLocator.toFileURL(url);
        }
        uri = new URI(url.getProtocol(), 
                null /*userInfo*/,
                url.getHost(), 
                url.getPort(), 
                (url.getPath()==null)?null:URLDecoder.decode(url.getPath(), ApgdiffConsts.UTF_8),
                (url.getQuery()==null)?null:URLDecoder.decode(url.getQuery(), ApgdiffConsts.UTF_8),
                null /*fragment*/);
        
        return new File(uri);
    }

    private ApgdiffUtils() {
    }
}
