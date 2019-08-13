package ca.csf.dfc.classes;

import java.awt.Color;

public interface IElementBuilder {
	
	public void constCouleur(Color p_couleur);
	public void constTypeElement(double p_posXOrig, double p_posYOrig, double p_haut, double p_larg);
	public void constTrait(float p_trait);
	public void constRemplissage(Color p_remplissage);
	public Element getElement();

}
