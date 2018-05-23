package com.ev.gone.fubiz.Manager;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ev.gone.fubiz.R;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class Rotate extends AppCompatActivity {

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
//                    ringProgressBar2.setProgress(progress);
                }

            }

        }


    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);


        image = (ImageView) findViewById(R.id.floating_image);

        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_center);
        image.startAnimation(hyperspaceJumpAnimation);

//        image = (ImageView) findViewById(R.id.floating_image);
//
//
//        // Setup things so that when this button is clicked the image rotates about it's center.
//        rotateAboutCenterButton = (Button) findViewById(R.id.rotate_center_button);
//
//
//
////        var rotateAboutCenterAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_center);
//
////        rotateAboutCenterButton.onClick += (sender, args) => image.StartAnimation(rotateAboutCenterAnimation);
//
//        rotateAboutCenterButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view){
//
//               image.animate().rotation(image.getRotation()-360).start();
//
//            }
//
//        });




        ringProgressBar1 = (RingProgressBar) findViewById(R.id.progress_bar_1);
//        ringProgressBar2 = (RingProgressBar) findViewById(R.id.progress_bar_2);


        ringProgressBar1.setOnProgressListener(new RingProgressBar.OnProgressListener() {
            @Override
            public void progressToComplete() {
                Toast.makeText(Rotate.this, "Complete", Toast.LENGTH_SHORT).show();
            }
        });

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


    }
}
