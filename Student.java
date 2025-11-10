public class Student {
    // Atribut private (enkapsulasi)
    private String name;
    private int score;

    // Constructor
    public Student(String name, int score) {
        this.name = name;
        setScore(score); // gunakan setter supaya validasi tetap berlaku
    }

    // Getter untuk name
    public String getName() {
        return name;
    }

    // Setter untuk name
    public void setName(String name) {
        this.name = name;
    }

    // Getter untuk score
    public int getScore() {
        return score;
    }

    // Setter untuk score, dengan validasi nilai 0–100
    public void setScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score harus antara 0 dan 100!");
        }
        this.score = score;
    }
}
