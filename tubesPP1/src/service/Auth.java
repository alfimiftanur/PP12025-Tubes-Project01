package service;

import entity.Admin;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Auth {
    private List<Admin> users = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Auth() {}

    public void register() {
        System.out.println("=== Registrasi Admin Baru ===");
        System.out.print("Masukkan ID Admin baru: ");
        String id = scanner.nextLine();

        for (Admin user : users) {
            if (user.getId().equals(id)) {
                System.out.println("ID sudah terdaftar!\n");
                return;
            }
        }

        System.out.print("Masukkan nama admin: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        users.add(new Admin(id, nama, password));
        System.out.println("Registrasi berhasil!\n");
    }

    public boolean login(String id, String password) {
        for (Admin user : users) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void tampilkanAdmin() {
        System.out.println("=== Daftar Admin Terdaftar ===");
        if (users.isEmpty()) {
            System.out.println("Belum ada admin terdaftar.\n");
            return;
        }

        for (Admin user : users) {
            System.out.println("ID: " + user.getId() + " | Nama: " + user.getNama());
        }
        System.out.println();
    }
}
