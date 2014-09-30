 
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

public class Console {
    
    private static LogSync log;
    
    public static void addMessage(String msg) {
        if(log != null) {
            log.addMessage(msg);
        }
        ConsoleFactory.write(msg);
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
