package com.xqg.domain;

public class VideoEntity {

    /*
     *视频ID
     */
    private Integer videoId;

    /*
     *用户ID
     */
    private Integer userId;

    /*
     *视频标题
     */
    private String videoTitle;

    /*
     *视频简介
     */
    private String videoIntroduction;

    /*
     *视频播放URL
     */
    private String videoUrl;

    /*
     *分类名
     */
    private String category;

    /*
     *分类ID
     */
    private Integer categoryId;

    /*
     *封面图
     */
    private String cover;

    /*
     *喜欢数
     */
    private Integer favoriteNum;

    /*
     *喜欢状态  0、不喜欢，1、喜欢
     */
    private Integer favoriteState;

    /*
     *关注状态 0、未关注  1、已关注
     */
    private Integer followState;

//    /*
//     *评论ID
//     */
//    private Integer commentId;
//
//    /*
//     *评论数
//     */
//    private Integer commentNum;

    /*
     *用户头像
     */
    private String  headPortrait;

    public VideoEntity(){
        this.favoriteNum = 0;
        this.followState = 0;
        this.favoriteState = 0;
    }
    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoIntroduction() {
        return videoIntroduction;
    }

    public void setVideoIntroduction(String videoIntroduction) {
        this.videoIntroduction = videoIntroduction;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getFavoriteNum() {
        return favoriteNum;
    }

    public void setFavoriteNum(Integer favoriteNum) {
        this.favoriteNum = favoriteNum;
    }

    public Integer getFavoriteState() {
        return favoriteState;
    }

    public void setFavoriteState(Integer favoriteState) {
        this.favoriteState = favoriteState;
    }

    public Integer getFollowState() {
        return followState;
    }

    public void setFollowState(Integer followState) {
        this.followState = followState;
    }

//    public Integer getCommentId() {
//        return commentId;
//    }
//
//    public void setCommentId(Integer commentId) {
//        this.commentId = commentId;
//    }
//
//    public Integer getCommentNum() {
//        return commentNum;
//    }
//
//    public void setCommentNum(Integer commentNum) {
//        this.commentNum = commentNum;
//    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }
}
