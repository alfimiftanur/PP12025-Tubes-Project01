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

}