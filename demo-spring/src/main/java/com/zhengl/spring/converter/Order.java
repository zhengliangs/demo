package com.zhengl.spring.converter;

import java.util.Date;

public class Order {

    private Integer id;
    private Date releaseDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
