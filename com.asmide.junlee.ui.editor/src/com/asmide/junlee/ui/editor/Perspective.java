package com.asmide.junlee.ui.editor;

import org.eclipse.ui.IPageLayout;

import org.eclipse.ui.IPerspectiveFactory;

import com.asmide.junlee.ui.editor.view.TestView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		layout.addStandaloneView(TestView.ID, true, IPageLayout.LEFT, .30f,
				layout.getEditorArea());
		layout.getViewLayout(TestView.ID).setCloseable(false);
		layout.setFixed(true);
	}
}
