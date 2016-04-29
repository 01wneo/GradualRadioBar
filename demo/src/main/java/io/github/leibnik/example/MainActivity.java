package io.github.leibnik.example;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.github.leibnik.gradualradiobar.GradualRadioGroup;
import io.github.leibnik.example.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private GradualRadioGroup gradualRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        gradualRadioGroup = (GradualRadioGroup) findViewById(R.id.radiobar);
        List<DemoFragment> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            DemoFragment fragment = new DemoFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type",i);
            fragment.setArguments(bundle);
            list.add(fragment);
        }
        viewPager.setAdapter(new DemoPagerAdapter(getSupportFragmentManager(), list));
        viewPager.addOnPageChangeListener(gradualRadioGroup);
        gradualRadioGroup.setOnRadioButtonClickListener(new GradualRadioGroup.OnRadioButtonClickListener() {
            @Override
            public void updateViewPager(int position) {
                viewPager.setCurrentItem(position,false);
            }
        });
    }

    class DemoPagerAdapter extends FragmentPagerAdapter {
        List<DemoFragment> mData;

        public DemoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public DemoPagerAdapter(FragmentManager fm, List<DemoFragment> data) {
            super(fm);
            mData = data;
        }

        @Override
        public Fragment getItem(int position) {
            return mData.get(position);
        }

        @Override
        public int getCount() {
            return mData.size();
        }
    }
}
