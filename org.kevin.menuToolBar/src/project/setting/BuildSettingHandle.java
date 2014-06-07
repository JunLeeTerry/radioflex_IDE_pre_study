package project.setting;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class BuildSettingHandle extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		
		BuildSettingDialog dialog = new BuildSettingDialog(shell);
		if(dialog.open() == Window.OK){
			
		}
		return null;
	}

}
