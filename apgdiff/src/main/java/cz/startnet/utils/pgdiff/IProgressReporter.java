package cz.startnet.utils.pgdiff;

public interface IProgressReporter {
    void writeMessage(String message);
    void writeWarning(String message);
    void writeError(String message);
    void terminate();
}
