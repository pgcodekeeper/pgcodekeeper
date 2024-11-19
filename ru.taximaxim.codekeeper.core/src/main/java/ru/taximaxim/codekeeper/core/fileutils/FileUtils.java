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
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.localizations.Messages;

public final class FileUtils {

    private static final String EMPTY_STRING = ""; //$NON-NLS-1$

    private static final Random RANDOM = new SecureRandom();

    private static final DateTimeFormatter FILE_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH''mm''ss"); //$NON-NLS-1$
    private static final Pattern INVALID_FILENAME = Pattern.compile("[\\\\/:*?\"<>|]"); //$NON-NLS-1$
    private static final Pattern MS_DB_NAME_PATTERN = Pattern.compile("\\=[^;]+\\;"); //$NON-NLS-1$

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
        Files.deleteIfExists(path);
    }

    public static String sanitizeFilename(String name) {
        return INVALID_FILENAME.matcher(name).replaceAll(EMPTY_STRING); // $NON-NLS-1$
    }

    public static String getValidFilename(String name) {
        Matcher m = INVALID_FILENAME.matcher(name);
        return m.find() ? m.replaceAll("_") : name; //$NON-NLS-1$
    }

    public static String getFileDate() {
        return FILE_DATE.format(LocalDateTime.now());
    }

    public static boolean isZipFile(Path path) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(path.toFile(), "r")) { //$NON-NLS-1$
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

    public static String dbNameFromUrl(String url) {
        if (url.startsWith("jdbc:sqlserver")) { //$NON-NLS-1$
            Matcher m = MS_DB_NAME_PATTERN.matcher(url);
            if (m.find()) {
                String s = m.group();
                return s.substring(1, s.length() - 1).replace("{", EMPTY_STRING).replace("}", EMPTY_STRING); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }

        try {
            return getNameFromUri(new URI(url.substring(5)));
        } catch (URISyntaxException e) {
            return EMPTY_STRING;
        }
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

    public static void loadURI(URI uri, String fileName, Path dir) throws IOException {
        // do nothing if directory already exists
        if (Files.exists(dir)) {
            return;
        }

        Path file = dir.resolve(fileName);
        try (InputStream in = uri.toURL().openStream()) {
            Files.createDirectories(dir);
            Files.copy(in, file);
        } catch (FileAlreadyExistsException e) {
            // someone else won the race and created the file
        } catch (IOException e) {
            IOException ioe = new IOException(
                    Messages.FileUtils_error_while_read_uri_lib.formatted(uri, e.getLocalizedMessage()), e);

            try {
                Files.deleteIfExists(file);
            } catch (IOException ex) {
                ioe.addSuppressed(ex);
            }

            try {
                Files.deleteIfExists(dir);
            } catch (IOException ex) {
                ioe.addSuppressed(ex);
            }

            throw ioe;
        }
    }

    public static String unzip(Path zip, Path dir) throws IOException {
        // return output directory if it exists
        if (Files.exists(dir)) {
            return dir.toString();
        }
        // create a directory with a unique name to avoid problems with parallel downloads
        Path tempDir = dir.resolveSibling(dir.getFileName() + "_" + RANDOM.nextInt()); //$NON-NLS-1$

        Files.createDirectories(tempDir);
        Path destDir = tempDir.toRealPath();

        try (FileSystem fs = FileSystems.newFileSystem(zip, (ClassLoader) null)) {
            final Path root = fs.getPath("/"); //$NON-NLS-1$

            // walk the zip file tree and copy files to the destination
            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Path destFile = Paths.get(destDir.toString(), file.toString());
                    Files.copy(file, destFile, StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    Path dirToCreate = Paths.get(destDir.toString(), dir.toString());
                    if (Files.notExists(dirToCreate)) {
                        Files.createDirectory(dirToCreate);
                    }

                    return FileVisitResult.CONTINUE;
                }
            });
        }

        // data racing
        if (!Files.exists(dir)) {
            // rename to expected name
            Files.move(tempDir, dir, StandardCopyOption.REPLACE_EXISTING);
        }

        return dir.toRealPath().toString();
    }

    private FileUtils() {
    }
}
