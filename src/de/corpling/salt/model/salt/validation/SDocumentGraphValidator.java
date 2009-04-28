/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.validation;

import de.corpling.salt.model.salt.SDocument;
import de.corpling.salt.model.salt.SProject;
import de.corpling.salt.model.salt.SSpanRelation;
import de.corpling.salt.model.salt.SStructure;
import de.corpling.salt.model.salt.STextualDataSource;
import de.corpling.salt.model.salt.STextualRelation;
import de.corpling.salt.model.salt.SToken;
import de.corpling.salt.model.salt.TextualRelation;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link de.corpling.salt.model.salt.SDocumentGraph}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SDocumentGraphValidator {
	boolean validate();

	boolean validateSTokens(EList<SToken> value);
	boolean validateSTextualRelations(EList<TextualRelation> value);
	boolean validateSTextualDataSources(EList<STextualDataSource> value);

	boolean validateSTextualDataSourcees(EList<STextualDataSource> value);

	boolean validateSStructures(EList<SStructure> value);

	boolean validateSpanRelations(EList<SSpanRelation> value);

	boolean validateSDocument(SDocument value);

	boolean validateSCoverageRelations(EList<SSpanRelation> value);

	boolean validateSProject(SProject value);

	boolean validateSCoverageRelations(SSpanRelation value);

	boolean validateSDominanceRelations(SSpanRelation value);
}
