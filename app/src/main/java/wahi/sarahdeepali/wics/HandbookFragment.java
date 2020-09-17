package wahi.sarahdeepali.wics;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.sarahdeepali.staySecure.R;

import static android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN;

/**
 * Created by WICS on 7/23/2016.
 */
public class HandbookFragment extends Fragment {


    WebView web;
    private static final String ARG_SECTION_NUMBER = "section_number";

        public HandbookFragment() {

        }


        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static HandbookFragment newInstance(int sectionNumber) {
            HandbookFragment fragment = new HandbookFragment();
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
            String pdf = "https://drive.google.com/file/d/1HYWJY2iWFNwr-ZGf0yU9HRyk9BNuvvVs/view?usp=sharing";
            //web.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
            web.loadUrl(pdf);
            return rootView;
        }



}
