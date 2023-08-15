package kelola;

import java.util.*;
import library.Library;
import parent.Book;

public class KelolaBuku {

    // Method to add a book to the library
    public static void tambahBuku(Library perpus, Scanner input, boolean ismenu) {
        String isbn;
        System.out.print("Input judul buku: ");
        input.nextLine();
        String judul = input.nextLine();

        if (judul.equals("0")) {
            ismenu = false;
        }

        System.out.print("Penulis : ");
        String penulis = input.nextLine();

        // Validate and input ISBN
        while (true) {
            System.out.print("Input ISBN : ");
            isbn = input.nextLine();
            if (validate13DigitNumericString(isbn)) {
                break;
            } else {
                System.out.println("String tidak valid dengan 13 digit numerik.");
            }
        }

        // Create a new book and add it to the library
        Book dataBuku = new Book(judul, penulis, isbn, "aktif");
        perpus.addBook(dataBuku);
    }

    // Method to view aggregated data about books in the library
    public static void viewData(Library perpus) {
        // Retrieve all books from the library
        List<Book> allBooks = perpus.getAllBooks();

        if (allBooks.isEmpty()) {
            System.out.println("Data masih Kosong");
        } else {
            System.out.println("Daftar Semua Buku:");

            // Create a map to store book titles and their counts
            Map<String, Integer> bookCounts = new HashMap<>();

            for (Book book : allBooks) {
                if (book.getStatus().equals("Aktif")) {
                    String judul = book.getJudul();
                    int count = bookCounts.getOrDefault(judul, 0);
                    bookCounts.put(judul, count + 1);
                }
            }

            // Display the aggregated book information
            for (Map.Entry<String, Integer> entry : bookCounts.entrySet()) {
                String judul = entry.getKey();
                int count = entry.getValue();

                System.out.println("\nJudul Buku : " + judul);
                System.out.println("Jumlah Buku : " + count);

                // Retrieve the book with the same title and display additional information
                for (Book book : allBooks) {
                    if (book.getJudul().equals(judul) && book.getStatus().equals("Aktif")) {
                        System.out.println("> " + book.getPenulis() + " | " + book.getIsbn());
                    }
                }
            }
        }
    }

    // Method to delete a book from the library
    public static void hapusData(Library perpus, Scanner input) {
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

            // Get user input for the book to be deleted
            System.out.print("Pilih Nomor Judul Buku: ");
            int pilihJudul1 = input.nextInt();
            input.nextLine(); // Consume newline

            // Rest of the code to select and delete the book
            // ...

        }
    }

    // Method to validate 13-digit numeric string
    public static boolean validate13DigitNumericString(String input) {
        return input.matches("\\d{13}");
    }
}
