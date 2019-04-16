package cz.startnet.utils.pgdiff;

public interface IProgressReporter extends AutoCloseable {
    void writeMessage(String message);
    void writeWarning(String message);
    void writeError(String message);
    void terminate();

    @Override
    default void close() {
        terminate();
    }
}
