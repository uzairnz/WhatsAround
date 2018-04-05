package com.example.uzairzohaib.whatsaround;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class PartnerHome extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // FragmentManager fragmentManager = getSupportFragmentManager();
            //FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_NewLeads:
                    NewLeadsFragment newleadsFragment = new NewLeadsFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.contentLayout2,
                            newleadsFragment, newleadsFragment.getTag()).commit();
                    return true;
                case R.id.navigation_Ongoing:
                    OngoingFragment ongoingFragment = new  OngoingFragment();
                    FragmentManager manager2 = getFragmentManager();
                    manager2.beginTransaction().replace(R.id.contentLayout2,
                            ongoingFragment,  ongoingFragment.getTag()).commit();
                    return true;
                case R.id.navigation_p_profile:
                    P_ProfileFragment p_profileFragment = new P_ProfileFragment();
                    FragmentManager manager3 = getFragmentManager();
                    manager3.beginTransaction().replace(R.id.contentLayout2,
                            p_profileFragment, p_profileFragment.getTag()).commit();
                    return true;


            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_home);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
