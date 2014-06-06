package ru.taximaxim.codekeeper.ui.prefs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
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
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.ExceptionNotifyHelper;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;

import com.jcraft.jsch.JSchException;

public class GitPrefPage extends FieldEditorPreferencePage
        implements IWorkbenchPreferencePage {
    
    private Button genKeysButt;
    private Button copyPublicKeyButt;
    private FileFieldEditor editorPrivate;
    
    public GitPrefPage() {
        super(GRID);
    }
    
    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(UIScopedPreferenceStore.get());
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
                if (privateFileName != null)
                    try {
                        JGitExec.genKeys(privateFileName);
                        editorPrivate.setStringValue(privateFileName);
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
                String publicFileName = editorPrivate.getTextControl(getFieldEditorParent()).getText() + ".pub";
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
                    box.setMessage("Public key file " + editorPrivate.getTextControl(getFieldEditorParent()).getText() + 
                            ".pub"+" either does not exist or inaccessible.");
                    box.open();
                }
            }
        });
        return super.createContents(parent);
    }
}