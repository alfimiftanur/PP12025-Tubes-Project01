package service;
import entity.Barang;
import java.util.Scanner;
import java.io.*;

public class Gudang {
    Barang head;
    private final String FILE_NAME = "D:\\data\\data_barang.dat";
    Scanner sc = new Scanner(System.in);

    public Gudang() {
        bacaDariFile();
    }
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

        simpanKeFile();
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

                simpanKeFile();
                System.out.println("Barang berhasil diupdate.");
                return;
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

    public void sortingBarang(String tipeUrut, boolean ascending) {
        if (head == null) {
            System.out.println("Tidak ada barang untuk diurutkan.");
            return;
        }

        Barang current = head;
        Barang index = null;
        String tempKode, tempNama, tempJenis;
        int tempStok;
        double tempHarga;

        while (current != null) {
            index = current.getNext();
            while (index != null) {
                boolean perluTukar = false;

                if (tipeUrut.equalsIgnoreCase("kode")) {
                    perluTukar = ascending
                            ? current.getKode().compareTo(index.getKode()) > 0
                            : current.getKode().compareTo(index.getKode()) < 0;
                } else if (tipeUrut.equalsIgnoreCase("nama")) {
                    perluTukar = ascending
                            ? current.getNama().compareTo(index.getNama()) > 0
                            : current.getNama().compareTo(index.getNama()) < 0;
                } else if (tipeUrut.equalsIgnoreCase("jenis")) {
                    perluTukar = ascending
                            ? current.getJenis().compareTo(index.getJenis()) > 0
                            : current.getJenis().compareTo(index.getJenis()) < 0;
                } else if (tipeUrut.equalsIgnoreCase("stok")) {
                    perluTukar = ascending
                            ? current.getStok() > index.getStok()
                            : current.getStok() < index.getStok();
                } else if (tipeUrut.equalsIgnoreCase("harga")) {
                    perluTukar = ascending
                            ? current.getHarga() > index.getHarga()
                            : current.getHarga() < index.getHarga();
                } else {
                    System.out.println("Tipe pengurutan tidak dikenali.");
                    return;
                }

                if (perluTukar) {
                    // Tukar data barang
                    tempKode = current.getKode();
                    tempNama = current.getNama();
                    tempJenis = current.getJenis();
                    tempStok = current.getStok();
                    tempHarga = current.getHarga();

                    current.setKode(index.getKode());
                    current.setNama(index.getNama());
                    current.setJenis(index.getJenis());
                    current.setStok(index.getStok());
                    current.setHarga(index.getHarga());

                    index.setKode(tempKode);
                    index.setNama(tempNama);
                    index.setJenis(tempJenis);
                    index.setStok(tempStok);
                    index.setHarga(tempHarga);
                }

                index = index.getNext();
            }
            current = current.getNext();
        }

        System.out.println("Barang berhasil diurutkan berdasarkan " + tipeUrut +
                (ascending ? " (naik)." : " (menurun)."));
    }

    public void simpanKeFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            Barang current = head;
            while (current != null) {
                oos.writeObject(current);
                current = current.getNext();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    public void bacaDariFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            head = null;
            Barang prev = null;

            while (true) {
                try {
                    Barang b = (Barang) ois.readObject();
                    b.setNext(null);
                    if (head == null) {
                        head = b;
                        prev = b;
                    } else {
                        prev.setNext(b);
                        prev = b;
                    }
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }

}