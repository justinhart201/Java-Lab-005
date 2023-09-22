import java.lang.management.PlatformLoggingMXBean;
import java.util.Scanner;

public class Game {
    Player p1;
    Player p2;
    Dice die;

    public Game(Player p1, Player p2, Dice die) {
        this.p1 = p1;
        this.p2 = p2;
        this.die = die;
    }


    public void play() {
        Player current= this.p1;
        takeTurn(current);
        current = nextPlayer(current);
        takeTurn(current);
        System.out.printf("Winner is %s%n", announceWinner());
    }


    public Player nextPlayer(Player current) {
        if( current.getName().equals( this.p1.getName() ) ) {
            return this.p2;
        }
        return this.p1;
    }

    public void takeTurn(Player player) {
        player.toss(this.die);
    }

    public String announceWinner() {
        System.out.printf("Name: %s Score: %d%n", this.p1.getName(), this.p1.getScore());
        System.out.printf("Name: %s Score: %d%n", this.p1.getName(), this.p1.getScore());
        if (p1.getScore() > this.p2.getScore()) {
            return p1.getName();
        }else if(p1.getScore()< this.p2.getScore()){
            return p2.getName();
        }
        return "tie";
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("how many sides should dice have.");
        int sides = Integer.parseInt(s.nextLine());
        String name;
        Player play1 = new Player("trevor");
        Player play2 = new Player("justin");
        Dice d = new Dice(sides);
        Game g = new Game(play1, play2, d);
        g.play();

    }
}