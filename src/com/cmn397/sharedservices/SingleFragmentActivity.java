package com.cmn397.sharedservices;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public abstract class SingleFragmentActivity extends Activity {
	
	abstract protected Fragment createFragment(int fragmentID);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_fragment_layout);
		
		FragmentManager fm = getFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.single_fragment_container);
		
		if (null == fragment) {
			fragment = createFragment(R.id.single_fragment_container);
			fm.beginTransaction()
				.add(R.id.single_fragment_container, fragment)
				.commit();
		}
	}
}
