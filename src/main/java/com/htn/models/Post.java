package com.htn.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Tiêu đề không được để trống")
    @Size(min = 4, message = "Tiêu để không được dưới 4 ký tự")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Nội dung không được để trống")
    @Size(min = 4, message = "Nội dung không được dưới 4 ký tự")
    @Column(name = "content")
    private String content;

    @Column(name = "date_time")
    private Date dateTime;

    @NotNull(message = "Sô phút đọc không được để trống")
    @Column(name = "read_minutes")
    private Integer readMinutes;

    @NotNull(message = "Phải có liên kết hình ảnh")
    @Column(name = "image")
    private String image;

    @NotNull(message = "Mô tả không được để trống")
    @Column(name = "descriptions")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<Comment> commentList;

    @Transient
    private String date;

    public Post() {

    }


    public String getDate() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        if(dateTime != null)
            return df.format(dateTime);
        return "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getReadMinutes() {
        return readMinutes;
    }

    public void setReadMinutes(Integer readMinutes) {
        this.readMinutes = readMinutes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dateTime=" + dateTime +
                ", readMinutes='" + readMinutes + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
