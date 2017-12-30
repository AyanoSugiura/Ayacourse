package com.zhou.restfultest.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private Integer userlevel=0; //用户等级 0--user 1--teacher  2--admin
    @Column(columnDefinition = "INTEGER DEFAULT 1")
    private Integer verify=1;    //审核状态 0--未通过 1--待审核 2--已通过
    @Column(columnDefinition = "INTEGER DEFAULT 1")
    private Integer usable=1;    //可用状态 1--可用 0--不可用
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "favorite",joinColumns = @JoinColumn(name = "uid"),inverseJoinColumns = @JoinColumn(name = "vid"))
    Set<Video> favorites;

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

    public Integer getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(Integer userlevel) {
        this.userlevel = userlevel;
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

    public Set<Video> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Video> favorites) {
        this.favorites = favorites;
    }
}