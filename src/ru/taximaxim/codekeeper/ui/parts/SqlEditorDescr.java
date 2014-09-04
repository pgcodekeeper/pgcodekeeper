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
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.EVENT;
import ru.taximaxim.codekeeper.ui.UIConsts.PART;
import ru.taximaxim.codekeeper.ui.UIConsts.PART_STACK;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.sqledit.SqlSourceViewer;
import cz.startnet.utils.pgdiff.PgDiffUtils;

public class SqlEditorDescr {
    
    // persistent data initializers
    // 3.x api doesn't provide create view->set data->activate/show/@PostConstruct separation
    private static File s_file;
    private static String s_nameToDisplay;

    @Inject
    private MPart part;
    
    @Inject
    UISynchronize sync;
    
    @Inject
    private EPartService partService;
    
    // constructor is injected before anything else
    // so we can prepare Persistent Data here via static fields
    @Inject
    public SqlEditorDescr(MPart p) {
        System.err.println("ctor");
        
        Assert.isNotNull(s_file);
        Assert.isNotNull(s_nameToDisplay);
        
        p.setLabel(s_nameToDisplay);
        String filename = s_file.getAbsolutePath();
        p.setTooltip(filename);
        p.getPersistedState().put(PART.SQL_EDITOR_FILENAME, filename);
    }
    
    @PostConstruct
    private void postConstruct(Composite parent, PgDbProject proj)
            throws UnsupportedEncodingException, IOException {
        // a lot of time in this; all before this seems to be fine 
        parent.setLayout(new FillLayout());
        System.err.println("@pc");
        File fileText = new File(part.getPersistedState().get(PART.SQL_EDITOR_FILENAME));
        IDocument doc = new Document(new String(
                Files.readAllBytes(fileText.toPath()), 
                /*proj.getString(PROJ_PREF.ENCODING)*/ "utf-8"));
        
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
        System.err.println("@inj");
        File myFile = new File(
                part.getPersistedState().get(PART.SQL_EDITOR_FILENAME));
        if(proj == null
                || !myFile.toPath().startsWith(proj.getProjectWorkingDir().toPath())
                || !myFile.exists()) {
            sync.asyncExec(new Runnable() {
                
                @Override
                public void run() {
                //    partService.hidePart(part);
                }
            });
        }
    }
    
    public static void openNew_(File file, String nameToDisplay) {
        System.err.println("static");
        Assert.isTrue(s_file == null);
        Assert.isTrue(s_nameToDisplay == null);
        
        Log.log(Log.LOG_DEBUG, "About to show editor: " + file.getAbsolutePath()); //$NON-NLS-1$
        
        try {
            s_file = file;
            s_nameToDisplay = nameToDisplay;
            
            
            /*
             * При таком создании вьюхи ни контекст ни TransientData не содержат
             * E4PartWrapper, который должна вернуть showView как IViewPart
             * 
             *  Разобраться, как его создать в конструкторе, полодить в контекст и transient data
             *  так же PartSite
             *  
             *  продебажить создание 3х вьюхи/вьюхи в перспектив лейауте
             */
            
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                    .showView(PART.SQL_EDITOR, 
                            PgDiffUtils.md5(file.getAbsolutePath()), 
                            IWorkbenchPage.VIEW_CREATE);
        } catch (PartInitException ex) {
            throw new IllegalStateException(ex);
        } finally {
            // null out statics after use for the next call
            s_file = null;
            s_nameToDisplay = null;
        }
    }
    
    public static void openNew(File file, EModelService model, EPartService partService,
            MApplication app, String nameToDisplay) {
        for(MPart existingPart : model.findElements(
                app, PART.SQL_EDITOR, MPart.class, null)) {
            if(file.getAbsolutePath().equals(
                    existingPart.getPersistedState().get(PART.SQL_EDITOR_FILENAME))) {
                partService.activate(existingPart);
                return;
            }
        }
        
        Log.log(Log.LOG_DEBUG, "About to show editor: " + file.getAbsolutePath()); //$NON-NLS-1$
        
        MPart newEditor = partService.createPart(PART.SQL_EDITOR);
        newEditor.setLabel(nameToDisplay);
        newEditor.setTooltip(file.getAbsolutePath());
        newEditor.getPersistedState().put(
                PART.SQL_EDITOR_FILENAME, file.getAbsolutePath());
        ((MPartStack) model.find(PART_STACK.EDITORS, app)).getChildren().add(newEditor);
        partService.activate(newEditor, false);
    }
}
