package ru.taximaxim.codekeeper.ui.externalcalls.utils;

import java.io.IOException;

@Deprecated
public class ReturnCodeException extends IOException {

    private static final long serialVersionUID = -280658816824675797L;
    
    private String output;

    public void setOutput(String output) {
        this.output = output;
    }
    
    public String getOutput() {
        return output;
    }
    
    public ReturnCodeException() {
    }

    public ReturnCodeException(String message) {
        super(message);
    }

    public ReturnCodeException(Throwable cause) {
        super(cause);
    }

    public ReturnCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
