package com.example.android.habittracker;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;



public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FragmentTransaction fragmentTransaction;
    private static final String TAG = "myLog";
    private BottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  View bottomSheet = findViewById(R.id.bottom_sheet);
       // mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        final FilterFragment filterFragment = new FilterFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerBottomSheet, filterFragment)
                .commit();
        NavigationView navigationView = findViewById((R.id.nav_view));
        navigationView.setNavigationItemSelectedListener(this);
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment;
        switch (id) {
            case R.id.nav_info:
                fragment = new DescriptionFragment();
                fragmentTransaction = getSupportFragmentManager()
                        .beginTransaction();
                fragmentTransaction.add(R.id.container, fragment);
                Log.d(TAG, "в контейнер добавлен infoFragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.nav_screen:
                fragment = new RecycleFragment();
                fragmentTransaction = getSupportFragmentManager()
                        .beginTransaction();
                fragmentTransaction.add(R.id.pager, fragment);
                Log.d(TAG, "в ViewPager добавлен RecycleFragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
        DrawerLayout drawerLayout = findViewById((R.id.drawer_layout));
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById((R.id.drawer_layout));
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Log.d(TAG, "MainActivity 89");
                    return RecycleFragment.newInstance(true);
                case 1:
                    return RecycleFragment.newInstance(false);
            }
            return null;
        }
    }
}
//<androidx.core.widget.NestedScrollView
//        android:id="@+id/bottom_sheet"
//        android:layout_width="match_parent"
//        android:layout_height="350dp"
//        android:background="@android:color/holo_orange_light"
//        android:clipToPadding="true"
//        app:layout_behavior="com.google.android.material.bottomsheet.BottomSheetBehavior">
//
//<TextView
//                android:layout_width="match_parent"
//                        android:layout_height="match_parent"
//                        android:paddingTop="16dp"
//                        android:text="@string/bottom_sheets"
//                        android:textSize="16sp" />
//</androidx.core.widget.NestedScrollView>

//<include layout="@layout/fragment_filter" />