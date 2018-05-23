package com.ev.gone.fubiz.Views;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ev.gone.fubiz.R;
import android.media.MediaPlayer;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountdownActivity extends AppCompatActivity {

    private long timeCountInMilliSeconds;
    private CountDownTimer countDownTimer;




    //extra classes
    private static class TimerStatus {
        private static final int STARTED = 188;
        private static final int STOPPED = 187;
    }

    @BindView(R.id.progressBarCircle)
    ProgressBar progressBarCircle;

    @BindView(R.id.textViewTime)
    TextView textViewTime;

    @BindView(R.id.buttonStartStop)
    Button buttonStartStop;

    @BindView(R.id.btnSetting)
    Button btnSetting;

    //Objects and variables
    int status = TimerStatus.STOPPED;
    ObjectAnimator smoothAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        ButterKnife.bind(this);

        //call to initialize the timer values
        setTimerValues();
        textViewTime.setText(hmsTimeFormatter(timeCountInMilliSeconds));


        buttonStartStop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountdownActivity.this, SettingCountdownActivity.class);
                startActivity(intent);

            }
        });
    }


    private void startStop() {

        if (status == TimerStatus.STOPPED) {
//            // call to initialize the timer values
//            setTimerValues();
            // call to initialize the progress bar values
            setProgressBarValues();
//            // changing the timer status to started
            status = TimerStatus.STARTED;
            // call to start the count down timer
            startCountDownTimer();
            buttonStartStop.setText("STOP");

        } else {
            // changing the timer status to stopped
            status = TimerStatus.STOPPED;
            stopCountDownTimer();
            buttonStartStop.setText("START");
        }

    }


    private void startCountDownTimer() {

        smoothAnimation = ObjectAnimator.ofInt(progressBarCircle, "progress", progressBarCircle.getProgress(), progressBarCircle.getMax());
        smoothAnimation.setDuration(500);
        smoothAnimation.setInterpolator(new AccelerateInterpolator());

        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTime.setText(hmsTimeFormatter(millisUntilFinished));
                progressBarCircle.setProgress((int) (timeCountInMilliSeconds / 10 - millisUntilFinished / 10));
            }

            @Override
            public void onFinish() {



                textViewTime.setText("Done");
                // call to initialize the progress bar values
                setProgressBarValues();
                // changing the timer status to stopped
                status = TimerStatus.STOPPED;

                Intent intent = getIntent();
                setResult(RESULT_OK,intent);
                finish();

                smoothAnimation.end();
                buttonStartStop.setText("START");


            }
        }.start();
        smoothAnimation.start();
        countDownTimer.start();
    }

    private void stopCountDownTimer() {
        countDownTimer.cancel();
        smoothAnimation.end();
    }

    private void setProgressBarValues() {
        progressBarCircle.setMax((int) (timeCountInMilliSeconds / 10));
        progressBarCircle.setProgress((int) (timeCountInMilliSeconds / 10));
        System.out.println("progres: " + (timeCountInMilliSeconds / 10));
    }

    private String hmsTimeFormatter(long milliSeconds) {
        String hms = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));
        return hms;
    }

    private void setTimerValues() {
        Intent intent = getIntent();
        // assigning values after converting to milliseconds
        timeCountInMilliSeconds = intent.getLongExtra("minutes", 15) * 60 * 1000;
    }
}
