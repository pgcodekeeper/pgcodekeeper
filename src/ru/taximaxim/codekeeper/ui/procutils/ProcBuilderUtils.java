package ru.taximaxim.codekeeper.ui.procutils;

public class ProcBuilderUtils {
	
	private final ProcessBuilder pb;
	
	public ProcBuilderUtils(ProcessBuilder pb) {
		this.pb = pb;
	}
	
	public void addEnv(String var, String value) {
		if(value != null && !value.isEmpty()) {
			pb.environment().put(var, value);
		}
	}
	
	public void addEnv(String var, int value) {
		if(value != 0) {
			pb.environment().put(var, ""+value);
		}
	}
}
