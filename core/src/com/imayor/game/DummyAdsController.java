package com.imayor.game;

/**
 * Created by Kalina on 09.12.2016.
 */
public class DummyAdsController implements adsController {
    @Override
    public void showBannerAd() {

    }

    @Override
    public void hideBannerAd() {

    }

    @Override
    public void showInterstitialAd(Runnable then) {

    }

    @Override
    public boolean isWifiConnected() {
        return false;
    }
}
