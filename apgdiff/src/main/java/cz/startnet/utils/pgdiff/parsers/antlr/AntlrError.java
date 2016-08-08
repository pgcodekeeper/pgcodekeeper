package cz.startnet.utils.pgdiff.parsers.antlr;

public class AntlrError {

	private int line;
	private int charPositionInLine;
	private String msg;

	public AntlrError(int line, int charPositionInLine, String msg) {
		this.line = line;
		this.charPositionInLine = charPositionInLine;
		this.msg = msg;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getCharPositionInLine() {
		return charPositionInLine;
	}

	public void setCharPositionInLine(int charPositionInLine) {
		this.charPositionInLine = charPositionInLine;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
