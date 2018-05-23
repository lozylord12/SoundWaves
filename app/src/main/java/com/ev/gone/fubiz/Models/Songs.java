package com.ev.gone.fubiz.Models;

import java.io.Serializable;
import java.security.PublicKey;

/**
 * Created by gone on 3/11/18.
 */

public class Songs implements Serializable {

    public String name;
    public int idsongs;
    public String url;

    public Songs() {

    }

    public Songs(String name, int idsongs, String url) {
        this.name = name;
        this.idsongs = idsongs;
        this.url = url;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getIdsongs() {
//        return idsongs;
//    }
//
//    public void setIdsongs(int idsongs) {
//        this.idsongs = idsongs;
//    }
}
