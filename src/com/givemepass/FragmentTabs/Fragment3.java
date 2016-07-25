package com.givemepass.FragmentTabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment3 extends Fragment {

	private static TextView TextForHelp;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_help, container, false);
		
		TextForHelp = (TextView) view.findViewById(R.id.text_help);
		TextForHelp.setText("Please hold your phone steadily, and then cover the camera lens completely with your fingertip.");
		
		return view;
	}
}