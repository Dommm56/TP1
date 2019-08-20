package ca.csf.dfc.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class FichierXML extends Fichier {
	
    private List<Element> p_listeDessin;
	
	private ListenerPanneauDessin m_listeDessin;
	
	@SuppressWarnings("unused")
	
	public FichierXML() {
		
	}
	
	public FichierXML(ListenerPanneauDessin p_listeDessin) {
		if(p_listeDessin==null) {
			throw new IllegalArgumentException("p_Element ne peut etre nul");
		}
		this.m_listeDessin=p_listeDessin;
		
	}

	public void Enregistrer(ListenerPanneauDessin p_listeDessin, File p_File) throws IOException, XMLStreamException
	{
		if (p_File== null) {
			throw new IllegalArgumentException("p_file ne doit etre nul");
		}
		XMLStreamWriter doc = null;
		FileWriter output = new FileWriter(p_File);
		doc = XMLOutputFactory.newInstance().createXMLStreamWriter(output);		
		doc.writeStartDocument();
		doc.writeStartElement("dessin");
		doc.writeStartElement("fond");
/*		doc.writeAttribute("hauteur", Double.toString(p_listeDessin.getHauteur()));
		doc.writeAttribute("largeur", Double.toString(p_listeDessin.getLargeur()));
		//doc.writeAttribute("couleur", Integer.toString(p_Element.getArrierePlan().getRGB()));
		doc.writeEndElement();
		
		doc.writeStartElement("forme");
		for (ListenerPanneauDessin elementGraphique : p_listeDessin) {
			doc.writeStartElement(elementGraphique.getNom());
			doc.writeAttribute("X", Double.toString(elementGraphique.get));
			doc.writeAttribute("Y", Double.toString(elementGraphique.getY()));
			doc.writeAttribute("hauteur", Double.toString(elementGraphique.getHauteur()));
			doc.writeAttribute("largeur", Double.toString(elementGraphique.getLargeur()));
			doc.writeAttribute("trait", Integer.toString(elementGraphique.getLargeurTrait()));
			doc.writeAttribute("traitcolor", Integer.toString(elementGraphique.getCouleurTrait().getRGB()));
			if (elementGraphique.getCouleur() != null) {
				doc.writeAttribute("couleur", Integer.toString(elementGraphique.getCouleur().getRGB()));
			} else {
				doc.writeAttribute("couleur", "null");
			}
			doc.writeEndElement();
		}
		
		doc.writeEndElement();
		doc.writeEndElement();
		if (doc != null) {
			doc.flush();
			doc.close();
		}
		
		 */
	} 
}
