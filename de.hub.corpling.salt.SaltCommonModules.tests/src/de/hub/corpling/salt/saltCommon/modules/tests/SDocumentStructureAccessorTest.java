package de.hub.corpling.salt.saltCommon.modules.tests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import de.hub.corpling.pepper.modules.dot.Salt2DOT;
import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.modules.SDocumentStructureAccessor;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpan;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructure;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;
import de.hub.corpling.salt.saltCore.SNode;

public class SDocumentStructureAccessorTest extends SDocumentStructureModuleTest 
{
	public SDocumentStructureAccessor getFixture() {
		return((SDocumentStructureAccessor)super.getFixture());
	} 
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception 
	{
		setFixture(new SDocumentStructureAccessor());
		SDocumentGraph sDocGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getFixture().setSDocumentGraph(sDocGraph);
	}
	
	/**
	 * 
	 * 		span1
	 * 		/		\
	 * 	tok1		tok2
	 * 	|			|
	 * 	This		is
	 */
	public void testGetSText()
	{
		//text
		STextualDS sText= SaltCommonFactory.eINSTANCE.createSTextualDS();
		sText.setSText("This is a sample text.");
		this.getFixture().getSDocumentGraph().addSNode(sText);
		
		//tok1
		SToken tok1= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().getSDocumentGraph().addSNode(tok1);
		//tok2
		SToken tok2= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().getSDocumentGraph().addSNode(tok2);
		//textlRel1
		STextualRelation textRel1= SaltCommonFactory.eINSTANCE.createSTextualRelation();
		textRel1.setSTextualDS(sText);
		textRel1.setSToken(tok1);
		textRel1.setSStart(0);
		textRel1.setSEnd(4);
		this.getFixture().getSDocumentGraph().addSRelation(textRel1);
		
		//textlRel1
		STextualRelation textRel2= SaltCommonFactory.eINSTANCE.createSTextualRelation();
		textRel2.setSTextualDS(sText);
		textRel2.setSToken(tok2);
		textRel2.setSStart(5);
		textRel2.setSEnd(7);
		this.getFixture().getSDocumentGraph().addSRelation(textRel2);
		
		//span1 
		SSpan span= SaltCommonFactory.eINSTANCE.createSSpan();
		this.getFixture().getSDocumentGraph().addSNode(span);
		
		//spanRel1
		SSpanningRelation spanRel1= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
		spanRel1.setSSpan(span);
		spanRel1.setSToken(tok1);
		this.getFixture().getSDocumentGraph().addSRelation(spanRel1);
		
		//spanRel2
		SSpanningRelation spanRel2= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
		spanRel2.setSSpan(span);
		spanRel2.setSToken(tok2);
		this.getFixture().getSDocumentGraph().addSRelation(spanRel2);
		
		assertEquals("This", this.getFixture().getSOverlappedText(tok1));
		assertEquals("is", this.getFixture().getSOverlappedText(tok2));
		assertEquals("This is", this.getFixture().getSOverlappedText(span));
	}
	
	/**
	 * tests graph:
	 * 			struct2			
	 * 		/	/			\
	 * 	struct1	/			|		
	 * 	/	|	/			|
	 * 	|	span1			span2		
	 * 	|	/	\	/					\
	 * tok1		tok2		tok3		tok4		tok5
	 * 
	 * PR�s tok1-> tok2; tok3-> tok4; tok4->tok2
	 */
	public void testGetRootsBySRelation()
	{
		SToken tok1= null;
		SToken tok2= null;
		SToken tok3= null;
		SToken tok4= null;
		SToken tok5= null;
		
		SSpan span1= null;
		SSpan span2= null;
		
		SStructure struct1= null;
		SStructure struct2= null;
		{//Token
			tok1= SaltCommonFactory.eINSTANCE.createSToken();
			tok1.setSName("tok1");
			this.getFixture().getSDocumentGraph().addSNode(tok1);
			assertEquals(tok1, this.getFixture().getSDocumentGraph().getSNode(tok1.getSId()));
			
			tok2= SaltCommonFactory.eINSTANCE.createSToken();
			tok2.setSName("tok2");
			this.getFixture().getSDocumentGraph().addSNode(tok2);
			assertEquals(tok2, this.getFixture().getSDocumentGraph().getSNode(tok2.getSId()));
			
			tok3= SaltCommonFactory.eINSTANCE.createSToken();
			tok3.setSName("tok3");
			this.getFixture().getSDocumentGraph().addSNode(tok3);
			assertEquals(tok3, this.getFixture().getSDocumentGraph().getSNode(tok3.getSId()));
			
			tok4= SaltCommonFactory.eINSTANCE.createSToken();
			tok4.setSName("tok4");
			this.getFixture().getSDocumentGraph().addSNode(tok4);
			assertEquals(tok4, this.getFixture().getSDocumentGraph().getSNode(tok4.getSId()));
			
			tok5= SaltCommonFactory.eINSTANCE.createSToken();
			tok5.setSName("tok5");
			this.getFixture().getSDocumentGraph().addSNode(tok5);
			assertEquals(tok5, this.getFixture().getSDocumentGraph().getSNode(tok5.getSId()));
		}//SToken
		{//SSpan
			span1= SaltCommonFactory.eINSTANCE.createSSpan();
			span1.setSName("span1");
			this.getFixture().getSDocumentGraph().addSNode(span1);
			assertEquals(span1, this.getFixture().getSDocumentGraph().getSNode(span1.getSId()));
			
			span2= SaltCommonFactory.eINSTANCE.createSSpan();
			span2.setSName("span2");
			this.getFixture().getSDocumentGraph().addSNode(span2);
			assertEquals(span2, this.getFixture().getSDocumentGraph().getSNode(span2.getSId()));
		}//SSpan
		
		{//SStructure
			struct1= SaltCommonFactory.eINSTANCE.createSStructure();
			struct1.setSName("struct1");
			this.getFixture().getSDocumentGraph().addSNode(struct1);
			assertEquals(struct1, this.getFixture().getSDocumentGraph().getSNode(struct1.getSId()));
			
			struct2= SaltCommonFactory.eINSTANCE.createSStructure();
			struct2.setSName("struct2");
			this.getFixture().getSDocumentGraph().addSNode(struct2);
			assertEquals(struct2, this.getFixture().getSDocumentGraph().getSNode(struct2.getSId()));
		}//SStructure
		
		{//SSpanningRelation
			SSpanningRelation sSpanRel= null;
			sSpanRel= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			sSpanRel.setSToken(tok1);
			sSpanRel.setSSpan(span1);
			this.getFixture().getSDocumentGraph().addSRelation(sSpanRel);
			assertEquals(sSpanRel, this.getFixture().getSDocumentGraph().getSRelation(sSpanRel.getSId()));
			
			sSpanRel= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			sSpanRel.setSToken(tok2);
			sSpanRel.setSSpan(span1);
			this.getFixture().getSDocumentGraph().addSRelation(sSpanRel);
			assertEquals(sSpanRel, this.getFixture().getSDocumentGraph().getSRelation(sSpanRel.getSId()));
			
			sSpanRel= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			sSpanRel.setSToken(tok2);
			sSpanRel.setSSpan(span2);
			this.getFixture().getSDocumentGraph().addSRelation(sSpanRel);
			assertEquals(sSpanRel, this.getFixture().getSDocumentGraph().getSRelation(sSpanRel.getSId()));
			
			sSpanRel= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			sSpanRel.setSToken(tok4);
			sSpanRel.setSSpan(span2);
			this.getFixture().getSDocumentGraph().addSRelation(sSpanRel);
			assertEquals(sSpanRel, this.getFixture().getSDocumentGraph().getSRelation(sSpanRel.getSId()));
		}//SSpanningRelation
		
		{//SPointingRelation
			SPointingRelation sPRel= null;
			sPRel= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			sPRel.setSStructuredSource(tok1);
			sPRel.setSStructuredTarget(tok2);
			this.getFixture().getSDocumentGraph().addSRelation(sPRel);
			assertEquals(sPRel, this.getFixture().getSDocumentGraph().getSRelation(sPRel.getSId()));
			
			sPRel= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			sPRel.setSStructuredSource(tok3);
			sPRel.setSStructuredTarget(tok4);
			this.getFixture().getSDocumentGraph().addSRelation(sPRel);
			assertEquals(sPRel, this.getFixture().getSDocumentGraph().getSRelation(sPRel.getSId()));
			
			sPRel= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			sPRel.setSStructuredSource(tok4);
			sPRel.setSStructuredTarget(tok2);
			this.getFixture().getSDocumentGraph().addSRelation(sPRel);
			assertEquals(sPRel, this.getFixture().getSDocumentGraph().getSRelation(sPRel.getSId()));
		}//SPointingRelation
		
		{//print saltGraph to dot (just for testing)
			Salt2DOT salt2Dot= new Salt2DOT();
			salt2Dot.salt2Dot(this.getFixture().getSDocumentGraph(), URI.createFileURI("_TMP" + "/doc1.dot"));
		}
		
		EList<SNode> roots= null;
		{//check SSpanningRelation
			roots= new BasicEList<SNode>();
			roots.add(span1);
			roots.add(span2);
			assertTrue(roots.containsAll(this.getFixture().getRootsBySRelation(SSpanningRelation.class)));
			assertTrue(this.getFixture().getRootsBySRelation(SSpanningRelation.class).containsAll(roots));
		}//check SSpanningRelation
		
		{//check SDominanceRelation
			roots= new BasicEList<SNode>();
			roots.add(struct1);
			System.out.println("");
			assertTrue(roots.containsAll(this.getFixture().getRootsBySRelation(SSpanningRelation.class)));
			assertTrue(this.getFixture().getRootsBySRelation(SSpanningRelation.class).containsAll(roots));
		}//check SDominanceRelation
		
		{//check SPointingRelation
			roots= new BasicEList<SNode>();
			roots.add(tok1);
			roots.add(tok3);
			assertTrue(roots.containsAll(this.getFixture().getRootsBySRelation(SSpanningRelation.class)));
			assertTrue(this.getFixture().getRootsBySRelation(SSpanningRelation.class).containsAll(roots));
		}//check SPointingRelation
	}
}
