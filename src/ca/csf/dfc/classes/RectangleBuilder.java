package ca.csf.dfc.classes;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class RectangleBuilder implements IElementBuilder {
	
	private Element m_element;
	
	public RectangleBuilder() {
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
	
	public void rectangleBuilder(double p_posXOrig, double p_posYOrig, double p_haut, double p_larg) {
		this.m_element.defTypeElement(new Rectangle2D.Double(p_posXOrig, p_posYOrig, p_haut, p_larg));
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
		rectangleBuilder(p_posXOrig, p_posYOrig, p_haut, p_larg);
		
	}

}
