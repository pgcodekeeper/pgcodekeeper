package ru.taximaxim.codekeeper.cli;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.URIUtil;

public class TestUtils {

    public static String readResource(Class<?> clazz, String fileName) throws IOException {
        try (InputStream inputStream = clazz.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                return null;
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    public static Path getPathToResource(Class<?> clazz, String fileName) throws IOException, URISyntaxException {
        URL url = clazz.getResource(fileName);
        return Paths.get(
                URIUtil.toURI("file".equals(url.getProtocol()) ?
                        url : FileLocator.toFileURL(url)));
    }
}
