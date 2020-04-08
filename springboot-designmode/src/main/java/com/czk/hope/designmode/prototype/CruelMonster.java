package com.czk.hope.designmode.prototype;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/7 16:41
 */
public class CruelMonster implements Cloneable{
    private String name;
    private String description;
    private static CruelMonster cruelMonster = new CruelMonster();

    private CruelMonster() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static CruelMonster getInstance(){
        cruelMonster.setName("cruel");
        cruelMonster.setDescription("very cruel");
        return cruelMonster;
    }

    @Override
    protected CruelMonster clone() {
        CruelMonster cruelMonster = null;
        try{
            cruelMonster = (CruelMonster) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return cruelMonster;
    }

    @Override
    public String toString() {
        return "CruelMonster{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
