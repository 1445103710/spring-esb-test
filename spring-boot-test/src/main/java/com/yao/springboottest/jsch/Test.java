package com.yao.springboottest.jsch;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/05/14 18:04
 */
public class Test {
    public static void main(String[] args) {
        String a = "2003年参演中国首部犯罪题材的电视剧《拯救少年犯》 [17]  ，该剧由10个故事组成，文章是其中一个故事的男主角。\n" +
                "2004年参演叶京导演，改编自王朔小说的电视剧《与青春有关的日子》 [18]  ，剧中文章饰演卓越一角，开始在影视圈崭露头角 [1]  。\n" +
                "2005年拍摄第一部古装剧《锦衣卫》，该剧由张黎导演\n" +
                "电视剧《奋斗》剧照\n" +
                "电视剧《奋斗》剧照(19张)\n" +
                " 。\n" +
                "2006年自中央戏剧学院毕业；与佟大为、马伊琍等人合作，出演赵宝刚执导的电视剧《奋斗》 [19]  ；11月赴深圳龙岗拍摄以反洗黑钱为题材的电视剧《暗流》 [20]  。\n" +
                "2007年主演的电视剧《奋斗》在全国各地方电视台播出 [21]  ，剧中文章饰演的向南是个懦弱的小男人；同年主演首部电影《走着瞧》，该片入围了第21届东京国际电影节“亚洲风”单元 [22]  以及第12届上海国际电影节新片展映单元 [23]  。\n" +
                "2008年在电视剧《蜗居》中饰演温柔执着，却又不失理性的80后城市青年小贝 [1]  [3]  。\n" +
                "2009年出演文艺片《海洋天堂》，饰演自闭症患者王大福；同年参与拍摄抗战题材的电视剧《雪豹》，与朱杰饰演一对情侣 [4]  ；6月，凭借电影《走着瞧》获得第12届上海国际电影节电影频道传媒大奖最受媒体关注新人男演员奖 [24]  。\n" +
                "2010年6月，主演的电视剧《雪豹》在北京地方台夺得收视冠军，随后在其他各地方台播出；10月8\n" +
                "《失恋33天》饰演王小贱\n" +
                "《失恋33天》饰演王小贱(10张)\n" +
                " 日，该剧在四川卫视首播 [25]  ；剧中文章突破其以往塑造的幽默贫嘴的男孩形象，成功塑造了男主角周卫国冷静沉稳、刚毅果敢的人物形象 [26]  。\n" +
                "2011年6月11日，主演的电视剧《裸婚时代》在各大卫视开播，开播第一周已成为全国同时段收视冠军 [5]  [27]  ；11月6日，参加电影《失恋33天》首映仪式 [28]  ；11月8日，主演的电影《失恋33天》在全国上映；该片上映4天票房突破1亿元，首周票房超过1.5亿元； [29]  11月16日，参加电影《失恋33天》票房过两亿的庆功答谢会 [30]  ；同年凭借电影《海洋天堂》获得第14届中国电影华表奖优秀新人男演员以及第18届北京大学生电影节最受大学生欢迎男演员奖 [6]  [31]  ；12月21日，《失恋33天》在全国各大院线正式下线，这部投资成本不足千万的电影，最终获得了3.5亿的票房。 [32] \n" +
                "2012年9月29日，凭借电影《失恋33天》获得第31届大众电影百花奖最佳男主角奖 [8]  ；同年成立自己经营的影视工作室—北京君竹影视文化有限公司，并参与投资制作第一部影视作品《小爸爸》。 [33] \n" +
                "2013年2月10日，由文章主演，周星驰执导的电影《西游·降魔篇》在全国上映 [9]  ，该片全球票房破2.15亿美元，打破华语片票房纪录 [34]  ；9月2日文章首部导演作品《小爸爸》完成制作，在东方、浙江、深圳、陕西四大卫视并同步优酷、土豆网双平台首播 [35]  ；9月参演姜文执导的动作喜剧《一步之遥》 [36]  ；11月凭借抗战剧《雪豹》中的演出获得第12届四川电视节金熊猫奖长篇电视剧类最佳男演员奖， [37]  这是他获得的第一个电视剧类专业个人表演奖项。\n" +
                "2014年3月28日，文章主演的中韩合资文艺爱情片《我在路上最爱你》\n" +
                "电视剧《裸婚时代》剧照\n" +
                "电视剧《裸婚时代》剧照(13张)\n" +
                " 在全国上映 [38]  ；9月1日，文章出席电影《一步之遥》首映礼倒计时100天活动 [39]  ；12月18日，与姜文主演的电影《一步之遥》在全国上映，在片饰演“武七”一角 [40]  。\n" +
                "2015年7月，文章执导的首部大银幕作品《陆垚知马俐》已经在上海低调开机 [41]  。\n" +
                "2016年1月11日，文章主演的年代剧《少帅》在北京卫视和东方卫视首播。 [42]  4月，自导自演谍战剧《剃刀边缘》 [12]  。7月15日，文章执导电影《陆垚知马俐》上映 [43]  。7月29日，参演电影《封神传奇》上映 [44]  。10月17日，客串包贝尔执导的微笑喜剧《欢喜密探》上线播出 [45-46]  。\n" +
                "2017年3月2日，凭借《少帅》获得2017中国电视剧品质盛典年度品质表演剧星 [47]  ；3月20日，文章执导并参演的《剃刀边缘》在东方卫视和北京卫视播出。 [48]  11月11日，指导的由马云、甄子丹、吴京、邹市明主演的微电影《功守道》上映。";
        String root = connectAndExecute("root", "47.95.120.202", "YN1261314Xnn#", 22,"echo '"+a+"'");
        System.out.println(root);
    }

    public static String connectAndExecute(String user, String host, String password, int port, String command1) {
        String CommandOutput = null;
        try {

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();

            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command1);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();

            channel.connect();
            CommandOutput = new BufferedReader(new InputStreamReader(in))
                    .lines().collect(Collectors.joining(System.lineSeparator()));
            channel.disconnect();
            session.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommandOutput;

    }
}
