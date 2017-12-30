package com.zhou.restfultest.model;

import javax.persistence.*;

@Entity
@Table(name="video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    //@Column(nullable = false)
    private String link;
    @Column(columnDefinition = "INTEGER DEFAULT 1")
    private Integer verify=1;    //审核状态 0--未通过 1--待审核 2--已通过
    @Column(columnDefinition = "INTEGER DEFAULT 1")
    private Integer usable=1;    //可用状态 1--可用 0--不可用
    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "uid")
    private User author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getVerify() {
        return verify;
    }

    public void setVerify(Integer verify) {
        this.verify = verify;
    }

    public Integer getUsable() {
        return usable;
    }

    public void setUsable(Integer usable) {
        this.usable = usable;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}
