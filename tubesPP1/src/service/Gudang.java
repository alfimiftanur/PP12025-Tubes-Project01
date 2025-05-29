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
}