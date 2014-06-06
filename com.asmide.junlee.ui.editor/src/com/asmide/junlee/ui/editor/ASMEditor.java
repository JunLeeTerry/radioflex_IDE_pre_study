package com.asmide.junlee.ui.editor;

import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.editors.text.TextEditor;



public class ASMEditor extends TextEditor {
	public static final String ID = "com.asmide.junlee.ui.editor.ASMEditor";
	
	private ASMColorProvider colorProvider;
	
	
	public ASMEditor() {
		super();
		colorProvider = new ASMColorProvider();
		setDocumentProvider(new ASMDocumentProvider());
		setSourceViewerConfiguration(new ASMSourceViewerConfiguration(colorProvider));
		
		
	}
	
	public void dispose() {
		colorProvider.dispose();
		super.dispose();
	}
	
	
	/*
	protected void initializeEditor(){
		System.out.println("initializeEditor is called");
		super.initializeEditor();
		setSourceViewerConfiguration(new ASMSourceViewerConfiguration(colorProvider));
		
	}
	*/
	
}
