package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.fileutils.TempFile;
import ru.taximaxim.codekeeper.ui.procutils.ProcBuilderUtils;
import ru.taximaxim.codekeeper.ui.procutils.StdStreamRedirector;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class PgDumper {

	public static PgDatabase pgDump(String exePgdump, PgDbProject props,
			IProgressMonitor pm) throws IOException, InterruptedException {
		SubMonitor subpm = SubMonitor.convert(pm, 2);
		
		try(TempFile tf = new TempFile(props.getProjectPath(),
				"tmp_dump_", ".sql")) {
			File dump = tf.get();
			
			subpm.subTask("Executing pg_dump");
			subpm.newChild(1);
			
			ProcessBuilder pgdump = new ProcessBuilder(exePgdump,
					"--file=" + dump.getAbsolutePath(),
					"--schema-only",
					"--no-password");
			
			ProcBuilderUtils env = new ProcBuilderUtils(pgdump);
			env.addEnv("PGHOST",
					props.getString(UIConsts.PROJ_PREF_DB_HOST));
			env.addEnv("PGPORT",
					props.getInt(UIConsts.PROJ_PREF_DB_PORT));
			env.addEnv("PGDATABASE",
					props.getString(UIConsts.PROJ_PREF_DB_NAME));
			env.addEnv("PGUSER",
					props.getString(UIConsts.PROJ_PREF_DB_USER));
			env.addEnv("PGPASSWORD",
					props.getString(UIConsts.PROJ_PREF_DB_PASS));
			env.addEnv("PGCLIENTENCODING",
					props.getString(UIConsts.PROJ_PREF_ENCODING));
			
			StdStreamRedirector.launchAndRedirect(pgdump);

			subpm.subTask("Loading dump");
			subpm.newChild(1);

			return PgDumpLoader.loadDatabaseSchemaFromDump(
					dump.getAbsolutePath(), 
					props.getString(UIConsts.PROJ_PREF_ENCODING),
					false, false);
		}
	}
}
