/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import de.util.graph.Label;
import java.net.URL;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAnnotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.SAnnotation#getSType <em>SType</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSAnnotation()
 * @model
 * @generated
 */
public interface SAnnotation extends Label {

	/**
	 * Returns the value of the '<em><b>SType</b></em>' attribute.
	 * The default value is <code>"STEXT"</code>.
	 * The literals are from the enumeration {@link de.corpling.salt.model.saltCore.SDATATYPES}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SType</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SType</em>' attribute.
	 * @see de.corpling.salt.model.saltCore.SDATATYPES
	 * @see #setSType(SDATATYPES)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSAnnotation_SType()
	 * @model default="STEXT"
	 * @generated
	 */
	SDATATYPES getSType();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SAnnotation#getSType <em>SType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SType</em>' attribute.
	 * @see de.corpling.salt.model.saltCore.SDATATYPES
	 * @see #getSType()
	 * @generated
	 */
	void setSType(SDATATYPES value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Long getValueSNumber();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Double getValueSReal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getValueSText();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="de.corpling.salt.model.saltCore.URL"
	 * @generated
	 */
	URL getValueSURL();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Object getValueSObject();
} // SAnnotation
