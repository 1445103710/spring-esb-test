package com.yao.springboottest.mail;

/**
 * @className MailTool
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/07/23 15:12
 */


import com.alibaba.fastjson.JSONObject;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Properties;

/**
 * 邮件发送工具类
 */
public class MailTool {
    private static final Logger logger = LoggerFactory.getLogger(MailTool.class);
    private static String PROPERTIES_CONFIG = "mailConfig.properties";
    private static String HOSTNAME = "west.mail.chinaunicom.cn";
    private static String USERNAME = "xunn10";
    private static String PASSWORD = "1266212Xunanayy!";
    private static Properties properties;
    private static String[] ERRORMSG_RECIPIENTCCS = {};
    public static String DOMAIN_NAME;


    /*static {
        changeSender();
    }
    public static boolean changeSender() {
        properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = MailTool.class.getClassLoader().getResourceAsStream(PROPERTIES_CONFIG);
            properties.load(inputStream);
            inputStream.close();
            HOSTNAME = properties.getProperty("mailHost");
            USERNAME = properties.getProperty("username");
            PASSWORD = properties.getProperty("password");
            DOMAIN_NAME = properties.getProperty("domain_name");
        } catch (IOException e) {
            logger.error("读取配置文件错误", e);
            return false;
        }
        return true;
    }
*/
    public static Map<String, Object> sendMail(String to, String subject, String message) {
        ExchangeClient exchangeClient = new ExchangeClient.ExchangeClientBuilder()
                .hostname(HOSTNAME)
                .exchangeVersion(ExchangeVersion.Exchange2010)
                .username(USERNAME)
                .password(PASSWORD)
                .subject(subject)
                .message(message)
                .recipientTo(to)
                .build();
        return exchangeClient.sendExchange();
    }

/*	public static void sendErrorMsg(String subject, String message) {
		ExchangeClient exchangeClient = new ExchangeClient.ExchangeClientBuilder()
				.hostname(HOSTNAME)
				.exchangeVersion(ExchangeVersion.Exchange2010)
				.username(USERNAME)
				.password(PASSWORD)
				.subject(subject)
				.message(message)
				.recipientTo(ERRORMSG_RECIPIENT)
				.recipientCc(Arrays.asList(ERRORMSG_RECIPIENTCCS))
				.build();
		exchangeClient.sendExchange();
	}*/


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/yaoyao/Desktop/salary/remark.txt"));
        String line = null;
        StringBuilder builder = new StringBuilder();
        while ((line = br.readLine()) != null) {
            builder.append(line + "<BR>");
        }
        br.close();
        builder.append("<BR>");


        BufferedReader bl = new BufferedReader(new FileReader("/Users/yaoyao/Desktop/salary/test.txt"));
        String list = null;
        while ((list = bl.readLine()) != null) {
            String[] split = list.split("\\|");
            String replace = builder.toString().replace("{0}", split[0]);

            ExchangeClient exchangeClient = new ExchangeClient.ExchangeClientBuilder()
                    .hostname(HOSTNAME)
                    .exchangeVersion(ExchangeVersion.Exchange2010)
                    .username(USERNAME)
                    .password(PASSWORD)
                    .subject("202007考核结果核对")
                    .message(replace)
                    .recipientTo(split[1])
                    .recipientBcc("1750022757@qq.com")
                    .attachments("/Users/yaoyao/Desktop/salary/"+split[0]+".xls")
                    .build();
            Map<String, Object> stringObjectMap = exchangeClient.sendExchange();
            String s = "[时间"+ LocalDateTime.now()+"]" +split[0]+"发送"+split[1]+"结果:"+JSONObject.toJSONString(stringObjectMap);
            System.out.println(s);
            writeFile("/Users/yaoyao/Desktop/salary/log.txt",s);

        }
        br.close();
    }

    public static void writeFile(String path,String line) {
        try {
            FileWriter fw = new FileWriter(path, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(line);   //字符串末尾不需要换行符
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}