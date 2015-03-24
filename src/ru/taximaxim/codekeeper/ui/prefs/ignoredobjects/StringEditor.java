package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import ru.taximaxim.codekeeper.ui.UIConsts;

public class StringEditor {

    private Path path;

    public StringEditor(Path path) {
        this.path = path;
    }

    public List<IgnoredObject> loadSettings() throws IOException {
        List<IgnoredObject> list = new ArrayList<>();
        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            Charset charset = Charset.forName(UIConsts.UTF_8);
            try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    IgnoredObject parsedObj = IgnoredObject.parseLine(line.trim());
                    if (parsedObj != null) {
                        list.add(parsedObj);
                    }
                }
            } catch (IOException x) {
                throw new IOException(x);
            }
        }
        return list;
    }
}
