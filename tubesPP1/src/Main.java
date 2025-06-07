import java.util.Scanner;
import service.Auth;
import service.Gudang;

public class Main {
    public static void main(String[] args) {
        Auth authService = new Auth();
        Scanner sc = new Scanner(System.in);
        boolean isLoggedIn = false;
        int maxTrys = 3;

        System.out.println("=== SISTEM LOGIN ===");
        while (!isLoggedIn) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Lihat Admin");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            String menu = sc.nextLine();

            int menuPilihan;
            try {
                menuPilihan = Integer.parseInt(menu);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.\n");
                continue; // langsung ke awal loop tanpa lanjut ke switch
            }

            switch (menuPilihan) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    for (int i = 0; i < maxTrys; i++) {
                        if (authService.login(id, password)) {
                            System.out.println("Login berhasil!\n");
                            isLoggedIn = true;
                            break;
                        } else {
                            if (i < maxTrys - 1) {
                                System.out.println("ID atau password salah. Coba lagi (" + (maxTrys - i - 1) + " percobaan tersisa).\n");
                                System.out.print("ID: ");
                                id = sc.nextLine();
                                System.out.print("Password: ");
                                password = sc.nextLine();
                            } else {
                                System.out.println("Anda telah mencoba " + maxTrys + " kali. Program akan keluar.");
                                System.exit(0);
                            }
                        }
                    }

                    break;
                case 2:
                    authService.register();
                    break;
                case 3:
                    authService.tampilkanAdmin();
                    break;
                case 0:
                    System.out.println("Keluar dari program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.\n");
            }
        }

        Gudang g = new Gudang();
        int menuPilihanB = -1;

        do {
            System.out.println("===== MENU GUDANG =====");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tambah Barang di Tengah");
            System.out.println("3. Tambah Barang di Akhir");
            System.out.println("4. Tampilkan Barang");
            System.out.println("5. Urutkan Barang");
            System.out.println("6. Hapus Barang");
            System.out.println("7. Hapus Barang di Tengah");
            System.out.println("8. Hapus Barang di Akhir");
            System.out.println("9. Cari Barang");
            System.out.println("10. Update Barang");
            System.out.println("0. Keluar ");
            System.out.print("Pilihan: ");
            String pilihan = sc.nextLine();

            try {
                menuPilihanB = Integer.parseInt(pilihan);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.\n");
                menuPilihanB = -1;
            }

            switch (menuPilihanB) {
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
                    System.out.print("Urut berdasarkan apa? (kode/nama/jenis/stok/harga): ");
                    String tipe = sc.nextLine().toLowerCase();
                    System.out.print("Urutan (asc/desc): ");
                    String urutan = sc.nextLine().toLowerCase();

                    boolean ascending = urutan.equals("asc");
                    g.sortingBarang(tipe, ascending);
                    g.tampilkanBarang();
                    break;
                case 6:
                    g.hapusBarang();
                    break;
                case 7:
                    g.hapusBarangTengah();
                    break;
                case 8:
                    g.hapusBarangTerakhir();
                    break;
                case 9:
                    g.cariBarang();
                    break;
                case 10:
                    g.updateBarang();
                    break;
                case 0:
                    System.out.println("Keluar dari menu gudang...");
                    break;
                default:
                    System.out.println("Pilihan Tidak Tersedia!");
            }
            System.out.println();
        } while (menuPilihanB != 0);

        sc.close();
    }
}
