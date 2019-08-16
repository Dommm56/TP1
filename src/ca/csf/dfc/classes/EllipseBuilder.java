package ca.csf.dfc.classes;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class EllipseBuilder implements IElementBuilder {
	
	private Element m_element;
	
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
	
	public void ellipseBuilder(double p_posXOrig, double p_posYOrig, double p_posXFin, double p_posYFin) {
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
	public void constTypeElement(double p_posXOrig, double p_posYOrig, double p_haut, double p_larg) {
		ellipseBuilder(p_posXOrig, p_posYOrig, p_haut, p_larg);
		
	}

}
