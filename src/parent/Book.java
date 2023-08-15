package parent;

public class Book {
    private String judul; // Variabel pribadi untuk mengenkapsulasi informasi judul buku
    private String penulis; // Variabel pribadi untuk mengenkapsulasi informasi penulis buku
    private String isbn; // Variabel pribadi untuk mengenkapsulasi informasi ISBN buku
    private int jumlahTersedia; // Variabel pribadi untuk mengenkapsulasi informasi jumlah buku tersedia
    private String status; // Variabel pribadi untuk mengenkapsulasi informasi status buku

    public Book(String judul, String penulis, String isbn, String status) {
        this.judul = judul;
        this.penulis = penulis;
        this.isbn = isbn;
        this.status = status;
    }

    public String getJudul() {
        return judul; // Metode getter untuk mengenkapsulasi pengambilan data judul buku
    }

    public void setJudul(String judul) {
        this.judul = judul; // Metode setter untuk mengenkapsulasi modifikasi data judul buku
    }

    public String getPenulis() {
        return penulis; // Metode getter untuk mengenkapsulasi pengambilan data penulis buku
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis; // Metode setter untuk mengenkapsulasi modifikasi data penulis buku
    }

    public String getIsbn() {
        return isbn; // Metode getter untuk mengenkapsulasi pengambilan data ISBN buku
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn; // Metode setter untuk mengenkapsulasi modifikasi data ISBN buku
    }

    public void setJumlahTersedia(int jumlahTersedia) {
        this.jumlahTersedia = jumlahTersedia; // Metode setter untuk mengenkapsulasi modifikasi data jumlah buku tersedia
    }

    public String getStatus() {
        return status; // Metode getter untuk mengenkapsulasi pengambilan data status buku
    }

    public void setStatus(String status) {
        this.status = status; // Metode setter untuk mengenkapsulasi modifikasi data status buku
    }
}
