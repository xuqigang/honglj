package com.xqg.domain;

public class UserInfoEntity {
    private Integer userId;

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
    private String age;


    private String phone;

    /*
     *关注数
     */
    private Integer followNum;

    /*
     *粉丝数
     */
    private Integer fansNum;


    /*
     *钻石数
     */
    private Integer diamondsNum;

    public UserInfoEntity(){
        this.followNum = 0;
        this.fansNum = 0;
        this.diamondsNum = 0;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public Integer getDiamondsNum() {
        return diamondsNum;
    }

    public void setDiamondsNum(Integer diamondsNum) {
        this.diamondsNum = diamondsNum;
    }

}


