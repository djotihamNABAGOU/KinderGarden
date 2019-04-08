package fr.etudes.kindergarden.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.etudes.kindergarden.R;
import fr.etudes.kindergarden.adapters.PagerAdapter;

public class ManagementActivity extends AppCompatActivity {
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);


        //get items from XML layout
        final ViewPager viewPager = (ViewPager) findViewById(R.id.myContainer);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.menu);


        //create 3 new tabs named "Cowboys", "Indians" and "All"
        //TabLayout cowboys = new TabLayout(getApplicationContext());
        tabLayout.addTab(tabLayout.newTab().setText("Cowboys"));
        tabLayout.addTab(tabLayout.newTab().setText("Indians"));
        tabLayout.addTab(tabLayout.newTab().setText("All"));

        //create a PagerAdapter for 3 tabs max
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        //adapt the viewPager with the adapter
        viewPager.setAdapter(pagerAdapter);
        //tabLayout.setupWithViewPager(viewPager);

        //listener on tab selected (set the current num tab in the viewPager)
        //tabLayout.setOnClickListener();
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setAdapter(pagerAdapter);
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        /*
        //get items from XML layout
        final ViewPager viewPager = findViewById(R.id.myContainer);
        TabLayout tabLayout = findViewById(R.id.menu);

        //create 3 new tabs named "Cowboys", "Indians" and "All"
        tabLayout.addTab(tabLayout.newTab().setText("Cowboys"));
        tabLayout.addTab(tabLayout.newTab().setText("Indians"));
        tabLayout.addTab(tabLayout.newTab().setText("All"));

        //create a PagerAdapter for 3 tabs max
        adapter = new PagerAdapter( getSupportFragmentManager(), tabLayout.getTabCount() );

        //adapt the viewPager with the adapter
        viewPager.setAdapter(adapter);

        //listener on tab selected (set the current num tab in the viewPager)
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setAdapter(adapter); //TODO: setAdapter only when Kindergarten's listview changed (make it obervable)
                viewPager.setCurrentItem( tab.getPosition() );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
        */
    }
}
