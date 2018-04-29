package com.consumer.enums;

/**
 *   
 * <p>食品类型枚举类</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/6 
 * @since V1.0
 *  
 */
public enum KindEnum {

    WORKING(1L, "加工类"),
    FOOD_WORKING(2L, "食品加工类"),
    STORE(3L, "储藏类"),
    COFFEE_CLASS(4L, "咖啡器具类"),
    WATER_SYSTEM(5L, "水系统类"),
    COFFEE_CONSUMPTION(6L, "咖啡耗用物品类"),
    MATERIAL(7L, "咖啡耗料"),
    MISCELLANEOUS(8L, "其他杂项类");

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;


    KindEnum(Long id, String type){
        this.id = id;
        this.type = type;
    }

    /**
     * 根据id获取类型描述
     * @param id
     * @return
     */
    public static String getType(Long id){
        KindEnum[] kindEnums = values();
        for (KindEnum kindEnum : kindEnums) {
            if (kindEnum.getId().equals(id)) {
                return kindEnum.getType();
            }
        }
        return null;
    }

}
