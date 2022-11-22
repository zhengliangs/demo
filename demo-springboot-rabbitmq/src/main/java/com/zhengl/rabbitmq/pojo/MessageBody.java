package com.zhengl.rabbitmq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class MessageBody implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int level;
    private long time;


    public MessageBody(String name, int level) {
        this.name = name;
        this.level = level;
    }
}
