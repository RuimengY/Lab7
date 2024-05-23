package com.exercise.demo;

public class Dwarf extends Creature {
    private double winRate = 0.5;

    // Dwarf也是相对强大的对手,他的胜率为0.5,不论它的生命值是大于冒险者还是小于冒险者.
    public Dwarf() {
        super("Dwarf", 9, 0);
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
            //即使不是真金币，钱的数量也会在相应位置
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
            //即使不是真金币，钱的数量也会在相应位置
            this.setMoney(money, levelNow - 1);
            winner = this;
            if (Hobbit.getSkill()[1] == 1) {
                Hobbit.setLife(Hobbit.getLife() - 2);
            }
        }
        return winner;
    }
}
