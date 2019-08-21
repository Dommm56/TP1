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
	 * Définit la position d'origine en X et Y de la forme par l'utilisation d'un objet de type Point
	 * 
	 * @param p_pos (java.awt.Point)
	 */
	public void setPosOrig(Point p_pos) {
		m_posOrig = p_pos;
	}
	/**
	 * Définit la position finale en X et Y de la forme par l'utilisation d'un objet de type Point
	 * 
	 * @param p_pos (java.awt.Point)
	 */
	public void setPosFin(Point p_pos) {
		m_posFin = p_pos;		
	}
	/**
	 * Définit la couleur du trait de la forme à créer
	 * p_couleur est un élément de l'enum Couleurs
	 * 
	 * @param p_couleur 
	 */
	public void setCouleur(Couleurs p_couleur) {
		
		m_couleur = p_couleur.getCouleur();
	}
	/**
	 * Définit la couleur de remplissage de la forme à créer
	 * p_couleur est un élément de l'enum Couleurs
	 * 
	 * @param p_couleur 
	 */
	public void setRemplissage(Couleurs p_remplissage) {
		m_remplissage = p_remplissage.getCouleur();
	}
	/**
	 * Définit la forme
	 * p_typeElement est de type enum Formes
	 * 
	 * @param p_typeElement
	 */
	public void setTypeElement(Formes p_typeElement) {
		m_typeElement = p_typeElement;
	}
	/**
	 * Définit la taille du trait de la forme
	 * p_trait est en élément de l'enum Traits
	 * @param p_trait
	 */
	public void setTrait(Traits p_trait) {
		m_trait = p_trait.getTrait();
	}
	/**
	 * Méthode qui prend l'ensemble des données et appelle le constructeur de createurElement
	 * Il passe en paramètre le Builder concret afin de créer le bon élément
	 * 
	 * @return Element
	 */
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
