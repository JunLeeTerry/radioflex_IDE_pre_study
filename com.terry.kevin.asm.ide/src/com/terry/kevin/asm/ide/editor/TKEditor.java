package com.terry.kevin.asm.ide.editor;

import org.eclipse.ui.editors.text.TextEditor;

public class TKEditor extends TextEditor {
	public static String ID = "com.terry.kevin.asm.ide.editor.tkeditor";

	public void initializeEditor() {
		super.initializeEditor();
		setSourceViewerConfiguration(new TKSourseViewerConfiguration());
	}
}
