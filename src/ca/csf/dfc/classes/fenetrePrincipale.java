package ca.csf.dfc.classes;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class fenetrePrincipale extends JFrame {
	private static final long serialVersionUID = 1L;

	public fenetrePrincipale(JPanel p_PanneauPrincipal)
    {
        super("TP POO");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.definirMenu();
        this.setLayout(new BorderLayout());
        this.add(p_PanneauPrincipal, BorderLayout.NORTH);
        
        //this.add(new PanneauOptions(), BorderLayout.NORTH);
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
	
		}//fin
	
}//fin fenetrePrincipale
