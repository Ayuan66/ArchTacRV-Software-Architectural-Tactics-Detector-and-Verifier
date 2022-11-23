package api;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MethodApi {
    private static final String baseUrl = "http://127.0.0.1:8080";
    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(2000)
            .setSocketTimeout(10000).build();

    public static boolean getMethodInfo(String tacticName, HashMap<String, String> methodHashMap){
        System.out.println("------进入api------");
        //pingecho ckprbk heartbeat voting redundancy
        System.out.println("tacticName:" + tacticName);
        System.out.println("methodHashMap:" + methodHashMap);

        // 参数
        List<Data> dataList = new ArrayList<>();
        // 遍历map
        for (Map.Entry<String, String> entry : methodHashMap.entrySet()) {
            dataList.add(new Data(entry.getValue(), entry.getKey()));
        }
        String paramJSONStr = MethodData.getJSONStr("lyyre@outlook.com",dataList);

        // http POST请求
        HttpPost httpPost = new HttpPost(baseUrl + "/" + tacticName +"/restoremethod");
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.setConfig(requestConfig);

        // JSON 格式
        StringEntity se = null;
        try {
            System.out.println("参数:" + paramJSONStr);
            se = new StringEntity(paramJSONStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        se.setContentType(CONTENT_TYPE_TEXT_JSON);
        httpPost.setEntity(se);

        CloseableHttpResponse response = null;
        String result = null;
        try {
            // 执行
            response = httpClient.execute(httpPost);

            // 获取内容
            HttpEntity httpEntity = response.getEntity();
            result = EntityUtils.toString(httpEntity, "UTF-8");
            JSONObject jsonObject = JSONObject.parseObject(result);
            System.out.println(jsonObject);

            // status code
            String code = (String) jsonObject.get("code");
            if (code.equals("200")){
                System.out.println("success!");
                return true;
            } else if (code.equals("400")){
                System.out.println("error!");
                return false;
            } else {
                System.out.println("other wrong!");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static JSONObject testMethodAPI(String tactic) {
        CloseableHttpResponse response = null;

        //POST请求
        HttpPost httpPost = new HttpPost(baseUrl + "/tactic/" + tactic);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.setConfig(requestConfig);
        System.out.println("httpPost is " + httpPost);

        try {
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String result = null;
        HttpEntity httpEntity = response.getEntity();
        try {
            result = EntityUtils.toString(httpEntity, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //替换//
        result = result.replaceAll("\\\\", "");
        result = result.replaceAll("\\\\", "");
        //去除首尾引号
        result = result.substring(1);
        result = result.substring(0, result.length() - 1);

        System.out.println("result is " + result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println("Json is " + jsonObject);

        return jsonObject;
    }
}

