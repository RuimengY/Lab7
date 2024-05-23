package com.exercise.demo;

public class Orc extends Creature {
    // 兽人的生命值和生命值有关，需要在战争时setter方法
    private double winRate;

    public Orc() {
        super("Orc", 8, 0);
    }

    // winRate的setter方法
    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    public double getWinRate() {
        return winRate;
    }

    @Override
    public Creature fight(Creature Hobbit, Money money, int levelNow) {
        Creature winner = null;
        int playerLife = Hobbit.getLife();
        int enemyLife = this.getLife();
        double random = Math.random();
        if (playerLife > enemyLife) {
            if (random < 0.7) {
                if (money.getRealCoin()) {
                    Hobbit.setGold(Hobbit.getGold() + money.getValue());
                }
                //即使不是真金币，钱也会在相应位置增加
                Hobbit.setMoney(money, levelNow - 1);
                winner = Hobbit;
                if (Hobbit.getSkill()[0] == 1) {
                    this.setLife(this.getLife() - 3);
                } else {
                    this.setLife(this.getLife() - 2);
                }
            } else {
                if (Hobbit.getSkill()[1] == 0) {
                    Hobbit.setLife(Hobbit.getLife() - 2);
                }
                if (money.getRealCoin()) {
                    this.setGold(this.getGold() + 1);
                }
                //即使不是真金币，钱也会在相应位置增加
                this.setMoney(money, levelNow - 1);
                winner = this;
            }
        } else if (playerLife < enemyLife) {
            if (random < 0.4) {
                if (money.getRealCoin()) {
                    Hobbit.setGold(Hobbit.getGold() + money.getValue());
                }
                //即使不是真金币，钱也会在相应位置增加
                Hobbit.setMoney(money, levelNow - 1);
                winner = Hobbit;
                if (Hobbit.getSkill()[0] == 1) {
                    this.setLife(this.getLife() - 3);
                } else {
                    this.setLife(this.getLife() - 2);
                }
            } else {
                if (Hobbit.getSkill()[1] == 0) {
                    Hobbit.setLife(Hobbit.getLife() - 2);
                }
                if (money.getRealCoin()) {
                    this.setGold(this.getGold() + 1);
                }
                //即使不是真金币，钱也会在相应位置增加
                this.setMoney(money, levelNow - 1);
                winner = this;
            }
        } else {
            if (random < 0.6) {
                if (money.getRealCoin()) {
                    Hobbit.setGold(Hobbit.getGold() + money.getValue());
                }
                //即使不是真金币，钱也会在相应位置增加
                Hobbit.setMoney(money, levelNow - 1);
                winner = Hobbit;
                if (Hobbit.getSkill()[0] == 1) {
                    this.setLife(this.getLife() - 3);
                } else {
                    this.setLife(this.getLife() - 2);
                }
            } else {
                if (Hobbit.getSkill()[1] == 0) {
                    Hobbit.setLife(Hobbit.getLife() - 2);
                }
                if (money.getRealCoin()) {
                    this.setGold(this.getGold() + 1);
                }
                //即使不是真金币，钱也会在相应位置增加
                this.setMoney(money, levelNow - 1);
                winner = this;
            }
        }
        return winner;
    }
}
