package wahi.sarahdeepali.wics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sarahdeepali.staySecure.R;

/**
 * Created by nidhi on 7/23/2016.
 */
public class GradesFragment extends Fragment {

    WebView web;
    private static final String ARG_SECTION_NUMBER = "section_number";
    public GradesFragment() {
    }


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static GradesFragment newInstance(int sectionNumber) {
        GradesFragment fragment = new GradesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_webview, container, false);

        web = (WebView) rootView.findViewById(R.id.webView3);

        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        String pdf = "https://sis.powayusd.com/";
        web.loadUrl(pdf);
        return rootView;
    }
}
