package com.zhengl.java.test;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * @author hero良
 */
public class HttpClient {

    /**
     * post调用
     * @author hero良
     */
    public static void postInvoking(String url, String param) {
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
            StringEntity se = new StringEntity(param);
            se.setContentType("application/json;charset=utf8");
            // 设置请求参数
            httpPost.setEntity(se);
            HttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                // 返回json格式
                String res = EntityUtils.toString(response.getEntity());
                System.out.println(res);
            } else {
                System.out.println(" getInvoking.url == " + url + "   param == " + param);
                System.out.println(" getInvoking.statusCode == " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * get调用
     * @author hero良
     */
    public static void getInvoking(String url) {
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
            HttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                // 返回json格式
                String res = EntityUtils.toString(response.getEntity());
                System.out.println(res);
            } else {
                System.out.println(" getInvoking.url == " + url);
                System.out.println(" getInvoking.statusCode == " + statusCode);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
