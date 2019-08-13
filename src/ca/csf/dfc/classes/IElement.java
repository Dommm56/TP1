package ca.csf.dfc.classes;

import java.awt.Color;
import java.awt.geom.RectangularShape;

public interface IElement {
	
	public void defTypeElement(RectangularShape p_typeElement);
	public void defCouleur(Color p_couleur);
	public void defTrait(float p_trait);
	public void defRemplissage(Color p_remplissage);
	public RectangularShape getTypeElement();
	public Color getCouleur();
	public float getTrait();
	public Color getRemplissage();

}
