/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.validation;

import de.corpling.salt.model.salt.SDocumentGraph;

/**
 * A sample validator interface for {@link de.corpling.salt.model.salt.SToken}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface STokenValidator {
	boolean validate();

	boolean validateSLeft(Long value);

	boolean validateSRight(Long value);

	boolean validateLeft(Long value);

	boolean validateRight(Long value);

	boolean validateLeft(long value);
	boolean validateRight(long value);
	boolean validateSDocumentGraph(SDocumentGraph value);
}
