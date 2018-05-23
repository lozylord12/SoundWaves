package com.ev.gone.fubiz.Views;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ev.gone.fubiz.R;

import java.io.File;
import java.util.ArrayList;

public class ListSongOfflineActivity extends AppCompatActivity {

    View alpha_btn;
    ListView listview;
    String[] items;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song_offline);

        alpha_btn = (View) findViewById(R.id.alpha_setting);
        listview = (ListView) findViewById(R.id.listview);
      final ArrayList<File> mySongs = findSongs(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
      //  final ArrayList<File> mySongs = findSongs(Environment.getExternalStorageDirectory());
        items = new String[mySongs.size()];
        alpha_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.offlinesong,R.id.home,items);
                listview.setAdapter(arrayAdapter);
                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        /*if(mp!=null){
                            mp.stop();
                            mp.release();

                        }*/
                    //   Uri uri = Uri.parse(mySongs.get(i).toString());
                     //   mp = MediaPlayer.create(getApplicationContext(),uri);
                     //   mp.start();



                        startActivity(new Intent(getApplicationContext(), AlphaActivity.class).putExtra("pos", i).putExtra("song_list", mySongs));



                    }
                });

            }
        });



        for (int i = 0; i < mySongs.size(); i++) {

            //          toast(mySongs.get(i).getName().toString());
            items[i] = mySongs.get(i).getName().toString().replace(".mp3", "").replace(".wav", "");

        }
    }


    public ArrayList<File> findSongs(File root) {
        ArrayList<File> a = new ArrayList<File>();
        File[] files = root.listFiles();
        for (File singleFile : files) {
            if (singleFile.isDirectory() && !singleFile.isHidden()) {

                a.addAll(findSongs(singleFile));

            } else {
                if (singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav")) {
                    a.add(singleFile);
                }
            }
        }
        return a;
    }

    public void toast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }
}

