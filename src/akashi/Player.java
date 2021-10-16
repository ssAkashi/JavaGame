package akashi;

public class Player {
    String playerName;
    double playerHealth;
    double playerAttack;
    boolean isDead = false;

    public Player() {

    }

    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public double getHealth() {
        return playerHealth;
    }
    public void setPlayerHealth(double health) {
        this.playerHealth = health;
    }

    public double getPlayerAttack() {
        return playerAttack;
    }
    public void setPlayerAttack(double attack) {
        this.playerAttack = attack;
    }

    public boolean getStatut() {
        return isDead;
    }
    public void setStatut(boolean dead) {
        this.isDead = dead;
    }

    public void Damage(double damage) {
        this.playerHealth = playerHealth - damage;
    }
}
