package wahi.sarahdeepali.wics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.ImageButton;
import android.widget.ImageView;

import com.sarahdeepali.staySecure.R;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.SimpleHtmlSerializer;
import org.htmlcleaner.TagNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import static android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN;

/**
 * Created by WICS on 7/23/2016.
 */
public class HomeFragment extends Fragment {


    private Button attendance;
    private Button grades;
    private Button canvas;
    private ImageView imageLoading;
    private WebView announcements;
        private static final String ARG_SECTION_NUMBER = "section_number";

        public HomeFragment() {

        }


        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static HomeFragment newInstance(int sectionNumber) {
            HomeFragment fragment = new HomeFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            View view = getActivity().getCurrentFocus();
            announcements = (WebView)rootView.findViewById(R.id.announcementsView);
            imageLoading = (ImageView) rootView.findViewById(R.id.loadingPicture);

            LoadContent("https://www.powayusd.com/en-US/Schools/HS/WVHS/home/Announcements");

            announcements.setVisibility(View.INVISIBLE);

            if(view != null)
            {
                InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            attendance = (Button) rootView.findViewById(R.id.attendanceButton);
            attendance.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    announcements.setVisibility(View.VISIBLE);
                    announcements.getSettings().setJavaScriptEnabled(true);
                    announcements.setWebViewClient(new WebViewClient());
                    String pdf = "https://www.powayusd.com/en-US/Schools/HS/WVHS/Contacts/Administrative-Departments/Attendance";
                    //web.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
                    announcements.loadUrl(pdf);

                }
            });

            grades = (Button) rootView.findViewById(R.id.gradesButton);
            grades.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    announcements.setVisibility(View.VISIBLE);
                    announcements.getSettings().setJavaScriptEnabled(true);
                    announcements.setWebViewClient(new WebViewClient());
                    String pdf = "https://sis.powayusd.com/";
                    announcements.loadUrl(pdf);
                }
            });

            canvas = (Button) rootView.findViewById(R.id.canvasButton);
            canvas.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    announcements.setVisibility(View.VISIBLE);
                    announcements.getSettings().setJavaScriptEnabled(true);
                    announcements.setWebViewClient(new WebViewClient());
                    String pdf = "https://poway.instructure.com/";
                    announcements.loadUrl(pdf);
                }
            });
            return rootView;
        }

    @SuppressLint({ "ParserError", "ParserError" })
    private void LoadContent(final String url)
    {
        imageLoading.setVisibility(View.VISIBLE);


        new Thread(new Runnable()
        {
            public void run()
            {
                final String newPage;
                final String modifiedPage;
                try
                {

                    Document doc = Jsoup.connect(url).get();
                    Elements newsRawTag = doc.select("div.newsItem");
                    newPage= " <style> @import url('https://fonts.googleapis.com/css?family=Roboto:400,500'); .newsItem p{font-family: 'Roboto', sans-serif; font-family: 400; font-size: 15px; color: #8F8E94;} .newsItem p strong a{font-weight: 500; font-size: 17px; color: #030303; text-decoration: none;} </style> "
                     + newsRawTag.html();
                    System.out.println(newPage);

                    modifiedPage = newPage.replaceAll("<a href=\"", "<a href=\"https://www.powayusd.com");
                    //System.out.println(modifiedPage);

                    getActivity().runOnUiThread(new Runnable()
                    {
                        public void run()
                        {
                            //System.out.println(newPage);

                            HtmlCleaner cleaner = new HtmlCleaner();
                            CleanerProperties props = cleaner.getProperties();
                            TagNode tagNode = new HtmlCleaner(props).clean(modifiedPage);
                            SimpleHtmlSerializer htmlSerializer =
                                    new SimpleHtmlSerializer(props);

                            announcements.loadDataWithBaseURL(null,htmlSerializer.
                                    getAsString(tagNode), "text/html", "charset=UTF-8",null);
                            announcements.setVisibility(View.VISIBLE);
                            imageLoading.setVisibility(View.GONE);



                        }
                    });

                }
                catch (IOException e) {

                }
                catch (NullPointerException e) {

                }

            }
        }).start();

    }


}
