package ca.csf.dfc.classes;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
/**
 * Énumération permettant de produire une liste simple de formes
 * Ceci permet de valider le paramètre des éléments pour la forme de l'objet
 * 
 * @author Dominic Legendre
 *
 */
public enum Formes {
	Rectangle(new Rectangle2D.Double()),
	Ellipse(new Ellipse2D.Double()),
	Ligne(new Line2D.Double());
	/**
	 * Donnée membre permettant de traduire la String de l'enum en objet Shape utilisable par le programme
	 */
	private Shape m_typeElement;
	/**
	  * Le paramètre p_typeElement est la forme correspondante en objet Shape
	  * @param p_typeElement
	  */
	Formes(Shape p_typeElement) {
		this.m_typeElement = p_typeElement;
	}
	/**
     * Retourne un objet de la classe Shape
     * @return m_typeElement
     */
	public Shape getTypeElement() {
		return this.m_typeElement;
	}
}//
