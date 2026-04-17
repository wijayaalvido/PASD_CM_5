import java.util.Scanner;

public class CM5Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Mahasiswa5[] mhs = {
            new Mahasiswa5("22001", "Andi ", "Teknik Informatika"),
            new Mahasiswa5("22002", "Budi ", "Teknik Informatika"),
            new Mahasiswa5("22003", "Citra", "Sistem Informasi Bisnis")
        };

        Buku5[] buku = {
            new Buku5("B001", "Algoritma  ", 2020),
            new Buku5("B002", "Basis Data ", 2019),
            new Buku5("B003", "Pemrograman", 2021),
            new Buku5("B004", "Fisika     ", 2024)
        };

        Peminjaman5[] pj = {
            new Peminjaman5(mhs[0], buku[0], 7),
            new Peminjaman5(mhs[1], buku[1], 3),
            new Peminjaman5(mhs[2], buku[2], 10),
            new Peminjaman5(mhs[2], buku[3], 6),
            new Peminjaman5(mhs[0], buku[1], 4)
        };

        int menu;
        do {
            System.out.println("\n=== Menu Peminjaman Buku ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("6. Urutkan Buku Berdasarkan Tahun Terbit Terlama");
            System.out.println("0. Keluar");
            System.out.print("\nPilih menu: ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    tampilMahasiswa(mhs);
                    break;

                case 2:
                    tampilBuku(buku);
                    break;

                case 3:
                    tampilPeminjaman(pj);
                    break;

                case 4:
                    sortDESC(pj);
                    System.out.println("Setelah diurutkan (DESC):");
                    tampilPeminjaman(pj);
                    break;

                case 5:
                    System.out.print("Masukkan NIM: ");
                    String nim = sc.next();
                    cariNIM(pj, nim);
                    break;
                case 6:
                    sortTahunTerbit(buku);
                    System.out.println("Buku setelah diurutkan berdasarkan tahun terbit:");
                    tampilBuku(buku);
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }

        } while (menu != 0);
    }


    static void tampilMahasiswa(Mahasiswa5[] mhs) {
        System.out.println("Daftar Mahasiswa:");
        for (Mahasiswa5 m : mhs) {
            System.out.println("NIM: " + m.nim + " | Nama: " + m.nama + " | Prodi: " + m.prodi);
        }
    }

    static void tampilBuku(Buku5[] buku) {
        System.out.println("Daftar Buku:");
        for (Buku5 b : buku) {
            System.out.println("Kode: " + b.kodeBuku + " | Judul: " + b.judulBuku + " | Tahun: " + b.tahunTerbit);
        }
    }

    static void tampilPeminjaman(Peminjaman5[] pj) {
        System.out.println("Daftar Peminjaman:");
        for (Peminjaman5 p : pj) {
            System.out.println(p.mhs.nama + " | " + p.buku.judulBuku +
                    " | Lama: " + p.lamaPinjam +
                    " | Denda: " + p.denda);
        }
    }

    static void sortDESC(Peminjaman5[] pj) {
        for (int i = 1; i < pj.length; i++) {
            Peminjaman5 temp = pj[i];
            int j = i - 1;

            while (j >= 0 && pj[j].denda < temp.denda) {
                pj[j + 1] = pj[j];
                j--;
            }
            pj[j + 1] = temp;
        }
    }

    static void cariNIM(Peminjaman5[] pj, String nim) {
        boolean ditemukan = false;

        for (Peminjaman5 p : pj) {
            if (p.mhs.nim.equals(nim)) {
                System.out.println(p.mhs.nama + " | " + p.buku.judulBuku +
                        " | Lama: " + p.lamaPinjam +
                        " | Denda: " + p.denda);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Data tidak ditemukan!");
        }
    }

    static void sortTahunTerbit(Buku5[] buku) {
            for (int i = 1; i < buku.length; i++) {
                Buku5 temp = buku[i];
                int j = i - 1;

                while (j >= 0 && buku[j].tahunTerbit < temp.tahunTerbit) {
                    buku[j + 1] = buku[j];
                    j--;
                }
                buku[j + 1] = temp;
        }
    }
}