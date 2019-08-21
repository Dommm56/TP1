package ca.csf.dfc.classes.test;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.classes.Couleurs;
import ca.csf.dfc.classes.Element;
import ca.csf.dfc.classes.Formes;
import ca.csf.dfc.classes.GenerateurElement;
import ca.csf.dfc.classes.SGenerateurElement;
import ca.csf.dfc.classes.Traits;
class ElementBuilderTest {

	@Test
	public void construireElementLigne() {
		// Arranger
		Point p1 = new Point(0,0);
		Point p2 = new Point(1,1);
		GenerateurElement geTestUnitaire = SGenerateurElement.getInstance();
		geTestUnitaire.setCouleur(Couleurs.CYAN);
		geTestUnitaire.setTrait(Traits.DEUX);
		geTestUnitaire.setPosFin(p2);
		geTestUnitaire.setPosOrig(p1);
		geTestUnitaire.setTypeElement(Formes.Ligne);
		geTestUnitaire.setRemplissage(Couleurs.BLEU);
		Shape l = new Line2D.Double(p1.getX(),p1.getY(),p2.getX(),p2.getY());
		// Agir
		Element e = geTestUnitaire.creerElement();
		// Auditer
		assertEquals(l.getBounds(), e.getTypeElement().getBounds());
		assertEquals(Couleurs.CYAN.getCouleur(), e.getCouleur());
		assertEquals(Couleurs.BLEU.getCouleur(), e.getRemplissage());
		assertEquals(Traits.DEUX.getTrait(), (int)e.getTrait());
	}
	
	@Test
	public void construireElementRectangle() {
		// Arranger
		Point p1 = new Point(0,0);
		Point p2 = new Point(1,1);
		GenerateurElement geTestUnitaire = SGenerateurElement.getInstance();
		geTestUnitaire.setCouleur(Couleurs.CYAN);
		geTestUnitaire.setTrait(Traits.DEUX);
		geTestUnitaire.setPosFin(p2);
		geTestUnitaire.setPosOrig(p1);
		geTestUnitaire.setTypeElement(Formes.Rectangle);
		geTestUnitaire.setRemplissage(Couleurs.BLEU);
		// Agir
		Element e = geTestUnitaire.creerElement();
		// Auditer
		assertEquals(new Rectangle2D.Double(p1.getX(),p1.getY(),p2.getX(),p2.getY()), e.getTypeElement());
		assertEquals(Couleurs.CYAN.getCouleur(), e.getCouleur());
		assertEquals(Couleurs.BLEU.getCouleur(), e.getRemplissage());
		assertEquals(Traits.DEUX.getTrait(), (int)e.getTrait());
	}
	
	@Test
	public void construireElementEllipse() {
		// Arranger
		Point p1 = new Point(0,0);
		Point p2 = new Point(1,1);
		GenerateurElement geTestUnitaire = SGenerateurElement.getInstance();
		geTestUnitaire.setCouleur(Couleurs.CYAN);
		geTestUnitaire.setTrait(Traits.DEUX);
		geTestUnitaire.setPosFin(p2);
		geTestUnitaire.setPosOrig(p1);
		geTestUnitaire.setTypeElement(Formes.Ellipse);
		geTestUnitaire.setRemplissage(Couleurs.BLEU);
		// Agir
		Element e = geTestUnitaire.creerElement();
		// Auditer
		assertEquals(new Ellipse2D.Double(p1.getX(),p1.getY(),p2.getX(),p2.getY()), e.getTypeElement());
		assertEquals(Couleurs.CYAN.getCouleur(), e.getCouleur());
		assertEquals(Couleurs.BLEU.getCouleur(), e.getRemplissage());
		assertEquals(Traits.DEUX.getTrait(), (int)e.getTrait());
	}

}
