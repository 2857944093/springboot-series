package com.czk.hope.designmode.command.operation;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 13:52
 * 遥控器
 */
public class RemoteControl {
    Command[] onCommand;
    Command[] offCommand;
    Command undoCommand;

    public RemoteControl() {
        onCommand = new Command[2];
        offCommand = new Command[2];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 2; i++) {
            onCommand[i] = noCommand;
            offCommand[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommand[slot] = onCommand;
        this.offCommand[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommand[slot].execute();
        undoCommand = onCommand[slot];
    }

    public void offButtonWasPushed(int slot){
        offCommand[slot].execute();
        undoCommand = offCommand[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }
}
