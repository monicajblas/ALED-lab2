package es.upm.aled.lab2.kinematics;

import es.upm.aled.lab2.gui.Node;

/**
 * This class implements a forward kinematics algorithm using recursion. It
 * expects a tree of Segments (defined by its length and angle with respect to
 * the previous Segment in the tree) and returns a tree of Nodes (defined by
 * their absolute coordinates in a 2-dimensional space).
 * 
 * @author rgarciacarmona
 */
public class ForwardKinematics {

	/**
	 * Returns a tree of Nodes to be used by SkeletonPanel to draw the position of
	 * an exoskeleton. This method is the public facade to a recursive method that
	 * builds the result from a tree of Segments defined by their angle and length,
	 * and the relationship between them (which Segment is children of which).
	 * 
	 * @param root    The root of the tree of Segments.
	 * @param originX The X coordinate for the origin point of the tree.
	 * @param originY The Y coordinate for the origin point of the tree.
	 * @return The tree of Nodes that represent the exoskeleton position in absolute
	 *         coordinates.
	 */
	// Public method: returns the root of the position tree
	// MÉTODO FACHADA
	public static Node computePositions(Segment root, double originX, double originY) {
		return computePositions(root, originX, originY, 0.0);
	}

	// Private helper method that implements the recursive algorithm
	private static Node computePositions(Segment link, double baseX, double baseY, double accumulatedAngle) {
		accumulatedAngle = accumulatedAngle + link.getAngle();  
		//para actualizar el ángulo q es el ángulo acumulado + el ángulo del sengmento
		double xi = baseX + link.getLenght()*Math.cos(accumulatedAngle); 
		double yi = baseY + link.getLenght()*Math.sin(accumulatedAngle);
		Node nodoNuevo = new Node(xi, yi);
		
		// CASO BASE
		if(link.getChildren().size() == 0) //tb valdría "link.getChildren().isEmpty()"
			return nodoNuevo;
		
		// PASO RECURSIVO
		for(Segment child: link.getChildren())
			//recorro los segmentos hijos y les pido q me conviertan a nodo hasta donde llegan  
			nodoNuevo.addChild(computePositions(child, xi, yi, accumulatedAngle)); 
			//y los nodos a donde llegan los segmentos hijos los añado a los hijos del nodo q yo estoy fabricando
		return nodoNuevo;
		
	}
}