import java.util.Scanner;
import service.Auth;
import service.Gudang;

public class Main {
    public static void main(String[] args) {
        Auth authService = new Auth();
        Scanner sc = new Scanner(System.in);
        boolean isLoggedIn = false;

        System.out.println("=== SISTEM LOGIN ===");
        while (!isLoggedIn) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Lihat Admin");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    if (authService.login(id, password)) {
                        System.out.println("Login berhasil!\n");
                        isLoggedIn = true;
                    } else {
                        System.out.println("ID atau password salah.\n");
                    }
                    break;
                case "2":
                    authService.register();
                    break;
                case "3":
                    authService.tampilkanAdmin();
                    break;
                case "0":
                    System.out.println("Keluar dari program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.\n");
            }
        }

        Gudang g = new Gudang();
        int pilihan;

        do {
            System.out.println("===== MENU GUDANG =====");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tambah Barang di Tengah");
            System.out.println("3. Tambah Barang di Akhir");
            System.out.println("4. Tampilkan Barang");
            System.out.println("5. Hapus Barang");
            System.out.println("6. Cari Barang");
            System.out.println("7. Update Barang");
            System.out.println("0. Keluar ");
            System.out.print("Pilihan: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    g.tambahBarang();
                    break;
                case 2:
                    g.tambahBarangTengah();
                    break;
                case 3:
                    g.tambahBarangAkhir();
                    break;
                case 4:
                    g.tampilkanBarang();
                    break;
                case 5:
                    g.hapusBarang();
                    break;
                case 6:
                    g.cariBarang();
                break;
                case 7:
                    g.updateBarang();
                break;
                case 0:
                    System.out.println("Keluar dari menu gudang...");
                    break;
                default:
                    System.out.println("Pilihan Tidak Tersedia!");
            }
            System.out.println();
        } while (pilihan != 0);

        sc.close();
    }
}