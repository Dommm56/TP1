package ca.csf.dfc.classes;

import java.awt.Color;

public enum Couleurs {
	
	ROUGE(new Color(255,0,0)),
	VERT(new Color(0,255,0)),
	BLEU(new Color(0,0,255)),
	JAUNE(new Color(255,255,0)),
	MAGENTA(new Color(255,0,255)),
	CYAN(new Color(0,255,255)),
	BLANC(new Color(255,255,255)),
	NOIR(new Color(0,0,0));
	
	private Color m_couleur;
	 
    Couleurs(Color p_couleur) {
        this.m_couleur = p_couleur;
    }
 
    public Color getCouleur() {
        return m_couleur;
    }

}
