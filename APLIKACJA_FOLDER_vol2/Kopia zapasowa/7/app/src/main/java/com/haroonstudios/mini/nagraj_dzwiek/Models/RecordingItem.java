package com.haroonstudios.mini.nagraj_dzwiek.Models;

import java.io.Serializable;

public class RecordingItem implements Serializable
{
    private String mane,path;
    private long lenihgt,time_added;



    public RecordingItem()
    {

    }


    public RecordingItem(String mane, String path, long lenihgt, long time_added) {
        this.mane = mane;
        this.path = path;
        this.lenihgt = lenihgt;
        this.time_added = time_added;
    }


    public String getMane() {
        return mane;
    }

    public void setMane(String mane) {
        this.mane = mane;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getLenihgt() {
        return lenihgt;
    }

    public void setLenihgt(long lenihgt) {
        this.lenihgt = lenihgt;
    }

    public long getTime_added() {
        return time_added;
    }

    public void setTime_added(long time_added) {
        this.time_added = time_added;
    }
}
