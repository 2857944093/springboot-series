package com.czk.hope.designmode.command.operation;

import com.czk.hope.designmode.command.manufacturer.GarageDoor;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 13:48
 */
public class GarageDoorOpenCommand implements Command {

    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
        garageDoor.stop();
        garageDoor.ligthOff();
    }

    @Override
    public void undo() {
        garageDoor.down();
        garageDoor.stop();
        garageDoor.ligthOn();
    }
}
