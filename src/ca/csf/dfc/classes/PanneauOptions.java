package ca.csf.dfc.classes;


import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.css.RGBColor;

import sun.awt.image.PixelConverter.Rgba;

public class PanneauOptions<E> extends JPanel{

	private static final long serialVersionUID = -6133798062695262877L;
	private String[] lesFormesStrings = {"Ligne","Ellipse","Rectangle"};
	
	JLabel lbl_FormeJLabel = new JLabel("Formes");
	JComboBox<String> combo_Forme = new JComboBox<String>(lesFormesStrings);
	
	JButton btn_Couleur = new JButton("Couleur");
	JColorChooser btn_ChoixCouleurChooser = new JColorChooser();
	
	
	JButton btn_Trait = new JButton("Trait");
	public PanneauOptions() {
		super();
        this.add(lbl_FormeJLabel);
        this.add(combo_Forme);
        //btn_ChoixCouleurChooser.setChooserPanels(colorChoosers);
        this.add(btn_Couleur);
        
        this.add(btn_Trait);
		
		
		
	}//fin Panneau1
	
	

	
	
	
}//fin JPanel
