package kelola;

import library.Anggota;
import library.Library;
import library.Peminjaman;
import parent.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KelolaPeminjaman {

    // Method untuk melakukan peminjaman buku
    public static void pinjamBuku(Library perpus, Scanner input, List<Anggota> members) {
        List<Book> allBooks = perpus.getAllBooks();
        List<String> displayedTitles = new ArrayList<>();
        List<String> displayedDetail = new ArrayList<>();

        int no = 1;

        if (allBooks.isEmpty()) {
            System.out.println("Data masih Kosong");
        } else {
            System.out.println("Daftar Judul Buku: ");
            for (Book book : allBooks) {
                String judulBuku = book.getJudul();
                if (book.getStatus().equals("Aktif") && !displayedTitles.contains(judulBuku)) {
                    System.out.println(no + ". " + judulBuku);
                    displayedTitles.add(judulBuku);
                    no++;
                }
            }

            System.out.print("Pilih Nomor Judul Buku: ");
            int pilihJudul1 = input.nextInt();
            input.nextLine(); // Consume newline

            if (pilihJudul1 >= 1 && pilihJudul1 <= displayedTitles.size()) {
                String selectedTitle = displayedTitles.get(pilihJudul1 - 1);

                no = 1; // Reset nomor unik untuk detail buku

                for (Book book : allBooks) {
                    if (book.getStatus().equals("Aktif") && book.getJudul().equals(selectedTitle)) {
                        System.out.println(no + ". " + selectedTitle + " - " + book.getIsbn());
                        displayedDetail.add(selectedTitle);
                        no++;
                    }
                }

                int bookOrder = 1; // To keep track of the book's order
                String isbn = null;
                System.out.print("Pilih Nomor Buku: ");
                int pilihIsbn = input.nextInt();
                input.nextLine(); // Consume newline
                for (Book book : allBooks) {
                    if (book.getStatus().equals("Aktif") && book.getJudul().equals(selectedTitle)) {
                        if (bookOrder == pilihIsbn) {
                            isbn = book.getIsbn();
                            break; // Exit the loop after selecting the book
                        }
                        bookOrder++; // Increment the book's order
                    }
                }
                if (bookOrder <= pilihIsbn) {
                    System.out.println("Nomor Buku tidak valid.");
                }

                Book selectedIsbn = perpus.getBookByIsbn(isbn);

                if (selectedIsbn != null) {
                    String nama;
//                    input.nextLine(); // Consume newline
                    while (true) {
                        System.out.println("Siapa Yang Meminjam: ");
                        nama = input.nextLine();

                        if (members.isEmpty()){
                            System.out.println("Anda Telah Keluar");
                            break;
                        }else{
                            if (nama.equals("0")){
                                System.out.println("Anda Telah Keluar");
                                break;
                            }else {
                                if (!KelolaMembers.isMembersExists(members, nama)) {
                                    System.out.println("Nama " + nama + " Tidak Terdaftar");
                                } else {
                                    Anggota anggota = KelolaMembers.getMemberByName(members, nama);
                                    if (anggota != null) {
                                        perpus.addPinjam(anggota, selectedIsbn);
                                    } else {
                                        System.out.println("Anggota dengan nama " + nama + " tidak ditemukan.");
                                    }
                                    System.out.println("Peminjaman berhasil ditambahkan.");
                                    break;
                                }
                            }
                        }

                    }
                } else {
                    System.out.println("Buku dengan ISBN " + isbn + " tidak ditemukan.");
                }
            } else {
                System.out.println("Nomor Judul Buku tidak valid.");
            }

        }

    }

    // Method untuk mengembalikan buku berdasarkan ISBN
    public static void kembalikanBuku(Library perpus, Scanner input, List<Anggota> members){
        List<Peminjaman> listPeminjaman = new ArrayList<>();
        String isbn;
        input.nextLine();
        while (true) {
            System.out.print("Input ISBN : ");
            isbn = input.nextLine();
            if (kelola.KelolaBuku.validate13DigitNumericString(isbn)) {
                if (cekPeminjamanByIsbn(listPeminjaman, isbn)){
                    System.out.println("Buku dengan "+isbn+" Tidak ada dalam data peminjaman.");

                }else {
                    break;
                }
            } else {
                System.out.println("String tidak valid dengan 13 digit numerik.");
            }
        }
        perpus.kembalikan(isbn);

    }

    // Method untuk memeriksa apakah ada peminjaman dengan ISBN tertentu
    public static boolean cekPeminjamanByIsbn(List<Peminjaman> peminjamanBuku, String isbn){
        for (Peminjaman peminjaman : peminjamanBuku) {
            if (peminjaman.getBook().getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }
}
