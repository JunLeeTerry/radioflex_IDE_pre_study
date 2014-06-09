package com.demo.editor;

import org.eclipse.ui.editors.text.TextEditor;

public class CustomEditor extends TextEditor {
	public static final String ID = "com.demo.editor.editor";

	private ASMColorProvider colorProvider;

	public CustomEditor() {
		super();
		colorProvider = new ASMColorProvider();
		setDocumentProvider(new ASMDocumentProvider());
		setSourceViewerConfiguration(new ASMSourceViewerConfiguration(
				colorProvider));

	}

	public void dispose() {
		colorProvider.dispose();
		super.dispose();
	}
}
