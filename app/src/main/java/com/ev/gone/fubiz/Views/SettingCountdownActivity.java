package com.ev.gone.fubiz.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ev.gone.fubiz.R;

import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingCountdownActivity extends AppCompatActivity {

    @BindView(R.id.btnOK)
    Button btnOK;

    @BindView(R.id.npHours)
    NumberPicker npHours = null;

    @BindView(R.id.npMinutes)
    NumberPicker npMinutes = null;

    Button back_to_alpha_main;



    private long minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_countdown);
        ButterKnife.bind(this);

//Set values picker hours
        npHours.setMaxValue(12);
        npHours.setMinValue(0);
        npHours.setWrapSelectorWheel(false);


//Set values picker minutes
        npMinutes.setMaxValue(60);
        npMinutes.setMinValue(0);
        npMinutes.setWrapSelectorWheel(false);


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingCountdownActivity.this, AlphaActivity.class);
                try {

                    minutes = npHours.getValue() * 60 + npMinutes.getValue();
                    intent.putExtra("minutes", minutes);
                    startActivity(intent);
                    finish();
                } catch (Exception ex) {
                    Toast.makeText(SettingCountdownActivity.this, "Please input here a minutes", Toast.LENGTH_SHORT).show();
                }
            }
        });


        back_to_alpha_main = (Button) findViewById(R.id.back_to_alpha_main);
        back_to_alpha_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent redirect_one = new Intent(SettingCountdownActivity.this, AlphaActivity.class);
                startActivity(redirect_one);


            }
        });

    }
}
