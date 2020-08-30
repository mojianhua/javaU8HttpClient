package cn.itcast.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

//让Spring自动实例化
@Component
public class HttpUtils {

    private PoolingHttpClientConnectionManager cm;

    /**
     * 构造函数
     * */
    public HttpUtils(){
        this.cm = new PoolingHttpClientConnectionManager();

        //设置最大连接数
        this.cm.setMaxTotal(100);

        //设置每个主机的最大连接数
        this.cm.setDefaultMaxPerRoute(10);
    }


    /**
     * 下载页面
     * */
    public String doGetHtml(String url){
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();

        //创建httpGet对象，设置url地址
        HttpGet httpGet = new HttpGet(url);

        //设置请求信息
        httpGet.setConfig(getConfig());

        CloseableHttpResponse response = null;

        String content = "";
        try {
            response = httpClient.execute(httpGet);
            //解释响应
            if(response.getStatusLine().getStatusCode() == 200){
                if(response.getEntity() != null){
                    content = EntityUtils.toString(response.getEntity());
                    return content;
                }
            }else{
                return content;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭response
            if(response != null){
                try{
                    response.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content;
    }

    /**
     * 下载图片
     * */
    public String doGetImage(String url){
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();

        //创建httpGet对象,设置url地址
        HttpGet httpGet = new HttpGet(url);

        //设置请求信息
        httpGet.setConfig(this.getConfig());

        CloseableHttpResponse response = null;

        String picName = null;
        try {
            response = httpClient.execute(httpGet);
            //解释响应
            if(response.getStatusLine().getStatusCode() == 200) {
                if (response.getEntity() != null) {
                    //下载图片
                    //获取图片后缀
                    String ext = url.substring(url.lastIndexOf("."));

                    //创建图片，重命名
                    picName = UUID.randomUUID().toString() + ext;

                    //下载保存图片到本地
                    OutputStream outputStream = new FileOutputStream(new File("src/images") + picName);
                    response.getEntity().writeTo(outputStream);

                    //返回图片名称
                    return picName;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭response
            if(response != null){
                try{
                    response.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return picName;
    }

    /**
     * 设置请求信息
     * */
    private RequestConfig getConfig(){
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(1000000)
                .setConnectionRequestTimeout(5000000)
                .setSocketTimeout(10000000)
                .build();
        return config;
    }
}
