package com.yao.springboottest.esb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/02/15 12:36
 */
public class Test {
    public static void main(String[] args) {
        String reqTest = "hsn=jd&promiseDate=1&invoiceName=AA&city=350&companyName=ABC&county=351&invoiceState=2&remark=ABC123&invoiceAddress=AAA&thirdOrder=34&isUseBalance=0&paymentType=1网吧01&province=6&invoiceType=1&sku=[{\"skuId\":\"123864\",\"num\":1,\"bNeedAnnex\":true,\"bNeedGift\":false,\"price\":11.76}]&email=abcde@163.com&submitState=0&invoiceProvice=1&zip=100085&invoiceContent=1&address=北京市&town=14000&selectedInvoiceTitle=5&mobile=12345678901&invoiceCity=1&invoiceCounty=1&token=rNATMYLA5yNCerJWZPzmgLYHQ&phone=12345678&name=张三&appkey=NwHdFjq19IKgoK7GLKHp&invoicePhone=12345678901&doOrderPriceMode=0";
        Pattern compile = Pattern.compile("&paymentType=(.*?)&");
        Matcher matcher = compile.matcher(reqTest);
        if (matcher.find()){
            System.out.println("11"+matcher.toString());
            reqTest = reqTest.replace(matcher.group(),"");
        }
        System.out.println(reqTest);
    }
}
