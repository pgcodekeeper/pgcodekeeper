package cz.startnet.utils.pgdiff.schema;

import java.util.List;

public interface IFunction extends IStatement {
    String getBareName();
    String getReturns();
    List<IArgument> getArguments();
}