package com.exercise.demo;

class Creature {
    private String name;
    private int life;
    private int gold;
    private int[] skill = new int[3]; // 此时的skill是指在下一关能用到的skill

    public Creature(String name, int life, int gold) {
        this.name = name;
        this.life = life;
        this.gold = gold;
    }

    // 玩家的creature的名字是Hobbit，生命值为随机的5-9（包括5和9），金币为0
    public Creature() {
        this.name = "Hobbit";
        this.life = (int) (Math.random() * 5) + 5;
        this.gold = 0;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getGold() {
        return gold;
    }

    // 用于更新生命值和金币的setter方法
    public void setLife(int life) {
        this.life = life;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int[] getSkill() {
        return skill;
    }

    public void setSkill(int[] skill) {
        this.skill = skill;
    }

    public void setSkill(int index) {
        for (int i = 0; i < skill.length; i++) {
            if (i == index) {
                skill[i] = 1;
            } else
                skill[i] = 0;
        }
    }

    // 随机抽选敌人的角色和生命值。如果角色是Dwarf，则生命值为9；如果角色是Elf，则生命值为7；如果角色为Orc，则生命值为5
    public static Creature randomEnemy() {
        int random = (int) (Math.random() * 3);
        Creature enemy;
        if (random == 0) {
            enemy = new Dwarf();
        } else if (random == 1) {
            enemy = new Elf();
        } else {
            enemy = new Orc();
        }
        return enemy;
    }

    public void attack(Creature enemy, Money money) {
        // 如果敌人是矮人而且敌人的生命值小于等于2，那么霍比特人直接获得金币
        if (enemy instanceof Dwarf && enemy.getLife() <= 2) {
            // 如果是真金币加钱
            if (money.getrealCoin()) {
                // 获得的真金币数量
                this.setGold(this.getGold() + money.getValue());
            }
        }
        if (this.getLife() < 2 && !(enemy instanceof Dwarf)) {
            System.out.println("You don't have enough health to fight for gold.");
            // 如果是真金币加钱
            if (money.getrealCoin()) {
                // 获得的真金币数量
                enemy.setGold(enemy.getGold() + money.getValue());
            }
        } else if (enemy.getLife() == 0) {
            // 如果是真金币加钱
            if (money.getrealCoin()) {
                // 获得的真金币数量
                this.setGold(this.getGold() + money.getValue());
            }
        } else {
            // this.fight(enemy);
            if (enemy instanceof Dwarf) {
                // 调用Dwarf类的方法
                ((Dwarf) enemy).fight(this, money);
            } else if (enemy instanceof Elf) {
                // 调用Elf类的方法
                ((Elf) enemy).fight(this, money);
            } else if (enemy instanceof Orc) {
                // 调用Orc类的方法
                ((Orc) enemy).fight(this, money);
            }
            // 冒险家受伤
            if (this.getLife() <= 2) {
                this.setLife(this.getLife() - 1);
            } else {
                this.setLife(this.getLife() + 1);
            }

        }
    }

    public void fight(Creature enemy, Money money) {
    }
}