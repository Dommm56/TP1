package ca.csf.dfc.classes;

import java.awt.Color;
/**
 * Interface qui définit les méthodes qui permettent la construction d'un élément
 * Cette interface est partie intégrante d'un design pattern de type Builder
 * 
 * @author Philippe Deschênes
 *
 */
public interface IElementBuilder {
	/**
	 * Méthode qui permet de définir la couleur du trait de l'élément
	 * 
	 * @param p_couleur
	 */
	public void constCouleur(Color p_couleur);
	/**
	 * Méthode qui construit l'élément grace aux positions capté par la souris
	 * Elle appelle une méthode propre à chaque Builder concret
	 * 
	 * @param p_posXOrig
	 * @param p_posYOrig
	 * @param p_posXFin
	 * @param p_posYFin
	 */
	public void constTypeElement(double p_posXOrig, double p_posYOrig, double p_posXFin, double p_posYFin);
	/**
	 * Méthode qui permet de définir l'épaisseur du trait de l'élément
	 * 
	 * @param p_trait
	 */
	public void constTrait(float p_trait);
	/**
	 * Méthode qui permet de définir la couleur de remplissage
	 * 
	 * @param p_remplissage
	 */
	public void constRemplissage(Color p_remplissage);
	/**
	 * Méthode qui retourne l'Objet de type Élément
	 * 
	 * @return Element
	 */
	public Element getElement();

}
