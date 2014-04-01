 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
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
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.ExceptionNotifyHelper;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.dbstore.DbStoreEditorDialog;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;
import ru.taximaxim.codekeeper.ui.prefs.ExecutableFileFieldEditor;
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
                        
                new FakePrefPageExtension("page.0.git", "GIT",
                                new GitPrefPage(), null)
        };
        
        PrefDialogFactory.show(shell, prefStore, pages);
    }
}

class GeneralPrefPage extends FieldEditorPreferencePage {

    public GeneralPrefPage() {
        super(GRID);
    }
    
    @Override
    protected void createFieldEditors() {
        addField(new ExecutableFileFieldEditor(UIConsts.PREF_SVN_EXE_PATH,
                "svn executable", getFieldEditorParent()));
        addField(new ExecutableFileFieldEditor(UIConsts.PREF_PGDUMP_EXE_PATH,
                "pg_dump executable", getFieldEditorParent()));
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
    private Text privateFileText;
    
    public GitPrefPage() {
        super(GRID);
    }

    @Override
    protected void createFieldEditors() {
        FileFieldEditor editorPrivate = new FileFieldEditor(UIConsts.PREF_GIT_KEY_PRIVATE_FILE,
                "Private key", getFieldEditorParent());
        addField(editorPrivate);
        privateFileText = editorPrivate.getTextControl(getFieldEditorParent());
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
                if (privateFileName != null)
                    try {
                        JGitExec.genKeys(privateFileName);
                        privateFileText.setText(privateFileName);
                    } catch (IOException | JSchException ex) {
                        ExceptionNotifyHelper
                                .notifyAndThrow(
                                        new IllegalStateException(
                                                "Some error occured during RSA keys creation and writing to files",
                                                ex), parent.getShell());
                    }
            }
        });
        copyPublicKeyButt = new Button(parent, SWT.PUSH);
        copyPublicKeyButt.setText("Copy public key to clipboard");
        copyPublicKeyButt.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String publicFileName = privateFileText.getText() + ".pub";
                File publicKey = new File (publicFileName);
                try (BufferedReader reader = new BufferedReader( new FileReader (publicKey))){
                    StringBuilder  sBuilder = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                        sBuilder.append(line + "\n");
                    }
                    Object [] data = new Object [] {sBuilder.toString()};
                    new Clipboard(parent.getDisplay()).setContents (data, new Transfer[]{TextTransfer.getInstance()});
                } catch (IOException e1) {
                    MessageBox box = new MessageBox(parent.getShell(), SWT.ERROR);
                    box.setMessage("Public key file " + privateFileText.getText() + 
                            ".pub"+" either does not exist or inaccessible.");
                    box.open();
                }
            }
        });
        return super.createContents(parent);
    }
}
