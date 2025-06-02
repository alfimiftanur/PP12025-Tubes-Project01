package service;
import entity.Barang;
import java.util.Scanner;

public class Gudang {
    Barang head;

    Scanner sc = new Scanner(System.in);


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

    public void cariBarang() {
        if (head == null) {
            System.out.println("Sedang tidak ada barang di gudang");
            return;
        }

        System.out.print("Masukkan kode barang yang ingin dicari: ");
        String kode = sc.nextLine();

        Barang temp = head;
        while (temp != null) {
            if (temp.getKode().equalsIgnoreCase(kode)) {
                System.out.println("Barang ditemukan:");
                System.out.println("Kode: " + temp.getKode());
                System.out.println("Nama: " + temp.getNama());
                System.out.println("Jenis: " + temp.getJenis());
                System.out.println("Stok: " + temp.getStok());
                System.out.println("Harga: Rp " + temp.getHarga());
                System.out.println("----------------------");
                return;
            }
            temp = temp.getNext();
        }

        System.out.println("Barang dengan kode " + kode + " tidak ditemukan.");
    }
     public void updateBarang() {
        if (head == null) {
            System.out.println("Tidak ada barang di gudang untuk diupdate.");
            System.out.println("----------------------");
            return;
        }

        System.out.print("Masukkan kode barang yang ingin diupdate: ");
        String kode = sc.nextLine();

        Barang temp = head;
        boolean ditemukan = false;

        while (temp != null) {
            if (temp.getKode().equalsIgnoreCase(kode)) {
                ditemukan = true;
                System.out.println("\nData barang saat ini:");
                System.out.println("Nama  : " + temp.getNama());
                System.out.println("Jenis : " + temp.getJenis());
                System.out.println("Stok  : " + temp.getStok());
                System.out.println("Harga : Rp " + String.format("%,.2f", temp.getHarga()));
                System.out.println("----------------------");
                System.out.println("Masukkan data baru (kosongkan jika tidak ingin mengubah field tertentu untuk Nama/Jenis):");

                System.out.print("Nama barang baru (" + temp.getNama() + "): ");
                String namaBaru = sc.nextLine();
                if (!namaBaru.trim().isEmpty()) {
                    temp.setNama(namaBaru);
                }

                System.out.print("Jenis barang baru (" + temp.getJenis() + "): ");
                String jenisBaru = sc.nextLine();
                if (!jenisBaru.trim().isEmpty()) {
                    temp.setJenis(jenisBaru);
                }

                // Untuk stok dan harga, kita akan selalu meminta input baru
                // atau bisa ditambahkan logika untuk skip jika input kosong (membutuhkan parsing dari String)
                
                int stokBaru = -1;
                while (stokBaru < 0) {
                    System.out.print("Stok barang baru (" + temp.getStok() + "): ");
                    String inputStok = sc.nextLine();
                    if (inputStok.trim().isEmpty()) { // Jika pengguna hanya menekan enter (tidak ingin mengubah)
                        stokBaru = temp.getStok(); // Gunakan stok lama
                        break; 
                    }
                    try {
                        stokBaru = Integer.parseInt(inputStok);
                        if (stokBaru < 0) {
                            System.out.println("Stok tidak boleh negatif. Silakan coba lagi.");
                        } else {
                             temp.setStok(stokBaru);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input stok tidak valid. Masukkan angka atau kosongkan.");
                        stokBaru = -1; // Set ulang agar loop berlanjut jika input salah
                    }
                }


                double hargaBaru = -1.0;
                while (hargaBaru < 0) {
                     System.out.print("Harga barang baru (Rp " + String.format("%,.2f", temp.getHarga()) + "): ");
                    String inputHarga = sc.nextLine();
                    if (inputHarga.trim().isEmpty()) { // Jika pengguna hanya menekan enter
                        hargaBaru = temp.getHarga(); // Gunakan harga lama
                        break;
                    }
                    try {
                        hargaBaru = Double.parseDouble(inputHarga);
                        if (hargaBaru < 0) {
                            System.out.println("Harga tidak boleh negatif. Silakan coba lagi.");
                        } else {
                            temp.setHarga(hargaBaru);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input harga tidak valid. Masukkan angka atau kosongkan.");
                        hargaBaru = -1.0; // Set ulang
                    }
                }

                System.out.println("Barang berhasil diupdate!");
                break; // Keluar dari loop while setelah update
            }
            temp = temp.getNext();
        }

        if (!ditemukan) {
            System.out.println("Barang dengan kode " + kode + " tidak ditemukan.");
        }
        System.out.println("----------------------");
    }

}