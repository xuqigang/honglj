package com.xqg.domain;

public class User {
    private Integer id;

    private String name;

    private String password;

    /*
     *用户昵称
     */
    private String nickName;

    /*
     *性别 1、男  2、女
     */
    private String sex;

    /*
     *座右铭
     */
    private String motto;

    /*
     *头像
     */
    private String headportrait;

    /*
     *年龄
     */
    private int age;

    /*
     *关注数
     */
    private long followNum;

    /*
     *喜欢数
     */
    private long favoriteNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getFollowNum() {
        return followNum;
    }

    public void setFollowNum(long followNum) {
        this.followNum = followNum;
    }

    public long getFavoriteNum() {
        return favoriteNum;
    }

    public void setFavoriteNum(long favoriteNum) {
        this.favoriteNum = favoriteNum;
    }
}