package com.asmide.junlee.ui.editor;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class MyWhitespaceDetector implements IWhitespaceDetector {

	@Override
	public boolean isWhitespace(char c) {
		// TODO Auto-generated method stub
		return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
		//return Character.isWhitespace(c);
	}

}
