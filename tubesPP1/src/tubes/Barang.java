package tubes;

public class Barang {
    private String kode;
    private String nama;
    private String jenis;
    private int stok;
    private double harga;
    private Barang next;

    public Barang(String kode, String nama, String jenis, int stok, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.jenis = jenis;
        this.stok = stok;
        this.harga = harga;
        this.next = null; // Inisialisasi next sebagai null
    }
}
