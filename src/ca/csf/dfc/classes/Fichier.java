package ca.csf.dfc.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Fichier {
	
	/**
	 * Permet d'enregistrer un ListenerPanneauDessin
	 * @param p_listeDessin c'est le fichier a enregistrer
	 * @param p_file cest le fichier de sortie
	 * @throws IOException
	 * @throws Exception
	 */
	
	public void Enregistrer ( ListenerPanneauDessin p_listeDessin, File p_file)throws IOException,Exception {
	}
	
	/**
	 * permet d'ouvrir un fichier
	 * @param p_listeDessin
	 * @param p_file
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	
	public void Charger ( ListenerPanneauDessin p_listeDessin, File p_file)throws IOException,FileNotFoundException, Exception {
	}
	
	/**
	 * retourne l'extension du fichier de sortie exemple .xml ou .svg
	 * @return
	 */
	public String getExtention() {
		return null;
	}

}
