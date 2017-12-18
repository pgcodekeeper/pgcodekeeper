package cz.startnet.utils.pgdiff.schema;

import java.util.List;

public interface IFunction {
    String getName();
    String getReturns();
    List<IArgument> getArguments();
}