package ca.csf.dfc.classes;

import java.awt.Color;
import java.awt.Shape;

public interface IElement {
	
	public void defType(Shape p_typeElement);
	public void defCouleur(Color p_couleur);
	public void defPosXOrigine(double p_posX);
	public void defPosYOrigine(double p_posY);
	public void defPosXFin(double p_posX);
	public void defPosYFin(double p_posY);
	public void defTrait(float p_trait);
	public void defRemplissage(Color p_remplissage);

}
