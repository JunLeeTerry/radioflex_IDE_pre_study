package org.kevin.preference;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.kevin.preference.Activator;

public class InitializeDefaultPreferences extends AbstractPreferenceInitializer {

	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault("BOOLEAN_VALUE", true);
		store.setDefault("CHOICE", "choice2");
		store.setDefault("MySTRING1","Default value");
	}

}
