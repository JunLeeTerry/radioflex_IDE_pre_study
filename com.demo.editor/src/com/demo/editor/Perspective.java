package com.demo.editor;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setFixed(true);
		layout.setEditorAreaVisible(true);
		layout.addView("com.demo.editor.view", IPageLayout.LEFT, 0.3f, layout.getEditorArea());
	}
}
