package ca.csf.dfc.classes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauDessin extends JPanel{
	private static final long serialVersionUID = -6133798062695262877L;
	JLabel lbl_Trait = new JLabel("Les dessins vont ici");
	private boolean p_premierClickFait = false;
	
	private List<Element> p_listeDessin = new ArrayList<Element>();
	
	public PanneauDessin() {
		super();  
        this.add(lbl_Trait);
        
        this.addMouseListener(new GestClickSouris());
        	
    } //fin Panneau1
        
    private class GestClickSouris implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent p_e) {
			GenerateurElement ge = SGenerateurElement.getInstance();
    		if (PanneauDessin.this.p_premierClickFait == false) {
    			//ge.setPosOrig(MouseInfo.getPointerInfo().getLocation());
    			PanneauDessin.this.p_premierClickFait = true;
    			PanneauDessin.this.lbl_Trait.setText("premier click");
    		}
    		else {
    			//ge.setPosFin(MouseInfo.getPointerInfo().getLocation());
    			//PanneauDessin.this.p_listeDessin.add(ge.creerElement());
    			PanneauDessin.this.p_premierClickFait = false;
    			PanneauDessin.this.lbl_Trait.setText("deuxieme click");
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
}//fin JPanel

