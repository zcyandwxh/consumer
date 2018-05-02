package com.consumer.controller;

import com.consumer.bean.dto.ProviderDTO;
import com.consumer.biz.BizResult;
import com.consumer.model.Product;
import com.consumer.model.Provider;
import com.consumer.service.ProductionService;
import com.consumer.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private ProductionService productionService;

    /**
     * 跳转到供应商的页面
     * @param modelMap
     * @return
     */
    @RequestMapping("provider.htm")
    public String provider(ModelMap modelMap) {
        BizResult<Map<String, List<Product>>> productDTOs = productionService.getProducts();
        modelMap.addAttribute("products", productDTOs);
        return "showProvider";
    }

    /**
     * 查询供应商
     * @return
     */
    @ResponseBody
    @RequestMapping("showProvider")
    public BizResult<List<ProviderDTO>> getProvider( @RequestParam(value = "providerName", required = false) String provoderName) {
        BizResult<List<ProviderDTO>> providerDTOS = productorService.getProvider(provoderName);
        return providerDTOS;
    }

    /**
     * 查询经销商的详细信息
     * @param providerDTO
     * @return
     */
    @RequestMapping("detail")
    @ResponseBody
    public BizResult<ProviderDTO> searchProvider(ProviderDTO providerDTO) {
        return productorService.selectProviderDetail(providerDTO);
    }

    /**
     * 删除供应商
     * @param providerDTO
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public BizResult<Integer> deleteProvider(ProviderDTO providerDTO){
        return productorService.deleteProvider(providerDTO);
    }

    /**
     * 新增供应商
     * @param providerDTO
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public BizResult<Boolean> addProvider(@RequestBody ProviderDTO providerDTO){
        return productorService.addProvider(providerDTO);
    }

}
