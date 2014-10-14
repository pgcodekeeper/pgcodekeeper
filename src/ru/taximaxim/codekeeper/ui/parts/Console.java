 
package ru.taximaxim.codekeeper.ui.parts;

@Deprecated
public class Console {
    
    public static void addMessage(String msg) {
        ConsoleFactory.write(msg);
    }
}