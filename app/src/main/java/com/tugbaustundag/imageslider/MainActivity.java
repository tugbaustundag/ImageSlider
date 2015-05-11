package com.tugbaustundag.imageslider;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import java.util.Arrays;
public class MainActivity extends ActionBarActivity {
    //Resimlerimizin  bulunduğu yolları IMAGES adlı dizide tutuyoruz...
    private static final String[] IMAGES = new String[] {
            "http://tugbaustundag.com/slider/Android_Developer_Days_Logo.png",
            "http://tugbaustundag.com/slider/cocuklar-icin-bilisim-zirvesi.jpg",
            "http://tugbaustundag.com/slider/indirmobil700.jpg",
          "http://tugbaustundag.com/slider/ux700.png"

    };

    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //ViewPager tanımladık..
        pager = (ViewPager) findViewById(R.id.pager);
        //Resimlermizi arayüzde göstermek için kullancagmız ScreenSlidePagerAdapter sınıfına resim, yollarnı set ettim.
        ScreenSlidePagerAdapter pagerAdapter =new ScreenSlidePagerAdapter(getSupportFragmentManager());

        pagerAdapter.addAll(Arrays.asList(IMAGES));
        pager.setAdapter(pagerAdapter);
        //Resmin altındaki kucuk yuvarlak iconları resim saysına göre üreten CirclePageIndicator sınıfını cagırdık
        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);
    }
    @Override
    public void onBackPressed() {
        if (pager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            pager.setCurrentItem(pager.getCurrentItem() - 1);
        }
    }
}
