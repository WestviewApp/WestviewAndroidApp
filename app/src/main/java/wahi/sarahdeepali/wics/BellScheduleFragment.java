package wahi.sarahdeepali.wics;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.sarahdeepali.staySecure.R;

import java.util.Calendar;

/**
 * Created by nidhi on 7/23/2016.
 */
public class BellScheduleFragment extends Fragment {

    //ImageView schedule;
    Button monday;
    Button tuesday;
    Button wednesday;
    Button thursday;
    Button friday;
    ImageView schedule;
    private static final String ARG_SECTION_NUMBER = "section_number";
    public BellScheduleFragment() {
    }


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static BellScheduleFragment newInstance(int sectionNumber) {
        BellScheduleFragment fragment = new BellScheduleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_bellschedule, container, false);
        schedule = (ImageView) rootView.findViewById(R.id.scheduleImage);

        monday = (Button) rootView.findViewById(R.id.monButton);
        monday.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                schedule.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.monfrisched));
                //schedule.setBackgroundResource(R.drawable.wedsched);
                monday.setTextColor(Color.parseColor("#4d79ff"));
                tuesday.setTextColor(Color.parseColor("#000000"));
                wednesday.setTextColor(Color.parseColor("#000000"));
                thursday.setTextColor(Color.parseColor("#000000"));
                friday.setTextColor(Color.parseColor("#000000"));
            }
        });

        tuesday = (Button) rootView.findViewById(R.id.tueButton);
        tuesday.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                schedule.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.tuesthurssched));
                monday.setTextColor(Color.parseColor("#000000"));
                tuesday.setTextColor(Color.parseColor("#4d79ff"));
                wednesday.setTextColor(Color.parseColor("#000000"));
                thursday.setTextColor(Color.parseColor("#000000"));
                friday.setTextColor(Color.parseColor("#000000"));

            }
        });

        wednesday = (Button) rootView.findViewById(R.id.wedButton);
        wednesday.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                schedule.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.wedschedfin));
                monday.setTextColor(Color.parseColor("#000000"));
                tuesday.setTextColor(Color.parseColor("#000000"));
                wednesday.setTextColor(Color.parseColor("#4d79ff"));
                thursday.setTextColor(Color.parseColor("#000000"));
                friday.setTextColor(Color.parseColor("#000000"));
            }
        });

        thursday = (Button) rootView.findViewById(R.id.thursButton);
        thursday.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                schedule.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.tuesthurssched));
                monday.setTextColor(Color.parseColor("#000000"));
                tuesday.setTextColor(Color.parseColor("#000000"));
                wednesday.setTextColor(Color.parseColor("#000000"));
                thursday.setTextColor(Color.parseColor("#4d79ff"));
                friday.setTextColor(Color.parseColor("#000000"));

            }
        });

        friday = (Button) rootView.findViewById(R.id.friButton);
        friday.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                schedule.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.monfrisched));
                monday.setTextColor(Color.parseColor("#000000"));
                tuesday.setTextColor(Color.parseColor("#000000"));
                wednesday.setTextColor(Color.parseColor("#000000"));
                thursday.setTextColor(Color.parseColor("#000000"));
                friday.setTextColor(Color.parseColor("#4d79ff"));
            }
        });


        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("DAY-------------------------------------" + day);
        System.out.println("CALENDAR.THURS------------------" + Calendar.THURSDAY);
        switch (day) {
            case Calendar.SUNDAY: {
                schedule.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.monfrisched));
                monday.setTextColor(Color.parseColor("#4d79ff"));
                tuesday.setTextColor(Color.parseColor("#000000"));
                wednesday.setTextColor(Color.parseColor("#000000"));
                thursday.setTextColor(Color.parseColor("#000000"));
                friday.setTextColor(Color.parseColor("#000000"));
                break;
            }
            case Calendar.MONDAY: {
                schedule.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.monfrisched));
                monday.setTextColor(Color.parseColor("#4d79ff"));
                tuesday.setTextColor(Color.parseColor("#000000"));
                wednesday.setTextColor(Color.parseColor("#000000"));
                thursday.setTextColor(Color.parseColor("#000000"));
                friday.setTextColor(Color.parseColor("#000000"));
                break;
            }
            case Calendar.TUESDAY: {
                schedule.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.tuesthurssched));
                monday.setTextColor(Color.parseColor("#000000"));
                tuesday.setTextColor(Color.parseColor("#4d79ff"));
                wednesday.setTextColor(Color.parseColor("#000000"));
                thursday.setTextColor(Color.parseColor("#000000"));
                friday.setTextColor(Color.parseColor("#000000"));
                break;
            }
            case Calendar.WEDNESDAY: {
                schedule.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.wedschedfin));
                monday.setTextColor(Color.parseColor("#000000"));
                tuesday.setTextColor(Color.parseColor("#000000"));
                wednesday.setTextColor(Color.parseColor("#4d79ff"));
                thursday.setTextColor(Color.parseColor("#000000"));
                friday.setTextColor(Color.parseColor("#000000"));
                break;
            }
            case Calendar.THURSDAY: {
                System.out.println("REACHED HERE!! ITS THURSDAY");
                schedule.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.tuesthurssched));
                monday.setTextColor(Color.parseColor("#000000"));
                tuesday.setTextColor(Color.parseColor("#000000"));
                wednesday.setTextColor(Color.parseColor("#000000"));
                thursday.setTextColor(Color.parseColor("#4d79ff"));
                friday.setTextColor(Color.parseColor("#000000"));
                break;
            }
            case Calendar.FRIDAY: {
                schedule.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.monfrisched));
                System.out.println("REACHED HERE!! ITS FRIDAY");
                monday.setTextColor(Color.parseColor("#000000"));
                tuesday.setTextColor(Color.parseColor("#000000"));
                wednesday.setTextColor(Color.parseColor("#000000"));
                thursday.setTextColor(Color.parseColor("#000000"));
                friday.setTextColor(Color.parseColor("#4d79ff"));
                break;
            }
            case Calendar.SATURDAY: {
                schedule.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.monfrisched));
                monday.setTextColor(Color.parseColor("#000000"));
                tuesday.setTextColor(Color.parseColor("#000000"));
                wednesday.setTextColor(Color.parseColor("#000000"));
                thursday.setTextColor(Color.parseColor("#000000"));
                friday.setTextColor(Color.parseColor("#4d79ff"));
                break;
            }
            default:
                break;

        }


        return rootView;
    }

}
