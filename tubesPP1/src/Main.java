import java.util.Scanner;
import service.Gudang;

public class Main {
    public static void main(String[] args) {
        Gudang g = new Gudang();
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do{
            System.out.println("Menu Pilihan");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tampilkan Barang");
            System.out.println("3. Hapus Barang");
            System.out.println("4. Cari Barang");
            System.out.println("5. Update Barang");
            System.out.println("0. Keluar ");
            System.out.print("Pilihan: ");
            pilihan = sc.nextInt();

            switch (pilihan){
                case 1:
                    g.tambahBarang();
                    break;
                case 2:
                    g.tampilkanBarang();
                    break;
                case 0:
                    System.out.println("Keluar");
                    break;
                default:
                    System.out.println("Pilihan Tidak Tersedia!");
            }
        }while(pilihan != 0);
    }
}