package com.terry.kevin.asm.ide.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class TKSourseViewerConfiguration extends SourceViewerConfiguration {
	static class SingleTokenScanner extends BufferedRuleBasedScanner {
		public SingleTokenScanner(TextAttribute attribute) {
			setDefaultReturnToken(new Token(attribute));
		}
	}

	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		TKColorProvider colorprovider = new TKColorProvider();
		reconciler
				.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(
				new TKCodeScanner(colorprovider));
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		dr = new DefaultDamagerRepairer(
				new SingleTokenScanner(new TextAttribute(colorprovider
						.getColor(TKColorProvider.SINGLE_LINE_COMMENT))));
		reconciler.setDamager(dr, TKPartitionScanner.SINGLELINE_COMMENT);
		reconciler.setRepairer(dr, TKPartitionScanner.SINGLELINE_COMMENT);

		dr = new DefaultDamagerRepairer(new SingleTokenScanner(
				new TextAttribute(
						colorprovider.getColor(TKColorProvider.STRING))));
		reconciler.setDamager(dr, TKPartitionScanner.STRING);
		reconciler.setRepairer(dr, TKPartitionScanner.STRING);

		return reconciler;
	}
}
