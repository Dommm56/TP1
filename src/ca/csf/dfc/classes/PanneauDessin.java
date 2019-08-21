package ca.csf.dfc.classes;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * @description la classe Panneau dessin utilise l'interface JPanel, et elle est utilisee par la fenetre principale.
 * Cest dans cette classe que lon va pouvoir cliquer pour produire les formes.
 */
public class PanneauDessin extends JPanel{
	private static final long serialVersionUID = -6133798062695262877L;
	private JLabel lbl_Trait = new JLabel("Les dessins vont ici");
	private boolean m_premierClickFait = false;	
	public List<Element> m_listeDessin = new ArrayList<Element>();
	
	/*
	 * Constructeur par default, pour ajouter une petite phrase et ajouter la gestion des clics de souris dans ce panneau
	 */
	public PanneauDessin() {
		super();  
        this.add(lbl_Trait); 
        this.addMouseListener(new GestClickSouris());   	
    } //fin Panneau1
	/**
	 * Méthode qui retourne la liste de dessin
	 * 
	 * @return List<Element>
	 */
	public List<Element> retournerDessin() {
		return m_listeDessin;
	}
	/**
	 * Peuple la liste de dessin
	 * 
	 * @param p_liste
	 */
	public void peuplerListeDessin(List<Element> p_liste) {
		this.m_listeDessin = p_liste;
	}

	/*
	 * description: Cette classe permet de gerer les clic de souris afin de produire les dessins.
	 * Le premier clique definit la position initiale et le deuxieme clique definit la position finale des formes.
	 */
	private class GestClickSouris implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent p_e) {
			GenerateurElement ge = SGenerateurElement.getInstance();
    		if (PanneauDessin.this.m_premierClickFait == false) {
    			ge.setPosOrig(PanneauDessin.this.getMousePosition());
    			PanneauDessin.this.m_premierClickFait = true;
    			PanneauDessin.this.lbl_Trait.setText("Premier clic " + MouseInfo.getPointerInfo().getLocation().toString());
    			
    		}
    		else {
    			ge.setPosFin(PanneauDessin.this.getMousePosition());
    			PanneauDessin.this.m_listeDessin.add(ge.creerElement());
    			PanneauDessin.this.m_premierClickFait = false;
    			PanneauDessin.this.lbl_Trait.setText("deuxieme clic " + MouseInfo.getPointerInfo().getLocation().toString());
    			PanneauDessin.this.repaint();
    		}//fin if		
		}//fin mouseclicked

		@Override
		public void mouseEntered(MouseEvent p_e) {
		}

		@Override
		public void mouseExited(MouseEvent p_e) {
		}

		@Override
		public void mousePressed(MouseEvent p_e) {
		}

		@Override
		public void mouseReleased(MouseEvent p_e) {
		}
	}//fin GestSouris
	
	
    @Override
    protected void paintComponent(Graphics p_g) {
    	super.paintComponent(p_g);
    	for (Element e : m_listeDessin) {
    		e.paint(p_g);
    	}
    }//fin paintComponent
}//fin JPanel

