package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.IOException;

public class FileException extends IOException {

	private static final long serialVersionUID = 1L;
	
	public FileException() {
	}

	public FileException(String message) {
		super(message);
	}

	public FileException(Throwable cause) {
		super(cause);
	}

	public FileException(String message, Throwable cause) {
		super(message, cause);
	}
}
