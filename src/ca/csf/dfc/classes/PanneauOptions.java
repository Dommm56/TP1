package ca.csf.dfc.classes;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * @description: La classe PanneauOption implemente linterface Jpanel, cette classe permet de regouper les differents groupbox present 
 * dans le panneau. Ces groupbox permettent de choisir les propriete des formes que lon veut creer. Ces comboxBox vont chercher
 * les elements de nos differents enumerations de proprietes
 */
public class PanneauOptions extends JPanel{
	private static final long serialVersionUID = -6133798062695262877L;
	
	JComboBox<Formes> combo_Forme = new JComboBox<Formes>(Formes.values());
	JComboBox<Couleurs> combo_Couleur = new JComboBox<Couleurs>(Couleurs.values());
	JComboBox<Traits> combo_Trait = new JComboBox<Traits>(Traits.values());
	JComboBox<Couleurs> combo_Remplissage = new JComboBox<Couleurs>(Couleurs.values());
	
	JLabel lbl_FormeJLabel = new JLabel("Formes");
	JLabel lbl_Couleur = new JLabel("Couleur");
	JLabel lbl_Trait = new JLabel("Trait");
	JLabel lbl_Remplissage = new JLabel("Remplissage");
	
	/*
	 * description: COnstructeur par defaut qui permet dajouter les labels, les combobox et les valeurs par defaut
	 */
	public PanneauOptions() {
		super();
        this.add(lbl_FormeJLabel);
        this.add(combo_Forme);
        this.combo_Forme.setSelectedItem(Formes.Rectangle);

        this.add(lbl_Couleur);
        this.add(combo_Couleur);
        this.combo_Couleur.setSelectedItem(Couleurs.NOIR);
        
        this.add(lbl_Trait);
        this.add(combo_Trait);
        this.combo_Trait.setSelectedItem(Traits.UN);
        
        this.add(lbl_Remplissage);
        this.add(combo_Remplissage);
        this.combo_Remplissage.setSelectedItem(Couleurs.AUCUNE);
        
        GenerateurElement ge = SGenerateurElement.getInstance();
        
        Formes forme = (Formes)this.combo_Forme.getSelectedItem();
        Couleurs remplissage = (Couleurs)this.combo_Remplissage.getSelectedItem();
        Couleurs couleur = (Couleurs)this.combo_Couleur.getSelectedItem();
        Traits trait = (Traits)this.combo_Trait.getSelectedItem();
        ge.setTypeElement(forme);
        ge.setTrait(trait);
        ge.setCouleur(couleur);
        ge.setRemplissage(remplissage);
        
        
        /*
         * Voici les differents listeners qui permettent de voir quels proprietes sont choisient pour la creation des formes
         */
        ItemListener formeListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		    	  int etat = itemEvent.getStateChange();
		    	  if (etat == ItemEvent.SELECTED) {
		    		  Formes f = (Formes)itemEvent.getItem();
		    		  ge.setTypeElement(f);
		    	  }
		      }
		};
		combo_Forme.addItemListener(formeListener);
		
        ItemListener traitListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		    	  int etat = itemEvent.getStateChange();
		    	  if (etat == ItemEvent.SELECTED) {
		    		  Traits t = (Traits)itemEvent.getItem();
		    		  ge.setTrait(t);
		    	  }
		      }
		};		
        combo_Trait.addItemListener(traitListener);
        
        ItemListener remplissageListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		    	  int etat = itemEvent.getStateChange();
		    	  if (etat == ItemEvent.SELECTED) {
		    		  Couleurs c = (Couleurs)itemEvent.getItem();
		    		  ge.setRemplissage(c);
		    	  }
		      }
		};
		combo_Remplissage.addItemListener(remplissageListener);
		
        ItemListener couleurListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		    	  int etat = itemEvent.getStateChange();
		    	  if (etat == ItemEvent.SELECTED) {
		    		  Couleurs c = (Couleurs)itemEvent.getItem();
		    		  ge.setCouleur(c);
		    	  }
		      }
		};
		combo_Couleur.addItemListener(couleurListener);
		
	}//fin Constructeur default
	
}//fin PanneauOptions
