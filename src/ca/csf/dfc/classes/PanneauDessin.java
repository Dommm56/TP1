package ca.csf.dfc.classes;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauDessin extends JPanel{
	private static final long serialVersionUID = -6133798062695262877L;
	JLabel lbl_Trait = new JLabel("Les dessins vont ici");

	public PanneauDessin() {
		super();  
        this.add(lbl_Trait);	
	}//fin Panneau1	
}//fin JPanel

