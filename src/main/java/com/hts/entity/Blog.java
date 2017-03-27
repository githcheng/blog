package com.hts.entity;

public class Blog {

    private String id;
    private String uniq;
    private String title;
    private String html;
    private Long createTime;
    private long updateTime;
    private String markdown;


    public Blog() {
    }


    public Blog(String uniq, String title, String markdown,
                String html, Long createTime, long updateTime) {
        this.uniq = uniq;
        this.title = title;
        this.markdown = markdown;
        this.html = html;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUniq() {
        return uniq;
    }

    public void setUniq(String uniq) {
        this.uniq = uniq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
}
