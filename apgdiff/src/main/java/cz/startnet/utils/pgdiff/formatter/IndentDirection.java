package cz.startnet.utils.pgdiff.formatter;

enum IndentDirection {
    /**
     * First token in new block
     */
    BLOCK_START,
    /**
     * Last token in block
     */
    BLOCK_STOP,
    /**
     * New line in block
     */
    BLOCK_LINE
}