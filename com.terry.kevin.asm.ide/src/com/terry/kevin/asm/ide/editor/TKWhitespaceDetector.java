package com.terry.kevin.asm.ide.editor;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class TKWhitespaceDetector implements IWhitespaceDetector{

	@Override
	public boolean isWhitespace(char character) {
		return Character.isWhitespace(character);
	}
}
