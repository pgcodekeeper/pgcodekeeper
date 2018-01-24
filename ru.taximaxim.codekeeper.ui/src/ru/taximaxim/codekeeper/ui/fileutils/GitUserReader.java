package ru.taximaxim.codekeeper.ui.fileutils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.IndexDiff;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.filter.RevFilter;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.util.io.NullOutputStream;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.ElementMetaInfo;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class GitUserReader implements AutoCloseable {

    public static GitUserReader create (Path path) throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder().findGitDir(path.toFile());
        Repository repository;

        if (builder.getGitDir() != null || builder.getWorkTree() != null) {
            repository = builder.build();
            return new GitUserReader(repository);
        }
        return null;
    }

    private final Repository repo;

    private GitUserReader(Repository repo) {
        this.repo = repo;
    }

    public Path getLocation() {
        return repo.getDirectory().getParentFile().toPath();
    }

    public void parseLastChange(Map<String, List<ElementMetaInfo>> metas) {
        try (RevWalk r = new RevWalk(repo); DiffFormatter df = new DiffFormatter(NullOutputStream.INSTANCE);) {
            ObjectId head = repo.resolve(Constants.HEAD);

            r.setRevFilter(RevFilter.NO_MERGES);
            r.markStart(r.lookupCommit(head));
            df.setRepository(repo);
            Iterator<RevCommit> it = r.iterator();

            while (it.hasNext() && !metas.isEmpty()) {
                RevCommit commit = it.next();
                if (commit.getParentCount() > 0) {
                    String author = commit.getAuthorIdent().getName();
                    RevCommit parent = r.parseCommit(commit.getParent(0).getId());
                    List<DiffEntry> de = df.scan(parent.getTree(), commit.getTree());

                    for (DiffEntry d : de) {
                        String p = d.getNewPath();
                        List<ElementMetaInfo> meta = metas.remove(p);
                        if (meta != null) {
                            meta.forEach(e -> e.setAuthor(author));
                        }
                    }
                }
            }
        } catch (IOException e) {
            Log.log(Log.LOG_ERROR,  Messages.DiffTableViewer_error_reading_git_history, e);
        }
    }

    public void parseLocalChanges(Map<String, List<ElementMetaInfo>> metas) {
        try {
            ObjectId head = repo.resolve(Constants.HEAD);
            IndexDiff status = new IndexDiff(repo, head, new FileTreeIterator(repo));
            status.diff();
            Set<String> local = status.getAdded();
            local.addAll(status.getChanged());
            local.addAll(status.getMissing());
            local.addAll(status.getModified());
            local.addAll(status.getUntracked());
            local.addAll(status.getUntrackedFolders());

            local.forEach(e -> {
                List<ElementMetaInfo> set = metas.get(e);
                if (set != null) {
                    set.forEach(ElementMetaInfo::setChanged);
                }
            });
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
