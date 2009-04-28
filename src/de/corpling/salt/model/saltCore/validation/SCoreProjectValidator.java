/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.validation;

import de.corpling.salt.model.saltCore.SGraph;
import de.corpling.salt.model.saltCore.SStereotypeContainer;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link de.corpling.salt.model.saltCore.SCoreProject}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SCoreProjectValidator {
	boolean validate();

	boolean validateSGraphs(EList<SGraph> value);
	boolean validateSStereotypeContainer(SStereotypeContainer value);
}
