package cz.startnet.utils.pgdiff.schema;

import java.util.List;

public interface IFunction extends IStatement, ISearchPath {
    String getBareName();
    String getReturns();
    List<? extends IArgument> getArguments();
}