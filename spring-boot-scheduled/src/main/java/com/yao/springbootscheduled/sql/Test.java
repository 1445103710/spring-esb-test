package com.yao.springbootscheduled.sql;

import ru.yandex.clickhouse.ClickHouseConnectionImpl;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.settings.ClickHouseProperties;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/04/27 09:46
 */
public class Test {
    private static ClickHouseProperties properties;
    static {
        properties=new ClickHouseProperties();
        properties.setUser("default");
        properties.setPassword("12345678");
        properties.setDatabase("ods");
    }


    public static void main(String[] args) {
        //会员用例
        String sql=" select member_id,name,id_card,mobile from ehr_user "
                //+ " where source_id = ? and create_time > '?' and create_time < '?' ";
        + "where create_time > ? and create_time < ? ";
        Integer [] arr=new Integer[]{1,12,15};
        String starttime = "2019-07-04 20:26:33";
        String endtime = "2019-07-05 20:26:33";
        ExcuteSQl(sql,arr,starttime,endtime);
    }

    private static void ExcuteSQl(String sql, Integer[] intArray,String starttime,String endtime) {
        ClickHouseConnectionImpl connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ClickHouseDataSource dataSource = new ClickHouseDataSource("jdbc:clickhouse://116.196.88.160:8123",properties);
            connection = (ClickHouseConnectionImpl) dataSource.getConnection();
            if(connection!=null) {
                System.out.println("Successful connection");
            }
            ps= connection.prepareStatement(sql);
            ps.setString(1,starttime);
            ps.setString(2, endtime);
//            for(int i=3;i<intArray.length+3;i++) {
//                ps.setInt(i, intArray[i-3]);
//            }
            long begin = System.currentTimeMillis();
            rs = ps.executeQuery();
            long end= System.currentTimeMillis();
            System.out.println("Execution time : "+(end-begin)+"ms");
            ResultSetMetaData rsmd = rs.getMetaData();
            List<Map<String, String>> list = new ArrayList<Map<String, String>>();
            while (rs.next()) {
                Map<String, String> map = new HashMap<String, String>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    map.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
                }
                list.add(map);

            }
            for(Map<?, ?> map : list){
                System.out.println(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {//关闭连接
            try {
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getStringFromArray(Object ... objects ) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objects.length; i++) {
            if(i == objects.length - 1) {
                sb.append(objects[i]);
            }else {
                sb.append(objects[i]).append(",");
            }
        }
        return sb.toString().trim();
    }
}
