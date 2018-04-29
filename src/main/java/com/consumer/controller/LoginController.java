package com.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.consumer.bean.dto.EmployeeDTO;
import com.consumer.biz.BizResult;
import com.consumer.model.Product;
import com.consumer.service.LoginService;
import com.consumer.service.ProductionService;
import com.util.MD5Util;
import com.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Map;

/**
 *   
 * <p>登录管理控制层</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/2/9 
 * @since V1.0
 *  
 */
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private ProductionService productionService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("page.htm")
    public String mainPage(Map map){
        map.put("family", "Open+Sans");
        return "login";
    }

    /**
     * 进行登录
     * @param employeeDTO
     * @param
     * @return
     */
    @RequestMapping(value = "login.htm")
    public ModelAndView login(EmployeeDTO employeeDTO) {

        BizResult<EmployeeDTO> emp = new BizResult<>();

        ModelMap modelMap = new ModelMap();
        ModelAndView modelAndView = new ModelAndView();
        if (null == employeeDTO || null == employeeDTO.getName() || null == employeeDTO.getPassword()) {
            emp.setFlag(false);
            emp.setDesc("登录失败");
            modelAndView.setViewName("login");
            modelAndView.addObject("bizResult", JSON.toJSONString(emp));
            return modelAndView;
        }
        log.info("登录的用户名和密码：{}", employeeDTO);
        String password = employeeDTO.getPassword();
        String md5Password = MD5Util.GetMD5Code(password);
        employeeDTO.setPassword(md5Password);
        emp = loginService.login(employeeDTO);
        if (!emp.getFlag()) {
            modelAndView.setViewName("login");
            return modelAndView;
        }
        if (emp != null) {
            employeeDTO.setLoginTime(emp.getData().getLoginTime());
        }
        String json = JSON.toJSONString(employeeDTO);
        log.info(json);
        redisUtil.set(json);
        BizResult<Map<String, List<Product>>> productDTOs = productionService.getProducts();
        modelAndView.setViewName("index");
        modelMap.addAttribute(json);
        modelAndView.getModelMap().addAttribute("employee" ,employeeDTO)
                .addAttribute("products", productDTOs);
        return modelAndView;
    }

    /**
     * 进行登出操作
     * @return
     */
    @RequestMapping("login")
    public String logout(){
        redisUtil.delete();
        return "login";
    }
}
