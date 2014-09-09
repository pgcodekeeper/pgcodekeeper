package ru.taximaxim.codekeeper.ui.parts;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.Assert;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.EVENT;
import ru.taximaxim.codekeeper.ui.UIConsts.PART;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.sqledit.SqlSourceViewer;
import cz.startnet.utils.pgdiff.PgDiffUtils;

public class SqlEditorDescr extends DynamicE4View {
    
    // initializers
    // 3.x api doesn't provide create view->set data->activate/show/@PostConstruct separation
    private static File s_file;
    private static String s_nameToDisplay;

    @Inject
    private MPart part;
    @Inject
    private UISynchronize sync;
    @Inject
    private IWorkbenchPage page;
    @Inject
    private IViewPart viewPart;
    
    // constructor is injected before anything else
    // so we can prepare Persistent Data here via static fields
    @Inject
    SqlEditorDescr(MPart part, IWorkbenchPage page) {
        super(part, page);
        
        Assert.isNotNull(s_file);
        Assert.isNotNull(s_nameToDisplay);
        
        part.setLabel(s_nameToDisplay);
        String filename = s_file.getAbsolutePath();
        part.setTooltip(filename);
        part.getPersistedState().put(PART.SQL_EDITOR_FILENAME, filename);
    }
    
    @PostConstruct
    private void postConstruct(Composite parent, PgDbProject proj)
            throws UnsupportedEncodingException, IOException {
        parent.setLayout(new FillLayout());
        
        File fileText = new File(part.getPersistedState().get(PART.SQL_EDITOR_FILENAME));
        IDocument doc = new Document(new String(
                Files.readAllBytes(fileText.toPath()), 
                proj.getString(PROJ_PREF.ENCODING)));
        
        SqlSourceViewer v = new SqlSourceViewer(parent, SWT.NONE);
        v.addLineNumbers();
        v.setDocument(doc);
        v.setEditable(false);
    }
    
    /**
     * On PgDbProject change and reinjection close editors that do not belong to new project.
     */
    @Inject
    private void projectChanged(
            PgDbProject proj,
            @Optional
            @EventTopic(EVENT.REOPEN_PROJECT)
            PgDbProject proj2) {
        File myFile = new File(
                part.getPersistedState().get(PART.SQL_EDITOR_FILENAME));
        if(proj == null
                || !myFile.toPath().startsWith(proj.getProjectWorkingDir().toPath())
                || !myFile.exists()) {
            sync.asyncExec(new Runnable() {
                
                @Override
                public void run() {
                    page.hideView(viewPart);
                }
            });
        }
    }
    
    public static void openNew(File file, String nameToDisplay, IWorkbenchPage page) {
        Assert.isTrue(s_file == null);
        Assert.isTrue(s_nameToDisplay == null);
        
        Log.log(Log.LOG_DEBUG, "About to show editor: " + file.getAbsolutePath()); //$NON-NLS-1$
        
        try {
            s_file = file;
            s_nameToDisplay = nameToDisplay;
            
            page.showView(PART.SQL_EDITOR, PgDiffUtils.md5(file.getAbsolutePath()), 
                            IWorkbenchPage.VIEW_ACTIVATE);
        } catch (PartInitException ex) {
            throw new IllegalStateException(ex);
        } finally {
            // null out statics after use for the next call
            s_file = null;
            s_nameToDisplay = null;
        }
    }
}
