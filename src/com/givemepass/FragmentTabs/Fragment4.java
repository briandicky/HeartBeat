package com.givemepass.FragmentTabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment4 extends Fragment {
	
	private static TextView vince;
	private static TextView tsai;
	private static TextView mos;
	private static TextView right;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_about, container, false);
		
		vince = (TextView) view.findViewById(R.id.detail_vince);
		tsai = (TextView) view.findViewById(R.id.detail_tsai);
		mos = (TextView) view.findViewById(R.id.detail_mos);
		right = (TextView) view.findViewById(R.id.all_right);
		
		vince.setText("National Sun Yat-sen University\n"+ "Computer Science & Engineering\n" + "Vince M. S. Chiang");
		tsai.setText("National Sun Yat-sen University\n"+ "Computer Science & Engineering\n" + "Alan C. L. Tsai");
		mos.setText("National Sun Yat-sen University\n"+ "Computer Science & Engineering\n" + "Brian W. C. Lo");
		right.setText("Copyright © 2014 V.A.B.   All rights reserved" );
		
		return view;
	}
}