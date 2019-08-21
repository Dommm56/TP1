package ca.csf.dfc.classes;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
/**
 * Classe qui implémente l'interface IElementBuilder
 * Cette classe permet de construire une ellipse grace au createurElement
 * Elle partie intégrante d'un design pattern de type Builder
 * 
 * @author Philippe Deschênes
 *
 */
public class EllipseBuilder implements IElementBuilder {
	/**
	 * Element qui est une ellipse de type Ellipse2D.Double
	 */
	private Element m_element;
	/**
	 * Constructeur de l'éllipse
	 * Initialise la donnée membre
	 */
	public EllipseBuilder() {
		this.m_element = new Element();
	}

	@Override
	public void constCouleur(Color p_couleur) {
		this.m_element.defCouleur(p_couleur);

	}

	@Override
	public Element getElement() {
		
		return this.m_element;
	}
	/**
	 * Méthode propre à la classe qui permet de construire correctement l'éllipse selon les paramètres fournis
	 * 
	 * @param p_posXOrig
	 * @param p_posYOrig
	 * @param p_posXFin
	 * @param p_posYFin
	 */
	private void ellipseBuilder(double p_posXOrig, double p_posYOrig, double p_posXFin, double p_posYFin) {
		double haut = p_posYFin - p_posYOrig;
		double larg = p_posXFin - p_posXOrig;
		this.m_element.defTypeElement(new Ellipse2D.Double(p_posXOrig, p_posYOrig, larg, haut));
	}

	@Override
	public void constTrait(float p_trait) {
		this.m_element.defTrait(p_trait);
		
	}

	@Override
	public void constRemplissage(Color p_remplissage) {
		this.m_element.defRemplissage(p_remplissage);
		
	}

	@Override
	public void constTypeElement(double p_posXOrig, double p_posYOrig, double p_posXFin, double p_posYFin) {
		ellipseBuilder(p_posXOrig, p_posYOrig, p_posXFin, p_posYFin);
		
	}

}
