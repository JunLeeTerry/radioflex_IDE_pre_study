package com.terry.kevin.asm.ide;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.terry.kevin.asm.ide.editor.TKEditor;
import com.terry.kevin.asm.ide.view.TKProjectExplorer;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setFixed(true);
		layout.setEditorAreaVisible(true);
		layout.addView(TKProjectExplorer.ID, IPageLayout.LEFT, 0.25F,
				layout.getEditorArea());
		layout.addView(TKEditor.ID, IPageLayout.RIGHT, 0.75f,
				layout.getEditorArea());
	}
}
