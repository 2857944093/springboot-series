package com.czk.hope.designmode.command.operation;

import com.czk.hope.designmode.command.manufacturer.Light;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 13:47
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
