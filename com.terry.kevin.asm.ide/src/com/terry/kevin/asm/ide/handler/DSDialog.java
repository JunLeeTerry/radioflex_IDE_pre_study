package com.terry.kevin.asm.ide.handler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.SelectionListenerAction;

public class DSDialog extends Dialog {
	private Text debugtoolpath;
	private Text debugdevice;
	private Text scriptpath;
	private Text hardwareaddress;
	private String debug_path;
	private String debug_device;
	private String script_path;
	private String hardware_add;
	private IWorkspaceRoot workspaceroot;

	protected DSDialog(Shell parentShell) {
		super(parentShell);
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Debug Setting");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 10;
		layout.marginWidth = 10;
		parent.setLayout(layout);

		createDebugToolPath(parent);
		createDebugDevice(parent);
		createScriptPath(parent);
		createHardAddress(parent);

		return super.createDialogArea(parent);
	}

	public void createDebugToolPath(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("DebugToolPath:");

		debugtoolpath = new Text(parent, SWT.BORDER);
		debugtoolpath
				.setLayoutData(new GridData(GridData.FILL, 0, true, false));

		Button button = new Button(parent, SWT.PUSH);
		button.setText("Bowser");
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = getShell();
				debug_path = openFileSystem(shell);
				debugtoolpath.setText(debug_path);
			}

		});

	}

	public void createDebugDevice(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("DebugDevice:");

		debugdevice = new Text(parent, SWT.BORDER);
		debugdevice.setLayoutData(new GridData(GridData.FILL, 0, true, false));

		Button button = new Button(parent, SWT.BORDER);
		button.setText("Bowser");
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = getShell();
				debug_device = openFileSystem(shell);
				debugdevice.setText(debug_device);
			}

		});
	}

	public void createScriptPath(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("ScriptPath");

		scriptpath = new Text(parent, SWT.BORDER);
		scriptpath.setLayoutData(new GridData(GridData.FILL, 0, true, false));

		Button button = new Button(parent, SWT.PUSH);
		button.setText("Bowser");
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				script_path = openFileSystem(shell);
				scriptpath.setText(script_path);
			}

		});
	}

	public void createHardAddress(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("Hardware Address:");

		hardwareaddress = new Text(parent, SWT.BORDER);
		hardwareaddress.setLayoutData(new GridData(GridData.FILL, 0, true,
				false));

		Button button = new Button(parent, SWT.PUSH);
		button.setText("Bowser");
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				hardware_add = openFileSystem(shell);
				hardwareaddress.setText(hardware_add);
			}

		});
	}

	protected Point getInitialSize() {
		return new Point(600, 455);
	}

	protected boolean isResizable() {
		return true;
	}

	public String openFileSystem(Shell shell) {
		FileDialog filedialog = new FileDialog(shell);
		filedialog.setText("Select File");
		String s = filedialog.open();
		return s;
	}

	protected void okPressed() {
		String root = Platform.getInstanceLocation().getURL().getPath();
		File debugconfiguration = new File(root + "debugconfiguration.xml");
		try {
			debugconfiguration.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileWriter fw = null;
		try {
			fw = new FileWriter(debugconfiguration);
			fw.write("<Debugconfiguration>\n" + debug_path + "\n"
					+ debug_device + "\n" + script_path + "\n" + hardware_add
					+ "\n</Debugconfiguration>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		super.okPressed();
	}
}
