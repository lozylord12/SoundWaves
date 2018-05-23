package com.ev.gone.fubiz.Views;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.ev.gone.fubiz.R;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

/**
 * Created by gone on 2/24/18.
 */

public class Loading  extends AppCompatActivity {


    private static int SLASH_TIME_OUT = 2500;

    ImageView image;
    Button rotateAboutCenterButton;


    RingProgressBar ringProgressBar1,ringProgressBar2;

    int progress = 0;

    Handler myHandler = new Handler(){


        @Override
        public void handleMessage(Message message){

            if(message.what == 0)
            {

                if(progress < 100)
                {
                    progress++;
                    ringProgressBar1.setProgress(progress);
                }

            }

        }


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);


        image = (ImageView) findViewById(R.id.floating_image);

        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_center);
        image.startAnimation(hyperspaceJumpAnimation);


        ringProgressBar1 = (RingProgressBar) findViewById(R.id.progress_bar_1);

//        ringProgressBar1.setOnProgressListener(new RingProgressBar.OnProgressListener() {
//            @Override
//            public void progressToComplete() {
//                Toast.makeText(Loading.this, "Fubiz", Toast.LENGTH_SHORT).show();
//            }
//        });

        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0; i<100; i++){

                    try{
                        Thread.sleep(20);
                        myHandler.sendEmptyMessage(0);

                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }
        }).start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(Loading.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SLASH_TIME_OUT);

    }


}
