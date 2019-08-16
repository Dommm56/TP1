package ca.csf.dfc.main.console;

import ca.csf.dfc.classes.PanneauDessin;
import ca.csf.dfc.classes.PanneauOptions;

import ca.csf.dfc.classes.FenetrePrincipale;

public class Main {

	public static void main(String[] args) {
		PanneauOptions pan1 = new PanneauOptions();
		PanneauDessin pan2 = new PanneauDessin();		
		new FenetrePrincipale(pan1, pan2).setVisible(true);

	}// fin main
}// fin main
