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

import com.sun.glass.ui.Application;

import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter; 


public class FenetrePrincipale extends JFrame {
	private static final long serialVersionUID = 1L;

	public FenetrePrincipale(JPanel p_PanneauPrincipal,JPanel p_PanneauSecondaire)
    {
        super("TP POO");
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
		JMenuItem itm_Enregistrer = new JMenuItem("Enregistrer");
		JMenuItem itm_Quitter = new JMenuItem("Quitter");
		
		private void definirMenu() {
			this.menuBar.add(menuFichier);
			
			this.menuFichier.add(this.itm_Nouveau);
			this.menuFichier.add(this.itm_Ouvrir);
			this.menuFichier.add(this.itm_Enregistrer);
			this.menuFichier.add(this.itm_Quitter);
			
			//definir OUVRIR
			this.itm_Ouvrir.addActionListener(new GestOuvrir());
			this.itm_Quitter.addActionListener(new GestQuitter());
			this.itm_Nouveau.addActionListener(new GestNouveau());
			this.itm_Enregistrer.addActionListener(new GestEnregistrer());
			
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
		
		class GestEnregistrer implements ActionListener {

			public GestEnregistrer() {
				// TODO Auto-generated constructor stub
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
		          fc.setCurrentDirectory( new File( System.getProperty( "user.dir" ) ) );
		          int rsp = fc.showSaveDialog(fc) ;

				}//fin actionPerformed
			
				
		}//fin GestEnregistrer
		
		
		
//fin fenetrePrincipale
