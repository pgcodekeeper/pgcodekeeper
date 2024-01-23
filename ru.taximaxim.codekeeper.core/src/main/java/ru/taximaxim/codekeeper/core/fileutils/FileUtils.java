/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.fileutils;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.PgDiffUtils;

public final class FileUtils {

    private static final DateTimeFormatter FILE_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH''mm''ss");
    private static final Pattern INVALID_FILENAME = Pattern.compile("[\\\\/:*?\"<>|]");

    /**
     * Deletes folder and its contents recursively.
     */
    public static void deleteRecursive(Path f) throws IOException {
        if (Files.isDirectory(f, LinkOption.NOFOLLOW_LINKS)) {
            try (Stream<Path> stream = Files.list(f)){
                for (Path sub : PgDiffUtils.sIter(stream)) {
                    deleteRecursive(sub);
                }
            } catch (UncheckedIOException wrapEx) {
                throw wrapEx.getCause();
            }
        }
        removeReadOnly(f);
    }

    public static void removeReadOnly(Path path) throws IOException {
        DosFileAttributeView att = Files.getFileAttributeView(
                path, DosFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
        if (att != null) {
            try {
                att.setReadOnly(false);
            } catch (FileSystemException ex) {
                // expected behaviour for symlinks on linux
                // the impl calls open(path, O_RDONLY | O_NOFOLLOW, 0)
                // which returns ELOOP which is translated into this exception
            }
        }
        Files.delete(path);
    }

    public static String sanitizeFilename(String name) {
        return INVALID_FILENAME.matcher(name).replaceAll("");
    }

    public static String getValidFilename(String name) {
        Matcher m = INVALID_FILENAME.matcher(name);
        if (m.find()) {
            return m.replaceAll("_"); //$NON-NLS-1$
        } else {
            return name;
        }
    }

    public static String getFileDate() {
        return FILE_DATE.format(LocalDateTime.now());
    }

    public static boolean isZipFile(Path path) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(path.toFile(), "r")) {
            int fileSignature = raf.readInt();
            return fileSignature == 0x504B0304 || fileSignature == 0x504B0506
                    || fileSignature == 0x504B0708;
        } catch (EOFException e) {
            return false;
        }
    }

    public static Path getUnzippedFilePath(Path metaPath, Path path) {
        String hash;
        if (path.startsWith(metaPath)) {
            hash = metaPath.relativize(path).toString();
        } else {
            hash = path.toString();
        }

        String name = path.getFileName().toString() + '_' + PgDiffUtils.md5(hash).substring(0, 10);

        return metaPath.resolve(name);
    }

    public static Path getLoadedFilePath(Path metaPath, URI uri) {
        String path = uri.getPath();
        String fileName = FileUtils.getValidFilename(Paths.get(path).getFileName().toString());
        String name = fileName + '_' + PgDiffUtils.md5(path).substring(0, 10);
        return metaPath.resolve(name);
    }

    public static String getNameFromUri(URI uri) {
        if (uri == null) {
            return null;
        }
        String urlPath = uri.getPath();
        if (urlPath != null) {
            return urlPath.substring(urlPath.lastIndexOf('/') + 1);
        }

        return uri.toString();
    }

    public static String readResource(Class<?> clazz, String fileName) throws IOException {
        try (InputStream inputStream = clazz.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                return null;
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    private FileUtils() {
    }
}
