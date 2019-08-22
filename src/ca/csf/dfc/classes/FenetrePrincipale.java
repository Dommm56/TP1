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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.xml.parsers.*;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

import ca.csf.dfc.main.console.Main;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
		 * @desc La classe GestNouveau qui va demander lorsqu'on clique sur nouveau si on veut sauvegarder le dessin courant
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
					saveToXML(filename, null, null);
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
			public void saveToXML(String filename,File p_File,List<Element>p_element) throws FileNotFoundException {	
				
				if (p_File == null) {
					throw new IllegalArgumentException("p_File est null");
				}
				XMLStreamWriter doc = null;
				FileWriter output = new FileWriter(p_File);
				doc = XMLOutputFactory.newInstance().createXMLStreamWriter(output);		
				doc.writeStartDocument();
				doc.writeStartElement("dessin");
				doc.writeStartElement("fond");
				doc.writeAttribute("hauteur", Double.toString(0.5));
				doc.writeAttribute("largeur", Double.toString(0.5));
				doc.writeEndElement();

				doc.writeStartElement("forme");
				
				for (Element e : p_element) {
					doc.writeStartDocument();
				    doc.writeAttribute("X",Double.toString(e.getTrait()));
					doc.writeAttribute("Y", Double.toString(e.getTrait()));
					doc.writeAttribute("hauteur", Double.toString(e.getTypeElement()));
					doc.writeAttribute("largeur", Double.toString(e.getTypeElement()));
					doc.writeAttribute("trait", Integer.toString((int) e.getTrait()));
					if (e.getCouleur() != null) {
						doc.writeAttribute("couleur", Integer.toString(e.getCouleur().getRGB()));
					} else {
						doc.writeAttribute("couleur", "null");
					}
					doc.writeEndElement();
				}
				
				doc.writeEndElement();
				doc.writeEndElement();
				if (doc != null) {
					doc.flush();
					doc.close();
				}
				
		 }

				
			}//fin methode 

		//fin try
			//fin methode SaveToXML
		//fin GestEnregistrer
		
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
		          try {
					saveToSVG(filename, null, null);
				} catch (XMLStreamException | FactoryConfigurationError | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		          if (rsp == JFileChooser.APPROVE_OPTION) {
		        	File fichier = fc.getSelectedFile();
		        	fichier.getAbsolutePath();  
			          }
				}//fin actionPerformed	
			
			/**
			 * 
			 * @param filename
			 * @param p_File
			 * @param p_element
			 * @throws XMLStreamException
			 * @throws FactoryConfigurationError
			 * @throws IOException
			 */
			public void saveToSVG(String filename,File p_File,List<Element>p_element) throws XMLStreamException, FactoryConfigurationError, IOException {
				
				XMLStreamWriter doc = null;
				FileWriter output = new FileWriter(filename);

				doc = XMLOutputFactory.newInstance().createXMLStreamWriter(output);
				doc.writeStartDocument();

				doc.writeStartElement("svg");
				doc.writeAttribute("xmlns", "http://www.w3.org/2000/svg");
				doc.writeAttribute("version", "1.1");
				doc.writeAttribute("width",Integer.toString(100));
				doc.writeAttribute("height", Integer.toString(100));
				doc.writeCharacters(filename.replaceAll(".svg", ""));
				doc.writeStartElement("titre");
				doc.writeEndElement();
				
				doc.writeStartElement("rect");
				doc.writeAttribute("width", "100%");
				doc.writeAttribute("height", "100%");
				doc.writeAttribute("x", "0");
				doc.writeAttribute("y", "0");
				doc.writeEndElement();
				
				for (PanneauDessin e : p_element) {
					if (e.getName() == "Ligne") {
						doc.writeStartElement("line");
						doc.writeAttribute("x1", Double.toString(e.getX()));
						doc.writeAttribute("y1", Double.toString(e.getY()));
						doc.writeAttribute("x2", Double.toString(e.getX() + e.getAlignmentX()));
						doc.writeAttribute("y2", Double.toString(e.getY() + e.getAlignmentY()));
					} else {
						if (e.getName() == "Rectangle") {
							doc.writeStartElement("rect");
							doc.writeAttribute("width", Double.toString(e.getAlignmentX()));
							doc.writeAttribute("height", Double.toString(e.getAlignmentY()));
							doc.writeAttribute("x", Double.toString(e.getX()));
							doc.writeAttribute("y", Double.toString(e.getY()));
						} else if (e.getName() == "Ellipse") {
							double rx = e.getAlignmentX() * 1.5;
							double ry = e.getAlignmentY() * 1.5;
							doc.writeStartElement("ellipse");
							doc.writeAttribute("rx", Double.toString(rx));
							doc.writeAttribute("ry", Double.toString(ry));
							doc.writeAttribute("cx", Double.toString(e.getX() + rx));
							doc.writeAttribute("cy", Double.toString(e.getY() + ry));
						}
						
						doc.writeAttribute("fill-opacity", Double.toString(e.getColorModel().getAlpha(0) / 255));
					}
					doc.writeAttribute("stroke-width", Integer.toString(e.getWidth()));					
					doc.writeEndElement();
				}
				doc.writeEndElement();
				doc.writeEndDocument();
				if (doc != null) {
					doc.flush();
					doc.close();
				}		
	
			}//fin methode 
		
		//fin GestEnregistrer
		
		public void ouvrir(List<Element> p_element, File p_file) throws Exception, FileNotFoundException {
			
			throw new NotImplementedException();
		}
		
		}
