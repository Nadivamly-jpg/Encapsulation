public final class ImmutableStudent {
    // Atribut bersifat final agar tidak bisa diubah setelah dibuat
    private final String name;
    private final int score;

    // Constructor
    public ImmutableStudent(String name, int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score harus antara 0 dan 100!");
        }
        this.name = name;
        this.score = score;
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    /**
     * Membuat objek baru dengan score yang telah ditambah delta.
     * Objek lama tidak berubah (immutability).
     */
    public ImmutableStudent withAddedScore(int delta) {
        int newScore = this.score + delta;

        // Pastikan tetap dalam batas 0–100
        if (newScore > 100) newScore = 100;
        if (newScore < 0) newScore = 0;

        // Mengembalikan objek baru, bukan mengubah yang lama
        return new ImmutableStudent(this.name, newScore);
    }
}

