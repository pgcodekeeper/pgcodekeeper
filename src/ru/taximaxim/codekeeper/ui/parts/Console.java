 
package ru.taximaxim.codekeeper.ui.parts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.resource.JFaceResources;

public class Console {
	
	private static LogSync log;
	
	public static void addMessage(String msg) {
		if(log != null) {
			log.addMessage(msg);
		}
	}
	
	@PostConstruct
	public void postConstruct(Composite parent,
			@Named(IServiceConstants.ACTIVE_SHELL)
			Shell shell,
			UISynchronize sync) {
		log = new LogSync(sync);
		
		parent.setLayout(new FillLayout());
		
		Text consoleLog = new Text(parent, SWT.MULTI
				| SWT.V_SCROLL | SWT.H_SCROLL | SWT.READ_ONLY);
		consoleLog.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
		consoleLog.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		
		log.setTextControl(consoleLog);
	}
	
	@PreDestroy
	public void preDestroy() {
		log.setTextControl(null);
	}
}

class LogSync {
	private final UISynchronize sync;
	
	private final Object syncLog = new Object();
	
	private Text consoleLog;
	
	LogSync(UISynchronize sync) {
		this.sync = sync;
	}
	
	void setTextControl(Text text) {
		synchronized (syncLog) {
			consoleLog = text;
		}
	}
	
	void addMessage(final String msg) {
		sync.asyncExec(new Runnable() {
			
			@Override
			public void run() {
				synchronized (syncLog) {
					if(consoleLog == null) {
						return;
					}
					
					consoleLog.append(msg);
					consoleLog.append(System.lineSeparator());
				}
			}
		});
	} 
}