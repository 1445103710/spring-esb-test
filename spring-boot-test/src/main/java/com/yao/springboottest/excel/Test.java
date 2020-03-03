package com.yao.springboottest.excel;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/03/03 20:54
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        File file=new File("/Users/yaoyao/Desktop/娜娜/xx1.xlsx");
        try {
            FileInputStream fis= new FileInputStream(file);
            Workbook workbook = ExcelUtil.getWorkbook(1, fis);
            Sheet sheetAt = workbook.getSheet("Sheet5");
            Map<String,Integer> map = new HashMap<String,Integer>();
            int x = 927;
            int y = 0;
            for (int i = 204; i <724 ; i++) {
                Row row = sheetAt.getRow(i);
                //System.out.println("i:"+"["+i+"]"+row.getCell(1));
                //System.out.println(row.getCell(6).getCellType().name());
                //System.out.println(row.getCell(6).getCellFormula());
                try {
                    //System.out.println(row.getCell(6).getNumericCellValue());
                    double numericCellValue = row.getCell(6).getNumericCellValue();
                    if (2.0 == numericCellValue || 2 == numericCellValue){
                        Sheet sheetAt2 = workbook.getSheet("人员信息+工号");
                        int count = 0;
                        for (int j = 1; j <924 ; j++) {
                            Row row1 = sheetAt2.getRow(j);
                            if (row.getCell(0).getStringCellValue().trim().equals(row1.getCell(0).getStringCellValue().trim())){
                                count++;
                                map.put(row.getCell(0).getStringCellValue().trim(),j);
                            }
                        }
                        //System.out.println("结束="+sheetAt2.getRow(923).getCell(1));
                        if (count==1){
                            y++;
                            //System.out.println("sss:"+row.getCell(1).getStringCellValue().trim());
                            List<String> list = new ArrayList();
                            //System.out.println(row.getCell(1));
                            Sheet sheetAt3 = workbook.getSheet("剔重工号");
                            for (int j = 1; j < 2930 ; j++) {
                                Row row1 = sheetAt3.getRow(j);
                                //System.out.println("row:"+row.getCell(0).getStringCellValue());
                                //System.out.println("row1:"+row1.getCell(0).getStringCellValue());
                                if (row.getCell(0).getStringCellValue().trim().equals(row1.getCell(0).getStringCellValue().trim())){
                                    list.add(row1.getCell(1).getStringCellValue());
                                }
                            }
                            Integer c = map.get(row.getCell(0).getStringCellValue());
                            //System.out.println(sheetAt2.getRow(c).getCell(8));
                            Row rowNew = sheetAt2.createRow(x);
                            for (int j = 0; j < 11; j++) {
                                try {
                                    if (sheetAt2.getRow(c).getCell(j)==null){
                                        //System.out.println("恐慌的");
                                    }else {
                                        if (j==2||j==10){
                                            //System.out.println(value);
                                            double numericCellValue1 = sheetAt2.getRow(c).getCell(j).getNumericCellValue();
                                            Cell cell = rowNew.createCell(j);
                                            cell.setCellValue(numericCellValue1);

                                        }else{
                                            String value = sheetAt2.getRow(c).getCell(j).getStringCellValue();
                                            Cell cell = rowNew.createCell(j);
                                            cell.setCellValue(value);
                                            if (j==8){
                                                if (list.get(0).equals(value)){
                                                    cell.setCellValue(list.get(1));
                                                }else {
                                                    cell.setCellValue(list.get(0));
                                                }
                                                //System.out.println(value);
                                            }
                                        }
                                    }

                                }catch (IllegalStateException e){
                                    e.printStackTrace();
                                    System.out.println("获取参数失败["+j+"]:"+sheetAt2.getRow(c).getCell(0).getStringCellValue());
                                }catch (Exception e){
                                    e.printStackTrace();
                                    System.out.println("222获取参数失败["+j+"]:"+sheetAt2.getRow(c).getCell(0).getStringCellValue());
                                }
                            }
                            x++;
                            //System.out.println("COUNT:"+x);
                        }else {
                            System.out.println("=============count"+count);
                            System.out.println("============="+row.getCell(0));

                            //System.out.println("sss:"+row.getCell(1).getStringCellValue().trim());
                            List<String> list = new ArrayList();
                            //System.out.println(row.getCell(1));
                            Sheet sheetAt3 = workbook.getSheet("剔重工号");
                            for (int j = 1; j < 2930 ; j++) {
                                Row row1 = sheetAt3.getRow(j);
                                //System.out.println("row:"+row.getCell(0).getStringCellValue());
                                //System.out.println("row1:"+row1.getCell(0).getStringCellValue());
                                if (row.getCell(0).getStringCellValue().trim().equals(row1.getCell(0).getStringCellValue().trim())){
                                    list.add(row1.getCell(1).getStringCellValue());
                                }
                            }

                        }

                    }

                } catch (IllegalStateException e){
                    //System.out.println("错误："+row.getCell(1).getStringCellValue());
                    //e.printStackTrace();
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/yaoyao/Desktop/娜娜/xx2.xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("y:"+y);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
