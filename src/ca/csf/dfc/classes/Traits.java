package ca.csf.dfc.classes;
/**
 * Énumération permettant de produire une liste simple de taille de trait
 * Ceci permet de valider le paramètre des éléments pour la taille des traits
 * 
 * @author Dominic Legendre
 *
 */
public enum Traits {
	UN(1),
	DEUX(2),
	QUATRE(4),
	SIX(6),
	HUIT(8),
	DIX(10),
	DOUZE(12),
	QUATORZE(14);
	/**
	 * Donnée membre permettant de traduire la String de l'enum en integer utilisable par le programme
	 */
	private int m_trait;
	/**
	  * Le paramètre p_trait est la taille correspondante en integer
	  * @param p_couleur
	  */
    Traits(int p_trait) {
        this.m_trait = p_trait;
    }
    /**
     * Retourne un integer représentant la taille trait
     * 
     * @return m_trait
     */
    public int getTrait() {
        return m_trait;
    }

}
