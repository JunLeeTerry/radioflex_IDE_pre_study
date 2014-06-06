package com.asmide.junlee.ui.editor;

import org.eclipse.jface.text.rules.IWordDetector;

public class MyWordDecetor implements IWordDetector {

	@Override
	public boolean isWordStart(char c) {
		// TODO Auto-generated method stub
		return Character.isJavaIdentifierStart(c);
	}

	@Override
	public boolean isWordPart(char c) {
		// TODO Auto-generated method stub
		return Character.isJavaIdentifierPart(c);
	}

}
