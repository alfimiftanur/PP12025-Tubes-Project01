package entity;

public class Admin {
    private String id;
    private String nama;
    private String password;

    public Admin(String id, String nama, String password) {
        this.id = id;
        this.nama = nama;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
