package com.edu.animationtest;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayoutSuperMarket = findViewById(R.id.constraintLayoutSuperMarket);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.aphal_animation);
        constraintLayoutSuperMarket.setAnimation(animation);

        CardView cardViewSuperMarketBar = findViewById(R.id.cardViewSuperMarketBar);


        Handler handler = new Handler();
        Runnable runnable = () -> {
            cardViewSuperMarketBar.getLayoutParams().width = cardViewSuperMarketBar.getWidth() + 5;
            cardViewSuperMarketBar.requestLayout();
        };
        Thread thread = new Thread(() -> {
            try {
                sleep(2000);
                do {
                    handler.post(runnable);
                    sleep(10);
                } while (cardViewSuperMarketBar.getWidth() < 400);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}