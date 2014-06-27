package org.kevin.preference;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

public class ShowPreferenceValues extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveWorkbenchWindowChecked(event)
				.getShell();
		
		String myPrefDirectory = Activator.getDefault().getPreferenceStore().getString("PATH");
		MessageDialog.openInformation(shell, "Info", myPrefDirectory);

		Boolean myPrefBoolean = Activator.getDefault().getPreferenceStore()
				.getBoolean("BOOLEAN_VALUE");
		MessageDialog.openInformation(shell, "Info", myPrefBoolean.toString());

		String choice = Activator.getDefault().getPreferenceStore()
				.getString("CHOICE");
		System.out.println(choice);
		
		String myPrefString = Activator.getDefault().getPreferenceStore()
				.getString("MySTRING1");
		MessageDialog.openInformation(shell, "Info", myPrefString);
		return null;
	}
}