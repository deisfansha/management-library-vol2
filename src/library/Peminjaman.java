package library;

import parent.Book;

import java.time.LocalDate;

public class Peminjaman {
    private Anggota anggota; // Variabel pribadi untuk mengenkapsulasi informasi anggota (peminjam)
    private Book book; // Variabel pribadi untuk mengenkapsulasi informasi buku
    private LocalDate tanggalPeminjaman; // Variabel pribadi untuk mengenkapsulasi tanggal peminjaman
    private LocalDate tanggalPengembalian; // Variabel pribadi untuk mengenkapsulasi tanggal pengembalian

    public Peminjaman(Anggota anggota, Book book, LocalDate tanggalPeminjaman, LocalDate tanggalPengembalian) {
        this.anggota = anggota;
        this.book = book;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tanggalPengembalian = tanggalPengembalian;
    }

    public Anggota getAnggota() {
        return anggota; // Metode getter untuk mengenkapsulasi pengambilan data anggota
    }

    public Book getBook() {
        return book; // Metode getter untuk mengenkapsulasi pengambilan data buku
    }

    public LocalDate getTanggalPeminjaman() {
        return tanggalPeminjaman; // Metode getter untuk mengenkapsulasi pengambilan tanggal peminjaman
    }

    public LocalDate getTanggalPengembalian() {
        return tanggalPengembalian; // Metode getter untuk mengenkapsulasi pengambilan tanggal pengembalian
    }

    public void setTanggalPengembalian(LocalDate tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian; // Metode setter untuk mengenkapsulasi modifikasi tanggal pengembalian
    }
}
