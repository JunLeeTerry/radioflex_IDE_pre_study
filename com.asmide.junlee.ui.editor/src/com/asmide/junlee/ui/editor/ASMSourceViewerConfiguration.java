package com.asmide.junlee.ui.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;





public class ASMSourceViewerConfiguration extends SourceViewerConfiguration {
	private ASMColorProvider colorProvider;
	
	
	public ASMSourceViewerConfiguration(ASMColorProvider colorProvider) {
		this.colorProvider = colorProvider;
	}
	
	
	
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] {
			IDocument.DEFAULT_CONTENT_TYPE,
			ASMPartitionScanner.SINGLELINE_COMMENT,
			ASMPartitionScanner.STRING };
	}

	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		
		
	/*	
		reconciler
				.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
*/
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new SingleTokenScanner(
				new TextAttribute(
						colorProvider.getColor(ASMColorProvider.STRING))));
		reconciler.setDamager(dr, ASMPartitionScanner.STRING);
		reconciler.setRepairer(dr, ASMPartitionScanner.STRING);
		
		dr = new DefaultDamagerRepairer(
				new ASMCodeScanner(colorProvider));
		
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		
		dr = new DefaultDamagerRepairer(new SingleTokenScanner(
				new TextAttribute(colorProvider
						.getColor(ASMColorProvider.SINGLE_LINE_COMMENT))));
		reconciler.setDamager(dr, ASMPartitionScanner.SINGLELINE_COMMENT);
		reconciler.setRepairer(dr, ASMPartitionScanner.SINGLELINE_COMMENT);

		
		
		System.out.println("getPresentationReconciler is called");
		
		return reconciler;
	}
}
