package com.wcompany.mrwah.reservation_vol.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.wcompany.mrwah.reservation_vol.R;
import com.wcompany.mrwah.reservation_vol.models.Session;
public class SplashActivity extends AppCompatActivity {
    private ImageView logo;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo = findViewById(R.id.splash_logo);
        Animation splash_animation = AnimationUtils.loadAnimation(this, R.anim.spalsh_transition);
        logo.startAnimation(splash_animation);

        final Intent walk_through = new Intent(this, Walk_throughActivity.class);
        final Intent home = new Intent(this, MainActivity.class);

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    session = new Session(getApplicationContext());
                    switch (session.getType()) {
                        case "client": {
                            startActivity(home);
                            break;
                        }
                        default:

                            startActivity(walk_through);
                    }
                    finish();
                }
            }
        };
        timer.start();
    }
}
