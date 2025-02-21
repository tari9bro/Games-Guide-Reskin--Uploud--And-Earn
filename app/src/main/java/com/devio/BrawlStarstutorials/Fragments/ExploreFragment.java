package com.devio.BrawlStarstutorials.Fragments;


import static com.devio.BrawlStarstutorials.Ads.myAds.playintertisialad;
import static com.devio.BrawlStarstutorials.Fragments.SettingsFragment.exittheapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.devio.BrawlStarstutorials.R;

import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment {
    public WebView webView;
    ImageView backbtn, forwardbtn, pausebtn, homebtn;

    public ExploreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homeview = inflater.inflate(R.layout.fragment_explore, container, false);
        ExploreFragment explorefragment = new ExploreFragment();
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main, explorefragment);
        webView = homeview.findViewById(R.id.include).findViewById(R.id.mywebview);
        creatwebvie();

        loadurl(R.string.link1);


        //  webView.loadDataWithBaseURL(getString(R.string.link),getString(R.string.link) , "text/html", "UTF-8", null);
        //  webView.loadData(getString(R.string.link),"text/html", "UTF-8");
        // webView.loadUrl(getString(R.string.link1));
        backbtn = homeview.findViewById(R.id.backbtn);
        homebtn = homeview.findViewById(R.id.homebtn);
        pausebtn = homeview.findViewById(R.id.pausebtn);
        forwardbtn = homeview.findViewById(R.id.forwardbtn);
        forwardbtn.setOnClickListener(v -> goforward());
        backbtn.setOnClickListener(v -> onBackPressed());
        homebtn.setOnClickListener(v -> webView.loadUrl(getString(R.string.link1)));
        pausebtn.setOnClickListener(v -> webView.stopLoading());
        setHasOptionsMenu(true);
        return homeview;
    }

    public void loadurl(int link) {
        String  str = "<meta content=\"width=device-width, initial-scale=1, user-scalable=no\" name=\"viewport\" /><link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/main.css\" /><link href=\"assets/css/noscript.css\" rel=\"stylesheet\" />" + getString(link);
        webView.loadDataWithBaseURL(null, str, "text/html", "UTF-8",null);
    }


    @SuppressLint("SetJavaScriptEnabled")
    private void creatwebvie() {
        WebSettings settings = webView.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        webView.setWebViewClient(new Callback());
    }


    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
            playintertisialad(this.getContext(), this.getActivity());
        } else {
            exittheapp(this.getActivity(), this.getContext());
        }
    }

    private void goforward() {
        if (webView != null && webView.canGoForward()) {
            webView.goForward();
        }
    }

    public WebView getwebview() {
        return webView;
    }

    private class Callback extends WebViewClient {

    }


}
