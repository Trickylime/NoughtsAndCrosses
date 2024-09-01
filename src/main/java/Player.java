public class Player {

    private String name;
    private int score;
    private String noughtsOrCrosses;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNoughtsOrCrosses() {
        return noughtsOrCrosses;
    }

    public void setNoughtsOrCrosses(String noughtsOrCrosses) {
        this.noughtsOrCrosses = noughtsOrCrosses;
    }
}
