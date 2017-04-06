package com.example.android.littlecups;

import android.content.ServiceConnection;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class SpinTheBottle extends AppCompatActivity {
    ImageView iv_Bottle;
    Button buttonGo;
    Random r;
    int angle;
    boolean restart = false;

    @Override
    public void unbindService(ServiceConnection conn) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin_the_bottle);
        iv_Bottle = (ImageView) findViewById(R.id.iv_bottle);
        buttonGo = (Button) findViewById(R.id.iv_buttongo);
        r = new Random();
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (restart) {
                    int aqngle = angle % 360;
                    angle = r.nextInt() + 360;
                    RotateAnimation rotateAnimation = new RotateAnimation(angle, 360
                            , RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setFillAfter(true);
                    rotateAnimation.setDuration(3600);
                    rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

                    iv_Bottle.startAnimation(rotateAnimation);
                    buttonGo.setText("GO");
                    restart = false;
                } else {
                    angle = r.nextInt(3600) + 360;
                    RotateAnimation rotateAnimation = new RotateAnimation(0, angle
                            , RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setFillAfter(true);
                    rotateAnimation.setDuration(3600);
                    rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

                    iv_Bottle.startAnimation(rotateAnimation);
                    restart = true;
                    buttonGo.setText("RESET");
                }
            }
        });
    }
}
