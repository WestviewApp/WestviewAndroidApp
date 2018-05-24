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
 * Created by WICS on 7/23/2016.
 */
public class MapFragment extends Fragment {


    WebView web;
    private static final String ARG_SECTION_NUMBER = "section_number";

        public MapFragment() {

        }


        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static MapFragment newInstance(int sectionNumber) {
            MapFragment fragment = new MapFragment();
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
            String pdf = "https://www.google.com/maps/d/viewer?mid=1UuI1sahr6xefo4F-uFgtxNIS_yw&ll=32.967204758073905%2C-117.1492184&z=17";
            //web.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
            web.loadUrl(pdf);
            return rootView;
        }



}
