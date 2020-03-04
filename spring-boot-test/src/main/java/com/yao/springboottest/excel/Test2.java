package com.yao.springboottest.excel;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/03/03 20:54
 */
@Slf4j
public class Test2 {
    public static void main(String[] args) {
        File file = new File("/Users/yaoyao/Desktop/娜娜/11.xlsx");
        try {
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = ExcelUtil.getWorkbook(1, fis);
            Sheet sheet1 = workbook.getSheet("人员信息");
            Sheet sheet2 = workbook.getSheet("人员信息+发展人编码");
            Sheet sheet3 = workbook.getSheet("人员信息+工号");
            Set<String> set = new HashSet<>();

            List<Integer> sheetx = new ArrayList();
            for (int i = 1; i < 724; i++) {
                sheetx.add(i);
            }

            List<Integer> sheety = new ArrayList();
            for (int i = 1; i < 1496; i++) {
                sheety.add(i);
                System.out.println(i);
                String stringCellValue = sheet2.getRow(i).getCell(5).getStringCellValue();
                System.out.println(stringCellValue);
                set.add(stringCellValue);
            }

            List<Integer> sheetz = new ArrayList();
            for (int i = 1; i < 1040; i++) {
                sheetz.add(i);
            }
            System.out.println(set.size());
            fis.close();

            List<String> result = new ArrayList<>(set);
            result.forEach((k) -> {
                File filex = new File("/Users/yaoyao/Desktop/娜娜/11.xlsx");
                FileInputStream fisx = null;
                try {
                    fisx = new FileInputStream(filex);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Workbook workbookx = null;
                try {
                    workbookx = ExcelUtil.getWorkbook(1, fisx);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Sheet sheetx1 = workbookx.getSheet("人员信息");
                Sheet sheetx2 = workbookx.getSheet("人员信息+发展人编码");
                Sheet sheetx3 = workbookx.getSheet("人员信息+工号");


                try {

                    int c = 724;
                    for (int i = 1; i < c; i++) {
                        String stringCellValue = sheetx1.getRow(i).getCell(4).getStringCellValue();
                        if (!k.equals(stringCellValue)) {
//                        int lastRowNum = sheetx1.getLastRowNum();
//                        if ( i>= 0 && i < lastRowNum) {
//                            sheetx1.shiftRows(i + 1, lastRowNum, -1);
//                        }
//                        if (i == lastRowNum) {
                            sheetx1.removeRow(sheetx1.getRow(i));
//                            workbookx.write(fileOutputStreamx);
//                        }
//                        i = i-1;
//                        c = c-1;
                        } else {
                            System.out.println("保留大区1：" + k + "：" + stringCellValue);
                        }
                    }

                    int b = 1496;
                    for (int i = 1; i < b; i++) {
                        String stringCellValue = sheetx2.getRow(i).getCell(5).getStringCellValue();
                        if (!k.equals(stringCellValue)) {
//                        int lastRowNum = sheetx2.getLastRowNum();
//                        if ( i>= 0 && i < lastRowNum) {
//                            sheetx2.shiftRows(i + 1, lastRowNum, -1);
//                        }
//                        if (i == lastRowNum) {
                            sheetx2.removeRow(sheetx2.getRow(i));
//                            workbookx.write(fileOutputStreamx);
//                        }
//                        i = i-1;
//                        b = b-1;
                        } else {
                            System.out.println("保留大区2：" + k + "：" + stringCellValue);
                        }
                    }

                    int a = 1040;
                    for (int i = 1; i < a; i++) {
                        String stringCellValue = sheetx3.getRow(i).getCell(5).getStringCellValue();
                        if (!k.equals(stringCellValue)) {
//                        int lastRowNum = sheetx3.getLastRowNum();
//                        if ( i>= 0 && i < lastRowNum) {
//                            sheetx3.shiftRows(i + 1, lastRowNum, -1);
//                        }
//                        if (i == lastRowNum) {
                            sheetx3.removeRow(sheetx3.getRow(i));
//                            workbookx.write(fileOutputStreamx);
////                        }
//                            i = i - 1;
//                            a = a - 1;
                        } else {
                            System.out.println("保留大区3：" + k + "：" + stringCellValue);
                        }
                    }
                    FileOutputStream fileOutputStreamx = null;

                    fileOutputStreamx = new FileOutputStream("/Users/yaoyao/Desktop/娜娜/各单元人员信息及对应发展人编码&工号（" + k + "）.xlsx");
                    workbookx.write(fileOutputStreamx);
                    fileOutputStreamx.flush();
                    fileOutputStreamx.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
