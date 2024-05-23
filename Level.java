package com.exercise.demo;

public class Level {
    private int allLevel;
    private static int nowLevel = 0;

    public int getLevel() {
        return allLevel;
    }

    public void setAllLevel(int allLevel) {
        this.allLevel = allLevel;
    }

    // level的输入设置
    public void setLevel() {
        System.out.println("please enter the number of level: ");
        while (true) {
            String level = System.console().readLine();
            try {
                this.allLevel = Integer.parseInt(level);
                break;
            } catch (NumberFormatException e) {
                System.out.println("please enter a number: ");
            }
        }
    }

    // 每一关的实现
    // 如果冒险者和对手为了金币而战,胜者会获得,失败者的生命值会减少2.生命值多的一方有0.7的概率获胜,如果生命值相同,则双方有都0.5的概率获胜.如果对手的生命值降到0,则冒险者会在接下来的每一关都获得金币.每一关结束时,在控制台输出每个生物的生命值和当前拥有的金币.
    public void everyLevel(Creature player, Creature enemy,  Money[] moneys, int level) {
        if (player.getSkill()[0] == 1) {
            player.setLife(player.getLife() + 2);
        }

        // 每一关开始的时候冒险者和对手的生命值＋1(如果对手生命值为0,则只有冒险者的生命值＋1)
        if (level != 1 && enemy.getLife() != 0) {
            player.setLife(player.getLife() + 1);
            enemy.setLife(enemy.getLife() + 1);
        } else if (level != 1 && enemy.getLife() == 0) {
            player.setLife(player.getLife() + 1);
        }
        Money money = moneys[level - 1];
        player.attack(enemy, money);
        int[] skill = { 0, 0, 0 };
        player.setSkill(skill);

    }

    // 1.奖励关卡
    public void rewardLevel(Creature player, Creature enemy, String destination, int level) {
        System.out.println("进入奖励关卡：" + level);
        // player.setGold(player.getGold() + 2);
        Money money = new Money(level);
        player.setGold(player.getGold() + money.getValue());
        enemy.setGold(enemy.getGold() + money.getValue());
        int[] skill = { 0, 0, 0 };
        player.setSkill(skill);
    }
    public int levelNow(){
        //每次调用的时候将当前关卡数加1
        nowLevel++;
        return nowLevel;
    }

}
