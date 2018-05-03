package com.fragment_user;

/**
 * Created by zhou on 18-5-3.
 */

public class UserEntity {
    private String user_text;

    private int imageId;

    public UserEntity(String user_text, int imageId) {
        this.user_text = user_text;
        this.imageId = imageId;
    }

    public String getUser_text() {
        return user_text;
    }


    public int getImageId() {
        return imageId;
    }

}
