package de.hu_berlin.u.saltnpepper.graph;

import de.hu_berlin.u.saltnpepper.salt.util.GraphUtil;

/**
 * This class represents an identifier, which is a special kind of a label. The identifier is used for
 * {@link Node}, {@link Relation}, {@link Graph} and {@link Layer} objects. The namespace of an {@link Identifier} 
 * objectis fixed to {@link GraphUtil#IDENTIFIER_NAMESPACE} and its name is fixed to 
 * {@link GraphUtil#IDENTIFIER_NAME}. 
 * 
 * @author florian
 */
public interface Identifier extends Label<String>{
	/**
	 * Returns the value of this {@link Label}.
	 * @return the id value
	 */
	public String getId();

	/**
	 * Returns the {@link IdentifiableElement} object containing this identifier.
	 * @return container
	 */
	public IdentifiableElement getIdentifiableElement();
	/**
	 * This method has no effect, since the id value is not changeable. 
	 */
	@Override
	public void setValue(String value);
}
