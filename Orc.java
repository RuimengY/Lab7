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
    public void fight(Creature Hobbit, Money money) {
        int playerLife = Hobbit.getLife();
        int enemyLife = this.getLife();
        double random = Math.random();
        if (playerLife > enemyLife) {
            if (random < 0.7) {
                if (money.getrealCoin()) {
                    Hobbit.setGold(Hobbit.getGold() + money.getValue());
                }
                if (Hobbit.getSkill()[0] == 1) {
                    this.setLife(this.getLife() - 3);
                } else {
                    this.setLife(this.getLife() - 2);
                }
            } else {
                if (Hobbit.getSkill()[1] == 0) {
                    Hobbit.setLife(Hobbit.getLife() - 2);
                }
                if (money.getrealCoin()) {
                    this.setGold(this.getGold() + 1);
                }
            }
        } else if (playerLife < enemyLife) {
            if (random < 0.4) {
                if (money.getrealCoin()) {
                    Hobbit.setGold(Hobbit.getGold() + money.getValue());
                }
                if (Hobbit.getSkill()[0] == 1) {
                    this.setLife(this.getLife() - 3);
                } else {
                    this.setLife(this.getLife() - 2);
                }
            } else {
                if (Hobbit.getSkill()[1] == 0) {
                    Hobbit.setLife(Hobbit.getLife() - 2);
                }
                if (money.getrealCoin()) {
                    this.setGold(this.getGold() + 1);
                }
            }
        } else {
            if (random < 0.6) {
                if (money.getrealCoin()) {
                    Hobbit.setGold(Hobbit.getGold() + money.getValue());
                }
                if (Hobbit.getSkill()[0] == 1) {
                    this.setLife(this.getLife() - 3);
                } else {
                    this.setLife(this.getLife() - 2);
                }
            } else {
                if (Hobbit.getSkill()[1] == 0) {
                    Hobbit.setLife(Hobbit.getLife() - 2);
                }
                if (money.getrealCoin()) {
                    this.setGold(this.getGold() + 1);
                }
            }
        }
    }
}
