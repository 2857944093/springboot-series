package com.czk.hope.designmode.command.operation;

import com.czk.hope.designmode.command.manufacturer.GarageDoor;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 13:50
 */
public class GarageDoorCloseCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }
    @Override
    public void execute() {
        garageDoor.down();
        garageDoor.stop();
        garageDoor.ligthOn();
    }

    @Override
    public void undo() {
        garageDoor.up();
        garageDoor.stop();
        garageDoor.ligthOff();
    }
}
