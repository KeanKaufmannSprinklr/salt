/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.util;

import de.hub.corpling.salt.saltCore.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage
 * @generated
 */
public class SaltCoreSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SaltCorePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltCoreSwitch() {
		if (modelPackage == null) {
			modelPackage = SaltCorePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SaltCorePackage.SNODE: {
				SNode sNode = (SNode)theEObject;
				T result = caseSNode(sNode);
				if (result == null) result = caseSAnnotatableElement(sNode);
				if (result == null) result = caseSNamedElement(sNode);
				if (result == null) result = caseSIdentifiableElement(sNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SRELATION: {
				SRelation sRelation = (SRelation)theEObject;
				T result = caseSRelation(sRelation);
				if (result == null) result = caseSAnnotatableElement(sRelation);
				if (result == null) result = caseSNamedElement(sRelation);
				if (result == null) result = caseSIdentifiableElement(sRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SANNOTATABLE_ELEMENT: {
				SAnnotatableElement sAnnotatableElement = (SAnnotatableElement)theEObject;
				T result = caseSAnnotatableElement(sAnnotatableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SANNOTATION: {
				SAnnotation sAnnotation = (SAnnotation)theEObject;
				T result = caseSAnnotation(sAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SGRAPH: {
				SGraph sGraph = (SGraph)theEObject;
				T result = caseSGraph(sGraph);
				if (result == null) result = caseSNamedElement(sGraph);
				if (result == null) result = caseSAnnotatableElement(sGraph);
				if (result == null) result = caseSIdentifiableElement(sGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SNAMED_ELEMENT: {
				SNamedElement sNamedElement = (SNamedElement)theEObject;
				T result = caseSNamedElement(sNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT: {
				SIdentifiableElement sIdentifiableElement = (SIdentifiableElement)theEObject;
				T result = caseSIdentifiableElement(sIdentifiableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SELEMENT_ID: {
				SElementId sElementId = (SElementId)theEObject;
				T result = caseSElementId(sElementId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SNode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSNode(SNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SRelation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SRelation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSRelation(SRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SAnnotatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SAnnotatable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSAnnotatableElement(SAnnotatableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SAnnotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SAnnotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSAnnotation(SAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SGraph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SGraph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSGraph(SGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SNamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SNamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSNamedElement(SNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SIdentifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SIdentifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSIdentifiableElement(SIdentifiableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SElement Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SElement Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSElementId(SElementId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //SaltCoreSwitch
