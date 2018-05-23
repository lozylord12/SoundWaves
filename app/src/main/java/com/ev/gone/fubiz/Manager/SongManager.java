package com.ev.gone.fubiz.Manager;

import com.ev.gone.fubiz.Models.LinkSongs;
import com.ev.gone.fubiz.Models.Songs;

import java.util.ArrayList;

/**
 * Created by gone on 3/11/18.
 */

public class SongManager {

    private static SongManager sInstance = null;

    private ArrayList<Songs> mSongList;
    private ArrayList<LinkSongs> mLinkSongs;

    private SongManager() {
        mSongList = new ArrayList<>();
    }

    public static SongManager getInstance(){
        if(sInstance == null){
            sInstance = new SongManager();
        }
        return sInstance;
    }
    public void load(){

//        mSongList.add(new Songs( "Requiem", 1));
//        mSongList.add(new Songs("The Magic Flute", 2));
//        mSongList.add(new Songs("Piano Sonata No. 11", 3));
//        mSongList.add(new Songs("Symphony No. 40", 4));
//        mSongList.add(new Songs("Don Giovanni", 5));
//        mSongList.add(new Songs("Ave verum corpus", 6));
//        mSongList.add(new Songs("Ave verum corpus 2", 7));

//        mLinkSongs.add(new LinkSongs(1, "link one"));
//        mLinkSongs.add(new LinkSongs(2, "link two"));
//        mLinkSongs.add(new LinkSongs(3, "link three"));
//        mLinkSongs.add(new LinkSongs(4, "link four"));
//        mLinkSongs.add(new LinkSongs(5, "link five"));

    }


//    public ArrayList<LinkSongs> getLinkSongs(Songs songs){
//
//        ArrayList<LinkSongs> list = new ArrayList<>();
//        for (LinkSongs l : mLinkSongs){
//            if(l.getId() == songs.getIdsongs()){
//                list.add(l);
//            }
//        }
//        return list;
//
//    }

//    public String[] getSongName(){
//
//        String [] name = new String[mSongList.size()];
//        for (int i = 0; i < name.length; i++){
//            name[i] = mSongList.get(i).getName();
//        }
//
//        return  name;
//    }

    public ArrayList<Songs> getSongs(){
        return mSongList;
    }


}
