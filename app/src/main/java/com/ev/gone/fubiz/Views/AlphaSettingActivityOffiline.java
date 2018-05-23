package com.ev.gone.fubiz.Views;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.ev.gone.fubiz.Manager.ListViewAdapter;
import com.ev.gone.fubiz.Manager.SongManager;
import com.ev.gone.fubiz.Models.LinkSongs;
import com.ev.gone.fubiz.Models.Songs;
import com.ev.gone.fubiz.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.ev.gone.fubiz.R;

public class AlphaSettingActivityOffiline extends AppCompatActivity {

    String settimes[] = new String[]{"5 mins", "10 mins", "15 mins", "20 mins", "25 mins", "30 mins", "35 mins", "40 mins", "45 mins", "50 mins", "55 mins", "60 mins"};

    View alpha_btn;
    Button backto_alpha_main;

    // data
    ListView lv1;
    ArrayList<String> ListSong;
    ArrayAdapter arr;
    ListView lv2;
    String[] items;
    MediaPlayer mp;
    ListViewAdapter data_adapter_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_setting_offiline);


        lv1 = (ListView) findViewById(R.id.lv);
        ListSong = new ArrayList<String>();
        ListSong.add("Chúng ta không thuộc về nhau - Sơn Tùng MTP");
        ListSong.add("Điều Anh Biết - Chi Dân");
        ListSong.add("Đường đến vinh quang - Bức Tường");
        ListSong.add("Em gái mưa - Hương Tràm");
        ListSong.add("Giấc Mơ Thần Tiên - Miu Lê");
        ListSong.add("Lạc Trôi - Sơn Tùng MTP");
        ListSong.add("Yêu 5 - Rhymatic");
        ListSong.add("Yêu Là Tha Thu");




        alpha_btn = (View) findViewById(R.id.alpha_setting);
        alpha_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayAdapter arr = new ArrayAdapter<String>(AlphaSettingActivityOffiline.this, android.R.layout.simple_list_item_1, ListSong);
                lv1.setAdapter(arr);
            }
        });


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    if (isConnectingToInternet()) {
                        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/test2-229c8.appspot.com/o/Chung-Ta-Khong-Thuoc-Ve-Nhau-Son-Tung-M-TP.mp3?alt=media&token=ce64e45e-57b7-42d9-b662-43c605ac5697");
                        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                        DownloadManager.Request request = new DownloadManager.Request(uri);

                        //Setting title of request
                        request.setTitle("Chung-Ta-Khong-Thuoc-Ve-Nhau-Son-Tung-M-TP.mp3");

                        //Setting description of request
                        request.setDescription("Downloading...");
                        check("Chung-Ta-Khong-Thuoc-Ve-Nhau-Son-Tung-M-TP.mp3");
                        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_MUSIC + "/" + "Music Fubiz", "Chung-Ta-Khong-Thuoc-Ve-Nhau-Son-Tung-M-TP.mp3");
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        Long reference = downloadManager.enqueue(request);
                    } else
                        Toast.makeText(AlphaSettingActivityOffiline.this, "Oops!! There is no internet connection. Please enable internet connection and try again.", Toast.LENGTH_SHORT).show();


                }
            }
        });

        backto_alpha_main = (Button) findViewById(R.id.backto_alpha_main);
        backto_alpha_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent redirect_one = new Intent(AlphaSettingActivityOffiline.this, AlphaActivityOffline.class);
                startActivity(redirect_one);


            }
        });


    }
    public ArrayList<File> findSongs(File root){
        ArrayList<File> a = new ArrayList<File>();
        File[] files = root.listFiles();
        for (File singleFile : files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){

                a.addAll(findSongs(singleFile));

            }
            else {
                if(singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav")){
                    a.add(singleFile);
                }
            }
        }
        return a;
    }
    public void toast(String text){
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }

    private boolean isConnectingToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager
                .getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    private void check(String name) {
        File apkStorage = new File(
                Environment.DIRECTORY_MUSIC + "/"
                        + "Music Fubiz");
        if (apkStorage.exists()) {
            apkStorage.mkdir();
            Log.e("MainActivity", "Directory Created.");
        }

        File outputFile = new File(apkStorage, name);//Create Output file in Main File

        //Create New File if not present
        if (!outputFile.exists()) {
            try {
                outputFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                outputFile = null;
                Log.e("MainActivity", "Download Error Exception " + e.getMessage());
            }
            Log.e("MainActivity", "File Created");
        }


        //Close all connection after doing task

    }

}
