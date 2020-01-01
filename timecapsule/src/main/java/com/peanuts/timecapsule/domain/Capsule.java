package com.peanuts.timecapsule.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "capsule", schema = "timecapsule")
public class Capsule {
    private long id;
    private String content;
    private Timestamp createtime;
    private Timestamp opentime;
    private String username;
    private String uuid;
    private String warncontent;
    private String email;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "opentime")
    public Timestamp getOpentime() {
        return opentime;
    }

    public void setOpentime(Timestamp opentime) {
        this.opentime = opentime;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "uuid")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "warncontent")
    public String getWarncontent() {
        return warncontent;
    }

    public void setWarncontent(String warncontent) {
        this.warncontent = warncontent;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capsule that = (Capsule) o;
        return id == that.id &&
                Objects.equals(content, that.content) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(opentime, that.opentime) &&
                Objects.equals(username, that.username) &&
                Objects.equals(uuid, that.uuid) &&
                Objects.equals(warncontent, that.warncontent) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, createtime, opentime, username, uuid, warncontent, email);
    }
}
