package ca.csf.dfc.classes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

class Element implements IElement {
	
	/**
	 * Classe qui implémente l'interface IElement qui définit un objet pour le dessin
	 * Elle est partie intégrante d'un design pattern de type Builder
	 * 
	 * @author Philippe Deschênes
	 */
	/**
	 * La forme de l'objet
	 */
	private Shape m_typeElement;
	/**
	 * La couleur du trait de l'objet
	 */
	private Color m_couleur;
	/**
	 * L'épaisseur du trait de l'objet
	 */
	private float m_trait;
	/**
	 * La couleur de remplissage de l'objet
	 */
	private Color m_remplissage;
	
	/**
	 * Définit la forme de l'élément
	 * Il est du type Objet Shape du java.awt
	 */
	@Override
	public void defTypeElement(Shape p_shape) {
		this.m_typeElement = p_shape;
	}
	/**
	 * Définit la couleur du trait de l'élément
	 * Il est du type Objet Color du java.awt
	 */
	@Override
	public void defCouleur(Color p_couleur) {
		this.m_couleur = p_couleur;
	}
	/**
	 * Définit l'épaisseur du trait de l'élément
	 * Il est du type primitif float
	 */
	@Override
	public void defTrait(float p_trait) {
		this.m_trait = p_trait;
	}
	/**
	 * Définit la couleur de remplissage de l'élément
	 * Il est du type Objet Color du java.awt
	 */
	@Override
	public void defRemplissage(Color p_remplissage) {
		this.m_remplissage = p_remplissage;
	}
	/**
	 * Méthode qui retourne la forme de l'objet
	 * @return m_typeElement (java.awt.Shape)
	 */
	@Override
	public Shape getTypeElement() {
		return this.m_typeElement;
	}
	/**
	 * Méthode qui retourne la couleur du trait de l'objet
	 * @return m_couleur (java.awt.Color)
	 */
	@Override
	public Color getCouleur() {
		return this.m_couleur;
	}
	/**
	 * Méthode qui retourne l'épaisseur du trait de l'objet
	 * @return m_trait (float)
	 */
	@Override
	public float getTrait() {
		return this.m_trait;
	}
	/**
	 * Méthode qui retourne la couleur de remplissage de l'objet
	 * @return m_remplissage (java.awt.Color)
	 */
	@Override
	public Color getRemplissage() {
		return this.m_remplissage;
	}
	/**
	 * Méthode qui permet l'affichage de l'objet à l'écran à l'aide d'un paramètre du type Graphics
	 * 
	 */
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
