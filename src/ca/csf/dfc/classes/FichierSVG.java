package ca.csf.dfc.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class FichierSVG extends Fichier {
	
	private List<Element> p_listeDessin;
	
	private ListenerPanneauDessin m_listeDessin;
	
	 public FichierSVG() {
		// TODO Auto-generated constructor stub
	}
	 public void FormatSVG (ListenerPanneauDessin p_listeDessin){
			if (m_listeDessin == null) {
				throw new IllegalArgumentException("La liste est vide");
			}
			this.m_listeDessin = p_listeDessin;
	 }
	 
	@Override
	public void Enregistrer(ListenerPanneauDessin p_listeDessin, File p_File) throws IOException, Exception {
		XMLStreamWriter doc = null;
		FileWriter output = new FileWriter(p_File);

		doc = XMLOutputFactory.newInstance().createXMLStreamWriter(output);
		doc.writeStartDocument();

		doc.writeStartElement("svg");
		doc.writeAttribute("xmlns", "http://www.w3.org/2000/svg");
		doc.writeAttribute("version", "1.1");
		doc.writeAttribute("width",null);
		doc.writeAttribute("height", null);

		doc.writeStartElement("titre");
		doc.writeEndElement();
		
		
		
	}

	@Override
	public void Charger( ListenerPanneauDessin p_listeDessin, File p_File) throws Exception {
		throw new Exception();
		
	}

	@Override
	public String getExtention() {
		// TODO Auto-generated method stub
		return ".SVG";
	}

}
