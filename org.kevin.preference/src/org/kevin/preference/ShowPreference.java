package org.kevin.preference;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;


public class ShowPreference extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IPreferencePage page1 = new MyPreferencePage();
		page1.setTitle("Custom Configuration1");

		// create a new PreferenceNode that will appear in the Preference window
		PreferenceNode node1 = new PreferenceNode("1", page1);
		PreferenceManager pm = new PreferenceManager();
		pm.addToRoot(node1);
		
		IPreferencePage page2 = new MyPreferencePage();
		page2.setTitle("Custom Configuration2");
		PreferenceNode node2 = new PreferenceNode("2", page2);
		pm.addTo("1",node2);
		
		IPreferencePage page3 = new MyPreferencePage();
		page3.setTitle("Custom Configuration3");
		PreferenceNode node3 = new PreferenceNode("3", page3);
		pm.addTo("1.2", node3);

		Shell shell = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell();
		PreferenceDialog pd = new PreferenceDialog(shell, pm);//分層的page

		// it tell us the PreferenceDialog on what store to used
		pd.setPreferenceStore(Activator.getDefault()
				.getPreferenceStore());
		pd.create();
		pd.open();
		return 0;
	}

}
