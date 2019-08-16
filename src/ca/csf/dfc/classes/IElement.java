package ca.csf.dfc.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;

public interface IElement {
	
	public void defTypeElement(Shape p_typeElement);
	public void defCouleur(Color p_couleur);
	public void defTrait(float p_trait);
	public void defRemplissage(Color p_remplissage);
	public Shape getTypeElement();
	public Color getCouleur();
	public float getTrait();
	public Color getRemplissage();
	
	public void paint(Graphics p_g);

}
