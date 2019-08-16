package ca.csf.dfc.classes;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauDessin extends JPanel{
	private static final long serialVersionUID = -6133798062695262877L;
	JLabel lbl_Trait = new JLabel("Les dessins vont ici");
	private boolean m_premierClickFait = false;
	
	private List<Element> m_listeDessin = new ArrayList<Element>();
	
	public PanneauDessin() {
		super();  
        this.add(lbl_Trait);
        
        this.addMouseListener(new GestClickSouris());
        	
    } //fin Panneau1
        
    private class GestClickSouris implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent p_e) {
			GenerateurElement ge = SGenerateurElement.getInstance();
    		if (PanneauDessin.this.m_premierClickFait == false) {
    			ge.setPosOrig(PanneauDessin.this.getMousePosition());
    			PanneauDessin.this.m_premierClickFait = true;
    			PanneauDessin.this.lbl_Trait.setText("Premier click " + MouseInfo.getPointerInfo().getLocation().toString());
    		}
    		else {
    			ge.setPosFin(PanneauDessin.this.getMousePosition());
    			PanneauDessin.this.m_listeDessin.add(ge.creerElement());
    			PanneauDessin.this.m_premierClickFait = false;
    			PanneauDessin.this.lbl_Trait.setText("deuxieme click " + MouseInfo.getPointerInfo().getLocation().toString());
    			PanneauDessin.this.repaint();
    		}
			
		}

		@Override
		public void mouseEntered(MouseEvent p_e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent p_e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent p_e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent p_e) {
			// TODO Auto-generated method stub
			
		}
		
	}
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	for (Element e : m_listeDessin) {
    		e.paint(g);
    	}
    }
}//fin JPanel

