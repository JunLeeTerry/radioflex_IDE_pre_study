package project.setting;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class BuildSettingDialog extends Dialog {
	
	private Text txtComplierToolPath;
	private Text ArchFilePathText;
	private String ArchFilePath;
	private String ComplierToolPath;
	private String Path;		
	private ArrayList<String> allpath = new ArrayList<String>();


	public BuildSettingDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}
	
	//set the dialog title;
	  protected void configureShell(Shell newShell) {
		    super.configureShell(newShell);
		    newShell.setText("Build Setting");
		  }

	@Override
	protected Control createDialogArea(Composite parent) {
	    Composite container = (Composite) super.createDialogArea(parent);
	    GridLayout layout = new GridLayout(1,false);
	    layout.marginRight = 5;
	    layout.marginLeft = 10;
	    container.setLayout(layout);
	    
	    //
	    createComplierToolPath(container);
	    createArchFilePath(container);
	    
	    //add a list
	    final List list = new List(container, SWT.BORDER);
	    GridData layout1 = new GridData();
	    layout1.grabExcessHorizontalSpace = true;
	    layout1.horizontalAlignment = GridData.FILL;
	    list.setLayoutData(layout1);
	   
	    	    
	    //create add button to get path;
	    Button b3 = new Button(container,SWT.PUSH);
	    b3.setText("Add");
	    b3.addSelectionListener(new SelectionAdapter() {
	        public void widgetSelected(SelectionEvent e) {
	            Shell shell = getShell();
	            Path = openDialogs(shell);
	            list.add(Path);
	            allpath.add(Path);
	            System.out.println(allpath);
	        }
	      });
	    
	    //create remove button;
	    Button b4 = new Button(container,SWT.PUSH);
	    b4.setText("Remove");
	    b4.addSelectionListener(new SelectionAdapter() {
	    	public void widgetSelected(SelectionEvent e) {
	         list.remove(list.getSelectionIndex());
	        }
	    	
		});
	    
	    
	    return container;
	    
	}
	 

	//create ComplierToolPath;
	  private void createComplierToolPath(Composite container) {
		    Label lbtComplierToolPath = new Label(container, SWT.NONE);
		    lbtComplierToolPath.setText("ComplierToolPath:");
		    
		    GridData dataComplierToolPath = new GridData();
		    dataComplierToolPath.grabExcessHorizontalSpace = true;
		    dataComplierToolPath.horizontalAlignment = GridData.FILL;
		    
		    txtComplierToolPath = new Text(container, SWT.BORDER);
		    txtComplierToolPath.setLayoutData(dataComplierToolPath);
		    
		    Button b1 = new Button(container, SWT.PUSH);
		    b1.setText("Browser");
		    b1.addSelectionListener(new SelectionAdapter() {
		        public void widgetSelected(SelectionEvent e) {
		            Shell shell = getShell();
		            txtComplierToolPath.setText(openDialogs(shell));
		        }
		      });
		  }

	//create ArchFilePath;
	  private void createArchFilePath(Composite container) {
		    Label lbtArchFilePath = new Label(container, SWT.NONE);
		    lbtArchFilePath.setText("ArchFilePath:");
		    
		    GridData dataArchFilePath = new GridData();
		    dataArchFilePath.grabExcessHorizontalSpace = true;
		    dataArchFilePath.horizontalAlignment = GridData.FILL;
		    
		    ArchFilePathText = new Text(container, SWT.BORDER);
		    ArchFilePathText.setLayoutData(dataArchFilePath);
		    
		    Button b2 = new Button(container, SWT.PUSH);
		    b2.setText("Browser");
		    b2.addSelectionListener(new SelectionAdapter() {
		        public void widgetSelected(SelectionEvent e) {
		            Shell shell = getShell();
		            ArchFilePathText.setText(openDialogs(shell));
		        }
		      });
		  }

	  
	  
	  

	protected boolean isResizable() {
		    return true;
		  }
	
	  protected Point getInitialSize() {
		    return new Point(450, 500);
		  }
	  
	  
	  
	  
	  private void saveInput() {
		  ComplierToolPath = txtComplierToolPath.getText();
		  ArchFilePath = ArchFilePathText.getText();
		  }

		
		@Override
		  protected void okPressed() {
		        
			  saveInput();
			  
			  //create a file;
			  File f = new File("C:\\Users\\kitkat\\Desktop\\1.txt");
			   	try {
				f.createNewFile();
			   	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   	}
			   
			  //write the file;
			    FileWriter output = null;
			    try {
			      output = new FileWriter(f);
			      BufferedWriter writer = new BufferedWriter(output);
			      writer.write(ComplierToolPath);
			      writer.newLine();
			      writer.write(ArchFilePath);
			      writer.newLine();
			      writer.write(allpath.toString());
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

			  
			  System.out.println(ArchFilePath);
			  System.out.println(ComplierToolPath);
			  System.out.println(allpath);

		    super.okPressed();
		  }

		  public String getComplierToolPath() {
		    return ComplierToolPath;
		  }

		  public String getArchFilePath() {
		    return ArchFilePath;
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
			    //System.out.println(selected);
			    return selected;
			    

/*			    // Directly standard selection
			    DirectoryDialog dirDialog = new DirectoryDialog(shell);
			    dirDialog.setText("Select your home directory");
			    String selectedDir = dirDialog.open();
			    System.out.println(selectedDir);

			    // Select Font
			    FontDialog fontDialog = new FontDialog(shell);
			    fontDialog.setText("Select your favorite font");
			    FontData selectedFont = fontDialog.open();
			    System.out.println(selectedFont);

			    // Select Color
			    ColorDialog colorDialog = new ColorDialog(shell);
			    colorDialog.setText("Select your favorite color");
			    RGB selectedColor = colorDialog.open();
			    System.out.println(selectedColor);

			    // Message
			    MessageBox messageDialog = new MessageBox(shell, SWT.ERROR);
			    messageDialog.setText("Evil Error has happend");
			    messageDialog.setMessage("This is fatal!!!");
			    int returnCode = messageDialog.open();
			    System.out.println(returnCode);

			    // Message with ok and cancel button and info icon
			    messageDialog = new MessageBox(shell, 
			        SWT.ICON_QUESTION | 
			        SWT.OK
			        | SWT.CANCEL);
			    messageDialog.setText("My info");
			    messageDialog.setMessage("Do you really want to do this.");
			    returnCode = messageDialog.open();
			    System.out.println(returnCode);
			    */
			  }

			} 

	  
	  



	
