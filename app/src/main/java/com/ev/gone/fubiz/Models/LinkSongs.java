package com.ev.gone.fubiz.Models;

/**
 * Created by gone on 3/11/18.
 */

public class LinkSongs {

    private  int id;
    private  String links;

    public LinkSongs(int id, String links) {
        this.id = id;
        this.links = links;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }
}
