package com.zhengl.es;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetadata;
import org.elasticsearch.common.compress.CompressedXContent;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Map;

@Slf4j
@SpringBootTest
class DemoSpringbootElasticsearchApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    void contextLoads() {
    }

    /**
     * 查询索引
     * @author hero良
     * @date 2022/4/6
     */
    @Test
    public void testFindIndex() throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest("*");
        GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);

        //所有索引
        String[] indices = getIndexResponse.getIndices();
        for (String index : indices) {
            log.info("index == {}", index);
        }
        // key: 索引名称 value: mapping
        Map<String, MappingMetadata> mappings = getIndexResponse.getMappings();
        for(Map.Entry<String, MappingMetadata> map : mappings.entrySet()){
            log.info("key == {}", map.getKey());
            MappingMetadata mappingMetadata = map.getValue();
            CompressedXContent source = mappingMetadata.source();
            log.info("mapping == {}", source);
        }
        restHighLevelClient.close();
    }

    /**
     * 删除索引
     * @author hero良
     * @date 2022/4/6
     */
    @Test
    public void testDeleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("user_index");
        AcknowledgedResponse acknowledgedResponse = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        log.info("acknowledgedResponse.isAcknowledged == {}", acknowledgedResponse.isAcknowledged());
        restHighLevelClient.close();
    }
    /**
     * 创建索引、映射
     * @author hero良
     * @date 2022/4/6
     */
    @Test
    public void testIndexAndMapping() throws IOException {
        // 创建索引请求对象
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("user_index");
        // source：指定的映射 xContentType：指定数据类型
        createIndexRequest.mapping("{\n" +
                "    \"properties\": {\n" +
                "      \"id\": {\n" +
                "        \"type\": \"integer\"\n" +
                "      },\n" +
                "      \"name\":{\n" +
                "        \"type\": \"text\",\n" +
                "        \"analyzer\": \"ik_max_word\"\n" +
                "      },\n" +
                "      \"age\":{\n" +
                "        \"type\": \"integer\"\n" +
                "      },\n" +
                "      \"birthday\":{\n" +
                "        \"type\": \"date\"\n" +
                "      }\n" +
                "    }\n" +
                "  }", XContentType.JSON);

        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        log.info("createIndexResponse.isAcknowledged == {}", createIndexResponse.isAcknowledged());
        //关闭资源
        restHighLevelClient.close();
    }

}
