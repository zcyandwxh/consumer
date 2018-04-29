import com.consumer.model.User;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import javax.net.ssl.SSLContext;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/1/22 
 * @since V1.0
 *  
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = ConsumerApplication.class)
public class HttpTest {

//    @Test
    public void test() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException, IOException {
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create();
        ConnectionSocketFactory plainConnectionSocketFactory = new PlainConnectionSocketFactory();
        registryBuilder.register("http", plainConnectionSocketFactory);

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        //信任任何链接
        TrustStrategy anyTrustStrategy = new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        };
        SSLContext sslContext = SSLContexts.custom().useSSL().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy).build();
        LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        registryBuilder.register("https", sslSF);

        Registry<ConnectionSocketFactory> registry = registryBuilder.build();
        PoolingHttpClientConnectionManager clientConnectionManager = new PoolingHttpClientConnectionManager(registry);
        clientConnectionManager.setMaxTotal(2);
        clientConnectionManager.setDefaultMaxPerRoute(20);

        HttpClient httpClient = HttpClientBuilder.create().setConnectionManager(clientConnectionManager).build();

//        HttpGet httpGet = new HttpGet("http://localhost:20881/IWmsAutoService/testLogin?username=xiaoni&password=111111");
        HttpPost httpPost = new HttpPost("http://localhost:20881/IWmsAutoService/testLogin");
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000).setSocketTimeout(10000).build();
        httpPost.setConfig(requestConfig);
        Gson gson = new Gson();
        User user = new User();
        user.setPassword("111111");
        user.setUsername("xiaoni");
        StringEntity stringEntity = new StringEntity(gson.toJson(user), "utf-8");
        httpPost.setEntity(stringEntity);
        httpPost.addHeader("Content-Type", "application/json");
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        InputStream in = httpEntity.getContent();
        DataInputStream dataInputStream = new DataInputStream(in);
        int c;
        System.out.println(httpEntity.getContent());
        int status = httpResponse.getStatusLine().getStatusCode();
        System.out.println(status);
    }

    public static void main(String[] args) throws Exception {
       // URL url = Thread.currentThread().getContextClassLoader().getParent();
 //       System.out.println(Thread.currentThread().getContextClassLoader().getParent().getParent());
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mgb.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }


}
