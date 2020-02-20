package com.application.playerapp;

public class Player {
    private String name;
    private String team;
    private String old;
    private String photo;

    public Player(String name, String team, String old, String photo) {
        this.name = name;
        this.team = team;
        this.old = old;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public void setPhoto(String photo){
        this.photo = photo;
    }

    public String getPhoto(){
        return photo;
    }
}
