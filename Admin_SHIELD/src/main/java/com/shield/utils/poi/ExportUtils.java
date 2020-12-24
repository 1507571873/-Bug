package com.shield.utils.poi;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class ExportUtils {

    public static void exportUtils(List<?> data, Class clazz, HttpServletResponse response) throws Exception {
        //获取对象中注解的信息
        PoiBean poiBean = getPoiBean(clazz);
        exportExcel(data,poiBean,response);
    }


    public static void exportExcel(List<?> data, PoiBean poiBean, HttpServletResponse response) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(poiBean.getSheetName());

        //获取样式
        XSSFCellStyle titleStyle = PoiCellStyle.titleStyle(workbook);
        XSSFCellStyle columnStyle = PoiCellStyle.columnStyle(workbook);
        XSSFCellStyle dataStyle = PoiCellStyle.dataStyle(workbook);

        //创建标题行
        XSSFRow titleRow = sheet.createRow(0);
        List<String> columnNames = poiBean.getColumnNames();
        CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, columnNames.size() - 1);
        sheet.addMergedRegion(cellRangeAddress);
        XSSFCell titleCell = titleRow.createCell(0);
        titleCell.setCellValue(poiBean.getTitle());
        titleCell.setCellStyle(titleStyle);

        //创建表头行
        XSSFRow columnRow = sheet.createRow(1);
        for (int i = 0; i < columnNames.size(); i++) {
            XSSFCell columnCell = columnRow.createCell(i);
            columnCell.setCellValue(columnNames.get(i));
            columnCell.setCellStyle(columnStyle);
        }

        //创建数据行
        List<String> fieldList=poiBean.getFieldNames();
        for (int i = 0; i < data.size(); i++) {
            Object obj = data.get(i);
            Class clazz = obj.getClass();
            XSSFRow dataRow= sheet.createRow(i+2);
            for (int j=0;j<fieldList.size();j++){
                String fieldName=fieldList.get(j);
                String methodName=getMethod(fieldName);
                Method method =obj.getClass().getMethod(methodName);
                Object objData = method.invoke(obj);
                XSSFCell dataCell = dataRow.createCell(j);
                if (objData instanceof Date){
                    Field field = clazz.getDeclaredField(fieldName);
                    ExcelFieldDescribeAnno annotation = field.getAnnotation(ExcelFieldDescribeAnno.class);
                    String pattern = annotation.patten();
                    String strDate= DateFormatUtils.format((Date) objData,pattern);
                    dataCell.setCellValue(strDate);
                }else {
                    dataCell.setCellValue(String.valueOf(objData));
                }
                dataCell.setCellStyle(dataStyle);
            }
        }
        for (int i = 0; i < fieldList.size(); i++) {
            sheet.autoSizeColumn((short) i);
            // 解决自动设置列宽中文失效的问题
            sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 17 / 10);
        }
        //导出
        response.setContentType("application/octet-stream");
        //默认Excel名称
        response.setHeader("Content-Disposition", "attachment;fileName=" + UUID.randomUUID().toString() + ".xlsx");
        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getMethod (String fieldName){
        return "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
    }

    public static PoiBean getPoiBean(Class clazz) {
        PoiBean poiBean = new PoiBean();
        //获取类上面的注解
        ExcelDescribeAnon excelDescribeAnon = (ExcelDescribeAnon) clazz.getAnnotation(ExcelDescribeAnon.class);
        poiBean.setTitle(excelDescribeAnon.title());
        poiBean.setSheetName(excelDescribeAnon.sheetName());

        //获取属性
        Field[] fields = clazz.getDeclaredFields();
        List<String> columnNames = new ArrayList<>();
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields) {
            fieldNames.add(field.getName());
            //获取注解
            ExcelFieldDescribeAnno annotation = field.getAnnotation(ExcelFieldDescribeAnno.class);
            columnNames.add(annotation.columnName());
        }
        poiBean.setColumnNames(columnNames);
        poiBean.setFieldNames(fieldNames);
        return poiBean;
    }
}
