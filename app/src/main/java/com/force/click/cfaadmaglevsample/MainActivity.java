package com.force.click.cfaadmaglevsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.clickforce.ad.AdMaglev;
import com.clickforce.ad.Listener.AdMaglevListener;

public class MainActivity extends AppCompatActivity {
    private AdMaglev adMaglev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adMaglev = new AdMaglev(this);
        adMaglev.init(this);
        adMaglev.getAdMaglev(9800);
        adMaglev.outputDebugInfo = true;
        adMaglev.setOnAdMaglevListener(new AdMaglevListener() {
            @Override
            public void onSuccessToAdMaglev() {
                Log.d("Clickforce","onSuccessToAdMaglev");
                adMaglev.show();
            }

            @Override
            public void onFailToAdMaglev() {
                Log.d("Clickforce","onFailToAdMaglev");
            }

            @Override
            public void onClickToAdMaglev() {
                Log.d("Clickforce","onClickToAdMaglev");
            }

            @Override
            public void onCloseToAdMaglev() {
                Log.d("Clickforce","onCloseToAdMaglev");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adMaglev != null)
            adMaglev.releaseAd();
    }
}
