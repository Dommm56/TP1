package ca.csf.dfc.classes;

import java.awt.Color;
/**
 * Énumération permettant de produire une liste simple de couleur
 * Ceci permet de valider le paramètre des éléments pour la couleur des traits et du remplissage
 * 
 * @author Philippe Deschênes
 *
 */
public enum Couleurs {
	
	AUCUNE(null),
	ROUGE(new Color(255,0,0)),
	VERT(new Color(0,255,0)),
	BLEU(new Color(0,0,255)),
	JAUNE(new Color(255,255,0)),
	MAGENTA(new Color(255,0,255)),
	CYAN(new Color(0,255,255)),
	BLANC(new Color(255,255,255)),
	NOIR(new Color(0,0,0));
	/**
	 * Donnée membre permettant de traduire la String de l'enum en objet Color utilisable par le programme
	 */
	private Color m_couleur;
	 /**
	  * Le paramètre p_couleur est la couleur correspondante en objet Color
	  * @param p_couleur
	  */
    Couleurs(Color p_couleur) {
        this.m_couleur = p_couleur;
    }
    /**
     * Retourne un objet de la classe Color
     * @return m_couleur
     */
    public Color getCouleur() {
        return m_couleur;
    }

}
