package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 15:38
 */
public class SmallPlantFactory extends AbstractPlant {

    SmallNutFactory smallNutFactory;
    SmallScrewPlant smallScrewPlant;

    @Override
    public void createPizza() {
        createNew();
        smallNutFactory.print();
        smallScrewPlant.print();

    }

    public void createNew() {
        if (smallNutFactory == null) {
            smallNutFactory =  SmallNutFactory.getInstance();
        }
        if (smallScrewPlant == null) {
            smallScrewPlant = SmallScrewPlant.getInstance();
        }
    }
}
