package com.example.petsapp2;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {

    private WebViewFragmentInterface webViewFragmentInterface;

    public WebViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        webViewFragmentInterface = (WebViewFragmentInterface) context;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_web_view, container, false);

        Bundle bundle = getArguments();

        String name = bundle.getString("Name");

        WebView webView = (WebView) v.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/");

        return v;

    }

    public interface WebViewFragmentInterface{

    }

}
