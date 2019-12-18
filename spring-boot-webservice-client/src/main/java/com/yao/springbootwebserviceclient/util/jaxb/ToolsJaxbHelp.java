package com.yao.springbootwebserviceclient.util.jaxb;


import com.sun.tools.xjc.XJCBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * @author yaoyao
 * @version 1.0
 * @taskId:
 * @createDate 2019/03/25 15:26
 */
public class ToolsJaxbHelp {

    private static Logger logger = LogManager.getLogger(ToolsJaxbHelp.class);

    public static String generatedCmd_javac_d = "-d";
    public static String generatedCmd_javac_p = "-p";

    public static void transformXSD2java(String xsdPath, String sourcePath, String packageName) {
        String[] cmdLine = new String[5];
        cmdLine[0] = xsdPath;
        cmdLine[1] = generatedCmd_javac_d;
        cmdLine[2] = sourcePath;
        cmdLine[3] = generatedCmd_javac_p;
        cmdLine[4] = packageName;
        try {
            //创建执行xsd转java文件
            XJCBase xjcBase = new XJCBase();
            logger.info(Arrays.toString(cmdLine));
            xjcBase.options.parseArguments(cmdLine);
            xjcBase.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
