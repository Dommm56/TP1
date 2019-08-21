package ca.csf.dfc.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
/**
 * Interface permettant de définir un Objet de type Element et ses méthodes
 * Cette classe est partie intégrante d'un design pattern de type Builder
 * 
 * @author Philippe
 *
 */
public interface IElement {
	/**
	 * Définit la forme de l'élément
	 * Il est du type Objet Shape du java.awt
	 * 
	 * @param p_typeElement
	 */
	public void defTypeElement(Shape p_typeElement);
	/**
	 * Définit la couleur du trait de l'élément
	 * Il est du type Objet Color du java.awt
	 * 
	 * @param p_couleur
	 */
	public void defCouleur(Color p_couleur);
	/**
	 * Définit l'épaisseur du trait de l'élément
	 * Il est du type primitif float
	 * 
	 * @param p_trait
	 */
	public void defTrait(float p_trait);
	/**
	 * Définit la couleur de remplissage de l'élément
	 * Il est du type Objet Color du java.awt
	 * 
	 * @param p_remplissage
	 */
	public void defRemplissage(Color p_remplissage);
	/**
	 * Méthode qui retourne la forme de l'objet
	 * 
	 * @return m_typeElement (java.awt.Shape)
	 */
	public Shape getTypeElement();
	/**
	 * Méthode qui retourne la couleur du trait de l'objet
	 * 
	 * @return m_couleur (java.awt.Color)
	 */
	public Color getCouleur();
	/**
	 * Méthode qui retourne l'épaisseur du trait de l'objet
	 * 
	 * @return m_trait (float)
	 */
	public float getTrait();
	/**
	 * Méthode qui retourne la couleur de remplissage de l'objet
	 * 
	 * @return m_remplissage (java.awt.Color)
	 */
	public Color getRemplissage();
	/**
	 * Méthode qui permet l'affichage de l'objet à l'écran à l'aide d'un paramètre du type Graphics
	 * 
	 * @param p_g (java.awt.Graphics)
	 */
	public void paint(Graphics p_g);

}
