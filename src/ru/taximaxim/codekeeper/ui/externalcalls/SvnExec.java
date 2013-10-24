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
			"^(?:![\\s]+)(.*)$", Pattern.MULTILINE);
	
	private static final Pattern PATTERN_UNVERSIONED = Pattern.compile(
			"^(?:\\?[\\s]+)(.*)$", Pattern.MULTILINE);
	
	private final String svnExec;
	
	private final PgDbProject props;
	
	public SvnExec(String svnExec, PgDbProject props) {
		this.svnExec = svnExec;
		this.props = props;
	}
	
	public void svnCo(File dirTo) throws IOException {
		ProcessBuilder svn = new ProcessBuilder(svnExec,
				"co",
				"--non-interactive");
		addCredentials(svn);
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
		ProcessBuilder svn = new ProcessBuilder(svnExec,
				"st",
				"--non-interactive");
		svn.directory(dirIn);
		
		List<String> files = new ArrayList<>();
		Matcher m = PATTERN_MISSING_FILE.matcher(
				StdStreamRedirector.launchAndRedirect(svn));
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
		ProcessBuilder svn = new ProcessBuilder(svnExec,
				"st",
				"--non-interactive");
		svn.directory(dirIn);
		
		List<String> files = new ArrayList<>();
		Matcher m = PATTERN_UNVERSIONED.matcher(
				StdStreamRedirector.launchAndRedirect(svn));
		while(m.find()) {
			files.add(m.group(1));
		}
		return files;
	}
	
	private void addCredentials(ProcessBuilder pb) {
		String user = props.getString(UIConsts.PROJ_PREF_SVN_USER);
		String pass = props.getString(UIConsts.PROJ_PREF_SVN_PASS);
		
		if(!user.isEmpty()) {
			pb.command().add("--username");
			pb.command().add(user);
		}
		if(!pass.isEmpty()) {
			pb.command().add("--password");
			pb.command().add(pass);
		}
	}
	
	private void addUrl(ProcessBuilder pb) {
		String url = props.getString(UIConsts.PROJ_PREF_SVN_URL);
		if(!url.isEmpty()) {
			pb.command().add(url);
		}
	}
}
