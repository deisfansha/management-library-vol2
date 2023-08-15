package kelola;

import library.Anggota;
import library.Peminjaman;

import java.util.List;
import java.util.Scanner;

public class KelolaMembers {

    // Method untuk menambahkan anggota baru
    public static void tambahAnggota(List<Anggota> members, Scanner input) {
        String nama;
        while (true) {
            System.out.print("Input Nama Anggota: ");
            input.nextLine();
            nama = input.nextLine();

            if (nama.isEmpty()) {
                System.out.println("Nama Tidak Boleh Kosong");
            } else {
                break;
            }
        }
        if (isMembersExists(members, nama)) {
            System.out.println("Nama Sudah Ada");
        } else {
            int newId = members.size() + 1;
            Anggota newMember = new Anggota(newId, nama);
            members.add(newMember);
            System.out.println("Anggota ditambahkan dengan ID: " + newId);
        }
    }

    // Method untuk menghapus anggota
    public static void hapusMember(List<Peminjaman> peminjamanBuku, List<Anggota> members, Scanner input) {
        String nama;
        while (true) {
            System.out.print("Input Nama Anggota: ");
            input.nextLine();
            nama = input.nextLine();

            if (nama.isEmpty()) {
                System.out.println("Nama Tidak Boleh Kosong");
            } else {
                break;
            }
        }
        if (!isMembersExists(members, nama)) {
            System.out.println("Nama " + nama + " Tidak Terdaftar");
        } else {
            if (cekPeminjamanByMember(peminjamanBuku, nama)) {
                System.out.println("Tidak dapat menghapus member " + nama + " karena memiliki peminjaman yang belum dikembalikan.");
            } else {
                // Cari anggota dan hapus dari daftar anggota
                Anggota memberToRemove = null;
                for (Anggota member : members) {
                    if (member.getNama().equalsIgnoreCase(nama)) {
                        memberToRemove = member;
                        break;
                    }
                }

                if (memberToRemove != null) {
                    members.remove(memberToRemove);
                    System.out.println("Hapus Member Berhasil: " + nama);
                } else {
                    System.out.println("Member dengan nama " + nama + " tidak ditemukan.");
                }
            }
        }
    }

    // Method untuk menampilkan daftar anggota
    public static void tampilAnggota(List<Anggota> members) {
        System.out.println("Daftar Anggota:");
        for (Anggota member : members) {
            System.out.println("ID: " + member.getId() + ", Nama: " + member.getNama());
        }
    }

    // Method untuk memeriksa apakah anggota sudah terdaftar
    public static boolean isMembersExists(List<Anggota> members, String nama) {
        for (Anggota member : members) {
            if (member.getNama().equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }

    // Method untuk mendapatkan objek anggota berdasarkan nama
    public static Anggota getMemberByName(List<Anggota> members, String nama) {
        for (Anggota member : members) {
            if (member.getNama().equalsIgnoreCase(nama)) {
                return member;
            }
        }
        return null;
    }

    // Method untuk memeriksa apakah anggota memiliki peminjaman yang belum dikembalikan
    public static boolean cekPeminjamanByMember(List<Peminjaman> peminjamanBuku, String nama) {
        for (Peminjaman peminjaman : peminjamanBuku) {
            if (peminjaman.getAnggota().getNama().equalsIgnoreCase(nama) && peminjaman.getTanggalPengembalian() == null) {
                return true;
            }
        }
        return false;
    }
}
