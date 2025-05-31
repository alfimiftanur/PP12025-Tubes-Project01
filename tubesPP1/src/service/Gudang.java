package service;
import entity.Barang;
import java.util.Scanner;

public class Gudang {
    Barang head;

    Scanner sc = new Scanner(System.in);


    //    dibawah ini merupakan method tambah barang
    public void tambahBarang() {
        System.out.print("Kode barang: ");
        String kode = sc.nextLine();

        System.out.print("Nama barang: ");
        String nama = sc.nextLine();

        System.out.print("Jenis barang: ");
        String jenis = sc.nextLine();

        System.out.print("Stok barang: ");
        int stok = sc.nextInt();

        System.out.print("Harga barang: Rp ");
        double harga = sc.nextDouble();
        sc.nextLine();

        Barang baru = new Barang(kode, nama, jenis, stok, harga);
        if (head == null) {
            head = baru;
        } else {
            Barang temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(baru);
        }

        System.out.println("Barang berhasil ditambahkan!");
        System.out.println("----------------------");
    }

    public void tampilkanBarang() {
        if (head == null) {
            System.out.println("Tidak ada barang di gudang.");
            return;
        }

        Barang temp = head;
        while (temp != null) {
            System.out.println("\nList Barang: ");
            System.out.println("Kode: " + temp.getKode());
            System.out.println("Nama: " + temp.getNama());
            System.out.println("Jenis: " + temp.getJenis());
            System.out.println("Stok: " + temp.getStok());
            System.out.println("Harga: Rp " + temp.getHarga());
            System.out.println("----------------------");
            temp = temp.getNext();
        }
    }

    public void hapusBarang() {
        if (head == null) {
            System.out.println("Tidak ada barang untuk dihapus.");
            return;
        }

        System.out.print("Masukkan kode barang yang ingin dihapus: ");
        String kode = sc.nextLine();

        Barang temp = head;
        Barang prev = null;

        while (temp != null && !temp.getKode().equals(kode)) {
            prev = temp;
            temp = temp.getNext();
        }

        if (temp == null) {
            System.out.println("Barang dengan kode " + kode + " tidak ditemukan.");
            return;
        }

        if (prev == null) {
            head = temp.getNext();
        } else {
            prev.setNext(temp.getNext());
        }

        System.out.println("Barang dengan kode " + kode + " berhasil dihapus.");
    }
    import java.util.ArrayList;

public class CariBarangConsole {
    // Kelas Barang
    static class Barang {
        String kode;
        String nama;
        int stok;

        Barang(String kode, String nama, int stok) {
            this.kode = kode;
            this.nama = nama;
            this.stok = stok;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Barang> daftarBarang = new ArrayList<>();

        // Data contoh
        daftarBarang.add(new Barang("BRG001", "Beras", 100));
        daftarBarang.add(new Barang("BRG002", "Gula", 50));
        daftarBarang.add(new Barang("BRG003", "Minyak Goreng", 30));
        daftarBarang.add(new Barang("BRG004", "Tepung", 20));

        System.out.println("=== Aplikasi Cari Barang di Gudang ===");

        while (true) {
            System.out.print("\nMasukkan nama atau kode barang (atau ketik 'exit' untuk keluar): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Keluar dari program.");
                break;
            }

            boolean ditemukan = false;
            for (Barang b : daftarBarang) {
                if (b.kode.toLowerCase().contains(input) || b.nama.toLowerCase().contains(input)) {
                    System.out.println("Ditemukan: ");
                    System.out.println("- Kode : " + b.kode);
                    System.out.println("- Nama : " + b.nama);
                    System.out.println("- Stok : " + b.stok);
                    ditemukan = true;
                }
            }

            if (!ditemukan) {
                System.out.println("Barang tidak ditemukan.");
            }
        }

        scanner.close();
    }
}
}