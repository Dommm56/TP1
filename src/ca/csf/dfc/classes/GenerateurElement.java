package ca.csf.dfc.classes;

import java.awt.Color;
import java.awt.Point;

public class GenerateurElement {
	
	private Point m_posOrig = new Point();
	private Point m_posFin;
	private Color m_couleur;
	private Color m_remplissage;
	private Formes m_typeElement;
	private float m_trait;
	private CreateurElement m_createur;
	
	public GenerateurElement() {
		this.m_couleur = Couleurs.NOIR.getCouleur();
		this.m_posOrig.setLocation(0, 0);
		this.m_trait = 0;
		this.m_remplissage = null;
	}
	
	public void setPosOrig(Point p_pos) {
		m_posOrig = p_pos;
	}
	
	public void setPosFin(Point p_pos) {
		m_posFin = p_pos;		
	}
	
	public void setCouleur(Couleurs p_couleur) {
		
		m_couleur = p_couleur.getCouleur();
	}
	
	public void setRemplissage(Couleurs p_remplissage) {
		m_remplissage = p_remplissage.getCouleur();
	}
	
	public void setTypeElement(Formes p_typeElement) {
		m_typeElement = p_typeElement;
	}
	
	public void setTrait(Traits p_trait) {
		m_trait = p_trait.getTrait();
	}
	
	public Element creerElement() {
		Element element = new Element();
		switch (m_typeElement) {
		case Rectangle:
			m_createur = new CreateurElement(new RectangleBuilder());
			break;
		case Ellipse:
			m_createur = new CreateurElement(new EllipseBuilder());
			break;
		case Ligne:
			m_createur = new CreateurElement(new LigneBuilder());
			break;
		default:
			break;
		}
		if(m_createur != null) {
			m_createur.construireElement(m_posOrig.getX(), m_posOrig.getY(), m_posFin.getX(), m_posFin.getY(), m_couleur, m_trait, m_remplissage);
			element = m_createur.getElement();
		}
		return element;
	}

}
