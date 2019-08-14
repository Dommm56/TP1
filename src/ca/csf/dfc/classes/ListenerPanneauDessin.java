package ca.csf.dfc.classes;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.MouseInputListener;

public class ListenerPanneauDessin implements MouseInputListener {
	
	private boolean p_premierClickFait;
	
	private List<Element> p_listeDessin = new ArrayList<Element>();
	
	public ListenerPanneauDessin() {

		p_premierClickFait = false;
	}

	@Override
	public void mouseClicked(MouseEvent p_arg0) {
		GenerateurElement ge = SGenerateurElement.getInstance();
		if (this.p_premierClickFait == false) {
			ge.setPosOrig(MouseInfo.getPointerInfo().getLocation());
			this.p_premierClickFait = true;
		}
		else {
			ge.setPosFin(MouseInfo.getPointerInfo().getLocation());
			this.p_listeDessin.add(ge.creerElement());
			this.p_premierClickFait = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent p_arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent p_arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent p_arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent p_arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent p_arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent p_arg0) {
		// TODO Auto-generated method stub

	}
	
	public List<Element> getListeElementDessin() {
		return this.p_listeDessin;
	}

}
