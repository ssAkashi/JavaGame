package akashi;

public class Main {
    public static void main(String[] args) {
        boolean startGame = true;
        boolean loop = true;
        int i = 0;
        double randomAttack = (int)(Math.random() * 100.0);
        int bonnusAttack = (int)(Math.random() * 10);
        String[] playerNameList = { "Player 1", "Player 2", "Monster" };
        if (startGame) {

            Player player1 = new Player();
            player1.setPlayerName(playerNameList[0]);
            player1.setPlayerHealth(500.0);
            player1.setPlayerAttack(randomAttack);

            Player player2 = new Player();
            player2.setPlayerName(playerNameList[1]);
            player2.setPlayerHealth(450.0);
            player2.setPlayerAttack(randomAttack);

            initMessage(1, "New player");
            try {
                Thread.sleep(3000);
                System.out.println("New Player Spawned :\nName : " + player1.getPlayerName() + " | Health : " + player1.getHealth() + " | Attack : " + player1.getPlayerAttack());
                Thread.sleep(500);
                initMessage(1, "Arena");
                Thread.sleep(2000);
                initMessage(2, "Arena");
                Thread.sleep(500);
                initMessage(1, "Monster");
                Thread.sleep(3000);
            }
            catch (Exception error){
                System.err.println(error);
            }

            Player monster = new Player();
            monster.setPlayerName(playerNameList[2]);
            monster.setPlayerHealth(700.0);
            monster.setPlayerAttack(35.0);
            System.out.println("Monster Spawned :\nName : " + monster.getPlayerName() + " | Health : " + monster.getHealth() + " | Attack : " + monster.getPlayerAttack());
            System.out.println("The fight start !!!");
            try {
                while(loop) {
                    i = i + 1;
                    System.out.println("Round " + i + " starting !");
                    if (!player1.getStatut()) {
                        if (player1.getPlayerAttack() <= monster.getPlayerAttack()) {
                            Thread.sleep(1000);
                            double attack = (player1.getPlayerAttack() + bonnusAttack);
                            monster.Damage(attack);
                            System.out.println("Ish ! The monster lost " + attack + " hp by player 1.");
                            System.out.println("Player 1 : " + player1.getHealth() + " hp | Monster : " + monster.getHealth() + " hp");
                            System.out.println("The monster preparing this attack !!");
                            Thread.sleep(2000);
                            attack = 0;
                            attack = (monster.getPlayerAttack() + bonnusAttack);
                            player1.Damage(attack);
                            System.out.println("Ishh ! The player lost " + attack + " hp by a monster.");
                            System.out.println("Player 1 : " + player1.getHealth() + " hp | Monster : " + monster.getHealth() + " hp");
                            if (player1.getHealth() <= 0) {
                                player1.setStatut(true);
                                System.out.println("Player 1 is Dead ! Monster has " + monster.getHealth() + " hp.");
                                initMessage(1, "Player 2");
                                Thread.sleep(1000);
                                initMessage(2, "Player 2");
                            }
                            if (monster.getHealth() <= 0) {
                                monster.setStatut(true);
                                System.out.println("Monster is Dead !\nTHE WINNER IS THE PLAYER 1 !");
                                break;
                            }
                        }
                    } else {
                        if (player2.getPlayerAttack() <= monster.getPlayerAttack()) {
                            Thread.sleep(1000);
                            double attack = (player2.getPlayerAttack() + bonnusAttack);
                            monster.Damage(attack);
                            System.out.println("Ish ! The monster lost " + attack + " hp by player 1.");
                            System.out.println("Player 2 : " + player2.getHealth() + " hp | Monster : " + monster.getHealth() + " hp");
                            System.out.println("The monster preparing this attack !!");
                            Thread.sleep(2000);
                            attack = 0;
                            attack = (monster.getPlayerAttack() + bonnusAttack);
                            player2.Damage(attack);
                            System.out.println("Ishh ! The player lost " + attack + " hp by a monster.");
                            System.out.println("Player 2 : " + player2.getHealth() + " hp | Monster : " + monster.getHealth() + " hp");
                            if (player2.getHealth() <= 0) {
                                player2.setStatut(true);
                                System.out.println("Player 2 is Dead !\nTHE WINNER IS THE MONSTER !\nTHE GAME STOPPED...");
                                break;
                            }
                            if (monster.getHealth() <= 0) {
                                monster.setStatut(true);
                                System.out.println("Monster is Dead !\nTHE WINNER IS THE PLAYER 2 !\nTHE GAME STOPPED...");
                                break;
                            }
                        }
                    }
                    Thread.sleep(6000);
                }
            }
            catch (Exception error){
                System.err.println(error);
            }
        }
    }

    public static void initMessage(int number, String message) {
        if (number == 1) {
            System.out.println("Initialization of " + message + ". Waiting...");
        }
        if (number == 2) {
            System.out.println("The " + message + " has been initialized !");
        }
    }
}