package com.yao.springboottest.mail;

/**
 * @className ExchangeClient
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/07/23 15:11
 */

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.exception.service.local.ServiceLocalException;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExchangeClient {

    Logger logger = LoggerFactory.getLogger(ExchangeClient.class);

    private final String hostname;
    private final ExchangeVersion exchangeVersion;
    private final String domain;
    private final String username;
    private final String password;
    private final String subject;
    private final String recipientTo;
    private final List<String> recipientCc;
    private final List<String> recipientBcc;
    private final List<String> attachments;
    private final String message;

    private ExchangeClient(ExchangeClientBuilder builder) {
        this.hostname = builder.hostname;
        this.exchangeVersion = builder.exchangeVersion;
        this.domain = builder.domain;
        this.username = builder.username;
        this.password = builder.password;
        this.subject = builder.subject;
        this.recipientTo = builder.recipientTo;
        this.recipientCc = builder.recipientCc;
        this.recipientBcc = builder.recipientBcc;
        this.attachments = builder.attachments;
        this.message = builder.message;
    }

    public static class ExchangeClientBuilder {

        private String hostname;
        private ExchangeVersion exchangeVersion;
        private String domain;
        private String username;
        private String password;
        private String subject;
        private String recipientTo;
        private List<String> recipientCc;
        private List<String> recipientBcc;
        private List<String> attachments;
        private String message;

        public ExchangeClientBuilder() {
            this.exchangeVersion = ExchangeVersion.Exchange2010_SP1;
            this.hostname = "";
            this.username = "";
            this.password = "";
            this.subject = "";
            this.recipientTo = "";
            this.recipientCc = new ArrayList<>(0);
            this.recipientBcc = new ArrayList<>(0);
            this.attachments = new ArrayList<>(0);
            this.message = "";
        }

        /**
         * @param hostname
         * @return
         * @Desc Exchange Web服务的主机名
         */
        public ExchangeClientBuilder hostname(String hostname) {
            this.hostname = hostname;
            return this;
        }

        /**
         * @param exchangeVersion
         * @return
         * @Desc Exchange Web服务器版本。
         */
        public ExchangeClientBuilder exchangeVersion(ExchangeVersion exchangeVersion) {
            this.exchangeVersion = exchangeVersion;
            return this;
        }

        /**
         * @param domain
         * @return
         * @Desc smtp服务器的域。
         */
        public ExchangeClientBuilder domain(String domain) {
            this.domain = domain;
            return this;
        }

        /**
         * @param username
         * @return
         * @Desc MS Exchange Smtp服务器的用户名 发送用户
         */
        public ExchangeClientBuilder username(String username) {
            this.username = username;
            return this;
        }

        /**
         * @param password
         * @return
         * @Desc 发送用户的密码
         */
        public ExchangeClientBuilder password(String password) {
            this.password = password;
            return this;
        }

        /**
         * @param subject
         * @return
         * @Desc 邮件主题
         */
        public ExchangeClientBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        /**
         * @param recipientTo
         * @return
         * @Desc 收件人
         */
        public ExchangeClientBuilder recipientTo(String recipientTo) {
            this.recipientTo = recipientTo;
            return this;
        }

        /**
         * @param recipientCc
         * @param recipientsCc
         * @return
         * @Desc 抄送人
         */
        public ExchangeClientBuilder recipientCc(String recipientCc, String... recipientsCc) {
            // Prepare the list.
            List<String> recipients = new ArrayList<>(1 + recipientsCc.length);
            recipients.add(recipientCc);
            recipients.addAll(Arrays.asList(recipientsCc));
            // Set the list.
            this.recipientCc = recipients;
            return this;
        }

        /**
         * @param recipientCc
         * @return
         * @Desc 抄送人
         */
        public ExchangeClientBuilder recipientCc(List<String> recipientCc) {
            this.recipientCc = recipientCc;
            return this;
        }

        /**
         * @param recipientBcc
         * @param recipientsBcc
         * @return
         * @Desc 密送人
         */
        public ExchangeClientBuilder recipientBcc(String recipientBcc, String... recipientsBcc) {
            // Prepare the list.
            List<String> recipients = new ArrayList<>(1 + recipientsBcc.length);
            recipients.add(recipientBcc);
            recipients.addAll(Arrays.asList(recipientsBcc));
            // Set the list.
            this.recipientBcc = recipients;
            return this;
        }

        /**
         * @param recipientBcc
         * @return
         * @Desc 密送人
         */
        public ExchangeClientBuilder recipientBcc(List<String> recipientBcc) {
            this.recipientBcc = recipientBcc;
            return this;
        }

        /**
         * @param attachment
         * @param attachments
         * @return
         * @Desc 附件
         */
        public ExchangeClientBuilder attachments(String attachment, String... attachments) {
            // Prepare the list.
            List<String> attachmentsToUse = new ArrayList<>(1 + attachments.length);
            attachmentsToUse.add(attachment);
            attachmentsToUse.addAll(Arrays.asList(attachments));
            // Set the list.
            this.attachments = attachmentsToUse;
            return this;
        }

        /**
         * @param attachments
         * @return
         * @Desc 附件
         */
        public ExchangeClientBuilder attachments(List<String> attachments) {
            this.attachments = attachments;
            return this;
        }

        /**
         * @param message
         * @return
         * @Desc 邮件正文
         */
        public ExchangeClientBuilder message(String message) {
            this.message = message;
            return this;
        }

        /**
         * @return
         * @Desc 创建邮件
         */
        public ExchangeClient build() {
            return new ExchangeClient(this);
        }
    }

    /**
     * @return
     * @Desc 发送邮件
     */
    public Map<String, Object> sendExchange() {
        // Exchange服务器版本。
        ExchangeService exchangeService = new ExchangeService(exchangeVersion);

        // 要在MS Exchange服务器上签名的凭据。
        ExchangeCredentials exchangeCredentials = new WebCredentials(username, password, domain);
        exchangeService.setCredentials(exchangeCredentials);

        // 邮箱的exchange web服务的URL
        try {
            exchangeService.setUrl(new URI("https://" + hostname + "/ews/Exchange.asmx"));
        } catch (URISyntaxException ex) {
            logger.error("创建与服务端的连接发生异常", ex);
            if (exchangeService != null) {
                exchangeService.close();
            }
            return ResultUtils.getFaildResultData("创建与服务端的连接发生异常");
        }

        // 设置邮件信息
        EmailMessage emailMessage;
        try {
            emailMessage = new EmailMessage(exchangeService);
            emailMessage.setSubject(subject);
            emailMessage.setBody(MessageBody.getMessageBodyFromText(message));
        } catch (Exception ex) {
            logger.error("设置邮件发生异常", ex);
            return ResultUtils.getFaildResultData("设置邮件发生异常");
        }

        // 设置收件人
        try {
            emailMessage.getToRecipients().add(recipientTo);
        } catch (ServiceLocalException ex) {
            logger.error("设置邮件收件人发生异常.", ex);
            return ResultUtils.getFaildResultData("设置邮件收件人发生异常");
        }

        // 设置抄送人
        for (String recipient : recipientCc) {
            try {
                emailMessage.getCcRecipients().add(recipient);
            } catch (ServiceLocalException ex) {
                logger.error("设置邮件抄送人发生异常.", ex);
                return ResultUtils.getFaildResultData("设置邮件抄送人发生异常");
            }
        }

        // 设置邮件密送人
        for (String recipient : recipientBcc) {
            try {
                emailMessage.getBccRecipients().add(recipient);
            } catch (ServiceLocalException ex) {
                logger.error("设置邮件密送人发生异常.", ex);
                return ResultUtils.getFaildResultData("设置邮件密送人发生异常");
            }
        }

        // 设置附件
        for (String attachmentPath : attachments) {
            try {
                emailMessage.getAttachments().addFileAttachment(attachmentPath);
            } catch (ServiceLocalException ex) {
                logger.error("设置邮件附件发生异常", ex);
                return ResultUtils.getFaildResultData("设置邮件附件发生异常");
            }
        }

        try {
            emailMessage.send();
            logger.info("邮件发送成功.");
        } catch (Exception ex) {
            logger.error("邮件发送异常.", ex);
            return ResultUtils.getFaildResultData("邮件发送异常");
        }
        return ResultUtils.getSuccessResultData("邮件发送成功");
    }

}
