package ca.csf.dfc.classes;
/**
 * Classe qui définit un Singleton pour la construction d'un objet de type Element
 * 
 * @author Philippe Deschênes
 *
 */
public class SGenerateurElement {
	/**
	 * Donnée statique de type GenerateurElement
	 */
	private static GenerateurElement instance = null;
	
	/**
	 * Constructeur privé de la classe 
	 */
	private SGenerateurElement() {
		
	}
	/**
	 * Méthode qui permet de gérer l'unicité de la donnée membre instance de la classe
	 * 
	 * @return un élément de type GenerateurElement
	 */
	public static GenerateurElement getInstance() {
		if (instance == null) {
			instance = new GenerateurElement();
		}
		return instance;
	}

}
	
