package ca.csf.dfc.classes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

public class Element implements IElement {
	
	private Shape m_typeElement;
	private Color m_couleur;
	private float m_trait;
	private Color m_remplissage;
	
	@Override
	public void defTypeElement(Shape p_shape) {
		this.m_typeElement = p_shape;
	}

	@Override
	public void defCouleur(Color p_couleur) {
		this.m_couleur = p_couleur;

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
	public Shape getTypeElement() {
		return this.m_typeElement;
	}
	

	@Override
	public Color getCouleur() {
		
		return this.m_couleur;
	}

	@Override
	public float getTrait() {
		
		return this.m_trait;
	}

	@Override
	public Color getRemplissage() {
		
		return this.m_remplissage;
	}

	@Override
	public void paint(Graphics p_g) {
		Graphics2D g2 = (Graphics2D)p_g;
		if ((getRemplissage() != null) && (getTypeElement() != Formes.Ligne.getTypeElement())) {
			g2.setPaint(getRemplissage());
			g2.fill(getTypeElement());
		}
		g2.setColor(getCouleur());
		g2.setStroke(new BasicStroke(getTrait()));
		g2.draw(getTypeElement());
		
		
		
		
	}

}
