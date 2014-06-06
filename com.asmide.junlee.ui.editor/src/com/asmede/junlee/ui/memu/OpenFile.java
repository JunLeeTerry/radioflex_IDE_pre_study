package com.asmede.junlee.ui.memu;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class OpenFile extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();
		FileDialog dialog= new FileDialog(shell, SWT.OPEN);
		dialog.setFilterExtensions(new String[]{".txt","*.*"});
		dialog.setFilterNames(new String[]{"Text File","All files"});
		String fileSelected = dialog.open();
		
		if (fileSelected != null){
			System.out.println("Selected file: "+fileSelected);
		}
		return null;
	}

}
