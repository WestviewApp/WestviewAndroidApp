package wahi.sarahdeepali.wics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import com.sarahdeepali.staySecure.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by nidhi on 7/23/2016.
 */
public class CalendarFragment extends Fragment {

    WebView calendar;

    private static final String ARG_SECTION_NUMBER = "section_number";
    public CalendarFragment() {
    }


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static CalendarFragment newInstance(int sectionNumber) {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_webview, container, false);
        calendar = (WebView)rootView.findViewById(R.id.webView3);
        calendar.getSettings().setJavaScriptEnabled(true);
        calendar.setWebViewClient(new WebViewClient());
        String pdf = "https://calendar.google.com/calendar/embed?showTitle=0&showTabs=0&showCalendars=0&showPrint=0&src=westviewwolverines%40gmail.com&ctz=America/Los_Angeles";
        calendar.loadUrl(pdf);

        //LoadContent("https://www.powayusd.com/en-US/Schools/HS/WVHS/home/Announcements");
        return rootView;
    }

}
