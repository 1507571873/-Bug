package com.shield.controller;

import com.alibaba.fastjson.JSON;
import com.shield.aop.LogsAnnotation;
import com.shield.model.User;
import com.shield.service.UserService;
import com.shield.utils.CommonsReturn;
import com.shield.utils.RedisUtils;
import com.shield.utils.ReturnCode;
import com.shield.utils.SubjectUtils;
import com.shield.utils.poi.ExportUtils;
import com.shield.utils.poi.poiBean.UserPoiModel;
import com.shield.vo.SeachBean;
import com.shield.vo.UserVo;
import freemarker.core.ReturnInstruction;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


/**
 * @author UserController
 */
@Controller
@RequestMapping("UserController")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisUtils redisUtils;

    private static String searchKey="SHIELD_SHEARCH:";

    /**
     * 查询数据
     *
     * @return UserVo
     */
    @RequestMapping("queryUserTable")
    @ResponseBody
    @LogsAnnotation("用户信息分页查询")
    public UserVo queryUserTable(UserVo userVo) {
        redisUtils.setExpire(SubjectUtils.getKeyAndUserName(searchKey),userVo);
        return userService.queryUserTable(userVo);
    }

    /**
     * 查询学历下拉框
     *
     * @return List<Map < String, Object>>
     */
    @RequestMapping("queryEduList")
    @ResponseBody
    @LogsAnnotation("查询学历下拉框")
    public List<Map<String, Object>> queryEduList() {
        return userService.queryEduList();
    }

    //省
    @RequestMapping("queryProvinceList")
    @ResponseBody
    @LogsAnnotation("查询省下拉框")
    public List<Map<String, Object>> queryProvinceList() {
        return userService.queryProvinceList();
    }

    //市
    @RequestMapping("queryCityList")
    @ResponseBody
    @LogsAnnotation("查询市下拉框")
    public List<Map<String, Object>> queryCityList(String code_p) {
        return userService.queryCityList(code_p);
    }

    //县
    @RequestMapping("queryAreaList")
    @ResponseBody
    @LogsAnnotation("查询县下拉框")
    public List<Map<String, Object>> queryAreaList(String code_c) {
        return userService.queryAreaList(code_c);
    }

    /**
     * 新增的方法
     *
     * @return String
     */
    @RequestMapping("addUserData")
    @ResponseBody
    @LogsAnnotation("用户新增的方法")
    public String addUserData(User user) {
        userService.addUserData(user);
        return "success";
    }

    /**
     * 修改的方法
     *
     * @return String
     */
    @RequestMapping("updateUserData")
    @ResponseBody
    @LogsAnnotation("用户修改的方法")
    public String updateUserData(User user) {
        userService.updateUserData(user);
        return "success";
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping("queryUserById")
    @ResponseBody
    public CommonsReturn queryUserById(Integer id) {
        User user = userService.queryUserById(id);
        return CommonsReturn.success(ReturnCode.SUCCESS, user);
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("removeUser")
    @ResponseBody
    @LogsAnnotation("用户删除的方法")
    public Map<String,Object> removeUser(Integer id){
        Map<String,Object> map = new HashMap<>();
        userService.removeUser(id);
        map.put("code",400);
        return map;
    }

    /**
     * plsc
     * @param ids
     * @return
     */
    @RequestMapping("deleteBatchUserData")
    @ResponseBody
    @LogsAnnotation("用户批量删除的方法")
    public Map<String,Object> deleteBatchUserData(Integer[] ids){
        Map<String,Object> map = new HashMap<>();
        userService.deleteBatchUserData(ids);
        map.put("code",400);
        return map;
    }

    @RequestMapping("exportUser")
    @ResponseBody
    public void exportUser(HttpServletResponse response) throws Exception {
        UserVo userVo = (UserVo) redisUtils.get(SubjectUtils.getKeyAndUserName(searchKey));
        //查询数据
        List<UserPoiModel> list = userService.queryExportUser(userVo);
        //到出数据
        ExportUtils.exportUtils(list,UserPoiModel.class,response);
    }

    @RequestMapping("importExcel")
    @ResponseBody
    public CommonsReturn importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        //把上传的Excel文件读取到
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        //读完之后放到list集合里
        List<UserPoiModel> userModel = new ArrayList<>();
        //首先读sheet页
        //int numberOfSheets = workbook.getNumberOfSheets(); 读取多个sheet页
        XSSFSheet sheet =workbook.getSheetAt(0);
        int lastRowNum=sheet.getLastRowNum();//获取第一行
        int firstRowNum=sheet.getFirstRowNum();//获取最后一行
        for(int i=1;i<lastRowNum;i++){
            UserPoiModel user = new UserPoiModel();
            //获取行
            XSSFRow dataRow =  sheet.getRow(i);
            //获取单元格
            XSSFCell cellName=dataRow.getCell(0);
            String name =String.valueOf(getValueByType(cellName)) ;
            user.setRealName(name);

            XSSFCell cellSex=dataRow.getCell(1);
            user.setSexName(String.valueOf(getValueByType(cellSex)));

            XSSFCell cellBarthdy=dataRow.getCell(2);
            user.setBirthday((Date) getValueByType(cellBarthdy));

            XSSFCell cellEdu=dataRow.getCell(3);
            user.setEduName(String.valueOf(getValueByType(cellEdu)));

            XSSFCell cellPhone=dataRow.getCell(4);
            user.setPhone(String.valueOf(getValueByType(cellPhone)));

            XSSFCell cellEmail=dataRow.getCell(5);
            user.setEmail(String.valueOf(getValueByType(cellEmail)));

            userModel.add(user);

        }
        System.out.println(JSON.toJSONString(userModel));
        return CommonsReturn.success();
    }

    public static Object getValueByType(XSSFCell cell){
        Object obj = null;
        switch (cell.getCellType()){
            case XSSFCell.CELL_TYPE_STRING:
                obj=cell.getStringCellValue();
                break;
            case XSSFCell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)){
                    obj=cell.getDateCellValue();
                }else{
                    obj=cell.getNumericCellValue();
                }
                break;
            default:
                obj="未知类型";
                break;
        }
        return obj;
    }
    //--------------------人事管理 ------------------ 根据ID查询--------------------------
    @RequestMapping("queryUserInfoById")
    @ResponseBody
    public CommonsReturn queryUserInfoById(Integer userId){
        UserVo userVo = userService.queryUserInfoById(userId);
        return CommonsReturn.success(userVo);
    }


}
