package ru.taximaxim.codekeeper.apgdiff;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;

public class ApgdiffUtils {

    
    private ApgdiffUtils() {
    }

    public static File getFileFromOsgiRes(URL resourceUrl) throws URISyntaxException, IOException{
        URI uri;
        if (resourceUrl.getProtocol().equals("file")){
            uri = resourceUrl.toURI();            
        }else{
            uri = FileLocator.toFileURL(resourceUrl).toURI();
        }
        
        return new File(uri);
    }
}
