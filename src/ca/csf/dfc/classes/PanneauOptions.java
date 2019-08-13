package ca.csf.dfc.classes;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauOptions<E> extends JPanel{
	private static final long serialVersionUID = -6133798062695262877L;
	private String[] lesFormesStrings = {"Ligne","Ellipse","Rectangle"};
	
	JComboBox combo_Forme = new JComboBox(Formes.values());
	JComboBox combo_Couleur = new JComboBox(Couleurs.values());
	JComboBox combo_Trait = new JComboBox(Traits.values());
	
	JLabel lbl_FormeJLabel = new JLabel("Formes");
	JLabel lbl_Couleur = new JLabel("Couleur");
	JLabel lbl_Trait = new JLabel("Trait");

	public PanneauOptions() {
		super();
        this.add(lbl_FormeJLabel);
        this.add(combo_Forme);

        this.add(lbl_Couleur);
        this.add(combo_Couleur);
        
        this.add(lbl_Trait);
        this.add(combo_Trait);
			
	}//fin Panneau1	
}//fin JPanel
