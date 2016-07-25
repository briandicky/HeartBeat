package com.givemepass.FragmentTabs;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

	private static TextView text = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_history, container,
				false);
		text = (TextView) view.findViewById(R.id.TextOfRecord);

		database mydata = new database(getActivity());
		List<man> Lm = mydata.getAllmans();
		
		myapp.IndexOfDB = mydata.getLastId();
				
		Log.i("Testing", "the value of IndexOfDB = " + myapp.IndexOfDB);
		if (myapp.IndexOfDB == 0) {
			text.setText("Null data.\n");
		} else if (myapp.IndexOfDB == 1) {
			text.setText(Lm.get(0).getTime() + " " + Lm.get(0).getRate() + "\n");
		} else {
			text.setText(Lm.get(0).getTime() + "\t" + Lm.get(0).getRate()
					+ "\n");
			for (int i = 1; i < myapp.IndexOfDB; i++)
				text.append(Lm.get(i).getTime() + "\t" + Lm.get(i).getRate()
						+ "\n");
		}

		if (mydata != null)
			mydata.close();

		return view;
	}
}
