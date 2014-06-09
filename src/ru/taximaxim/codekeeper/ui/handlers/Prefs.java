 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.inject.Named;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.statushandlers.StatusManager;

import ru.taximaxim.codekeeper.ui.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.dbstore.DbStoreEditorDialog;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;
import ru.taximaxim.codekeeper.ui.prefs.FakePrefPageExtension;
import ru.taximaxim.codekeeper.ui.prefs.PrefDialogFactory;

import com.jcraft.jsch.JSchException;

public class Prefs {
    
    @Execute
    private void execute(
            @Named(UIConsts.PREF_STORE)
            IPreferenceStore prefStore,
            @Named(IServiceConstants.ACTIVE_SHELL)
            Shell shell) {
        FakePrefPageExtension[] pages = {
                
                new FakePrefPageExtension("page.0.general", "General",
                        new GeneralPrefPage(), null),
                        
                new FakePrefPageExtension("page.1.dbstore", "DB Store",
                        new DbStorePrefPage(), "page.0.general"),
                        
                new FakePrefPageExtension("page.0.git", "Git+SSH",
                                new GitPrefPage(), null)
        };
        
        Log.log(Log.LOG_DEBUG, "About to show app prefs dialog");
        
        PrefDialogFactory.show(shell, prefStore, pages);
    }
}

class GeneralPrefPage extends FieldEditorPreferencePage {

    public GeneralPrefPage() {
        super(GRID);
    }
    
    @Override
    protected void createFieldEditors() {
        addField(
                new FileFieldEditor(UIConsts.PREF_PGDUMP_EXE_PATH, "pg_dump executable", getFieldEditorParent()){
                    @Override
                    protected boolean checkState() {
                        return true;
                    }
                });
        
        addField(new StringFieldEditor(UIConsts.PREF_PGDUMP_CUSTOM_PARAMS,
                "pg_dump custom parameters", getFieldEditorParent()));
        
        BooleanFieldEditor openLast = new BooleanFieldEditor(
                UIConsts.PREF_OPEN_LAST_ON_START, "Open last project on startup",
                FileFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent());
        addField(openLast);
        openLast.setEnabled(false, getFieldEditorParent());
    }
}

class DbStorePrefPage extends FieldEditorPreferencePage {
    
    private String preference;

    public DbStorePrefPage() {
        super(GRID);
    }
    
    @Override
    protected void createFieldEditors() {
        // this is our "hidden field editor"
        preference = getPreferenceStore().getString(UIConsts.PREF_DB_STORE);
    }
    
    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        getDefaultsButton().setText("Clear DB Store");
    }
    
    @Override
    protected Control createContents(Composite parent) {
        Button btnDbStore = new Button(parent, SWT.PUSH);
        btnDbStore.setText("Edit Db Store...");
        btnDbStore.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DbStoreEditorDialog dialog = new DbStoreEditorDialog(
                        getShell(), preference);
                
                if(dialog.open() == Dialog.OK) {
                    preference = dialog.getPreferenceString();
                    
                    if(preference.trim().isEmpty()) {
                        performDefaults();
                    }
                }
            }
        });
        
        return super.createContents(parent);
    }
    
    @Override
    protected void performDefaults() {
        preference = getPreferenceStore().getDefaultString(UIConsts.PREF_DB_STORE);
    }
    
    @Override
    public boolean performOk() {
        if(getPreferenceStore() != null) {
            getPreferenceStore().setValue(UIConsts.PREF_DB_STORE, preference);
        }
        return true;
    }
}

class GitPrefPage extends FieldEditorPreferencePage {
    private Button genKeysButt;
    private Button copyPublicKeyButt;
    private FileFieldEditor editorPrivate;
    
    public GitPrefPage() {
        super(GRID);
    }

    @Override
    protected void createFieldEditors() {
        editorPrivate = new FileFieldEditor(UIConsts.PREF_GIT_KEY_PRIVATE_FILE, 
                "Private key", true, FileFieldEditor.VALIDATE_ON_KEY_STROKE,
                getFieldEditorParent());
        addField(editorPrivate);
    }
    
    @Override
    protected Control createContents(final Composite parent) {
        genKeysButt = new Button(parent, SWT.PUSH);
        genKeysButt.setText("Generate keys");
        genKeysButt.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                MessageBox dialog = new MessageBox(getShell(), SWT.OK);
                dialog.setMessage("Select file to save private key");
                dialog.open();
                FileDialog fd = new FileDialog(parent.getShell(), SWT.SAVE);
                fd.setText("Save private key to a file...");
                fd.setOverwrite(true);
                String privateFileName = fd.open();
                if (privateFileName != null){
                    try {
                        JGitExec.genKeys(privateFileName);
                        editorPrivate.setStringValue(privateFileName);
                    } catch (IOException | JSchException ex) {
                        Status status = new Status(IStatus.ERROR, UIConsts.PLUGIN_ID, 
                                "Error occured during RSA keys creation and writing to files", ex);
                        StatusManager.getManager().handle(status, StatusManager.BLOCK);
                    }
                }
            }
        });
        copyPublicKeyButt = new Button(parent, SWT.PUSH);
        copyPublicKeyButt.setText("Copy public key to clipboard");
        copyPublicKeyButt.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String publicFileName = editorPrivate.getTextControl(
                        getFieldEditorParent()).getText() + ".pub";
                File publicKey = new File (publicFileName);
                try (BufferedReader reader = new BufferedReader( new FileReader (publicKey))){
                    StringBuilder  sBuilder = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                        sBuilder.append(line + "\n");
                    }
                    Object [] data = new Object [] {sBuilder.toString()};
                    new Clipboard(parent.getDisplay()).setContents (data, 
                            new Transfer[]{TextTransfer.getInstance()});
                } catch (IOException ex) {
                    Status status = new Status(IStatus.ERROR, UIConsts.PLUGIN_ID, 
                            "Public key file " + editorPrivate.getTextControl(
                                    getFieldEditorParent()).getText() + 
                                    ".pub either does not exist or inaccessible.", ex);
                    StatusManager.getManager().handle(status, StatusManager.BLOCK);
                }
            }
        });
        return super.createContents(parent);
    }
}
