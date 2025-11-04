Encapsulation
Tugas Pemrograman Berorientasi Objek – Encapsulation
Repositori ini dibuat untuk memenuhi tugas mata kuliah Pemrograman Berorientasi Objek (PBO).
Materi yang dibahas: Encapsulation dalam Java, mencakup penggunaan private attribute, getter, setter, dan validasi nilai dalam class.
Di sini saya membuat beberapa class seperti Student, Team, dan ImmutableStudent untuk mempraktikkan penggunaan private fields, getter/setter, serta kontrol akses data dengan cara yang aman.

// Latihan
Buat class Student dengan private String name, private int score. Buat constructor, getter, dan setter. Di setScore(int), batasi nilai 0..100, kalau di luar lempar IllegalArgumentException. Buat Main untuk menguji.
Ubah Student supaya score hanya bisa diubah lewat method addScore(int delta) dan reduceScore(int delta) yang memeriksa batasnya — hapus setter setScore. Jelaskan kenapa ini lebih bagus.
Buat class Team yang menyimpan private List<Student> members. Implementasikan method addMember(Student s) dan getMembers() yang mengembalikan salinan list (agar caller tidak bisa ubah list internal langsung).
Buat ImmutableStudent (class final) dengan private final String name; private final int score; tanpa setter. Buat method withAddedScore(int delta) yang mengembalikan ImmutableStudent baru dengan score terupdate.

//Source Code
--Latihan Student--
--Student
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

--Team
import java.util.ArrayList;
import java.util.List;

public class Team {

    // List anggota bersifat private (enkapsulasi)
    private List<Student> members = new ArrayList<>();

    // Method untuk menambah anggota ke dalam tim
    public void addMember(Student s) {
        members.add(s);
    }

    // Method untuk mendapatkan daftar anggota
    // Mengembalikan SALINAN agar list internal tidak bisa diubah langsung
    public List<Student> getMembers() {
        return new ArrayList<>(members);
    }
}

--ImmutableStudent
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

--Main
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Membuat beberapa objek Student
        Student s1 = new Student("Nadiva Meiliya", 90);
        Student s2 = new Student("Yuhayyidun Sababa", 95);
        Student s3 = new Student("Librativial", 85);

        // Membuat objek Team dan menambahkan anggota
        Team team = new Team();
        team.addMember(s1);
        team.addMember(s2);
        team.addMember(s3);

        // Menampilkan daftar anggota
        List<Student> anggota = team.getMembers();
        System.out.println("Daftar anggota tim:");
        for (Student s : anggota) {
            System.out.println("- " + s.getName() + " (Nilai: " + s.getScore() + ")");
        }

        // Mencoba memodifikasi list hasil getMembers()
        anggota.remove(0); // hanya menghapus dari salinan, bukan dari list asli

        System.out.println("\nSetelah mencoba menghapus dari list salinan:");
        System.out.println("Jumlah anggota asli: " + team.getMembers().size()); // tetap sama
    }
}

Tugas ini menunjukkan penerapan konsep enkapsulasi dalam Java dan telah dijalankan dengan baik. Semua contoh telah diuji dan siap untuk dijadikan referensi studi lebih lanjut.Dengan latihan ini, saya dapat memahami penerapan enkapsulasi dalam Java secara praktis, termasuk penggunaan private fields, getter/setter, dan validasi data. Proyek ini menjadi dasar yang kuat untuk mempelajari konsep OOP lainnya seperti inheritance, polymorphism, dan abstraction.

Sekian, Terima Kasih, Peace n Love
