package com.dualDev.cvMaker.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.dualDev.cvMaker.R;
import com.dualDev.cvMaker.datamodel.Resume;
import com.dualDev.cvMaker.helper.Const;
import com.dualDev.cvMaker.helper.ResumeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrivacyFragment extends ResumeFragment {

  private WebView web;

  public static ResumeFragment newInstance(Resume resume) {
    ResumeFragment fragment = new PrivacyFragment();
    fragment.setResume(resume, Const.DELAY_PRIVACY_POLICY);
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view= inflater.inflate(R.layout.fragment_privacy, container, false);

    web =view.findViewById(R.id.webView);
    web.getSettings().setJavaScriptEnabled(true);
    web.loadUrl("file:///android_asset/privacy_policy.html");


    return view;
  }

}
