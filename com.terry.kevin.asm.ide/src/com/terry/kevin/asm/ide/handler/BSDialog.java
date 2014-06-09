package com.terry.kevin.asm.ide.handler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;

public class BSDialog extends Dialog {
	private Text compilertoolpath;
	private Text archfilepath;
	private String compilerpath;
	private String archpath;
	private String path;
	private ArrayList<String> includeLibspath = new ArrayList<String>();

	protected BSDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Build Setting");
		
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout = new GridLayout(1,false);
		layout.marginHeight = 10;
		layout.marginWidth = 10;
		parent.setLayout(layout);

		createCompilerToolPath(parent);
		createArchFilePath(parent);
		createIncludeLibs(parent);

		return super.createDialogArea(parent);
	}

	public void createCompilerToolPath(Composite parent) {
		GridLayout layout1 = new GridLayout();

		// Label Compiler tool path----------------------
		Label label = new Label(parent, SWT.NONE);
		label.setText("CompilerToolPath:");

		// text to show path-------------------------------
		compilertoolpath = new Text(parent, SWT.BORDER);
		compilertoolpath.setLayoutData(new GridData(GridData.FILL, 0, true,
				false));
		

		// Browser button----------------------------------
		Button button1 = new Button(parent, SWT.PUSH);
		button1.setText("Browser");
		button1.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = getShell();
				compilerpath = openFileSystem(shell);
				compilertoolpath.setText(compilerpath);
			}

		});
	}

	public void createArchFilePath(Composite parent) {
		// Label ArchFilePath--------------------------------
		Label label = new Label(parent, SWT.NONE);
		label.setText("ArchFilePath:");

		// text to show path---------------------------------
		archfilepath = new Text(parent, SWT.BORDER);
		archfilepath.setLayoutData(new GridData(GridData.FILL, 0, true, false));

		// Browser button------------------------------------
		Button button2 = new Button(parent, SWT.PUSH);
		button2.setText("Browser");
		button2.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = getShell();
				archpath = openFileSystem(shell);
				archfilepath.setText(archpath);
			}

		});

	}
	public void createIncludeLibs(Composite parent){
		//Laybel----------------
		Label label = new Label(parent, SWT.NONE);
		label.setText("IncludeLibs:");
		
		//list----------------------------
		final List list = new List(parent, SWT.BORDER);
		list.setLayoutData(new GridData(GridData.FILL, 0, true, false)); 
		
		//button browser----------------------
		Button button1 = new Button(parent, SWT.PUSH);
		button1.setText("Add");
		button1.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = getShell();
				path = openFileSystem(shell);
				list.add(path);
				includeLibspath.add(path);
			}
			
		});
		
		Button button2 = new Button(parent, SWT.PUSH);
		button2.setText("Remove");
		button2.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				list.remove(list.getSelectionIndex());
			}
			
		});
	}

	@Override
	protected Point getInitialSize() {
		return new Point(600, 435);
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
		File debugconfiguration = new File(root + "buildconfiguration.xml");
		try {
			debugconfiguration.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileWriter fw = null;
		try {
			fw = new FileWriter(debugconfiguration);
			fw.write("<Debugconfiguration>\n" + compilerpath + "\n"
					+ archpath + "\n" + includeLibspath.toString()
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
		setReturnCode(OK);
		close();
	}
}
