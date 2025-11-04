Encapsulation
📘 Tugas Pemrograman Berorientasi Objek – Encapsulation
Repositori ini dibuat untuk memenuhi tugas mata kuliah Pemrograman Berorientasi Objek (PBO).
Materi yang dibahas: Encapsulation dalam Java, mencakup penggunaan private attribute, getter, setter, dan validasi nilai dalam class.
Di sini saya membuat beberapa class seperti Student, Team, dan ImmutableStudent untuk mempraktikkan penggunaan private fields, getter/setter, serta kontrol akses data dengan cara yang aman.

// Latihan
Buat class Student dengan private String name, private int score. Buat constructor, getter, dan setter. Di setScore(int), batasi nilai 0..100, kalau di luar lempar IllegalArgumentException. Buat Main untuk menguji.
Ubah Student supaya score hanya bisa diubah lewat method addScore(int delta) dan reduceScore(int delta) yang memeriksa batasnya — hapus setter setScore. Jelaskan kenapa ini lebih bagus.
Buat class Team yang menyimpan private List<Student> members. Implementasikan method addMember(Student s) dan getMembers() yang mengembalikan salinan list (agar caller tidak bisa ubah list internal langsung).
Buat ImmutableStudent (class final) dengan private final String name; private final int score; tanpa setter. Buat method withAddedScore(int delta) yang mengembalikan ImmutableStudent baru dengan score terupdate.
//Source Code
C
