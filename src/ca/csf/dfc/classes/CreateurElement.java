package ca.csf.dfc.classes;

import java.awt.Color;
/**
 * Classe qui dirige la construction d'un élément de type Element
 * Cette classe est partie intégrante d'un design pattern de type Builder
 * Elle est le Directeur du pattern
 * 
 * @author Philippe Deschênes
 *
 */
public class CreateurElement {
	/**
	 * Donnée membre de type IElementBuilder qui représente la construction d'un objet de type Element
	 */
	private IElementBuilder m_elementBuilder;
	/**
	 * Constructeur du CreateurElement
	 */
	public CreateurElement() {
		this.m_elementBuilder = null;
	}
	/**
	 * Constructeur d'initialisation du CreateurElement
	 * 
	 * @param p_elementBuilder
	 */
	public CreateurElement(IElementBuilder p_elementBuilder) {
		this.m_elementBuilder = p_elementBuilder;
	}
	/**
	 * Permet de retourner l'élément créer
	 * 
	 * @return
	 */
	public Element getElement() {
		return this.m_elementBuilder.getElement();
	}
	
	/**
	 * Permet d'appeler le builder concret pour construction du bon élément 
	 * 
	 * @param p_posXOrig
	 * @param p_posYOrig
	 * @param p_haut
	 * @param p_larg
	 * @param p_couleur
	 * @param p_trait
	 * @param p_remplissage
	 */
	public void construireElement(double p_posXOrig, double p_posYOrig, double p_haut, double p_larg, Color p_couleur, float p_trait, Color p_remplissage) {
		this.m_elementBuilder.constCouleur(p_couleur);
		this.m_elementBuilder.constRemplissage(p_remplissage);
		this.m_elementBuilder.constTrait(p_trait);
		this.m_elementBuilder.constTypeElement(p_posXOrig, p_posYOrig, p_haut, p_larg);
	}

}
