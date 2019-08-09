package ca.csf.dfc.classes;

import java.awt.Color;
import java.awt.Shape;

public class Element implements IElement {
	
	private Shape m_typeElement;
	private Color m_couleur;
	private double m_posXOrigine;
	private double m_posYOrigine;
	private double m_posXFin;
	private double m_posYFin;
	private float m_trait;
	private Color m_remplissage;

	@Override
	public void defCouleur(Color p_couleur) {
		this.m_couleur = p_couleur;

	}

	@Override
	public void defPosXOrigine(double p_posX) {
		this.m_posXOrigine = p_posX;

	}

	@Override
	public void defPosYOrigine(double p_posY) {
		this.m_posYOrigine = p_posY;

	}

	@Override
	public void defPosXFin(double p_posX) {
		this.m_posXFin = p_posX;

	}

	@Override
	public void defPosYFin(double p_posY) {
		this.m_posYFin = p_posY;

	}

	@Override
	public void defTrait(float p_trait) {
		this.m_trait = p_trait;

	}

	@Override
	public void defRemplissage(Color p_remplissage) {
		this.m_remplissage = p_remplissage;

	}

	@Override
	public void defType(Shape p_typeElement) {
		this.m_typeElement = p_typeElement;
		
	}

}
