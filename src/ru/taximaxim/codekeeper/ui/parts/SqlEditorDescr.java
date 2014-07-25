package ru.taximaxim.codekeeper.ui.parts;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.EVENT;
import ru.taximaxim.codekeeper.ui.UIConsts.PART;
import ru.taximaxim.codekeeper.ui.UIConsts.PART_STACK;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class SqlEditorDescr {
    
    @Inject
    private MPart part;
    
    @Inject
    UISynchronize sync;
    
    @Inject
    private EPartService partService;
    
    @PostConstruct
    private void postConstruct(Composite parent, PgDbProject proj)
            throws UnsupportedEncodingException, IOException {
        parent.setLayout(new FillLayout());
        
        Text txt = new Text(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
                | SWT.READ_ONLY | SWT.MULTI);
        
        txt.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
        txt.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
        
        File fileText = new File(part.getPersistedState().get(PART.SQL_EDITOR_FILENAME));
        txt.setText(new String(Files.readAllBytes(fileText.toPath()),
                proj.getString(PROJ_PREF.ENCODING)));
    }
    
    /**
     * On PgDbProject change and reinjection close editors that do not belong to new project.
     * 
     * @param proj
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
                    partService.hidePart(part);
                }
            });
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
