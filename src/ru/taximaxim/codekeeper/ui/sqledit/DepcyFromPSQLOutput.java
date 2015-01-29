package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;

import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class DepcyFromPSQLOutput implements IEditorInput, IStorageEditorInput {
    
    private static final Pattern PATTERN_ERROR = Pattern.compile(
            "^.*(ERROR|ОШИБКА):.+$"); //$NON-NLS-1$
    private static final Pattern PATTERN_DROP_CASCADE = Pattern.compile(
            "^(HINT|ПОДСКАЗКА):.+(DROP \\.\\.\\. CASCADE).+$",  //$NON-NLS-1$
            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE); 
    
    private List<PgStatement> objList;
    private List<Entry<String, String>> addDepcy;
    private Differ differ;
    List<Entry<PgStatement, PgStatement>> depcyToAdd;
    private IProject proj;
    private PgDbParser parser;
    
    String dbHost;
    String dbPort;
    String dbName;
    String dbUser;
    String dbPass;
    
    public DepcyFromPSQLOutput(Differ differ, IProject proj, List<PgStatement> list) {
        this.differ = differ;
        this.proj = proj;
        this.objList = list;
    }
    
    public List<Entry<PgStatement, PgStatement>> addAdditionalDepciesSource() {
        List<Entry<PgStatement, PgStatement>> saveToRestore = new ArrayList<>(
                differ.getAdditionalDepciesSource());
        differ.addAdditionalDepciesSource(depcyToAdd);
        return saveToRestore;
    }
    
    public String getRepeatedDepcy() {
        List<Entry<PgStatement, PgStatement>> existingDepcy = differ.getAdditionalDepciesSource();
        StringBuilder sb = new StringBuilder();
        depcyToAdd = getAdditionalDepcyFromNames();
        for (Entry<PgStatement, PgStatement> entry : depcyToAdd) {
            if (existingDepcy.contains(entry)) {
                sb.append(entry.getKey().getName())
                    .append(" -> ") //$NON-NLS-1$
                    .append(entry.getValue().getName())
                    .append(UIConsts.LINE_SEP);
            }
        }
        return sb.toString();
    }
    
    private List<Entry<PgStatement, PgStatement>> getAdditionalDepcyFromNames() {
        List<Entry<PgStatement, PgStatement>> result = new ArrayList<>();
        for (Entry<String, String> entry : addDepcy) {
            PgStatement depcy1 = getPgObjByName(entry.getKey());
            PgStatement depcy2 = getPgObjByName(entry.getValue());
            if (depcy1 != null && depcy2 != null) {
                result.add(new AbstractMap.SimpleEntry<>(
                    depcy1, depcy2));
            }
        }
        return result; 
    }

    public PgStatement getPgObjByName(String objName) {
        for (PgStatement obj : objList) {
            if (obj.getName().equals(objName)) {
                return obj; 
            }
        }
        return null;
    }
    
    public boolean isAddDepcyEmpty() {
        return addDepcy.isEmpty();
    }
    
    public void updateParser() throws CoreException {
        parser = PgDbParser.getRollOnParser(getStorage().getContents(), null);
    }
    public PgDbParser getParser() {
        return parser;
    }
    //------------------------------------------
    // From this only parsing from output begins
    //------------------------------------------
    
    public void getDependenciesFromOutput(String output) {
        addDepcy = new ArrayList<>();
        if (output == null || output.isEmpty()) {
            return;
        }
        
        int begin, end;
        begin = end = -1;
        
        // replacing all multiple spaces by single one, replacing CRLF by LF, 
        // replacing all leading spaces for every line in the string 
        String replaced = output.replaceAll("[ ]{2,}", " ") //$NON-NLS-1$ //$NON-NLS-2$
                .replaceAll("\r\n", "\n") //$NON-NLS-1$ //$NON-NLS-2$
                .replaceAll("(\n[ ]+)", "\n"); //$NON-NLS-1$ //$NON-NLS-2$
        String[] lines = replaced.split(Pattern.quote("\n")); //$NON-NLS-1$
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (PATTERN_ERROR.matcher(line).matches()) {
                begin = i;
            } 
            if (PATTERN_DROP_CASCADE.matcher(line).matches()) {
                end = i;
                break;
            }
        }
        
        if (begin != -1 && end != -1 && (end - begin) >= 2) {
            String words[] = lines[begin + 1].split(Pattern.quote(" ")); //$NON-NLS-1$
            // parse first case separately, as it starts from extra word "details"
            addDepcy.add(new AbstractMap.SimpleEntry<>(
                    words[2], words[words.length - 1]));
            // parse rest of dependencies
            parseDependencies(lines, begin + 2, end);
        }
    }

    private void parseDependencies(String[] lines, int begin, int end) {
        String space = Pattern.quote(" "); //$NON-NLS-1$
        for (int i = begin; i < end; i++) {
            String words[] = lines[i].split(space); 
            addDepcy.add(new AbstractMap.SimpleEntry<>(
                    words[1], words[words.length - 1]));
        }
    }
    
    public String depcyToString() {
        StringBuilder sb = new StringBuilder();
        for (Entry<String, String> entry : addDepcy) {
            sb.append(' '); 
            sb.append(entry.getKey());
            sb.append(" -> "); //$NON-NLS-1$
            sb.append(entry.getValue());
            sb.append(UIConsts.LINE_SEP); 
        }
        return sb.toString();
    }
    
    public void setDbParams(String dbHost, String dbPort, String dbName,
            String dbUser, String dbPass) {
        this.dbHost = dbHost;
        this.dbName = dbName; 
        this.dbUser = dbUser;
        this.dbPass = dbPass;
        this.dbPort = dbPort;
    }
    
    @Override
    public Object getAdapter(Class adapter) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean exists() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public ImageDescriptor getImageDescriptor() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public IPersistableElement getPersistable() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String getToolTipText() {
        // TODO Auto-generated method stub
        return null;
    }
    public Differ getDiffer() {
        return differ;
    }
    public IProject getProject() {
        return proj;
    }

    @Override
    public IStorage getStorage() throws CoreException {
        try {
            return new StringStorage(differ.getDiffDirect());
        } catch (PgCodekeeperUIException e) {
            return new StringStorage("");
        }
    }

    class StringStorage implements IStorage {
        String str;
        public StringStorage(String str) {
            this.str = str;
        }

        @Override
        public Object getAdapter(Class adapter) {
            return null;
        }

        @Override
        public InputStream getContents() throws CoreException {
            return new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        }

        @Override
        public IPath getFullPath() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public boolean isReadOnly() {
            return false;
        }
    }
}
