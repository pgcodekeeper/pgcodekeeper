package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Listener;

import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class DepcyFromPSQLOutput extends StringEditorInput {

    private static final Pattern PATTERN_ERROR = Pattern.compile(
            "^.*(ERROR|ОШИБКА):.+$"); //$NON-NLS-1$
    private static final Pattern PATTERN_DROP_CASCADE = Pattern.compile(
            "^(HINT|ПОДСКАЗКА):.+(DROP \\.\\.\\. CASCADE).+$",  //$NON-NLS-1$
            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

    private final Map<String, PgStatement> objList;
    private List<Entry<String, String>> addDepcy = new ArrayList<>();
    private final Differ differ;
    private List<Entry<PgStatement, PgStatement>> depcyToAdd;
    private final IProject proj;
    private PgDbParser parser;
    private final List<FunctionBodyContainer> funcBodies = new ArrayList<>();
    DbInfo dbinfo;
    private final String scriptFileEncoding;
    private StringStorage updatedScript;

    public List<FunctionBodyContainer> getFuncBodies() {
        return funcBodies;
    }

    public void setDbinfo(DbInfo dbinfo) {
        this.dbinfo = dbinfo;
    }

    public String getScriptFileEncoding() {
        return scriptFileEncoding;
    }

    public DepcyFromPSQLOutput(Differ differ, PgDbProject proj2, Map<String, PgStatement> list) {
        super(getDiff(differ), Messages.diffPartDescr_diff_script);
        this.differ = differ;
        this.proj = proj2.getProject();
        this.objList = list;
        String scriptFileEncoding;
        try {
            scriptFileEncoding = proj2.getProjectCharset();
        } catch (CoreException e) {
            scriptFileEncoding = ApgdiffConsts.UTF_8;
        }
        this.scriptFileEncoding = scriptFileEncoding;
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
                .append(UIConsts._NL);
            }
        }
        return sb.toString();
    }

    private List<Entry<PgStatement, PgStatement>> getAdditionalDepcyFromNames() {
        List<Entry<PgStatement, PgStatement>> result = new ArrayList<>();
        for (Entry<String, String> entry : addDepcy) {
            PgStatement depcy1 = objList.get(entry.getKey());
            PgStatement depcy2 = objList.get(entry.getValue());
            if (depcy1 != null && depcy2 != null) {
                result.add(new AbstractMap.SimpleEntry<>(
                        depcy1, depcy2));
            }
        }
        return result;
    }

    public boolean isAddDepcyEmpty() {
        return addDepcy.isEmpty();
    }

    public void updateParser(IProgressMonitor monitor)
            throws CoreException, InterruptedException, IOException, LicenseException {
        List<Listener> listener = new ArrayList<>();
        if (parser != null) {
            listener.addAll(parser.getListeners());
        }
        funcBodies.clear();
        parser = PgDbParser.getRollOnParser(getStorage().getContents(), scriptFileEncoding, monitor, funcBodies);
        for (Listener e : listener) {
            parser.addListener(e);
        }
        listener.clear();
        parser.notifyListeners();
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
        String[] lines = replaced.split("\n"); //$NON-NLS-1$
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
            String words[] = lines[begin + 1].split(" "); //$NON-NLS-1$
            // parse first case separately, as it starts from extra word "details"
            addDepcy.add(new AbstractMap.SimpleEntry<>(
                    words[2], words[words.length - 1]));
            // parse rest of dependencies
            parseDependencies(lines, begin + 2, end);
        }
    }

    private void parseDependencies(String[] lines, int begin, int end) {
        for (int i = begin; i < end; i++) {
            String words[] = lines[i].split(" "); //$NON-NLS-1$
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
            sb.append(UIConsts._NL);
        }
        return sb.toString();
    }

    public Differ getDiffer() {
        return differ;
    }

    public IProject getProject() {
        return proj;
    }

    public void updateScript(String newScript) {
        updatedScript = new StringStorage(newScript, getName());
    }

    @Override
    public IStorage getStorage() {
        return updatedScript == null ? super.getStorage() : updatedScript;
    }

    private static String getDiff(Differ differ) {
        return differ.getDiffDirect();
    }
}
