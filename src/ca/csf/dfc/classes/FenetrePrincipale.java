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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class FenetrePrincipale extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public FenetrePrincipale(JPanel p_PanneauPrincipal,JPanel p_PanneauSecondaire)
    {
        super("Projet Dessin");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.definirMenu();
        this.setLayout(new BorderLayout());
        this.add(p_PanneauPrincipal,BorderLayout.NORTH);
        
        this.add(p_PanneauSecondaire,BorderLayout.SOUTH);
        //dimensions du panneau a dessins
        p_PanneauSecondaire.setPreferredSize(new Dimension(100, 661));
        p_PanneauPrincipal.setBorder(BorderFactory.createLineBorder(Color.black));
        p_PanneauSecondaire.setBorder(BorderFactory.createLineBorder(Color.black));
        
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setJMenuBar(menuBar);   
        
    }//fin
	
		//creation dun menu
		JMenuBar menuBar = new JMenuBar();

		//creation des elements principaux du menu
		JMenu menuFichier = new JMenu("Fichier");
		JMenuItem itm_Nouveau = new JMenuItem("Nouveau");
		JMenuItem itm_Ouvrir = new JMenuItem("Ouvrir");
		JMenuItem itm_EnregistrerXML = new JMenuItem("Enregistrer XML");
		JMenuItem itm_EnregistrerSVG= new JMenuItem("Enregistrer SVG");
		JMenuItem itm_Quitter = new JMenuItem("Quitter");
		
		private void definirMenu() {
			this.menuBar.add(menuFichier);
			
			this.menuFichier.add(this.itm_Nouveau);
			this.menuFichier.add(this.itm_Ouvrir);
			this.menuFichier.add(this.itm_EnregistrerXML);
			this.menuFichier.add(this.itm_EnregistrerSVG);
			this.menuFichier.add(this.itm_Quitter);
			
			//definir OUVRIR
			this.itm_Ouvrir.addActionListener(new GestOuvrir());
			this.itm_Quitter.addActionListener(new GestQuitter());
			this.itm_Nouveau.addActionListener(new GestNouveau());
			this.itm_EnregistrerXML.addActionListener(new GestEnregistrerXML());
			this.itm_EnregistrerSVG.addActionListener(new GestEnregistrerSVG());
			
			}
			
		
		}//fin
		
		class GestOuvrir implements ActionListener {

			public GestOuvrir() {
				// TODO Auto-generated constructor stub
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(fileChooser );
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile1 = fileChooser.getSelectedFile();
				}//fin actionPerformed
				
				
		}//fin GestOuvrir
		}
			
		class GestQuitter implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					}//fin actionPerformed
					
					
			}//fin GestQuitter
		
		class GestNouveau implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				int response = javax.swing.JOptionPane.showConfirmDialog((Component) null, "Voulez-vous sauvegarder?","Nouveau Fichier", JOptionPane.YES_NO_CANCEL_OPTION); 
				if (response == JOptionPane.NO_OPTION) {
				      //ici non
				    } else if (response == JOptionPane.YES_OPTION) {
				      //metre le new gestionEnregistrer
				    } else if (response == JOptionPane.CLOSED_OPTION) {
				      //ici mettre le Nouveau
				    }	
			}//fin actionPerformed
							
		}//fin GestNouveau
		
		class GestEnregistrerXML implements ActionListener {

			public GestEnregistrerXML() {
				// TODO Auto-generated constructor stub
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
		          fc.setCurrentDirectory( new File( System.getProperty( "user.dir" ) ) );
		          int rsp = fc.showSaveDialog(fc) ;
		          String filename = fc.getSelectedFile().getName();
		          saveToXML(filename);
				}//fin actionPerformed	
			
			public void saveToXML(String xml) {
				String role1 = null;
				String role2 = null;
				String role3 = null;
				String role4 = null;
				ArrayList<String> rolev;

			    Document dom;
			    org.w3c.dom.Element e = null;

			    // instance of a DocumentBuilderFactory
			    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			    try {
			        // use factory to get an instance of document builder
			        DocumentBuilder db = dbf.newDocumentBuilder();
			        // create instance of DOM
			        dom = db.newDocument();

			        // create the root element
			        org.w3c.dom.Element rootEle = dom.createElement("roles");

			        // create data elements and place them under root
			        e = dom.createElement("role1");
			        e.appendChild(dom.createTextNode(role1));
			        rootEle.appendChild(e);

			        e = dom.createElement("role2");
			        e.appendChild(dom.createTextNode(role2));
			        rootEle.appendChild(e);

			        e = dom.createElement("role3");
			        e.appendChild(dom.createTextNode(role3));
			        rootEle.appendChild(e);

			        e = dom.createElement("role4");
			        e.appendChild(dom.createTextNode(role4));
			        rootEle.appendChild(e);

			        dom.appendChild(rootEle);

			        try {
			            Transformer tr = TransformerFactory.newInstance().newTransformer();
			            tr.setOutputProperty(OutputKeys.INDENT, "yes");
			            tr.setOutputProperty(OutputKeys.METHOD, "xml");
			            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
			            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			            // send DOM to file
			            tr.transform(new DOMSource(dom), 
			                                 new StreamResult(new FileOutputStream(xml)));

			        } catch (TransformerException te) {
			            System.out.println(te.getMessage());
			        } catch (IOException ioe) {
			            System.out.println(ioe.getMessage());
			        }
			    } catch (ParserConfigurationException pce) {
			        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
			    }
			}//fin methode 
		}//fin GestEnregistrer
		
		class GestEnregistrerSVG implements ActionListener {

			public GestEnregistrerSVG() {
				// TODO Auto-generated constructor stub
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
		          fc.setCurrentDirectory( new File( System.getProperty( "user.dir" ) ) );
		          int rsp = fc.showSaveDialog(fc) ;
		          String filename = fc.getSelectedFile().getName();
		          saveToSVG(filename);
				}//fin actionPerformed	
			
			public void saveToSVG(String xml) {
				String role1 = null;
				String role2 = null;
				String role3 = null;
				String role4 = null;
				ArrayList<String> rolev;

			    Document dom;
			    org.w3c.dom.Element e = null;

			    // instance of a DocumentBuilderFactory
			    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			    try {
			        // use factory to get an instance of document builder
			        DocumentBuilder db = dbf.newDocumentBuilder();
			        // create instance of DOM
			        dom = db.newDocument();

			        // create the root element
			        org.w3c.dom.Element rootEle = dom.createElement("roles");

			        // create data elements and place them under root
			        e = dom.createElement("role1");
			        e.appendChild(dom.createTextNode(role1));
			        rootEle.appendChild(e);

			        e = dom.createElement("role2");
			        e.appendChild(dom.createTextNode(role2));
			        rootEle.appendChild(e);

			        e = dom.createElement("role3");
			        e.appendChild(dom.createTextNode(role3));
			        rootEle.appendChild(e);

			        e = dom.createElement("role4");
			        e.appendChild(dom.createTextNode(role4));
			        rootEle.appendChild(e);

			        dom.appendChild(rootEle);

			        try {
			            Transformer tr = TransformerFactory.newInstance().newTransformer();
			            tr.setOutputProperty(OutputKeys.INDENT, "yes");
			            tr.setOutputProperty(OutputKeys.METHOD, "svg");
			            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
			            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			            // send DOM to file
			            tr.transform(new DOMSource(dom), 
			                                 new StreamResult(new FileOutputStream(xml)));

			        } catch (TransformerException te) {
			            System.out.println(te.getMessage());
			        } catch (IOException ioe) {
			            System.out.println(ioe.getMessage());
			        }
			    } catch (ParserConfigurationException pce) {
			        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
			    }
			}//fin methode 
		}//fin GestEnregistrer
		
		
//fin fenetrePrincipale
