public class Peminjaman5 {
    Mahasiswa5 mhs;
    Buku5 buku;
    int lamaPinjam, denda;

    public Peminjaman5(Mahasiswa5 mhs, Buku5 buku, int lamaPinjam) {
        this.mhs = mhs;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
        hitungDenda();
    }

    void hitungDenda() {
        int batas = 5;
        int telat = lamaPinjam - batas;

        if (telat > 0) {
            denda = telat * 2000;
        } else {
            denda = 0;
        }
    }
}