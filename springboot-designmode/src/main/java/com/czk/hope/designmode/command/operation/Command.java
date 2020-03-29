package com.czk.hope.designmode.command.operation;

/**
 * @Author: ChenZK
 * @Create: 2020/3/26 13:33
 * 命令模式：执行命令接口
 **/
public interface Command {
    void execute();
    void undo();
}
