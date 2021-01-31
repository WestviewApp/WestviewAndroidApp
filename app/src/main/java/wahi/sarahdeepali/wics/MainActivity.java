package wahi.sarahdeepali.wics;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.sarahdeepali.staySecure.R;

public class MainActivity extends AppCompatActivity{
    DrawerLayout mDL;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDL = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation) ;
       
        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

             mFragmentManager = getSupportFragmentManager();
             mFragmentTransaction = mFragmentManager.beginTransaction();
             mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();

            mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(MenuItem menuItem) {
                 int id = menuItem.getItemId();
                 if(id == R.id.nav_fragment_home)
                 {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
                 }


                 mDL.closeDrawers();


                 return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

                android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
                ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDL, toolbar,R.string.app_name,
                R.string.app_name);

                mDL.setDrawerListener(mDrawerToggle);

                mDrawerToggle.syncState();

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onBackPressed(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
    }
}