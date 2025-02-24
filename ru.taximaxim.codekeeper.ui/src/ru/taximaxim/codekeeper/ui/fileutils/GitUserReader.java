/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.fileutils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.lib.BaseRepositoryBuilder;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.IndexDiff;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.filter.RevFilter;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.util.io.NullOutputStream;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.differ.ElementMetaInfo;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public final class GitUserReader implements AutoCloseable {

    public static boolean checkRepo(Path path) {
        FileRepositoryBuilder builder = new FileRepositoryBuilder().findGitDir(path.toFile());
        return builder.getGitDir() != null || builder.getWorkTree() != null;
    }

    private final Repository repo;

    /**
     * Base constructor that search git repository from given path
     *
     * @param path project path
     * @throws IOException the repository could not be accessed to configure the rest of the builder's parameters
     * @throws IllegalArgumentException if repository not found
     * @see BaseRepositoryBuilder#requireGitDirOrWorkTree
     */
    public GitUserReader(Path path) throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder().findGitDir(path.toFile());
        repo = builder.build();
    }

    public Path getLocation() {
        return repo.getDirectory().getParentFile().toPath();
    }

    /**
     * Looks for the author of the latest changes from the history of git.
     * The values ​​found will be removed from the map
     *
     * @param metas map with elements meta information grouped by their location
     */
    public void parseLastChange(Map<String, List<ElementMetaInfo>> metas) {
        try (RevWalk r = new RevWalk(repo); DiffFormatter df = new DiffFormatter(NullOutputStream.INSTANCE);) {
            ObjectId head = repo.resolve(Constants.HEAD);
            if (head == null) {
                return;
            }
            r.setRevFilter(RevFilter.NO_MERGES);
            r.markStart(r.lookupCommit(head));
            df.setRepository(repo);
            Iterator<RevCommit> it = r.iterator();

            while (it.hasNext() && !metas.isEmpty()) {
                RevCommit commit = it.next();
                String author = commit.getAuthorIdent().getName();
                RevTree parent = commit.getParentCount() > 0 ?
                        r.parseCommit(commit.getParent(0).getId()).getTree() : null;

                List<DiffEntry> de = df.scan(parent, commit.getTree());
                for (DiffEntry d : de) {
                    List<ElementMetaInfo> meta = metas.remove(d.getNewPath());
                    if (meta != null) {
                        meta.forEach(e -> e.setGitUser(author));
                    }
                }
            }
        } catch (IOException e) {
            Log.log(Log.LOG_ERROR, Messages.DiffTableViewer_error_reading_git_history, e);
        }
    }

    public void parseLocalChanges(Map<String, List<ElementMetaInfo>> metas) {
        try {
            ObjectId head = repo.resolve(Constants.HEAD);
            IndexDiff status = new IndexDiff(repo, head, new FileTreeIterator(repo));
            status.diff();

            Consumer<String> setter = e -> {
                List<ElementMetaInfo> set = metas.get(e);
                if (set != null) {
                    set.forEach(ElementMetaInfo::setChanged);
                }
            };

            status.getAdded().forEach(setter);
            status.getChanged().forEach(setter);
            status.getModified().forEach(setter);
            status.getUntracked().forEach(setter);
            status.getUntracked().forEach(metas::remove);
        } catch (IOException e) {
            Log.log(Log.LOG_ERROR, Messages.GitUserReader_error_reading_local_changes, e);
        }
    }

    @Override
    public void close() {
        if (repo != null) {
            repo.close();
        }
    }
}
