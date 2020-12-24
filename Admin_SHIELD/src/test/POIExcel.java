import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class POIExcel {

    public static void main(String[] args) throws IOException {
        //文件路径
        String filePath="D:\\FHWork\\ExcelTest\\student.xlsx";
        /*
        文件格式 .xlsx 新版  XSSFWorkbook
        文件格式.xls   旧版  HSSFWorkbook
         */
        //创建工作簿  相当于在桌面 右击鼠标新建Excel
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建Sheet 页 参数可以指定sheet页名称
        XSSFSheet sheet = workbook.createSheet("学生信息");
        //创建行  参数是创建从第几行开始 值为下标 下标从0开始  下标0 就是第一行
        XSSFRow row = sheet.createRow(0);
        //创建列   cell单元格 0就是第一个单元格
        XSSFCell cell =row.createCell(0);
        //给单元格赋值
        cell.setCellValue("张三");
        //输出流
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        //输出workbook
        workbook.write(fileOutputStream);
        //关流
        fileOutputStream.close();

        /*
        第一步 创建工作簿
        第二部 创建sheet页面 可以自定义名称
        第三步 创建行
        第四步 创建单元格
        第五步 给单元格赋值
        第六步 通过输出流 吧workbook 写到本地指定的目录下
        第七步 关流
         */
    }
}
