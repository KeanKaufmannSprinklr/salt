package de.hu_berlin.u.saltnpepper.graph;

import de.hu_berlin.u.saltnpepper.salt.util.Copyable;

/**
 * A label is an attribute-value-pair and can belong to either a {@link Node},
 * an {@link Relation}, a {@link Graph}, a {@link Layer} or another
 * {@link Label} as shown in . An attribute-value-pair is a triple which
 * consists of a namespace, a name and a value (namespace::name=value). The
 * combination of name and namespace is used to identify a label and therefore
 * must be unique. The namespace is an optional value, to distinguish in case of
 * there are two labels having the same name.
 * 
 * @author florian
 *
 * @param <V>
 *            this parameter determines the type of the value of this label.
 */
public interface Label extends LabelableElement, Copyable<Label> {
	/**
	 * Separator between namespace and name: qname= NAMESPACE
	 * {@value #NS_SEPERATOR} NAME.
	 */
	public static final String NS_SEPERATOR = "::";

	/**
	 * Returns the optional namespace of the label. The combination of namespace
	 * and name must be unique in the containing object.
	 * 
	 * @return namespace
	 **/
	public String getNamespace();

	/**
	 * Sets the optional namespace of the label. The combination of namespace
	 * and name must be unique in the containing object.
	 * 
	 * @param namespace
	 *            namespace
	 */
	public void setNamespace(String namespace);

	/**
	 * Returns the name of the label. The combination of namespace and name must
	 * be unique in the containing object.
	 * 
	 * @return name of the label
	 */
	public String getName();

	/**
	 * Sets the name of the label. The combination of namespace and name must be
	 * unique in the containing object. The passed name must not be empty.
	 * 
	 * @param name
	 *            name of the label
	 */
	public void setName(String name);

	/**
	 * Returns the qName of this label, which is the combination of namespace
	 * and name must be unique in the containing object.
	 * 
	 * @return NAMESPACE {@value #NS_SEPERATOR} NAME
	 */
	public String getQName();

	/**
	 * Sets the qName of this label, which is the combination of namespace and
	 * name must be unique in the containing object.
	 * 
	 * @param qname
	 *            the qname is splitted into NAMESPACE {@value #NS_SEPERATOR}
	 *            NAME
	 */
	public void setQName(String qName);

	/**
	 * Returns the value of this label.
	 * 
	 * @return generic value of this label.
	 */
	public Object getValue();

	/**
	 * Sets the value of this label.
	 * 
	 * @param value
	 *            generic value of this label.
	 */
	public void setValue(Object value);

	/**
	 * Returns the container element, which contains this label. The label and
	 * the container are double chained, which means when a label is added to
	 * the container, the labels container is automatically set to it or even
	 * removed.
	 * 
	 * @return container of this label
	 */
	public <C extends LabelableElement> C getContainer();

	/**
	 * Sets the container element, which contains this label. The label and the
	 * container are double chained, which means when a label is added to the
	 * container, the labels container is automatically set to it or even
	 * removed. Passing a null value means removing the label from the
	 * container.
	 * 
	 * @param value
	 *            container of this label
	 */
	public <C extends LabelableElement> void setContainer(C container);
}