package com.peanuts.timecapsule.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


@Data
@Entity
@Table(name = "user", schema = "timecapsule")
public class User {
    @ApiModelProperty(value = "主键无实际意义")
    private long id;

    @ApiModelProperty(value = "用户名",required = true)
    private String username;

    @ApiModelProperty(value = "密码",required = true)
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "邮箱",required = true)
    private String email;

    @ApiModelProperty(value = "创建时间")
    private Timestamp createtime;

    @ApiModelProperty(value = "更新时间")
    private Timestamp updatetime;

    @ApiModelProperty(value = "头像地址")
    private String avatar;

    @Id
    @Column(name = "id")

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "updatetime")
    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(nickname, that.nickname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(updatetime, that.updatetime) &&
                Objects.equals(avatar, that.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, nickname, email, createtime, updatetime, avatar);
    }
}
