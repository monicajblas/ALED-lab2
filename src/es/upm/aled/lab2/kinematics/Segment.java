package es.upm.aled.lab2.kinematics;

import java.util.ArrayList;
import java.util.List;

public class Segment {

	private double length; 
	private double angle;
	private List<Segment> children = new ArrayList<Segment>(); 
	
	/**
	 * Construye un nuevo Segment a partir de su longitud y su ángulo
	 * 
	 * @param lenght of the Segment
	 * @param angle que forma Segment con su padre 
	 */
	public Segment(double lenght, double angle) {
		this.length = lenght;
		this.angle = angle;
	}
	
	/**
	 * Devuelve la longitud del segmento 
	 * 
	 * @return length of the Segment 
	 */
	public double getLenght() {
		return length;
	}
	
	/**
	 * Devuelve el ángulo en radianes que forma el Segment y su padre 
	 * (el Segment al que está conectado)
	 * 
	 * @return angle entre Segment y su conexión previa
	 */
	public double getAngle() {
		return angle;
	}
	
	/**
	 * Modifica el atributo ángulo 
	 * 
	 * @param angle 
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	/**
	 * Returns the Segments this one is connected to. 
	 * 
	 * @return children
	 */
	public List<Segment> getChildren() {
		return children;

	}
	
	/**
	 * Adds a new Segment to the List of Segments this one is connected to. 
	 * Each Segment can only appear as a child once.
	 * 
	 * @param child to be added
	 */
	public void addChild(Segment child){
		if(child != null && !children.contains(child))
			children.add(child);	
	}

	
}
