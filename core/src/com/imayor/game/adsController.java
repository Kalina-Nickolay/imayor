package com.imayor.game;

/**
 * Created by Kalina on 09.12.2016.
 */

public interface adsController {
    public void showBannerAd();
    public void hideBannerAd();

    public void showInterstitialAd (Runnable then);
    public boolean isWifiConnected();

}
