package com.zhengl.mongodb.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageData {

    private String time;
    private List<MessageBody> data;
}
