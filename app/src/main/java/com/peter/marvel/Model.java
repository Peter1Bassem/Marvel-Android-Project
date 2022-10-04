package com.peter.marvel;

import com.google.gson.annotations.SerializedName;

public class Model {

    public String imageurl;
    public String name;
    public String realname;
    public String team;
    public String firstappearance ;
    public String createdby;
    public String publisher;
    public String bio;

    public Model(String imageurl, String name, String realname, String team, String firstappearance, String createdby, String publisher, String bio) {
        this.imageurl = imageurl;
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.bio = bio;
    }

    public String getImageurl() {return imageurl;}

    public String getName() {return name;}

    public String getRealname() {return realname;}

    public String getTeam() {return team;}

    public String getFirstappearance() {return firstappearance;}

    public String getCreatedby() {return createdby;}

    public String getPublisher() {return publisher;}

    public String getBio() {return bio;}
}
