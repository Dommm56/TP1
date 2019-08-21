package ca.csf.dfc.classes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

import ca.csf.dfc.main.console.Main;

/*
 * La classe FenetrePrincipale implemente linterface JFrame. Cette classe sert a placer les differents panneaux necessaires 
 * au programme et permet de regrouper le tout ensemble.
 */
public class FenetrePrincipale extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private PanneauOptions m_panOption = new PanneauOptions();
	private PanneauDessin m_panDessin = new PanneauDessin();
	/**
	 *  La fenetre principale du programme. Elle contient 2 JPannels (principal et secondaire)
	 *  On definit dans cette classe les differentes proprietes de la fenetre principale,
	 *  tel les dimensions, les bordures et les positionnements
	 * @param p_PanneauPrincipal
	 * @param p_PanneauSecondaire
	 */
	public FenetrePrincipale()
    {		
        super("Projet Dessin");							 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);	 
        this.definirMenu();								 //methode qui ajoute les boutons au menu et des actionListeners
        this.setLayout(new BorderLayout());				 
        this.add(m_panOption,BorderLayout.NORTH);     
        this.add(m_panDessin,BorderLayout.SOUTH);
        m_panDessin.setPreferredSize(new Dimension(100, 661));
        m_panOption.setBorder(BorderFactory.createLineBorder(Color.black));
        m_panDessin.setBorder(BorderFactory.createLineBorder(Color.black));   
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setJMenuBar(menuBar);          
    }//fin FenetrePrincipale
	
		/*
		 * @description: Ici on cree les differents elements du menu
		 */
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFichier = new JMenu("Fichier");
		JMenuItem itm_Nouveau = new JMenuItem("Nouveau");
		JMenuItem itm_Ouvrir = new JMenuItem("Ouvrir");
		JMenuItem itm_EnregistrerXML = new JMenuItem("Enregistrer XML");
		JMenuItem itm_EnregistrerSVG= new JMenuItem("Enregistrer SVG");
		JMenuItem itm_Quitter = new JMenuItem("Quitter");	
		
		/*
		 * @description: methode definirMenu, qui associe les elements crees aux differents boutons du menu
		 * et qui associe des actions Listeners a ces elements.
		 */
		private void definirMenu() {
			this.menuBar.add(menuFichier);	
			this.menuFichier.add(this.itm_Nouveau);
			this.menuFichier.add(this.itm_Ouvrir);
			this.menuFichier.add(this.itm_EnregistrerXML);
			this.menuFichier.add(this.itm_EnregistrerSVG);
			this.menuFichier.add(this.itm_Quitter);
				
			this.itm_Ouvrir.addActionListener(new GestOuvrir());
			this.itm_Quitter.addActionListener(new GestQuitter());
			this.itm_Nouveau.addActionListener(new GestNouveau());
			this.itm_EnregistrerXML.addActionListener(new GestEnregistrerXML());
			this.itm_EnregistrerSVG.addActionListener(new GestEnregistrerSVG());	
		}//fin definirMenu
			
}//fin fenetrePrincipale
		
		/*
		 * @desc La classe GestOuvrir qui va detecter quand on clique sur Ouvrir et permettre de creer un nouveau fichier
		 */
	  	class GestOuvrir implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser BoiteFichier = new JFileChooser();
				BoiteFichier.setCurrentDirectory(new File(System.getProperty("user.home")));
				int resultatOuvrir = BoiteFichier.showOpenDialog(BoiteFichier );
				if (resultatOuvrir == JFileChooser.APPROVE_OPTION) {
					File selectedFile1 = BoiteFichier.getSelectedFile();
					selectedFile1.getAbsolutePath();
				}//fin if
			}//fin actionPerformed
		}//fin GestOuvrir
			
	  	/*
		 * @desc La classe GestQuitter qui va detecter quand on clique sur Quitter et fermer le programme
		 */
		class GestQuitter implements ActionListener {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					}//fin actionPerformed
		}//fin GestQuitter
		
		
		/*
		 * @desc La classe GestNouveau qui va demander lorsquon clique sur nouveau si on veut sauvegarder le dessin courant
		 * et va reagir en fonction du choix
		 */
		class GestNouveau implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = javax.swing.JOptionPane.showConfirmDialog((Component) null, "Voulez-vous sauvegarder?","Nouveau Fichier", JOptionPane.YES_NO_CANCEL_OPTION); 
				if (response == JOptionPane.NO_OPTION) {
					
				} else if (response == JOptionPane.YES_OPTION) {
					
				} else if (response == JOptionPane.CLOSED_OPTION) {
				      
				}//fin if
			}//fin actionPerformed					
		}//fin GestNouveau
		
		/*
		 * @desc La classe GestEnregistrerXML qui va enregistrer les dessins present dans le panneau en dessin
		 * en format xml (avec les proprietes)
		 */
		class GestEnregistrerXML implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
		        fc.setCurrentDirectory( new File( System.getProperty( "user.dir" ) ) );
		        int rsp = fc.showSaveDialog(fc) ;
		        String filename = fc.getSelectedFile().getName()+".xml";
		        try {
					saveToXML(filename);
		        } catch (FileNotFoundException e1) {		
					e1.printStackTrace();
		        }//fin try
		          
		        if (rsp ==JFileChooser.APPROVE_OPTION) {	
		        	File fichier = fc.getSelectedFile();
			        fichier.getAbsolutePath();
		         }//fin if
		          
			}//fin actionPerformed	

			/*
			 * @desc Methode SaveToXML pour factoriser le code de GestEnregistrer
			 */
			public void saveToXML(String xml) throws FileNotFoundException {	
				 try {
					 
					Properties properties = new Properties();
					properties.setProperty("Forme", "");
					properties.setProperty("Couleur","");
					properties.setProperty("Trait", "");
					properties.setProperty("Remplissage", "");
					properties.setProperty("PositionInitialeX", "");
					properties.setProperty("PositionFinaleX", "");
										
					FileOutputStream fileOut = new FileOutputStream(xml);
					properties.storeToXML(fileOut, "Proprietes");
					fileOut.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
				}//fin try
			}//fin methode SaveToXML
		}//fin GestEnregistrer
		
		/*
		 * @desc La classe GestEnregistrerSVG qui va enregistrer les dessins present dans le panneau en dessin
		 * en format svg (avec les proprietes)
		 */
		class GestEnregistrerSVG implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
		          fc.setCurrentDirectory( new File( System.getProperty( "user.dir" ) ) );
		          int rsp = fc.showSaveDialog(fc) ;
		          String filename = fc.getSelectedFile().getName()+".svg";
		          saveToSVG(filename);
		          if (rsp == JFileChooser.APPROVE_OPTION) {
						//code savuer dans fichier
		        	File fichier = fc.getSelectedFile();
		        	fichier.getAbsolutePath();  
			          }
				}//fin actionPerformed	
			
			public void saveToSVG(String xml) {
	
			}//fin methode 
		}//fin GestEnregistrer
		
