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

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahBarangAkhir() {
        Scanner sc = new Scanner(System.in);

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

        Barang posBarang = null;
        Barang curBarang = null;
        Barang newBarang = new Barang(kode, nama, jenis, stok, harga);

        if (isEmpty()) {
            head = newBarang;
        } else {
            curBarang = head;
            while (curBarang != null) {
                posBarang = curBarang;
                curBarang = curBarang.getNext();
            }
            posBarang.setNext(newBarang);
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

    public void tambahBarangTengah() {
        Scanner sc = new Scanner(System.in);

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

        System.out.print("Masukkan posisi untuk menambahkan barang di tengah: ");
        int posisi = sc.nextInt();

        Barang posBarang = new Barang(kode, nama, jenis, stok, harga);
        Barang curBarang;
        int i = 1;

        if (head == null) {
            head = posBarang;
        } else {
            curBarang = head;
            if (posisi == 1) {
                posBarang.setNext(head);
                head = posBarang;
            } else {
                while (curBarang != null && i < posisi - 1) {
                    curBarang = curBarang.getNext();
                    i++;
                }
                if (curBarang == null) {
                    System.out.println("Posisi melebihi jumlah barang yang ada.");
                } else {
                    posBarang.setNext(curBarang.getNext());
                    curBarang.setNext(posBarang);
                }
            }
        }
        System.out.println("Barang berhasil ditambahkan!");
        System.out.println("----------------------");
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

                int stokBaru = -1;
                while (stokBaru < 0) {
                    System.out.print("Stok barang baru (" + temp.getStok() + "): ");
                    String inputStok = sc.nextLine();
                    if (inputStok.trim().isEmpty()) {
                        stokBaru = temp.getStok();
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
                        stokBaru = -1;
                    }
                }


                double hargaBaru = -1.0;
                while (hargaBaru < 0) {
                     System.out.print("Harga barang baru (Rp " + String.format("%,.2f", temp.getHarga()) + "): ");
                    String inputHarga = sc.nextLine();
                    if (inputHarga.trim().isEmpty()) {
                        hargaBaru = temp.getHarga();
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
                        hargaBaru = -1.0;
                    }
                }

                System.out.println("Barang berhasil diupdate!");
                break;
            }
            temp = temp.getNext();
        }

        if (!ditemukan) {
            System.out.println("Barang dengan kode " + kode + " tidak ditemukan.");
        }
        System.out.println("----------------------");
    }

    public void hapusBarangTengah() {
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

    public void hapusBarangTerakhir() {
        if (head == null) {
            System.out.println("Tidak ada barang untuk dihapus.");
            return;
        }

        if (head.getNext() == null) {
            head = null;
            System.out.println("Barang terakhir berhasil dihapus.");
            return;
        }

        Barang temp = head;
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(null);
        System.out.println("Barang terakhir berhasil dihapus.");
    }

}