package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 15:33
 */
public class BigPlantFactory extends AbstractPlant {
    BigNutPlant bigNutPlant;
    BigScrewPlant bigScrewPlant;

    @Override
    public void createPizza() {
        createNew();
        bigScrewPlant.print();
        bigNutPlant.print();
    }

    void createNew(){
        if (bigNutPlant == null) {
            bigNutPlant = new BigNutPlant();
        }
        if (bigScrewPlant == null) {
            bigScrewPlant = new BigScrewPlant();
        }
    }
}
