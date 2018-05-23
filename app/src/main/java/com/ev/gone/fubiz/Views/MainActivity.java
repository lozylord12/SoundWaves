package com.ev.gone.fubiz.Views;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ev.gone.fubiz.R;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MainActivity extends AppCompatActivity{

    CircleMenu circleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_play_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We normally won't show the welcome slider again in real app
                // but this is for testing
                LaunchManager LaunchManager = new LaunchManager(getApplicationContext());
                // make first time launch TRUE
                LaunchManager.setFirstTimeLaunch(true);
                startActivity(new Intent(MainActivity.this, SliderActivity.class));
                finish();
            }
        });

        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);


        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.icon_menu, R.mipmap.icon_cancel);

        circleMenu.addSubMenu(Color.parseColor("#C27DF3"), R.mipmap.omega)
                .addSubMenu(Color.parseColor("#9DFCF7"), R.mipmap.alpha)
                .addSubMenu(Color.parseColor("#FF885D"), R.mipmap.delta)
                .addSubMenu(Color.parseColor("#FFD088"), R.mipmap.gamma)
                .addSubMenu(Color.parseColor("#CDB7A0"), R.drawable.betal_thirs)
                .addSubMenu(Color.parseColor("#88C0FF"), R.mipmap.theta);


        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

                                                 @Override
                                                 public void onMenuSelected(int index) {
                                                     switch (index) {
                                                         case 0:
                                                             Toast.makeText(MainActivity.this, "xxx button Clicked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 1:
                                                             Intent redirectAlpha = new Intent(MainActivity.this, AlphaActivity.class);
                                                             startActivity(redirectAlpha);
                                                             break;
                                                         case 2:
                                                             Toast.makeText(MainActivity.this, "Notify button Clciked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 3:
                                                             Toast.makeText(MainActivity.this, "Settings button Clcked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 4:
                                                             Toast.makeText(MainActivity.this, "GPS button Clicked", Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case 5:
                                                             Intent redirect = new Intent(MainActivity.this, AlphaActivity.class);
                                                             startActivity(redirect);
                                                             break;

                                                     }
                                                 }
                                             }

        );
//
//        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {
//
//                                                     @Override
//                                                     public void onMenuOpened() {
//                                                         Toast.makeText(MainActivity.this, "Menu Opend", Toast.LENGTH_SHORT).show();
//                                                     }
//
//                                                     @Override
//                                                     public void onMenuClosed() {
//                                                         Toast.makeText(MainActivity.this, "Menu Closed", Toast.LENGTH_SHORT).show();
//                                                     }
//                                                 }
//        );


    }

    @Override
    public void onBackPressed() {
        if (circleMenu.isOpened())
            circleMenu.closeMenu();
        else
            finish();
    }

}
