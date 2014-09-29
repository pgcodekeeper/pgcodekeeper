 
package ru.taximaxim.codekeeper.ui.parts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class Console {
    
    private static LogSync log;
    private static MessageConsoleStream outer;
    
    public static void addMessage(String msg) {
        if(log != null) {
            log.addMessage(msg);
        }
        if (outer == null) {
            findConsole();
        }
        outer.println(msg);
    }
    
    @PostConstruct
    private void postConstruct(Composite parent, Display display, UISynchronize sync) {
        log = new LogSync(sync);
        
        parent.setLayout(new FillLayout());
        
        Text consoleLog = new Text(parent, SWT.MULTI
                | SWT.V_SCROLL | SWT.H_SCROLL | SWT.READ_ONLY);
        consoleLog.setFont(JFaceResources.getTextFont());
        consoleLog.setBackground(display.getSystemColor(SWT.COLOR_LIST_BACKGROUND));
        
        log.setTextControl(consoleLog);
    }
    
    @PreDestroy
    private void preDestroy() {
        log.setTextControl(null);
    }
    
    private static void findConsole() {
        String name = "MyConsole";
        MessageConsole myConsole = null;
        ConsolePlugin plugin = ConsolePlugin.getDefault();
        IConsoleManager conMan = plugin.getConsoleManager();
        IConsole[] existing = conMan.getConsoles();
        for (int i = 0; i < existing.length; i++) {
            if (name.equals(existing[i].getName())) {
                myConsole = (MessageConsole) existing[i];
            }
        }
        if (myConsole == null) {
            myConsole = new MessageConsole(name, null);
        }
        conMan.addConsoles(new IConsole[] { myConsole });
        outer = myConsole.newMessageStream();
     }
}

class LogSync {
    
    private final UISynchronize sync;
    private Text consoleLog;
    
    LogSync(UISynchronize sync) {
        this.sync = sync;
    }
    
    void setTextControl(Text text) {
        consoleLog = text;
    }
    
    void addMessage(final String msg) {
        sync.asyncExec(new Runnable() {
            
            @Override
            public void run() {
                if(consoleLog == null) {
                    return;
                }
                
                consoleLog.append(msg);
                consoleLog.append(System.lineSeparator());
            }
        });
    } 
}
