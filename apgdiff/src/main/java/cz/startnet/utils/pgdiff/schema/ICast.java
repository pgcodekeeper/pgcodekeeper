package cz.startnet.utils.pgdiff.schema;

public interface ICast extends IStatement {
    String getSource();
    String getTarget();
    CastContext getContext();
}
