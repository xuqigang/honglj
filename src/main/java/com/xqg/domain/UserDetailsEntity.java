package com.xqg.domain;

public class UserDetailsEntity {

    private Integer userId;

    private String userName;

    private String password;

    /*
     *用户昵称
     */
    private String nickName;

    /*
     *性别 1、男  2、女
     */
    private Integer sex;

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


    private String phone;

    /*
     *关注数
     */
    private long followNum;

    /*
     *喜欢数
     */
    private long favoriteNum;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
