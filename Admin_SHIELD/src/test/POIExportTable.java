import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class POIExportTable {

    public static void main(String[] args) throws IOException {
        List<Student> list =  studentList();
        String title = "学生信息";
        String[] columns={"姓名","年龄","性别","生日"};
        //生成Excel   ||重点 对二维数组的理解 ||
        String filePath="D:\\FHWork\\ExcelTest\\student1.xlsx";
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建sheet页
        XSSFSheet sheet = workbook.createSheet(title);

        XSSFCellStyle titleStyle =createTitleStyle(workbook);
        XSSFCellStyle clomunRowStyle =createColumnStyle(workbook);
        XSSFCellStyle dataStyle =createDataStyle(workbook);
        //标题行
        //创建头部 此时需要进行行合并
        XSSFRow titleRow = sheet.createRow(0);
        //行合并                                                  开始行     结束行    开始列     结束列
        CellRangeAddress cellRangeAddress =new CellRangeAddress(0,0,0,columns.length-1);
        //在sheet页执行 合并
        sheet.addMergedRegion(cellRangeAddress);
        //创建单元格
        XSSFCell titleCell = titleRow.createCell(0);
        //给单元格赋值
        titleCell.setCellValue(title);
        titleCell.setCellStyle(titleStyle);

        //创建头部行
        XSSFRow clomunRow = sheet.createRow(1);

        for (int i=0; i<columns.length;i++ ){
            XSSFCell cell = clomunRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(clomunRowStyle);
        }

        //创建数据行
        for (int i = 0 ; i < list.size();i++){
            //这一行从i+2 开始 因为标题和头部占了两行 此时数据行从第3行开始
            XSSFRow dataRow = sheet.createRow(i+2);
            Student student = list.get(i);
            //创建nema的单元格
            XSSFCell nameCell = dataRow.createCell(0);
            nameCell.setCellValue(student.getName());//赋值
            nameCell.setCellStyle(dataStyle);
            //创建age的单元格
            XSSFCell ageCell = dataRow.createCell(1);
            ageCell.setCellValue(student.getAge());//赋值
            ageCell.setCellStyle(dataStyle);
            //创建sex的单元格
            XSSFCell sexCell = dataRow.createCell(2);
            sexCell.setCellValue(student.getSex());//赋值
            sexCell.setCellStyle(dataStyle);
            //创建birthdy的单元格
            XSSFCell birthdyCell = dataRow.createCell(3);
            birthdyCell.setCellValue(student.getBirthdy());//赋值
            birthdyCell.setCellStyle(dataStyle);
        }
        //输出流
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        //输出workbook
        workbook.write(fileOutputStream);
        //关流
        fileOutputStream.close();
    }

    public static List<Student> studentList(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三",12,"男",new Date()));
        list.add(new Student("张三",12,"男",new Date()));
        list.add(new Student("张三",12,"男",new Date()));
        list.add(new Student("张三",12,"男",new Date()));
        list.add(new Student("张三",12,"男",new Date()));
        list.add(new Student("张三",12,"男",new Date()));
        return list;
    }

    //excell的样式
    public static XSSFCellStyle createTitleStyle(XSSFWorkbook workbook){
        XSSFCellStyle cellStyle=workbook.createCellStyle();
        //字体的样式
        XSSFFont font=workbook.createFont();
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints((short)24);
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyle.setFont(font);
        return cellStyle;
    }

    //excell的样式
    public static XSSFCellStyle createColumnStyle(XSSFWorkbook workbook){
        XSSFCellStyle cellStyle=workbook.createCellStyle();
        //字体的样式
        XSSFFont font=workbook.createFont();
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints((short)16);
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyle.setFont(font);
        cellStyle.setBorderBottom((short)1);
        cellStyle.setBorderTop((short)1);
        cellStyle.setBorderLeft((short)1);
        cellStyle.setBorderRight((short)1);
        return cellStyle;
    }

    //excell的样式
    public static XSSFCellStyle createDataStyle(XSSFWorkbook workbook){
        XSSFCellStyle cellStyle=workbook.createCellStyle();
        //字体的样式
        XSSFFont font=workbook.createFont();
        // font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints((short)14);
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyle.setFont(font);
        cellStyle.setBorderBottom((short)1);
        cellStyle.setBorderTop((short)1);
        cellStyle.setBorderLeft((short)1);
        cellStyle.setBorderRight((short)1);
        return cellStyle;
    }
    //excell的样式
    public static XSSFCellStyle createDataForDateStyle(XSSFWorkbook workbook){
        XSSFCellStyle cellStyle=workbook.createCellStyle();
        //字体的样式
        XSSFFont font=workbook.createFont();
        // font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints((short)14);
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyle.setFont(font);
        cellStyle.setBorderBottom((short)1);
        cellStyle.setBorderTop((short)1);
        cellStyle.setBorderLeft((short)1);
        cellStyle.setBorderRight((short)1);
        DataFormat dataFormat=workbook.createDataFormat();
        cellStyle.setDataFormat(dataFormat.getFormat("yyyy-MM-dd"));
        return cellStyle;
    }

}
