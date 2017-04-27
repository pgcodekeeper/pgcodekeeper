package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;

import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class DepcyFromPSQLOutput extends StringEditorInput {

    private final Differ differ;
    private final IProject proj;
    private final List<FunctionBodyContainer> funcBodies = new ArrayList<>();
    private DbInfo dbinfo;
    private final String scriptFileEncoding;
    private StringStorage updatedScript;

    public List<FunctionBodyContainer> getFuncBodies() {
        return funcBodies;
    }

    public void setDbinfo(DbInfo dbinfo) {
        this.dbinfo = dbinfo;
    }

    public DbInfo getDbinfo() {
        return dbinfo;
    }

    public String getScriptFileEncoding() {
        return scriptFileEncoding;
    }

    public DepcyFromPSQLOutput(Differ differ, PgDbProject proj2) {
        super(getDiff(differ), Messages.diffPartDescr_diff_script);
        this.differ = differ;
        this.proj = proj2.getProject();
        String scriptFileEncoding;
        try {
            scriptFileEncoding = proj2.getProjectCharset();
        } catch (CoreException e) {
            scriptFileEncoding = ApgdiffConsts.UTF_8;
        }
        this.scriptFileEncoding = scriptFileEncoding;
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
