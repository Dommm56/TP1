package ca.csf.dfc.classes;

import java.awt.Color;
import java.awt.Point;

public class GenerateurElement {
	
	private Point m_posOrig = new Point();
	private double m_haut;
	private double m_larg;
	private Color m_couleur;
	private Color m_remplissage;
	private Formes m_typeElement;
	private float m_trait;
	private CreateurElement createur;
	
	public GenerateurElement() {
		this.m_couleur = Couleurs.NOIR.getCouleur();
		this.m_posOrig.setLocation(0, 0);
		this.m_haut = 0;
		this.m_larg = 0;
		this.m_trait = 0;
		this.m_remplissage = null;
	}
	
	public void setPosOrig(Point p_pos) {
		m_posOrig = p_pos;
	}
	
	public void setPosFin(Point p_pos) {
		if (m_posOrig != null) {
			m_haut = p_pos.getY() - m_posOrig.getY();
			m_larg = p_pos.getX() - m_posOrig.getX();
		}
		
	}
	
	public void setCouleur(Color p_couleur) {
		m_couleur = p_couleur;
	}
	
	public void setRemplissage(Color p_remplissage) {
		m_remplissage = p_remplissage;
	}
	
	public void setTypeElement(Formes p_typeElement) {
		m_typeElement = p_typeElement;
	}
	
	public void setTrait(float p_trait) {
		m_trait = p_trait;
	}
	
	public Element creerElement() {
		Element element = new Element();
		switch (m_typeElement) {
		case Rectangle:
			createur = new CreateurElement(new RectangleBuilder());
			break;
		case Ellipse:
			createur = new CreateurElement(new EllipseBuilder());
			break;
		case Ligne:
			createur = new CreateurElement(new LigneBuilder());
			break;
		default:
			break;
		}
		if(createur != null) {
			createur.construireElement(m_posOrig.getX(), m_posOrig.getY(), m_haut, m_larg, m_couleur, m_trait, m_remplissage);
			element = createur.getElement();
		}
		return element;
	}

}
