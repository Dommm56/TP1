package ca.csf.dfc.classes;

import java.awt.Color;
import java.awt.Point;
/**
 * Classe qui permet l'instanciation d'un objet de CreateurElement
 * Elle partie intégrante d'un design pattern de type Singleton
 * 
 * @author Philippe Deschênes
 *
 */
public class GenerateurElement {
	/**
	 * Premier point, représente l'origine de la forme
	 */
	private Point m_posOrig = new Point();
	/**
	 * Deuxième point, représente le point définissant la hauteur et la largeur du rectangle qui définit la forme
	 */
	private Point m_posFin = new Point();
	/**
	 * Couleur du trait de la forme
	 */
	private Color m_couleur;
	/**
	 * Couleur de remplissage de la forme
	 */
	private Color m_remplissage;
	/**
	 * Type de forme
	 */
	private Formes m_typeElement;
	/**
	 * Épaisseur du trait de la forme
	 */
	private float m_trait;
	/**
	 * Objet de type CreateurElement qui est un Builder de forme
	 */
	private CreateurElement m_createur;
	
	/**
	 * Constructeur d'un GenrateurElement
	 * Initialise les données membres à des valeurs par défaut
	 */
	public GenerateurElement() {
		this.m_couleur = Couleurs.NOIR.getCouleur();
		this.m_posOrig.setLocation(0, 0);
		this.m_trait = 0;
		this.m_remplissage = null;
	}
	/**
	 * 
	 * @param p_pos
	 */
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
