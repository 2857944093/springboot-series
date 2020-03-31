package com.czk.hope.designmode.templatemethod;

import com.czk.hope.designmode.templatemethod.shop.CaffeineBeverage;
import com.czk.hope.designmode.templatemethod.shop.Coffe;
import com.czk.hope.designmode.templatemethod.shop.Tea;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 17:21
 * 模板方法
 */
public class TemplateDemo {
    public static void main(String[] args) {
        CaffeineBeverage caffeineBeverage = new Coffe();
        caffeineBeverage.preparRecipe();

        CaffeineBeverage caffeineBeverage1 = new Tea();
        caffeineBeverage1.preparRecipe();
    }
}
