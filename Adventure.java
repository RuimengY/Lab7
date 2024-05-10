package lab7;

public class Adventure {
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

    // 每一关的实现
    // 如果冒险者和对手为了金币而战,胜者会获得,失败者的生命值会减少2.生命值多的一方有0.7的概率获胜,如果生命值相同,则双方有都0.5的概率获胜.如果对手的生命值降到0,则冒险者会在接下来的每一关都获得金币.每一关结束时,在控制台输出每个生物的生命值和当前拥有的金币.
    public static void everyLevel(Creature player, Creature enemy, String destination, int level) {

        // 每一关开始的时候冒险者和对手的生命值＋1(如果对手生命值为0,则只有冒险者的生命值＋1)
        if (level != 1 && enemy.getLife() != 0) {
            player.setLife(player.getLife() + 1);
            enemy.setLife(enemy.getLife() + 1);
        } else if (level != 1 && enemy.getLife() == 0) {
            player.setLife(player.getLife() + 1);
        }

        player.attack(enemy);

    }

    // 输出每个生物的生命值和当前拥有的金币
    public static void printAfterLevel(Creature player, Creature enemy, int level) {
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
        } else {
            System.out.println("Winner: " + player.getName());
        }
        System.out.println("Your total gold: " + player.getGold());
        System.out.println("Enemy's total gold: " + enemy.getGold());
        // 用百分比的形式输出冒险者的评分(player.getGold()/(player.getGold() + enemy.getGold()))
        System.out.println(
                "Your score: " + (int) (player.getGold() * 100.0 / (player.getGold() + enemy.getGold())) + "%");
    }

    public static void main(String[] args) {
        startPage();
        String destination = getDestination();
        // 创建玩家的creature
        Creature player = new Creature();
        // 创建敌人的creature
        Creature enemy = Creature.randomEnemy();
        // 进行关卡，一共12关
        boolean flag = true;
        for (int i = 1; i <= 12 && flag; i++) {
            flag = false;
            everyLevel(player, enemy, destination, i);
            printAfterLevel(player, enemy, i);
            if (player.getLife() == 0 || i == 12) {
                break;
            }
            System.out.println("Do you want to continue?Type'y'to continue, other keys to exit.");
            String input = System.console().readLine();
            if (input.equals("y")) {
                flag = true;
            }
        }
        printEnd(destination, player, enemy);
    }
}
