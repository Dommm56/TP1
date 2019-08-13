package ca.csf.dfc.classes;

import java.awt.Color;

public class CreateurElement {
	
	private IElementBuilder m_elementBuilder;
	
	public CreateurElement(IElementBuilder p_elementBuilder) {
		this.m_elementBuilder = p_elementBuilder;
	}
	
	public Element getElement() {
		return this.m_elementBuilder.getElement();
	}
	
	public void construireElement(double p_posXOrig, double p_posYOrig, double p_haut, double p_larg, Color p_couleur, float p_trait, Color p_remplissage) {
		this.m_elementBuilder.constCouleur(p_couleur);
		this.m_elementBuilder.constRemplissage(p_remplissage);
		this.m_elementBuilder.constTrait(p_trait);
		this.m_elementBuilder.constTypeElement(p_posXOrig, p_posYOrig, p_haut, p_larg);
	}

}
