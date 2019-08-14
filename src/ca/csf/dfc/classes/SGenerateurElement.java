package ca.csf.dfc.classes;

public class SGenerateurElement {
	
	private static GenerateurElement instance = null;
	
	private SGenerateurElement() {
		
	}
	
	public static GenerateurElement getInstance() {
		if (instance == null) {
			instance = new GenerateurElement();
		}
		return instance;
	}

}
	
