package es.upm.aled.lab2.kinematics;

import java.util.ArrayList;
import java.util.List;

// TODO: Implemente la clase
public class Segment {

	private double length; 
	private double angle;
	private List<Segment> children = new ArrayList<Segment>(); 
	
	/**
	 * Builds a new Segment from its lenght and angle measurements
	 * 
	 * @param lenght
	 * @param angle
	 */
	public Segment(double lenght, double angle) {
		this.length = lenght;
		this.angle = angle;
	}
	
	/**
	 * Returns the lenght of the segment
	 * 
	 * @return length of the Segment 
	 */
	public double getLenght() {
		return length;
	}
	
	/**
	 * Returns the angle in radians formed by the segment and its parent 
	 * (the segment to which it i connected) 
	 * 
	 * @return angle between Segment and it previous conecction
	 */
	public double getAngle() {
		return angle;
	}
	
	/**
	 * Modifies the angle of the segment
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
