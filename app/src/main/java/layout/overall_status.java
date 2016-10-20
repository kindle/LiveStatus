package layout;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reddah.livestatus.livestatus.R;


import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;


public class overall_status extends Fragment {

    View view;
    TextView tv_overall_status;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_overall_status, null);
        tv_overall_status = (TextView)view.findViewById(R.id.tv_overall_status);
        tv_overall_status.setText("inital...");

        new Thread(new Runnable() {
            @Override
            public void run() {
                TextView tv_overall_status1 = (TextView)view.findViewById(R.id.tv_overall_status);
                HttpURLConnection connection = null;
                try {


                    tv_overall_status1.setText("in thread...");
                    URL url = new URL(".xml?seed=1234");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");// 设置请求的方式
                    connection.setReadTimeout(5000);// 设置超时的时间
                    connection.setConnectTimeout(5000);// 设置链接超时的时间
                    // 设置请求的头
                    connection
                            .setRequestProperty("User-Agent",
                                    "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:27.0) Gecko/20100101 Firefox/27.0");
                    // 获取响应的状态码 404 200 505 302
                    if (connection.getResponseCode() == 200) {
                        // 获取响应的输入流对象
                        tv_overall_status1.setText("start..200");
                    }
                    else{
                        tv_overall_status1.setText("start.."+connection.getResponseCode());
                    }
                    /*connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);

                    connection.setRequestProperty("Charset", "UTF-8");
                    connection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");

                    if(connection.getResponseCode() == 200) {
                        tv_overall_status1.setText("start..200");
                    }
                    else{
                        tv_overall_status1.setText("start.."+connection.getResponseCode());
                    }
*//*
                    InputStream in = connection.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                            .newDocumentBuilder();
                    InputStream   inputStream   =   new ByteArrayInputStream(response.toString().getBytes());
                    Document document = builder.parse(inputStream);
                    // 生成XPath对象
                    XPath xpath = XPathFactory.newInstance().newXPath();*/
                    //tv_overall_status.setText("result:......");
                    // 获取节点值
                    //String webTitle = (String) xpath.evaluate(
                    //        "/RootNode/LiveStatus/Status/text()", document, XPathConstants.STRING);
                    //tv_overall_status.setText("result:"+webTitle);


                    //tv_overall_status.setText("start..");
                } catch (Exception e) {
                    tv_overall_status1.setText("error.." +e.toString());
                    e.printStackTrace();

                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
             }
        }).start();

        return view;
    }

class LiveStatus{

    public int Status;
    public String Timestamp;

}


}
