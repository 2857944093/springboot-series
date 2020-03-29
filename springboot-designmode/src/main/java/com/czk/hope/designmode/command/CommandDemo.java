package com.czk.hope.designmode.command;

import com.czk.hope.designmode.command.manufacturer.GarageDoor;
import com.czk.hope.designmode.command.manufacturer.Light;
import com.czk.hope.designmode.command.operation.*;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 10:57
 * 命令模式
 */
public class CommandDemo {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorCloseCommand garageDoorCloseCommand = new GarageDoorCloseCommand(garageDoor);
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);

        remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
        remoteControl.setCommand(1, garageDoorOpenCommand, garageDoorCloseCommand);

        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();

//        remoteControl.offButtonWasPushed(1);
//        remoteControl.onButtonWasPushed(1);
    }
}
