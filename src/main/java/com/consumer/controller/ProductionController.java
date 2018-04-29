package com.consumer.controller;

import com.consumer.bean.dto.*;
import com.consumer.bean.form.PaymentForm;
import com.consumer.bean.form.StockForm;
import com.consumer.biz.BizResult;
import com.consumer.biz.PageResult;
import com.consumer.model.Employee;
import com.consumer.model.PaymentRelation;
import com.consumer.model.Product;
import com.consumer.service.PaymentService;
import com.consumer.service.ProductionService;
import com.consumer.service.StockService;
import com.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("production")
@Slf4j
public class ProductionController {

    @Autowired
    private ProductionService productionService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private StockService stockService;
    @Autowired
    private PaymentService paymentService;

//    @ModelAttribute
//    public void setUser(Map<String, Employee> map){
//        if (null == redisUtil.getUser()) {
//            BizResult<Map<String, List<String>>> result = new BizResult<>();
//            result.setDesc("用户未登录");
//            result.setData(null);
//            result.setFlag(false);
//            return "login";
//        }
//    }

    /**
     * 显示产品内容 TODO 后期使用ajax优化，现有jquery版本太低
     * @return
     */
    @RequestMapping("content")
    @ResponseBody
    public BizResult<Map<String, List<Product>>> showProduct(){
        BizResult<Map<String, List<Product>>> productDTOs = productionService.getProducts();
        return productDTOs;
    }

    /**
     * 根据类别查看原料
     * @param kind
     * @param modelMap
     * @return
     */
    @RequestMapping("product/{kind}")
//    @RequiresRoles("admin")
    public String showMaterial(@PathVariable("kind") Long kind, ModelMap modelMap, @RequestParam(defaultValue = "1") Integer pageNo) {
        if (null == redisUtil.getUser()) {
            BizResult<Map<String, List<String>>> result = new BizResult<>();
            result.setDesc("用户未登录");
            result.setData(null);
            result.setFlag(false);
            return "login";
        }
        BizResult<Map<String, List<Product>>> productDTOs = productionService.getProducts();
        modelMap.addAttribute("products", productDTOs)
        .addAttribute("employee", redisUtil.getUser());
        BizResult<PageResult<List<ProductDTO>>> productDTOS = productionService.findProductByKind(kind, pageNo);
        if (productDTOS.getFlag()) {
            modelMap.addAttribute("productDTOS", productDTOS.getData());
        }
        return "/material";
    }

    @RequestMapping("stock")
    public String inStock(StockForm stockForm){
        return "stock";
    }

    /**
     * 库存报表接口
     * @return
     */
    @RequestMapping("stockProduct")
    public BizResult<List<StockDTO>> stokcProduct() {
        return stockService.findProductInStockByPage();
    }

    /**
     * 将商品添加进购物车
     * @param productDTO
     * @return
     */
    @RequestMapping("shopCart")
    @ResponseBody
    public BizResult<Integer> addToShopCart(@RequestBody ProductDTO productDTO) {
        BizResult<Integer> products = productionService.addProduct(productDTO);
        return products;
    }

    /**
     * 显示购物车内商品
     * @param modelMap
     * @return
     */
    @RequestMapping("show/shopCart")
    public String showShopCart(ModelMap modelMap){
        Employee employee = redisUtil.getUser();
        if (employee == null) {
            return "login";
        }
        BizResult<Map<String, List<Product>>> productDTOs = productionService.getProducts();
        modelMap.addAttribute("products", productDTOs);
        modelMap.addAttribute("employee", employee);
        BizResult<List<ShopCartDTO>> shopCarts = productionService.findShopCart(employee.getId());
        modelMap.addAttribute("shopCarts", shopCarts);
        return "shopCart";
    }

    /**
     * 结算
     * @param paymentForm
     * @param modelMap
     * @return
     */
    @RequestMapping("payment")
    public String payment(PaymentForm paymentForm, ModelMap modelMap) {
        BizResult<String> bizResult = paymentService.addPayment(paymentForm.getList());
        modelMap.addAttribute("paymentNo", bizResult);
        return "payment";
    }

    /**
     * 显示结算单内商品
     * @param patmentNo
     * @return
     */
    @RequestMapping("show/paymentDetail")
    public String findAllPayment(String patmentNo, ModelMap modelMap) {
        BizResult<List<PaymentRelation>> paymentDetail = paymentService.findPayment(patmentNo);
        modelMap.addAttribute("paymentDetail", paymentDetail);
        return "paymentDetail";
    }

    /**
     * 返回到主界面
     * @return
     */
    @RequestMapping("back")
    public String back() {
        return "redirect:/page/shopCart";
    }

    @RequestMapping("detail")
    public BizResult<ProductDTO> productDetail(ProductDTO productDTO) {
        return productionService.findProductDetail(productDTO.getId());
    }
}
