package com.givemepass.FragmentTabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;


public class Fragment1 extends Fragment {
	private static TextView text = null;
    public static int result;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = inflater.inflate(R.layout.activity_measure, container, false);
		
		Button button = (Button) view.findViewById(R.id.start_test);
		button.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(getActivity(), HeartRateMonitor.class);
				getActivity().startActivity(intent);
			} 
		});

		text = (TextView) view.findViewById(R.id.text_measure);
		text.setText(String.valueOf(Fragment1.result));
//		 Log.i("test",  "######Fragment1.result="+ Fragment1.result);	
		return view;
	}
	
    @Override
    public void onResume() {
        super.onResume();

		text.setText(String.valueOf(Fragment1.result));
		text.setTextColor(android.graphics.Color.BLUE);
//		Log.i("test",  "######Fragment1.result="+ Fragment1.result);	
    }


}