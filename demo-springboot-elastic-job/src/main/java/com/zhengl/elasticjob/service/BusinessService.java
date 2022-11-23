package com.zhengl.elasticjob.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BusinessService {

    /**
     * 业务处理
     * @author hero良
     * @date 2022/3/31
     * @param shardingParameter
     */
    public void businessLogic(String shardingParameter){
        log.info("业务逻辑处理...");

        List<Integer> dataSource = Arrays.asList(1, 105, 106, 107, 108, 109, 119, 120, 121, 122, 123, 124, 125, 127, 128, 129, 130, 131, 132, 133, 134, 135,
                136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196,
                197, 198, 199, 2, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 41, 74, 75, 78, 79,
                80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97);

        List<String> list = new ArrayList<>();
        for (Integer integer : dataSource) {
            list.add(String.valueOf(integer));
        }
        List<String> boList = list.stream()
                .filter(n -> n.substring(n.length() -1).equals(shardingParameter)).collect(Collectors.toList());
        log.info("   list.size = {}, boList.size = {}", list.size(), boList.size());

    }

}
