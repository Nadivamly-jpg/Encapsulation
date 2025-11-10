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

