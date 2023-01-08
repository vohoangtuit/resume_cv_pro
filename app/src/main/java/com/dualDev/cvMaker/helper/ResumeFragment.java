package com.dualDev.cvMaker.helper;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dualDev.cvMaker.ClassAds;
import com.dualDev.cvMaker.R;
import com.dualDev.cvMaker.datamodel.Resume;
import com.dualDev.cvMaker.fragments.PrivacyFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


abstract public class ResumeFragment extends Fragment {

    public static final String ARGUMENT_RESUME = "resume_builder";
    public static final String ARGUMENT_DELAY_ADS = "delayAds";
    protected Handler handlerInterstitial;
    protected Handler handlerLoop;
    protected Runnable runnable;
    private long delayAds = 0;
    private ClassAds classAds;
    private InterstitialAd mInterstitialAd;


    public void setResume(Resume resume, long delayAds) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARGUMENT_RESUME, resume);
        bundle.putLong(ARGUMENT_DELAY_ADS, delayAds);
        setArguments(bundle);
    }

    public Resume getResume() {
        return getArguments().getParcelable(ARGUMENT_RESUME);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        classAds = new ClassAds();
        mInterstitialAd = new InterstitialAd(view.getContext());
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.admob_interstitial));

        if (getArguments() != null) {
            delayAds = getArguments().getLong(ARGUMENT_DELAY_ADS);
        }
        if (view.findViewById(R.id.adView) != null) {
            MobileAds.initialize(getContext(), getResources().getString(R.string.admob_app_id));
            AdView adView = view.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
        }

        handlerInterstitial = new Handler();
        handlerLoop = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                classAds.mobileAds(getContext(), mInterstitialAd);
                handlerLoop.postDelayed(this, delayAds * Const.LOOP_DELAY);
            }
        };
        if (!(ResumeFragment.this instanceof PrivacyFragment)) {
            handlerInterstitial.postDelayed(runnable, delayAds);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (runnable != null) {
            if (handlerInterstitial != null) {
                handlerInterstitial.removeCallbacks(runnable);
            }
            if (handlerLoop != null) {
                handlerLoop.removeCallbacks(runnable);
            }
        }
    }
}
