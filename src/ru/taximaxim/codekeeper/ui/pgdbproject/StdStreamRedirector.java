
package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ru.taximaxim.codekeeper.ui.parts.Console;

/**
 * A Runnable that consumes everything from the {@link InputStream},
 * redirects data to {@link Console} and optionally stores it as a String.
 * 
 * @author Alexander Levsha
 */
public class StdStreamRedirector implements Runnable {

	private BufferedReader in;
	
	private StringBuilder storage = new StringBuilder(2000);
	
	/**
	 * @param in {@link InputStream} to 
	 */
	private StdStreamRedirector(InputStream in) {
		this.in = new BufferedReader(new InputStreamReader(in));
	}
	
	@Override
	public void run() {
		String line = null;
		try {
			while((line = in.readLine()) != null) {
				Console.addMessage(line);
				storage.append(line);
				storage.append(System.lineSeparator());
		}
		} catch(IOException ex) {
			throw new IllegalStateException(
					"Error while reading from stdout/stderr", ex);
		}
	}
	
	/**
	 * Launches a process combining stdout & stderr and redirecting them
	 * onto {@link Console}.
	 * 
	 * @param cmdLine Command line to execute
	 * @param workingDir Working directory for process to start in
	 * @return captured stdout & stderr output
	 * @throws IOException
	 */
	public static String launchProcessWithRedirection(ProcessBuilder pb)
			throws IOException {
		pb.redirectErrorStream(true);
		Process p = pb.start();
		
		StdStreamRedirector redirector = new StdStreamRedirector(
				p.getInputStream());
		Thread redirectorThread = new Thread(redirector);
		redirectorThread.start();
		try {
			p.waitFor();
			redirectorThread.join();
		} catch(InterruptedException ex) {
			throw new IllegalStateException(ex);
		}
		
		return redirector.storage.toString();
	}
}
