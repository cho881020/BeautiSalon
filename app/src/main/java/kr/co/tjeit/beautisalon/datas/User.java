package kr.co.tjeit.beautisalon.datas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by user on 2017-07-26.
 */

public class User extends Person implements Serializable {
    // implements Serializable
    // User 클래스 객체들이
    // intent.putExtra => intent에 첨부되어 전송될수 있도록 하는 구문

    private Calendar birthDay;
    private String profilePicturePath;


    private ArrayList<Designer> likeDesigners;

    // Constructor도 생성

    public User() {

    }


    public User(String name, int gender, Calendar birthDay, ArrayList<Designer> likeDesigners, String path) {
        setName(name);
        setGender(gender);
        this.birthDay = birthDay;
        this.likeDesigners = likeDesigners;
        this.profilePicturePath = path;
    }




    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    public Calendar getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Calendar birthDay) {
        this.birthDay = birthDay;
    }

    public ArrayList<Designer> getLikeDesigners() {
        return likeDesigners;
    }

    public void setLikeDesigners(ArrayList<Designer> likeDesigners) {
        this.likeDesigners = likeDesigners;
    }
}





