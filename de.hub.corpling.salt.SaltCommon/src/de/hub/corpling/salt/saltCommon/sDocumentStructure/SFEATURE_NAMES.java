/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>SFEATURE NAMES</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSFEATURE_NAMES()
 * @model
 * @generated
 */
public enum SFEATURE_NAMES implements Enumerator {
	/**
	 * The '<em><b>STEXT OVERLAPPING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEXT_OVERLAPPING_VALUE
	 * @generated
	 * @ordered
	 */
	STEXT_OVERLAPPING(0, "STEXT_OVERLAPPING", "salt::STEXT_OVERLAPPING"), /**
	 * The '<em><b>SSTART</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SSTART_VALUE
	 * @generated
	 * @ordered
	 */
	SSTART(1, "SSTART", "SSTART"), /**
	 * The '<em><b>SEND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEND_VALUE
	 * @generated
	 * @ordered
	 */
	SEND(2, "SEND", "SEND"), /**
	 * The '<em><b>STEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEXT_VALUE
	 * @generated
	 * @ordered
	 */
	STEXT(3, "STEXT", "STEXT"), /**
	 * The '<em><b>SDATA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SDATA_VALUE
	 * @generated
	 * @ordered
	 */
	SDATA(4, "SDATA", "SDATA");

	/**
	 * The '<em><b>STEXT OVERLAPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEXT OVERLAPPING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEXT_OVERLAPPING
	 * @model literal="salt::STEXT_OVERLAPPING"
	 * @generated
	 * @ordered
	 */
	public static final int STEXT_OVERLAPPING_VALUE = 0;

	/**
	 * The '<em><b>SSTART</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SSTART</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SSTART
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SSTART_VALUE = 1;

	/**
	 * The '<em><b>SEND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SEND_VALUE = 2;

	/**
	 * The '<em><b>STEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEXT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEXT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEXT_VALUE = 3;

	/**
	 * The '<em><b>SDATA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SDATA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SDATA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SDATA_VALUE = 4;

	/**
	 * An array of all the '<em><b>SFEATURE NAMES</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SFEATURE_NAMES[] VALUES_ARRAY =
		new SFEATURE_NAMES[] {
			STEXT_OVERLAPPING,
			SSTART,
			SEND,
			STEXT,
			SDATA,
		};

	/**
	 * A public read-only list of all the '<em><b>SFEATURE NAMES</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SFEATURE_NAMES> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>SFEATURE NAMES</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SFEATURE_NAMES get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SFEATURE_NAMES result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SFEATURE NAMES</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SFEATURE_NAMES getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SFEATURE_NAMES result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SFEATURE NAMES</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SFEATURE_NAMES get(int value) {
		switch (value) {
			case STEXT_OVERLAPPING_VALUE: return STEXT_OVERLAPPING;
			case SSTART_VALUE: return SSTART;
			case SEND_VALUE: return SEND;
			case STEXT_VALUE: return STEXT;
			case SDATA_VALUE: return SDATA;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SFEATURE_NAMES(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //SFEATURE_NAMES
