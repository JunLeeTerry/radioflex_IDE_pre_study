package org.kevin.preference;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class MyPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public MyPreferencePage() {
		/**
	     * Layout constant (value <code>1</code>) indicating that
	     * the field editors' basic controls are put into a grid layout.
	     */
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("A demonstration of a preference page implementation");
	}

	public void createFieldEditors() {
		addField(new DirectoryFieldEditor("PATH", "&Directory preference:",
				getFieldEditorParent()));//Returns a parent composite for a field editor
		addField(new BooleanFieldEditor("BOOLEAN_VALUE",
				"&An example of a boolean preference", getFieldEditorParent()));
		addField(new RadioGroupFieldEditor("CHOICE",
				"An example of a multiple-choice preference", 1,
				new String[][] { { "&Choice 1", "choice1" },//label and vlaue
						{ "C&hoice 2", "choice2" } }, getFieldEditorParent()));
		addField(new StringFieldEditor("MySTRING1", "A &text preference:",
				getFieldEditorParent()));
		addField(new StringFieldEditor("MySTRING2", "A &text preference:",
				getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {
		
	}
}