package com.hc.udemy.util;

import com.hc.udemy.entity.User;

public class ResponseBody {

    private String url;
    private User user;

    public ResponseBody(String url, User user) {
        this.url = url;
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
