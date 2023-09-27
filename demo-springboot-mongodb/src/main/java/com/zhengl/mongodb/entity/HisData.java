package com.zhengl.mongodb.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.zhengl.mongodb.converter.MongoLongConverter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @description  todo
 * @author hero良
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class HisData {

    @Field
    private double value;
    //1：有效 否则无效
    @Field
    private int quality;
    @JSONField(deserializeUsing = MongoLongConverter.class)
    private long timeStamp;
}
