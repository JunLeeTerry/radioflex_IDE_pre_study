package com.terry.kevin.asm.ide.editor;

import org.eclipse.jface.text.rules.IWordDetector;

public class TKWordDetector implements IWordDetector {

	@Override
	public boolean isWordStart(char c) {
		return Character.isJavaIdentifierPart(c);
	}

	@Override
	public boolean isWordPart(char c) {
		return Character.isJavaIdentifierStart(c);
	}

}
