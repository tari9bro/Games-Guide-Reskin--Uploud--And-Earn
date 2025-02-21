package com.devio.BrawlStarstutorials.Ads;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import com.devio.BrawlStarstutorials.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class myAds {


    public static AdView mAdView;
    public static InterstitialAd mInterstitialAd;


    public static void loadBanner(Activity activity) {
        AdView mAdView = activity.findViewById(R.id.adView);
        AdRequest bannerequest = new AdRequest.Builder().build();
        mAdView.loadAd(bannerequest);
    }

    public static void loadIntertesial(Context context, Activity activity) {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(context, activity.getString(R.string.Interstitial_id), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                    }
                });
    }

    public static void playintertisialad(Context context, Activity activity) {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(activity);
        } else {
            loadIntertesial(context, activity);
        }
    }


}
