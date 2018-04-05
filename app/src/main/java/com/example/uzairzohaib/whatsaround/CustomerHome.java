package com.example.uzairzohaib.whatsaround;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class CustomerHome extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           // FragmentManager fragmentManager = getSupportFragmentManager();
            //FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_search:
                    SearchFragment searchFragment = new SearchFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.contentLayout,
                            searchFragment, searchFragment.getTag()).commit();
                    return true;
                case R.id.navigation_booking:
                    BookingFragment bookingFragment = new BookingFragment();
                    FragmentManager manager2 = getFragmentManager();
                    manager2.beginTransaction().replace(R.id.contentLayout,
                            bookingFragment, bookingFragment.getTag()).commit();
                    return true;
                case R.id.navigation_profile:
                    ProfileFragment profileFragment = new ProfileFragment();
                    FragmentManager manager3 = getFragmentManager();
                    manager3.beginTransaction().replace(R.id.contentLayout,
                            profileFragment, profileFragment.getTag()).commit();
                    return true;


            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        BottomNavigationView navigation = findViewById(R.id.navigation);  // removed redundant cast
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        SearchFragment searchFragment = new SearchFragment();
//        FragmentManager manager = getFragmentManager();
//        manager.beginTransaction().replace(R.id.contentLayout,
//                searchFragment, searchFragment.getTag()).commit();
    }

}
