package ca.csf.dfc.main.console;

import ca.csf.dfc.classes.PanneauDessin;
import ca.csf.dfc.classes.PanneauOptions;

import ca.csf.dfc.classes.FenetrePrincipale;

public class Main {

	/*
	 * La classe main cree une fenetre principae avec comme 2 arguements les 2 panneaux necessaires
	 */
	public static void main(String[] args) {
		new FenetrePrincipale(new PanneauOptions(), new PanneauDessin()).setVisible(true);
		//avec plus de temps nous aurions pu faire un fabrique de Panneau pour eviter de faire des new dans le main
	}// fin main
	
}// fin Main
