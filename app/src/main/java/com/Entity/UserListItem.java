package com.Entity;

/**
 * Created by zhou on 18-5-3.
 */

public class UserListItem {
    private String user_text;

    private int imageId;

    public UserListItem(String user_text, int imageId) {
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
