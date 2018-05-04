package com.xqg.domain;

public class UserFollowEntity {

    private Integer id;

    private Integer followerId;

    private Integer beFollowerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }

    public Integer getBeFollowerId() {
        return beFollowerId;
    }

    public void setBeFollowerId(Integer beFollowerId) {
        this.beFollowerId = beFollowerId;
    }
}
