package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.ProcBuilderUtils;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.fileutils.TempFile;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class PgDumper {

	public static PgDatabase pgDump(String exePgdump, PgDbProject props,
			SubMonitor pm) throws IOException, InterruptedException {
		SubMonitor subpm = SubMonitor.convert(pm, 2);
		
		try(TempFile tf = new TempFile(props.getProjectPath(),
				"tmp_dump_", ".sql")) {
			File dump = tf.get();
			
			subpm.newChild(1).subTask("Executing pg_dump");
			
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

			subpm.newChild(1).subTask("Loading dump");

			return PgDumpLoader.loadDatabaseSchemaFromDump(
					dump.getAbsolutePath(), 
					props.getString(UIConsts.PROJ_PREF_ENCODING),
					false, false);
		}
	}
}
