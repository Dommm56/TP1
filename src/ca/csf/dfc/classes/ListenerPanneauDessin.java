package ca.csf.dfc.classes;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.MouseInputListener;

public class ListenerPanneauDessin implements MouseInputListener {
	
	private Point p_mousePos;
	private Point p_mousePosFin;
	private boolean p_premierClickFait;
	
	private List<Element> p_listeDessin = new ArrayList<Element>();
	
	public ListenerPanneauDessin() {
		p_mousePos = MouseInfo.getPointerInfo().getLocation();
		p_mousePosFin.setLocation(0, 0);
		p_premierClickFait = false;
	}

	@Override
	public void mouseClicked(MouseEvent p_arg0) {
		if (this.p_premierClickFait == false) {
			this.p_mousePos = MouseInfo.getPointerInfo().getLocation();
			
			this.p_premierClickFait = true;
		}
		else {
			this.p_mousePosFin = MouseInfo.getPointerInfo().getLocation();
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
	
	public double getMousePosX() {
		return this.p_mousePos.getX();
	}
	
	public double getMousePosY() {
		return this.p_mousePos.getY();
	}
	
	public List<Element> getListeElementDessin() {
		return this.p_listeDessin;
	}

}
