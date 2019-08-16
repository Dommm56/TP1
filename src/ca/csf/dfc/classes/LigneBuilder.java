package ca.csf.dfc.classes;

import java.awt.Color;
import java.awt.geom.Line2D;

public class LigneBuilder implements IElementBuilder {

private Element m_element;
	
	public LigneBuilder() {
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
	
	public void ligneBuilder(double p_posXOrig, double p_posYOrig, double p_posXFin, double p_posYFin) {
		this.m_element.defTypeElement(new Line2D.Double(p_posXOrig, p_posYOrig, p_posXFin, p_posYFin));
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
		ligneBuilder(p_posXOrig, p_posYOrig, p_haut, p_larg);
		
	}

}
