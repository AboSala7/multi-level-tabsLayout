package multileveltablayouts.tutorial.multileveltablayouts;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import multileveltablayouts.tutorial.multileveltablayouts.fragments.FragmentFive;
import multileveltablayouts.tutorial.multileveltablayouts.fragments.FragmentFour;
import multileveltablayouts.tutorial.multileveltablayouts.fragments.FragmentOne;
import multileveltablayouts.tutorial.multileveltablayouts.fragments.FragmentSix;
import multileveltablayouts.tutorial.multileveltablayouts.fragments.FragmentThree;
import multileveltablayouts.tutorial.multileveltablayouts.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity {

   // private Toolbar toolbar;
    private TabLayout tabLayout , tabMain;
    private ViewPager viewPager ,viewPager2;
    private Button first ,secound ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        first =findViewById(R.id.button1);
        secound = findViewById(R.id.button2);
        viewPager =  findViewById(R.id.viewpager);
        setupFirstViewPager(viewPager);
        viewPager2 = findViewById(R.id.viewpager2);
        setupSecoundViewPager(viewPager2);
        tabLayout =  findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2.setVisibility(View.GONE);
                viewPager.setVisibility(View.VISIBLE);
                setupFirstViewPager(viewPager);
                tabLayout.setupWithViewPager(viewPager);
                first.setBackgroundResource(R.drawable.button_clicked);
                secound.setBackgroundResource(R.drawable.button_unclicked);
            }
        });
         secound.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 viewPager.setVisibility(View.GONE);
                 viewPager2.setVisibility(View.VISIBLE);
                 setupSecoundViewPager(viewPager2);
                 tabLayout.setupWithViewPager(viewPager2);
                 secound.setBackgroundResource(R.drawable.button_clicked);
                 first.setBackgroundResource(R.drawable.button_unclicked);

             }
         });
    }
    private void setupFirstViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "ONE");
        adapter.addFragment(new FragmentTwo(), "TWO");
        adapter.addFragment(new FragmentThree(), "THREE");
        viewPager.setAdapter(adapter);
    }
    private void setupSecoundViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentFour(), "Four");
        adapter.addFragment(new FragmentFive(), "Five");
        adapter.addFragment(new FragmentSix(), "six");
        viewPager.setAdapter(adapter);

    }



    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
