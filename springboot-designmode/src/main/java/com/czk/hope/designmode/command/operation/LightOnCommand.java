package com.czk.hope.designmode.command.operation;

import com.czk.hope.designmode.command.manufacturer.Light;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 13:34
 * 点灯开关
 */
public class LightOnCommand implements Command {
    protected Light light;


    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }


}
