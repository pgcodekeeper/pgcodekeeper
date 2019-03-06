package cz.startnet.utils.pgdiff;

import java.util.List;

public interface IProgressReporter {
    void writeMessage(String message);
    void writeWarning(String message);
    void writeError(String message);
    void terminate();
    void showData(List<List<Object>> Object);
}
