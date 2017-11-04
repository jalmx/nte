package com.leyva.josef.nto.admob;

import android.app.Activity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.leyva.josef.nto.R;

/**
 * Created by josef on 11/4/17.
 */

public class AdMob {

    private final static String TAG = AdMob.class.getSimpleName();
    private AdView adView;
    private Activity context;

    public AdMob(Activity context) {
        this.context = context;
        MobileAds.initialize(context, context.getString(R.string.app_id));
        adView = context.findViewById(R.id.ad_view_main);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        adView.loadAd(adRequest);
    }

    public AdView getAdView() {
        return adView;
    }

    public AdView pauseAdMob() {
        if (adView != null) {
            adView.pause();
        } else {
            adView = new AdMob(context).getAdView();
        }
        return adView;
    }

    public AdView destroyAdMob() {
        if (adView != null) {
            adView.destroy();
        }
        return adView;
    }

    public AdView resumeAdMob() {
        if (adView != null) {
            adView.resume();
        } else {
            adView = new AdMob(context).getAdView();
        }
        return adView;
    }
}
