package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class SvnExec {
	
	private static final Pattern PATTERN_MISSING_FILE = Pattern.compile(
			"^(?:!.{6}[\\s]+)(.*)$", Pattern.MULTILINE);
	
	private static final Pattern PATTERN_UNVERSIONED = Pattern.compile(
			"^(?:\\?.{6}[\\s]+)(.*)$", Pattern.MULTILINE);
	
	private static final Pattern PATTERN_ST_CONFLICTED = Pattern.compile(
	        "^(?:C.{6}[\\s]+)(.*)$", Pattern.MULTILINE);
	
	private static final Pattern PATTERN_UP_CONFLICTED = Pattern.compile(
            "^(?:C.{3}[\\s]+)(.*)$", Pattern.MULTILINE);
	
	private static final Pattern PATTERN_VERSION = Pattern.compile(
	        "^[\\d]+\\.[\\d]+\\.[\\d]+$");
	
	private final String svnExec;
	
	private final String url, user, pass;
	
	public SvnExec(String svnExec, String url, String user, String pass) {
		this.svnExec = svnExec;
		
		this.url = url;
		this.user = user;
		this.pass = pass;
	}
	
	public SvnExec(String svnExec, PgDbProject proj) {
	    this(svnExec,
	            proj.getString(UIConsts.PROJ_PREF_SVN_URL),
	            proj.getString(UIConsts.PROJ_PREF_SVN_USER),
	            proj.getString(UIConsts.PROJ_PREF_SVN_PASS));
	}
	
	/**
	 * Constructs an object for simple operations,
	 * not requiring credentials and/or repository URL.
	 * 
	 * Such operations WILL THROW NPEs when performed on this object.
	 * 
	 * @param svnExec
	 */
	public SvnExec(String svnExec) {
	    this.svnExec = svnExec;
	    
	    url = user = pass = null;
	}
	
	public void svnCo(File dirTo) throws IOException {
	    svnCo(dirTo, null);
	}
	
	public void svnCo(File dirTo, String rev) throws IOException {
		ProcessBuilder svn = new ProcessBuilder(svnExec,
				"co",
				"--non-interactive");
		addCredentials(svn);
		if(rev != null && !rev.isEmpty()) {
            svn.command().add("-r");
            svn.command().add(rev);
        }
		addUrl(svn);
		svn.command().add(".");
		
		svn.directory(dirTo);
		
		StdStreamRedirector.launchAndRedirect(svn);
	}
	
	public void svnCi(File dirFrom, String comment) throws IOException {
		ProcessBuilder svn = new ProcessBuilder(svnExec,
				"ci",
				"--non-interactive");
		addCredentials(svn);
		svn.command().add("--message");
		svn.command().add(comment);
		svn.command().add(".");
		
		svn.directory(dirFrom);
		
		StdStreamRedirector.launchAndRedirect(svn);
	}
	
	public void svnRmMissing(File dirIn) throws IOException {
		List<String> files = svnGetMissing(dirIn);
		if(!files.isEmpty()) {
			svnRm(dirIn, files);
		}
	}
	
	private List<String> svnGetMissing(File dirIn) throws IOException {
		List<String> files = new ArrayList<>();
		Matcher m = PATTERN_MISSING_FILE.matcher(svnStatus(dirIn));
		while(m.find()) {
			files.add(m.group(1));
		}
		return files;
	}
	
	private void svnRm(File dirIn, String... files) throws IOException {
		svnRm(dirIn, Arrays.asList(files));
	}
	
	private void svnRm(File dirIn, List<String> files) throws IOException {
		if(files.isEmpty()) {
			throw new IllegalArgumentException(
					"Cannot svn rm an empty file list!");
		}
		
		ProcessBuilder svn = new ProcessBuilder(svnExec,
				"rm",
				"--non-interactive");
		svn.command().addAll(files);
		svn.directory(dirIn);
		
		StdStreamRedirector.launchAndRedirect(svn);
	}
	
	public void svnAddAll(File dirIn) throws IOException {
		List<String> files = svnGetUnversioned(dirIn);
		
		while(!files.isEmpty()) {
			ProcessBuilder svn = new ProcessBuilder(svnExec,
					"add",
					"--non-interactive",
					"--depth", "infinity",
					"--force", "--parents");
			svn.command().addAll(files);
			svn.directory(dirIn);
			
			StdStreamRedirector.launchAndRedirect(svn);
			
			files = svnGetUnversioned(dirIn);
		}
	}
	
	private List<String> svnGetUnversioned(File dirIn) throws IOException {
		List<String> files = new ArrayList<>();
		Matcher m = PATTERN_UNVERSIONED.matcher(svnStatus(dirIn));
		while(m.find()) {
			files.add(m.group(1));
		}
		return files;
	}
	
	public boolean hasConflicts(File dirIn) throws IOException {
	    return !svnGetConflicted(dirIn).isEmpty();
	}
	
	private List<String> svnGetConflicted(File dirIn) throws IOException {
	    List<String> files = new ArrayList<>();
	    Matcher m = PATTERN_ST_CONFLICTED.matcher(svnStatus(dirIn));
	    while(m.find()) {
	        files.add(m.group(1));
	    }
	    return files;
	}
	
	private String svnStatus(File dirIn) throws IOException {
	    return svnStatus(dirIn, false);
	}
	
	private String svnStatus(File dirIn, boolean showUpdates) throws IOException {
	    ProcessBuilder svn = new ProcessBuilder(svnExec,
                "st",
                "--non-interactive");
	    if(showUpdates) {
	        svn.command().add("--show-updates");
	    }
	    
        svn.directory(dirIn);
        return StdStreamRedirector.launchAndRedirect(svn);
	}
	
	/**
	 * Performs svn update on dirIn.
	 * 
	 * @param dirIn
	 * @return false if opration generated item conflicts
	 * @throws IOException
	 */
	public boolean svnUpdate(File dirIn) throws IOException {
	    ProcessBuilder svn = new ProcessBuilder(svnExec,
	            "up",
	            "--non-interactive");
	    svn.directory(dirIn);
	    
	    return !PATTERN_UP_CONFLICTED.matcher(
	            StdStreamRedirector.launchAndRedirect(svn)).find();
	}
	
	private void addCredentials(ProcessBuilder pb) {
		if(user != null && !user.isEmpty()) {
			pb.command().add("--username");
			pb.command().add(user);
		}
		if(pass != null && !pass.isEmpty()) {
			pb.command().add("--password");
			pb.command().add(pass);
		}
	}
	
	private void addUrl(ProcessBuilder pb) {
		if(url != null) {
			pb.command().add(url);
		}
	}
	
	public String svnGetVersion() throws IOException {
	    ProcessBuilder svn = new ProcessBuilder(svnExec,
	            "--version", "--quiet",
	            "--non-interactive");
	    String version = StdStreamRedirector.launchAndRedirect(svn).trim();
	    if(!PATTERN_VERSION.matcher(version).matches()) {
	        throw new IOException("Bad svn --version output: " + version);
	    }
	    return version;
	}
}
