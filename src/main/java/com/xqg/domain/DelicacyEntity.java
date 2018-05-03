package com.xqg.domain;

import java.util.Date;

public class DelicacyEntity {

    private Integer delicacyId;

    private String title;

    private String content;

    private Date date;

    private Integer delete;

    public Integer getDelicacyId() {
        return delicacyId;
    }

    public void setDelicacyId(Integer delicacyId) {
        this.delicacyId = delicacyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }
}
