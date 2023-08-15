import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import kelola.KelolaBuku;
import kelola.KelolaMembers;
import kelola.KelolaPeminjaman;
import library.Anggota;
import library.Library;

public class Main {
    public static void main(String[] args) {
        Library perpus = new Library(); // Objek Library yang menggunakan enkapsulasi untuk mengelola data buku dan peminjaman
        Scanner input = new Scanner(System.in);
        List<Anggota> members = new ArrayList<>(); // List Anggota yang menyimpan objek-objek Anggota dengan informasi yang dienkapsulasi
        boolean isMenu = true; // Variabel yang mengendalikan loop menu

        int menu;
        while (isMenu){
            System.out.println("\n============ Menu ============");
            System.out.println("1. Manage Buku");
            System.out.println("2. Manage Anggota");
            System.out.println("3. Peminjaman Buku");
            System.out.println("4. Daftar Buku");
            System.out.println("5. Data Histori");
            System.out.println("0. Exit");
            System.out.print("Pilih Menu : ");
            // Validasi angka tertentu
            if (input.hasNextInt()) {
                menu = input.nextInt();

                switch (menu) {
                    case 1:
                        subMenuBook(perpus, isMenu, input, menu);
                        break;
                    case 2:
                        subMenuMember(members, isMenu, input, menu);
                        break;
                    case 3:
                        subMenuPinjamBuku(perpus, members, isMenu, input, menu);
                        break;
                    case 4:
                        KelolaBuku.viewData(perpus);
                        break;
                    case 5:
                        perpus.tampilDataHistory();
                        break;
                    case 0:
                        // Keluar dari program
                        System.out.println("Terimakasih sudah menggunakan aplikasi ini!!!");
                        input.close();
                        System.exit(0);
                }
            } else {
                System.out.println("Maaf, input harus berupa angka.");
                input.next();
            }
        }
    }

    public static void subMenuBook(Library perpus, boolean isMenu, Scanner input, int menu){
        while (isMenu){
            System.out.println("\n============ Menu ============");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("0. Kembali");
            System.out.print("Pilih Menu : ");
            // Validasi angka tertentu
            if (input.hasNextInt()) {
                menu = input.nextInt();
                switch (menu) {
                    case 1:
                        KelolaBuku.tambahBuku(perpus, input, isMenu);
                        break;
                    case 2:
                        KelolaBuku.hapusData(perpus, input);
                        break;
                    case 0:
                        isMenu =false;
                        break;
                }
            } else {
                System.out.println("Maaf, input harus berupa angka.");
                input.next();
            }
        }
    }

    public static void subMenuMember(List<Anggota> members, boolean isMenu, Scanner input, int menu){
        while (isMenu){
            System.out.println("\n============ Menu ============");
            System.out.println("1. Tambah Anggota");
            System.out.println("2. Lihat Data Anggota");
            System.out.println("3. Hapus Anggota");
            System.out.println("0. Kembali");
            System.out.print("Pilih Menu : ");
            // Validasi angka tertentu
            if (input.hasNextInt()) {
                menu = input.nextInt();
                switch (menu) {
                    case 1:
                        KelolaMembers.tambahAnggota(members, input);
                        break;
                    case 2:
                        KelolaMembers.tampilAnggota(members);
                        break;
                    case 3:

                        break;
                    case 0:
                        isMenu =false;
                        break;
                }
            } else {
                System.out.println("Maaf, input harus berupa angka.");
                input.next();
            }
        }
    }

    public static void subMenuPinjamBuku(Library perpus, List<Anggota> members, boolean isMenu, Scanner input, int menu){
        while (isMenu){
            System.out.println("============ Menu ============");
            System.out.println("1. Pinjam Buku");
            System.out.println("2. Lihat Data Buku Dipinjam");
            System.out.println("3. Kembalikan Buku");
            System.out.println("0. Kembali");
            System.out.print("Pilih Menu : ");
            // Validasi angka tertentu
            if (input.hasNextInt()) {
                menu = input.nextInt();
                switch (menu) {
                    case 1:
                        KelolaPeminjaman.pinjamBuku(perpus, input, members);
                        break;
                    case 2:
                        perpus.tampilDataPeminjaman();
                        break;
                    case 3:
                        KelolaPeminjaman.kembalikanBuku(perpus, input, members);
                        break;
                    case 0:
                        isMenu =false;
                        break;
                }
            } else {
                System.out.println("Maaf, input harus berupa angka.");
                input.next();
            }
        }
    }
}