package com.example.escape_room.Activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.escape_room.Fragment.HomeFragment;
import com.example.escape_room.Fragment.MapFragment;
import com.example.escape_room.Fragment.MypageFragment;
import com.example.escape_room.Fragment.SearchFragment;
import com.example.escape_room.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ContentsPagerAdapter mContentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setBackgroundColor(Color.parseColor("#000000"));
        mTabLayout.setTabTextColors(Color.parseColor("#FFFFFF"),Color.parseColor("#F08080"));

        mTabLayout.addTab((mTabLayout.newTab().setText("HOME")));
        mTabLayout.addTab((mTabLayout.newTab().setText("SEARCH")));
        mTabLayout.addTab((mTabLayout.newTab().setText("MAP")));
        mTabLayout.addTab((mTabLayout.newTab().setText("MYPAGE")));


        mViewPager = (ViewPager) findViewById(R.id.pager_content);
        mContentPagerAdapter = new ContentsPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(mContentPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    public class ContentsPagerAdapter extends FragmentStatePagerAdapter {
        private int mPageCount;


        public ContentsPagerAdapter(FragmentManager fm, int pageCount) {
            super(fm);
            this.mPageCount = pageCount;
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle(1); // 파라미터는 전달할 데이터 개수
            switch (position) {
                case 0:
                    HomeFragment homeFragment = new HomeFragment();
                    homeFragment.setArguments(bundle);
                    return homeFragment;

                case 1:
                    SearchFragment searchFragment = new SearchFragment();
                    searchFragment.setArguments(bundle);
                    return searchFragment;

                case 2:
                    MapFragment mapFragment = new MapFragment();
                    mapFragment.setArguments(bundle);
                    return mapFragment;

                case 3:
                    MypageFragment mypageFragment = new MypageFragment();
                    mypageFragment.setArguments(bundle);
                    return mypageFragment;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mPageCount;
        }
    }
}