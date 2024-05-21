
public class Adventure {
    // 将每局的金币的真假可能情况在一开始就确定
    private static Money[] moneys = new Money[12];

    // moneys的构造方法
    public static void setMoney(Money[] moneys) {
        for (int i = 0; i < moneys.length; i++) {
            moneys[i] = new Money(i);
        }
    }

    // 游戏欢迎界面的实现
    public static void startPage() {
        System.out.println("****************************************");
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("You are a Hobbit. You have to defeat the enemies to win the game.");
        System.out.println("If you win, you will get gold.");
        System.out.println("If you lose, you will lose health.");
        System.out.println("Let's start the game!");
        System.out.println("****************************************");
    }

    // 输出每个生物的生命值和当前拥有的金币
    public static void printAfterLevel(Creature player, Creature enemy, int level) {
        System.out.println();
        System.out.println("Level: " + level);
        System.out.println("Your life: " + player.getLife());
        System.out.println("Your gold: " + player.getGold());
        System.out.println("Enemy: " + enemy.getName() + " (Life: " + enemy.getLife() + ")");
    }

    // 进入游戏后,用户输入冒险的目的地名称,必须只包含字母和空格，不能以空格开头或结尾,长度为4至16个字符
    public static String getDestination() {
        String destination = "";
        while (true) {
            System.out.println("Please enter the name of your destination (4-16 characters):");
            destination = System.console().readLine();
            if (destination.length() < 4 || destination.length() > 16) {
                System.out.println("The length of the destination should be 4-16 characters.");
            } else if (destination.charAt(0) == ' ' || destination.charAt(destination.length() - 1) == ' ') {
                System.out.println("The destination should not start or end with a space.");
            } else if (!destination.matches("^[a-zA-Z ]+$")) {
                System.out.println("The destination should only contain letters and spaces.");
            } else {
                break;
            }
        }
        return destination;
    }

    // 结束时输出目的地名称，胜利方，冒险者获得的总金币，对手获得的总金币和冒险者评分
    public static void printEnd(String destination, Creature player, Creature enemy) {
        System.out.println("Destination: " + destination);
        if (player.getLife() == 0) {
            System.out.println("Winner: " + enemy.getName());
        } else if (enemy.getLife() == 0) {
            System.out.println("Winner: " + player.getName());
        } else
            System.out.println("Winner: " + enemy.getName() + " and " + player.getName());
        System.out.println("Your total gold: " + player.getGold());
        System.out.println("Enemy's total gold: " + enemy.getGold());
        // 用百分比的形式输出冒险者的评分(player.getGold()/(player.getGold() + enemy.getGold()))
        System.out.println(
                "Your score: " + (int) (player.getGold() * 100.0 / (player.getGold() + enemy.getGold())) + "%");
    }

    public static void main(String[] args) {
        startPage();
        setMoney(moneys);
        String destination = getDestination();
        // 创建玩家的creature
        Creature player = new Creature();
        // 创建敌人的creature
        Creature enemy = Creature.randomEnemy();
        // 创建背包
        Package pack = new Package();

        // 进行关卡
        ProductList productList = new ProductList();
        Level level = new Level();
        level.setLevel();
        for (int i = 1; i <= level.getLevel(); i++) {
            if (i % 3 != 0) {
                level.everyLevel(player, enemy, destination, moneys, i);
            } else {
                level.rewardLevel(player, enemy, destination, i);
            }
            printAfterLevel(player, enemy, i);
            if (player.getLife() == 0 || i == 12) {
                break;
            }
            if (i != level.getLevel()) {
                productList.judgePrint(pack, player);// 将要买入的商品放到背包中
                pack.skillFromPackage(productList, player);// 考虑是否将技能从背包中拿出来
            }
        }
        printEnd(destination, player, enemy);
    }

}
