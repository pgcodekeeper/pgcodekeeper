package ru.taximaxim.codekeeper.ui.externalcalls.utils;

public class ProcBuilderUtils {

    private final ProcessBuilder pb;

    public ProcBuilderUtils(ProcessBuilder pb) {
        this.pb = pb;
    }

    public void addEnv(String variable, String value) {
        if (value != null && !value.isEmpty()) {
            pb.environment().put(variable, value);
        }
    }

    public void addEnv(String variable, int value) {
        if (value != 0) {
            pb.environment().put(variable, String.valueOf(value));
        }
    }
}
