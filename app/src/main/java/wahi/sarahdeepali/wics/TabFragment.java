package wahi.sarahdeepali.wics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sarahdeepali.staySecure.R;

/**
 * Created by Ratan on 7/27/2015.
 */
public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 5 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
            View x =  inflater.inflate(R.layout.tab_layout,null);
            tabLayout = (TabLayout) x.findViewById(R.id.tabs);
            viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

       tabLayout.post(new Runnable() {
            @Override
            public void run() {
                    tabLayout.setupWithViewPager(viewPager);
                    //tabLayout.getTabAt(0).setIcon(R.drawable.home); //home
                    //tabLayout.getTabAt(1).setIcon(R.drawable.camera); //handbook
                    //tabLayout.getTabAt(2).setIcon(R.drawable.finishedphone); //schedule
                    //tabLayout.getTabAt(3).setIcon(R.drawable.exclamation); //map
                    //tabLayout.getTabAt(4).setIcon(R.drawable.exclamation); //calendar

                View view0 = getActivity().getLayoutInflater().inflate(R.layout.custom_tab, null);
                view0.findViewById(R.id.icon).setBackgroundResource(R.drawable.home);
                TextView text0 = (TextView)view0.findViewById(R.id.textIcon);
                text0.setGravity(Gravity.CENTER);
                text0.setText("Home");
                tabLayout.getTabAt(0).setCustomView(view0);

                View view1 = getActivity().getLayoutInflater().inflate(R.layout.custom_tab, null);
                view1.findViewById(R.id.icon).setBackgroundResource(R.drawable.handbook);
                TextView text1 = (TextView)view1.findViewById(R.id.textIcon);
                text1.setGravity(Gravity.CENTER);
                text1.setText("Handbook");
                tabLayout.getTabAt(1).setCustomView(view1);

                View view2 = getActivity().getLayoutInflater().inflate(R.layout.custom_tab, null);
                view2.findViewById(R.id.icon).setBackgroundResource(R.drawable.bellsched);
                TextView text2 = (TextView)view2.findViewById(R.id.textIcon);
                text2.setGravity(Gravity.CENTER);
                text2.setText("Schedule");
                tabLayout.getTabAt(2).setCustomView(view2);

                View view3 = getActivity().getLayoutInflater().inflate(R.layout.custom_tab, null);
                view3.findViewById(R.id.icon).setBackgroundResource(R.drawable.map);
                TextView text3 = (TextView)view3.findViewById(R.id.textIcon);
                text3.setGravity(Gravity.CENTER);
                text3.setText("Map");
                tabLayout.getTabAt(3).setCustomView(view3);

                View view4 = getActivity().getLayoutInflater().inflate(R.layout.custom_tab, null);
                view4.findViewById(R.id.icon).setBackgroundResource(R.drawable.calendar);
                TextView text4 = (TextView)view4.findViewById(R.id.textIcon);
                text4.setGravity(Gravity.CENTER);
                text4.setText("Calendar");
                tabLayout.getTabAt(4).setCustomView(view4);
            }
        });

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
          switch (position){
              case 0 : return new HomeFragment(); //home
              case 1 : return new HandbookFragment(); //handbook
              case 2 : return new BellScheduleFragment(); //schedule
              case 3 : return new MapFragment(); //map
              case 4 : return new CalendarFragment(); //calendar

          }
        return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

       /** @Override
        public CharSequence getPageTitle(int position) {
                return null;
        }*/

    }

}
