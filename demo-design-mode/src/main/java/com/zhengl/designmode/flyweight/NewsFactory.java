package com.zhengl.designmode.flyweight;

import java.util.HashMap;

/**
 * @author hero良
 */
public class NewsFactory {

    // 集合，池容器
    private HashMap<String, INewsFlyweight> pool = new HashMap<>();

    public INewsFlyweight getNews(String key){
        if (!this.pool.containsKey(key)) {
            this.pool.put(key, new ConcreteNews(key));
        }
        return this.pool.get(key);
    }

    public int getNewsCount(){
        return this.pool.size();
    }

}
