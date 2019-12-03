package com.example.Rsyzw.models;

import io.realm.RealmList;
import io.realm.RealmObject;

public class MusicSourceModel extends RealmObject {

    private RealmList<AlbumModel> album;
    private RealmList<PlayListModel> playList;
    private RealmList<MusicModel> hot;

    public RealmList<PlayListModel> getPlayList() {
        return playList;
    }

    public void setPlayList(RealmList<PlayListModel> playList) {
        this.playList = playList;
    }

    public RealmList<AlbumModel> getAlbum() {
        return album;
    }

    public void setAlbum(RealmList<AlbumModel> album) {
        this.album = album;
    }

    public RealmList<MusicModel> getHot() {
        return hot;
    }

    public void setHot(RealmList<MusicModel> hot) {
        this.hot = hot;
    }
}
