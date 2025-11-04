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

//Latihan Kendaraan//
--Latihan 1--
--Vehicle
package Latihan1;

public class Vehicle {
    String brand;

    void start() {
        System.out.println("vehicle starts");
    }
}

--Car
package Latihan1;

    public class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("car starts with key ignition");
    }
}

--Motorcycle
package Latihan1;

    public class Motorcycle extends Vehicle {
    @Override
    void start() {
        System.out.println("motorcycle starts with button");
    }
}

--Main
package Latihan1;

    public class Main {
    public static void main(String[] args) {
        // Membuat array Vehicle yang berisi berbagai jenis kendaraan
        Vehicle[] vehicles = new Vehicle[3];

        // Mengisi array dengan objek Car dan Motorcycle
        vehicles[0] = new Vehicle();
        vehicles[1] = new Car();
        vehicles[2] = new Motorcycle();

        // Memanggil start() pada tiap elemen array
        for (Vehicle v : vehicles) {
            v.start();  // polymorphism: panggil sesuai tipe objek sebenarnya
        }
    }
}

--Latihan 2--
--Account
package Latihan2;
public class Account {
    String accNo;
    double balance;

    public Account(String accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println(accNo + ": Deposit " + amount + ", balance = " + balance);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(accNo + ": Withdraw " + amount + ", balance = " + balance);
        } else {
            System.out.println(accNo + ": Insufficient balance!");
        }
    }

    void showInfo() {
        System.out.println("Account [" + accNo + "] balance = " + balance);
    }
}

--SavingsAccount
package Latihan2;

    public class SavingsAccount extends Account {
    double interestRate; // contoh: 0.05 = 5%

    public SavingsAccount(String accNo, double balance, double interestRate) {
        super(accNo, balance);
        this.interestRate = interestRate;
    }

    void addInterest() {
        balance += balance * interestRate;
        System.out.println(accNo + ": Interest added, new balance = " + balance);
    }

    @Override
    void showInfo() {
        System.out.println("SavingsAccount [" + accNo + "] balance = " + balance + ", rate = " + (interestRate * 100) + "%");
    }
}

--CheckingAccount
package Latihan2;

    public class CheckingAccount extends Account {
    double overdraftLimit; // batas saldo minus

    public CheckingAccount(String accNo, double balance, double overdraftLimit) {
        super(accNo, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println(accNo + ": Withdraw " + amount + ", new balance = " + balance);
        } else {
            System.out.println(accNo + ": Overdraft limit exceeded!");
        }
    }

    @Override
    void showInfo() {
        System.out.println("CheckingAccount [" + accNo + "] balance = " + balance + ", overdraft limit = " + overdraftLimit);
    }
}

--Main
package Latihan2;

   public class Main {
    public static void main(String[] args) {
        // Membuat array berisi berbagai tipe akun (polymorphism)
        Account[] accounts = new Account[4];
        accounts[0] = new SavingsAccount("SA001", 1000, 0.05);
        accounts[1] = new CheckingAccount("CA001", 2000, 500);
        accounts[2] = new SavingsAccount("SA002", 1500, 0.03);
        accounts[3] = new CheckingAccount("CA002", 2500, 1000);

        // Iterasi semua akun
        for (Account acc : accounts) {
            acc.showInfo(); // panggil versi masing-masing (override)

            // Jika akun adalah SavingsAccount, tambahkan bunga
            if (acc instanceof SavingsAccount) {
                SavingsAccount sa = (SavingsAccount) acc; // casting
                sa.addInterest(); // panggil method khusus SavingsAccount
            }
        }

        System.out.println("\n=== Setelah bunga ditambahkan pada akun tabungan ===");
        for (Account acc : accounts) {
            acc.showInfo();
        }
    }
}

--Latihan 3--
--Shape
package Latihan3;

   public abstract class Shape {
    // Method abstract → wajib diimplementasikan oleh subclass
    public abstract double area();

    // (Opsional) method umum untuk semua bentuk
    public void showArea() {
        System.out.println("Area: " + area());
    }
}

--Triangle
package Latihan3;

    public class Triangle extends Shape {
    double base;
    double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

--Rectangle
package Latihan3;

    public class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

--Circle
package Latihan3;

    public class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

--Main
package Latihan3;

    public class Main {
    public static void main(String[] args) {
        // Membuat array dari berbagai bentuk (polymorphism)
        Shape[] shapes = {
            new Triangle(10, 5),
            new Rectangle(4, 6),
            new Circle(3)
        };

        double totalArea = 0;

        // Iterasi semua shape dan hitung total area
        for (Shape s : shapes) {
            System.out.println(s.getClass().getSimpleName() + " area = " + s.area());
            totalArea += s.area();
        }

        System.out.println("----------------------");
        System.out.println("Total area = " + totalArea);
    }
}

Tugas ini menunjukkan penerapan konsep enkapsulasi dalam Java dan telah dijalankan dengan baik. Semua contoh telah diuji dan siap untuk dijadikan referensi studi lebih lanjut.Dengan latihan ini, saya dapat memahami penerapan enkapsulasi dalam Java secara praktis, termasuk penggunaan private fields, getter/setter, dan validasi data. Proyek ini menjadi dasar yang kuat untuk mempelajari konsep OOP lainnya seperti inheritance, polymorphism, dan abstraction.

Sekian, Terima Kasih, Peace n Love
