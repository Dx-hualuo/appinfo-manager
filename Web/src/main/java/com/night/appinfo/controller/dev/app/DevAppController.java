package com.night.appinfo.controller.dev.app;

import com.night.appinfo.service.dev.user.DevUserService;
import com.night.appinfo.util.Page;
import com.night.appinfo.entity.AppInfo;
import com.night.appinfo.vo.AppListParameter;
import com.night.appinfo.vo.JsonData;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import com.night.appinfo.service.dev.appinfo.DevAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 *  开发者后台Controller
 * @author night
 */
@Controller
@SessionAttributes(DevUserService.DEV_USER)
public class DevAppController {
    /**
     *  Service 注入
     */
    @Autowired
    private DevAppService appService;

    /**
     *  进入app维护并且查询全部信息
     * @return 维护路径
     */
    @RequestMapping("/dev/appInfo")
    public String allApp(Model model, AppInfo info, Page<AppInfo> page, AppListParameter parameter){
        parameter.fullAppInfo(info);
        model.addAttribute("categoryLevel1List", appService.queryAppCategoryLevel1());
        model.addAttribute("flatFormList", appService.queryAllAppFlatform());
        model.addAttribute("statusList", appService.queryAllAppStatus());
        model.addAttribute("pages",appService.queryAppInfoPagination(info, page));
        model.addAttribute("param", parameter);
        return "developer/appinfolist";
    }

    /**
     *  添加AppInfo View
     * @return 添加App页面
     */
    @RequestMapping("/dev/appInfo/add")
    public String toAddAppInfo(){
        return "developer/appinfoadd";
    }

    @PostMapping("/dev/appInfo/add/save")
    public String addAppInfo(AppInfo appInfo, MultipartFile aLogoPicPath){

        return "developer/appinfoadd";
    }

    //---JSON---*******************************************************************************************************************************************************

    /**
     *  查询指定父Id下的子分类
     * @param fatherId 父级id
     * @return JsonData 前端数据
     *      data{
     *          data: List<AppCategory> 父Id下的子分类
     *      }
     */
    @ResponseBody
    @GetMapping("/dev/appInfo/levelList")
    public JsonData levelList(Long fatherId){
        JsonData jsonData = new JsonData();
        jsonData.setData(appService.queryAppCategoryListByFatherId(fatherId));
        return jsonData;
    }

    /**
     *  更改销售开关
     * @return JsonData 前端数据
     *      data{
     *           errorCode:
     *               0               成功
     *               exception000001 系统异常
     *               param000001     参数错误
     *           message:
     *               success         成功
     *               failed          失败
     *      }
     */
    @ResponseBody
    @GetMapping("/dev/appInfo/saleStatusChange/{appId}")
    public JsonData saleStatusChange(@PathVariable String appId){
        JsonData jsonData = new JsonData();
        long id;
        try{
            id = Long.parseLong(appId);
        }catch (Exception e){
            return new JsonData().setErrorCode("param000001");
        }
        //更新App状态
        if (appService.changeAppStatus(id)) {
            jsonData.setErrorCode("0");
            jsonData.setMessage("success");
        }else {
            jsonData.setMessage("failed");
            jsonData.setErrorCode("failed");
        }
        return jsonData;
    }

    /**
     *  判断Apk名字是否存在
     * @param apkName ApkName
     * @return JsonData 前端数据
     *      data{
     *          message:
     *              empty   ApkName为空
     *              exist   ApkName已存在
     *              noexist ApkName不存在
     *      }
     */
    @ResponseBody
    @GetMapping("/dev/appInfo/apkName/exist")
    public JsonData apkNameIsExist(@RequestParam("name") String apkName){
        //判断参数非空
        if(apkName == null || "".equals(apkName.trim())){
            return new JsonData().setMessage("empty");
        }
        //调用Service判断
        if(appService.apkNameIsExist(apkName)){
            return new JsonData().setMessage("exist");
        }else{
            return new JsonData().setMessage("noexist");
        }
    }

    /**
     *  根据指定typeCode查询数据字典
     * @param typeCode 类型代码
     * @return JsonData 前端数据
     *      data{
     *          data: List<DataDictionary> 符合条件的数据字典结果
     *      }
     */
    @ResponseBody
    @GetMapping("/dev/appInfo/dataDictionary/{typeCode}")
    public JsonData dataDictionary(@PathVariable String typeCode){
        return new JsonData().setData(appService.queryDataDictionaryByTypeCode(typeCode));
    }
}
