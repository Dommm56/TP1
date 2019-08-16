package ca.csf.dfc.classes;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public enum Formes {
	Rectangle(new Rectangle2D.Double()),
	Ellipse(new Ellipse2D.Double()),
	Ligne(new Line2D.Double());
	
	private Shape m_typeElement;
	
	Formes(Shape p_typeElement) {
		this.m_typeElement = p_typeElement;
	}
	
	public Shape getTypeElement() {
		return this.m_typeElement;
	}
}//
