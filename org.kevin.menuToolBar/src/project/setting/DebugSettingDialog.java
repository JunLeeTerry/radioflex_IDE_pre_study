package project.setting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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

public class DebugSettingDialog extends Dialog {
	private Text txtDebugToolPath;
	private Text txtDebugDevice;
	private Text txtscriptpath;
	private Text txtHardwareAddress;
	private String s1, s2, s3, s4;

	protected DebugSettingDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Debug Setting");
	}

	protected Control createDialogArea(Composite parent) {
		// TODO Auto-generated method stub
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout(1, false);
		layout.marginRight = 5;
		layout.marginLeft = 10;
		container.setLayout(layout);

		createDebugToolPath(container);
		createDebugDevice(container);
		createScriptpath(container);
		createHardwareAddress(container);

		return container;
	}

	private void createHardwareAddress(Composite container) {
		// TODO Auto-generated method stub
		Label lab1 = new Label(container, SWT.PUSH);
		lab1.setText("Hardware Address:");

		GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;

		txtHardwareAddress = new Text(container, SWT.BORDER);
		txtHardwareAddress.setLayoutData(data);

		Button b1 = new Button(container, SWT.PUSH);
		b1.setText("Browser");
		b1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Shell shell = getShell();
				txtHardwareAddress.setText(openDialogs(shell));
			}
		});
	}

	private void createScriptpath(Composite container) {
		// TODO Auto-generated method stub
		Label lab1 = new Label(container, SWT.PUSH);
		lab1.setText("scriptpath:");

		GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;

		txtscriptpath = new Text(container, SWT.BORDER);
		txtscriptpath.setLayoutData(data);

		Button b1 = new Button(container, SWT.PUSH);
		b1.setText("Browser");
		b1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Shell shell = getShell();
				txtscriptpath.setText(openDialogs(shell));
			}
		});
	}

	private void createDebugDevice(Composite container) {
		Label lab1 = new Label(container, SWT.PUSH);
		lab1.setText("DebugDevice:");

		GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;

		txtDebugDevice = new Text(container, SWT.BORDER);
		txtDebugDevice.setLayoutData(data);

		Button b1 = new Button(container, SWT.PUSH);
		b1.setText("Browser");
		b1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Shell shell = getShell();
				txtDebugToolPath.setText(openDialogs(shell));
			}
		});
	}

	protected void createDebugToolPath(Composite container) {
		Label lab1 = new Label(container, SWT.PUSH);
		lab1.setText("DebugToolPath:");

		GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;

		txtDebugToolPath = new Text(container, SWT.BORDER);
		txtDebugToolPath.setLayoutData(data);

		Button b1 = new Button(container, SWT.PUSH);
		b1.setText("Browser");
		b1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Shell shell = getShell();
				txtDebugToolPath.setText(openDialogs(shell));
			}
		});
	}

	protected Point getInitialSize() {
		return new Point(450, 500);
	}

	private void saveInput() {
		s1 = txtDebugToolPath.getText();
		s2 = txtDebugDevice.getText();
		s3 = txtscriptpath.getText();
		s4 = txtHardwareAddress.getText();
	}

	protected void okPressed() {

		saveInput();

		// create a file;
		File f = new File("C:\\Users\\kitkat\\Desktop\\1.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// write the file;
		FileWriter output = null;
		try {
			output = new FileWriter(f);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write(s1);
			writer.newLine();
			writer.write(s2);
			writer.newLine();
			writer.write(s3);
			writer.newLine();
			writer.write(s4);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		super.okPressed();
	}

	private String openDialogs(Shell shell) {
		// File standard dialog
		FileDialog fileDialog = new FileDialog(shell);
		// Set the text
		fileDialog.setText("Select File");
		// Set filter on .txt files
		fileDialog.setFilterExtensions(new String[] { "*.txt" });
		// Put in a readable name for the filter
		fileDialog.setFilterNames(new String[] { "Textfiles(*.txt)" });
		// Open Dialog and save result of selection
		String selected = fileDialog.open();
		// System.out.println(selected);
		return selected;
	}

}
