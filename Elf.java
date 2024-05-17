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
    public void fight(Creature Hobbit, Money money) {
        double random = Math.random();
        if (random > this.winRate) {
            // 如果是真金币加钱
            if (money.getrealCoin()) {
                // 获得的真金币数量
                Hobbit.setGold(Hobbit.getGold() + money.getValue());
            }
            this.setLife(this.getLife() - 2);
        } else {
            if (money.getrealCoin()) {
                this.setGold(this.getGold() + money.getValue());
            }
            Hobbit.setLife(Hobbit.getLife() - 2);
        }
    }
}