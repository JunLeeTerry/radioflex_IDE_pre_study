package org.kevin.navigator;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setFixed(true);
		layout.addView("org.kevin.navigetor.view", IPageLayout.LEFT, 0.4f, layout.getEditorArea());
	}
}
