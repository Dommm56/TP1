package ca.csf.dfc.classes;

public class SGenerateurElement {
	
	private static CreateurElement instance = null;
	
	private SGenerateurElement() {
		
	}
	
	public static CreateurElement getInstance() {
		if(instance == null) {
			instance = new CreateurElement();
		}
		return instance;
	}

}
