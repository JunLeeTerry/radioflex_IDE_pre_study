package com.demo.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ViewPart;

public class CustomView extends ViewPart {

	public CustomView() {
		// TODO Auto-generated constructor stub
		System.out.println("run a view");
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		Button button = new Button(parent, SWT.BUTTON_MASK);
		button.setText("add an editor");
		button.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				IWorkspaceRoot myworkspaceRoot = ResourcesPlugin.getWorkspace()
						.getRoot();
				IProject myProject = myworkspaceRoot.getProject("com.editor");
				IFile myFile = myProject.getFile("editor.asm");
				System.out.println(myFile);
				FileEditorInput input = new FileEditorInput(myFile);

				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage()
							.openEditor(input, "com.demo.editor.editor");
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
