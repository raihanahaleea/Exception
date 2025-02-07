import java.util.Scanner;

// Parent class untuk transaksi
class Transaksi {
    protected String noFaktur;
    protected String kodeBarang;
    protected String namaBarang;
    protected double hargaBarang;
    protected int jumlahBeli;

    // Constructor
    public Transaksi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        this.noFaktur = noFaktur;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBeli = jumlahBeli;
    }

    // Method untuk menghitung total harga
    public double hitungTotal() {
        return hargaBarang * jumlahBeli;
    }
}

// Subclass untuk menangani validasi dan exception handling
class ValidasiTransaksi extends Transaksi {
    public ValidasiTransaksi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);
    }

    // Method untuk memvalidasi data input
    public void validasiData() throws IllegalArgumentException {
        if (hargaBarang < 0) {
            throw new IllegalArgumentException("Harga barang tidak boleh negatif.");
        }
        if (jumlahBeli <= 0) {
            throw new IllegalArgumentException("Jumlah beli harus lebih dari 0.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input data
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = scanner.nextDouble();

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = scanner.nextInt();

            // Membuat objek ValidasiTransaksi
            ValidasiTransaksi transaksi = new ValidasiTransaksi(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Validasi data
            transaksi.validasiData();

            // Menghitung total harga
            double totalHarga = transaksi.hitungTotal();
            System.out.println("Total Harga: Rp " + totalHarga);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
