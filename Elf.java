package com.exercise.demo;

public class Elf extends Creature {
    private double winRate = 0.8;

    public Elf() {
        super("Elf", 7, 0);
    }

    // getter方法
    public double getWinRate() {
        return winRate;
    }

    @Override
    public Creature fight(Creature Hobbit, Money money, int levelNow) {
        Creature winner = null;
        double random = Math.random();
        if (random > this.winRate) {
            // 如果是真金币加钱
            if (money.getRealCoin()) {
                // 获得的真金币数量
                Hobbit.setGold(Hobbit.getGold() + money.getValue());
            }
            //即使金币是假的，也会增加钱币的数量
            Hobbit.setMoney(money, levelNow - 1);
            winner = Hobbit;
            if (Hobbit.getSkill()[0] == 1) {
                this.setLife(this.getLife() - 3);
            } else {
                this.setLife(this.getLife() - 2);
            }
        } else {
            if (money.getRealCoin()) {
                this.setGold(this.getGold() + money.getValue());
            }
            //即使金币是假的，也会增加钱币的数量
            this.setMoney(money, levelNow - 1);
            winner = this;
            if (Hobbit.getSkill()[1] == 0) {
                Hobbit.setLife(Hobbit.getLife() - 2);
            }
        }
        return winner;
    }
}
