package com.zhengl.mongodb.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageBody {

    private String tagId;
    private double value;
    private int quality;
}
