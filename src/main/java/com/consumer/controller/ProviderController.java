package com.consumer.controller;

import com.consumer.bean.dto.ProviderDTO;
import com.consumer.biz.BizResult;
import com.consumer.model.Provider;
import com.consumer.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/1 
 * @since V1.0
 *  
 */
@Controller
@RequestMapping("provider")
public class ProviderController {

    @Autowired
    private ProviderService productorService;

    @ResponseBody
    @RequestMapping("showProvider.htm")
    public String getProviders(ModelMap modelMap) {
        BizResult<List<ProviderDTO>> providerDTOS = productorService.getProvider();
        modelMap.addAttribute("providers", providerDTOS);
        return "showProvider";
    }

    public BizResult<List<Provider>> searchProvider(ProviderDTO providerDTO) {
//        productorService.
        return null;
    }

}
