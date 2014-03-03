package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.externalcalls.SvnExec;
import ru.taximaxim.codekeeper.ui.fileutils.Dir;
import ru.taximaxim.codekeeper.ui.fileutils.TempDir;

public class ProjectCreator implements IRunnableWithProgress {
	
	final private String exePgdump, exeSvn; 
	
	final private PgDbProject props;
	
	final private String dumpPath;
	
	final private boolean doInit;
	
	public ProjectCreator(final IPreferenceStore mainPrefStore,
			final PgDbProject props, final String dumpPath, boolean doInit) {
		this.exePgdump = mainPrefStore.getString(UIConsts.PREF_PGDUMP_EXE_PATH);
		this.exeSvn = mainPrefStore.getString(UIConsts.PREF_REPO_EXE_PATH);
		
		this.props = props;
		this.dumpPath = dumpPath;
		this.doInit = doInit;
	}
	
	@Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException {
        try {
            int workToDo = doInit? 100 : 1;
            SubMonitor pm = SubMonitor.convert(monitor, "Creating project...", workToDo); // 0
            
            SvnExec svn = new SvnExec(exeSvn, props);
            
            pm.newChild(doInit? 25 : workToDo).subTask("SVN current rev checkout..."); // 25 or 100%
            File dirSvn = props.getProjectSchemaDir();
            if(dirSvn.exists()) {
                Dir.deleteRecursive(dirSvn);
            }
            Files.createDirectory(dirSvn.toPath());
            svn.repoCheckOut(dirSvn);
            
            // clean repository, generate new file structure,
            // preserve and fix svn metadata, svn rm/add, commit new revision
            if(doInit) {
                SubMonitor taskpm = pm.newChild(25); // 50

                PgDatabase db;
                switch(props.getString(UIConsts.PROJ_PREF_SOURCE)) {
                case UIConsts.PROJ_SOURCE_TYPE_DB:
                    db = DbSource.fromDb(exePgdump, props).get(taskpm);
                    break;
                    
                case UIConsts.PROJ_SOURCE_TYPE_DUMP:
                    db = DbSource.fromFile(dumpPath,
                            props.getString(UIConsts.PROJ_PREF_ENCODING)).get(taskpm);
                    break;
                    
                default:
                    throw new InvocationTargetException(
                            new IllegalStateException("Init requested but no Schema Source"));
                }

                pm.newChild(25).subTask("Exporting DB model..."); // 75
                
                try(TempDir tmpSvnMeta = new TempDir(props.getProjectPath(),
                        "tmp_svn_meta_")) {
                    File svnMetaProj = new File(dirSvn, ".svn");
                    File svnMetaTmp = new File(tmpSvnMeta.get(), ".svn");
                    Files.move(svnMetaProj.toPath(), svnMetaTmp.toPath());
                    Dir.deleteRecursive(dirSvn);
                    
                    new ModelExporter(dirSvn.getAbsolutePath(), db, 
                            props.getString(UIConsts.PROJ_PREF_ENCODING)).export();
                    
                    Files.move(svnMetaTmp.toPath(), svnMetaProj.toPath());
                }
                
                pm.newChild(25).subTask("SVN committing..."); // 100
                svn.repoRemoveMissing(dirSvn);
                svn.repoAddAll(dirSvn);
                svn.repoCommit(dirSvn, "new rev");
            }
            
            monitor.done();
        } catch(IOException ex) {
            throw new InvocationTargetException(ex,
                    "IOException while creating project!");
        }
    }
}
