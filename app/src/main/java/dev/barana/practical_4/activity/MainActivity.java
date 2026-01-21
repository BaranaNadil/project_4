package dev.barana.practical_4.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import dev.barana.practical_4.R;
import dev.barana.practical_4.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;

    private ViewPager2 viewpager2;

    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tablayout = findViewById(R.id.tabLayout);
        viewpager2 = findViewById(R.id.viewPager2);

        tablayout.addTab(tablayout.newTab().setText("Sign Up"));
        tablayout.addTab(tablayout.newTab().setText("Sign In"));

        FragmentManager fragmentManager = getSupportFragmentManager();

        System.out.println("Activity Created");

         adapter = new ViewPagerAdapter(fragmentManager, getLifecycle());

         viewpager2.setAdapter(adapter);


         tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {
                viewpager2.setCurrentItem(tab.getPosition());

             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {

             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {


             }
         });

         viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
             @Override
             public void onPageSelected(int position) {
                 System.out.println("Fragment Selected");
                 super.onPageSelected(position);
                 tablayout.selectTab(tablayout.getTabAt(position));
             }
         });


    }
}