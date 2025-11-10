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

