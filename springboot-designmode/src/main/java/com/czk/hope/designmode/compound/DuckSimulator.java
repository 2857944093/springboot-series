package com.czk.hope.designmode.compound;

import com.czk.hope.designmode.compound.goose.Goose;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 10:33
 */
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    private void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDUck = new QuackCounter(new GooseAdapter(new Goose()));

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDUck);

        simulate(flockOfDucks);


        System.out.println(QuackCounter.getQuacks());
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
