package library;

import java.util.ArrayList;
import java.util.List;

public class Anggota {
    private int id; // Variabel pribadi untuk mengenkapsulasi informasi ID anggota
    private String nama; // Variabel pribadi untuk mengenkapsulasi informasi nama anggota

    public Anggota(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id; // Metode getter untuk mengenkapsulasi pengambilan data ID anggota
    }

    public void setId(int id) {
        this.id = id; // Metode setter untuk mengenkapsulasi modifikasi data ID anggota
    }

    public String getNama() {
        return nama; // Metode getter untuk mengenkapsulasi pengambilan data nama anggota
    }

    public void setNama(String nama) {
        this.nama = nama; // Metode setter untuk mengenkapsulasi modifikasi data nama anggota
    }
}
