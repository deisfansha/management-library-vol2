package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import parent.Book;

public class Library {
    private List<Book> books; // Private field to store books
    private List<Peminjaman> peminjamanBuku; // Private field to store peminjaman data

    public Library() {
        books = new ArrayList<>();
        peminjamanBuku = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to get a book by its ISBN
    public Book getBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Method to retrieve all books in the library
    public List<Book> getAllBooks() {
        return books;
    }

    // Method to delete a book by changing its status
    public void deleteBook(String isbn) {
        Book book = getBookByIsbn(isbn);
        book.setStatus("Non Aktif");
        System.out.println("Data Berhasil Terhapus");
    }

    // Method to add a peminjaman record
    public void addPinjam(Anggota anggota, Book buku) {
        if (buku != null) {
            Peminjaman peminjaman = new Peminjaman(anggota, buku, LocalDate.now(), null);
            peminjamanBuku.add(peminjaman);
            buku.setStatus("Dipinjam");
        } else {
            System.out.println("Book is null. Cannot add peminjaman.");
        }
    }

    // Method to mark a book as returned in peminjaman records
    public void kembalikan(String isbn) {
        for (Peminjaman peminjaman : peminjamanBuku) {
            if (peminjaman.getBook().getIsbn().equals(isbn) && peminjaman.getTanggalPengembalian() == null) {
                peminjaman.getBook().setStatus("Aktif");
                peminjaman.setTanggalPengembalian(LocalDate.now());
                System.out.println("Buku dengan ISBN " + isbn + " telah dikembalikan.");
                return; // Exit the loop after finding and processing the book
            }
        }
    }

    // Method to display peminjaman data
    public void tampilDataPeminjaman() {
        int no = 1;
        if (peminjamanBuku.isEmpty()) {
            System.out.println("\nBelum ada Buku yang dipinjam\n");
        } else {
            System.out.println("Daftar Data Peminjaman:");
            for (Peminjaman peminjaman : peminjamanBuku) {
                if (peminjaman.getTanggalPengembalian() == null) {
                    System.out.println(no + ". " + peminjaman.getAnggota().getId() + " | : " + peminjaman.getAnggota().getNama() + " | " + peminjaman.getBook().getJudul() + " | " + peminjaman.getBook().getIsbn() + " | " + peminjaman.getTanggalPeminjaman());
                    no++;
                }
            }
        }
    }

    // Method to display history data
    public void tampilDataHistory() {
        if (peminjamanBuku.isEmpty()) {
            System.out.println("\nBelum ada Buku yang dikembalikan\n");
        } else {
            System.out.println("Daftar Data Histotry:");
            for (Peminjaman peminjaman : peminjamanBuku) {
                if (peminjaman.getTanggalPengembalian() != null) {
                    System.out.println("> " + peminjaman.getAnggota().getId() + " | : " + peminjaman.getAnggota().getNama() + " | " + peminjaman.getBook().getJudul() + " | " + peminjaman.getBook().getIsbn());
                    System.out.println("Dipinjam : " + peminjaman.getTanggalPeminjaman() + "\tDikembalikan : " + peminjaman.getTanggalPengembalian());
                }
            }
        }
    }
}
