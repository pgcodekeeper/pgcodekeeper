 
package ru.taximaxim.codekeeper.ui.parts;

import ru.taximaxim.codekeeper.ui.consoles.ConsoleFactory;

@Deprecated
public class Console {
    
    public static void addMessage(String msg) {
        ConsoleFactory.write(msg);
    }
}