package com.zhengl.mongodb.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

/**
 * @description  todo
 * @author hero良
 **/
@Data
@Accessors(chain = true)
@CompoundIndexes({@CompoundIndex(name = "day_tag_index", def = "{'day': -1, 'tag': 1}")})
public class HisDataPerDay {

    @MongoId
    private ObjectId id;
    @Field
    @Indexed
    private String day;
    @Field
    @Indexed
    private String tag;
    @Field("data_list")
    private List<HisData> data_list;
}
