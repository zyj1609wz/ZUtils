package com.zyj.app;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.zyj.app.adapter.TabAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {

    private TabLayout tabLayOut ;
    private ViewPager viewPager ;
    private TabAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabLayOut = (TabLayout) findViewById( R.id.tabLayOut );
        viewPager = (ViewPager) findViewById( R.id.viewPager );

        tabLayOut.addTab(tabLayOut.newTab().setText("feed"));
        tabLayOut.addTab(tabLayOut.newTab().setText("chat"));
        tabLayOut.addTab(tabLayOut.newTab().setText("setting"));

        List<Fragment> list = new ArrayList<>() ;
        list.add(  ContainFragment.newInstance( "aa" , "fragment1" ) ) ;
        list.add( ContainFragment.newInstance( "aa" , "fragment2" ) ) ;
        list.add( ContainFragment.newInstance( "aa" , "fragment3" ) ) ;

        adapter = new TabAdapter( getSupportFragmentManager() , list ) ;

        viewPager.setAdapter( adapter );

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int state = ViewPager.SCROLL_STATE_DRAGGING;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabLayOut.setScrollPosition(position, positionOffset, ViewPager.SCROLL_STATE_DRAGGING == state);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                this.state = state;
            }
        });

        tabLayOut.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
