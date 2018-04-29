package com;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com.model.User）
 * @date: 2017/12/20 
 * @since V1.0
 *  
 */
@ImportResource("classpath:consumer.xml")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages ={"com"})
//@MapperScan({"com.consumer.mapper", "com.consumer.mapper.ext"})
public class ConsumerApplication {

//    @Autowired
//    @Lazy
//    private UserService userService;
//
//    @RequestMapping("test")
//    @ResponseBody
//    public User user() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException, IOException {
//        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create();
//        ConnectionSocketFactory plainConnectionSocketFactory = new PlainConnectionSocketFactory();
//        registryBuilder.register("http", plainConnectionSocketFactory);
//
//        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
//        //信任任何链接
//        TrustStrategy anyTrustStrategy = new TrustStrategy() {
//            @Override
//            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
//                return true;
//            }
//        };
//        SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy).build();
//        LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//        registryBuilder.register("https", sslSF);
//
//        Registry<ConnectionSocketFactory> registry = registryBuilder.build();
//        PoolingHttpClientConnectionManager clientConnectionManager = new PoolingHttpClientConnectionManager(registry);
//        clientConnectionManager.setMaxTotal(2);
//        clientConnectionManager.setDefaultMaxPerRoute(20);
//
//        HttpClient httpClient = HttpClientBuilder.create().setConnectionManager(clientConnectionManager).build();
//
//        HttpGet httpGet = new HttpGet("http://localhost:20881");
//        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(1000).build();
//        httpGet.setConfig(requestConfig);
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//        int status = httpResponse.getStatusLine().getStatusCode();
//        System.out.println(status);
//        return null;
//
//    }

    public static void main(String[] args){
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
