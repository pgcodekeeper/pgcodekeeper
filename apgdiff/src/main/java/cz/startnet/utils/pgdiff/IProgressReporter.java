package cz.startnet.utils.pgdiff;

import java.util.List;

public interface IProgressReporter extends AutoCloseable {
    void writeMessage(String message);
    void writeWarning(String message);
    void writeError(String message);
    void terminate();
    void showData(String query, List<List<Object>> Object);
    void reportErrorLocation(int start, int length);

    @Override
    default void close() {
        terminate();
    }
}
