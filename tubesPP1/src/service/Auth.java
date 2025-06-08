package service;

import entity.Admin;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Auth {
    private List<Admin> users = new ArrayList<>();
    private final String FILE_NAME = "D:\\data\\admin.dat";
    private Scanner scanner = new Scanner(System.in);


    public Auth() {
        bacaDariFile();
    }

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
        simpanKeFile();
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

    private void simpanKeFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data admin: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void bacaDariFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            users = (ArrayList<Admin>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Gagal membaca file admin: " + e.getMessage());
        }
    }
}
