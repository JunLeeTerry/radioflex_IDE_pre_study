package org.kevin.preference;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setFixed(true);
		layout.addView("org.kevin.preference.view1", IPageLayout.LEFT, 0.3f,
				layout.getEditorArea());
	}
}
