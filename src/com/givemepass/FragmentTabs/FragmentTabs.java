package com.givemepass.FragmentTabs;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

/**
 * This demonstrates how you can implement switching between the tabs of a
 * TabHost through fragments.  It uses a trick (see the code below) to allow
 * the tabs to switch between fragments instead of simple views.
 */
public class FragmentTabs extends FragmentActivity {
    private TabHost mTabHost;
    private TabManager mTabManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.fragment_tabs);
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        mTabManager = new TabManager(this, mTabHost, R.id.realtabcontent);
        
        mTabHost.setCurrentTab(0);

        TextView x;
        
        mTabManager.addTab(mTabHost.newTabSpec("Fragment1").setIndicator("Measure", null),Fragment1.class, null);
        
        x = (TextView) mTabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        x.setTextSize(20);
        
        mTabManager.addTab(mTabHost.newTabSpec("Fragment2").setIndicator("History",null),Fragment2.class, null);
        x = (TextView) mTabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
        x.setTextSize(20);
        
        mTabManager.addTab(mTabHost.newTabSpec("Fragment3").setIndicator("Help",null),Fragment3.class, null);
        x = (TextView) mTabHost.getTabWidget().getChildAt(2).findViewById(android.R.id.title);
        x.setTextSize(22);
        
        mTabManager.addTab(mTabHost.newTabSpec("Fragment4").setIndicator("AboutUs",null),Fragment4.class, null);
        x = (TextView) mTabHost.getTabWidget().getChildAt(3).findViewById(android.R.id.title);
        x.setTextSize(20);
        
		   
        DisplayMetrics dm = new DisplayMetrics();   
        getWindowManager().getDefaultDisplay().getMetrics(dm); //先取得螢幕解析度  
        int screenWidth = dm.widthPixels;   //取得螢幕的寬
           
           
        TabWidget tabWidget = mTabHost.getTabWidget();   //取得tab的物件
        int count = tabWidget.getChildCount();   //取得tab的分頁有幾個
      
            for (int i = 0; i < count; i++) {   
                tabWidget.getChildTabViewAt(i).setMinimumWidth( ( (screenWidth) / 4) + 6 );//設定每一個分頁最小的寬度  
            }   
            
    }
    
    @Override
    public void onResume() {
        super.onResume();

        myapp myapp= (myapp)getApplicationContext();
//      Log.i("test",  "myapp.result="+ myapp.result);	
        Fragment1.result =myapp.result;
//      Log.i("test",  "Fragment1.result="+ Fragment1.result);	
    }

}