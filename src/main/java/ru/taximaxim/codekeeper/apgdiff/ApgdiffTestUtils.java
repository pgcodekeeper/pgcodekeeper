package ru.taximaxim.codekeeper.apgdiff;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.eclipse.core.runtime.FileLocator;

public class ApgdiffTestUtils {
    
    public static File getFileFromRes(URL resourceUrl) throws URISyntaxException, IOException{
        URI uri;
        if (resourceUrl.getProtocol().equals("file")){
            uri = resourceUrl.toURI();            
        }else{
            uri = FileLocator.toFileURL(resourceUrl).toURI();
        }
        
        assertEquals("Could not convert URL to file uri: " + resourceUrl.toString(), 
                "file", uri.getScheme());
        File resource = new File(uri);
        assertTrue("Resource does not exist", resource.exists());
        return resource;
    }
}
