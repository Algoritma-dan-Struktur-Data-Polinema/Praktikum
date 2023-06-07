import java.util.Scanner;

public class DLLPasienMain {
    static Scanner sc = new Scanner(System.in);
    static boolean exit = false;
    public static void main(String[] args) throws Exception {
        DLLPasien dll = new DLLPasien();
        antreanVaksin(dll);
    }

    public static void antreanVaksin(DLLPasien dll) throws Exception {
        while(!exit) {
            menu();
            int pilihMenu = sc.nextInt();
            
            switch(pilihMenu) {
                case 1:
                    System.out.print("Masukkan no antrean: ");
                    int noAntre = sc.nextInt();
                    System.out.print("Masukkan nama: ");
                    String nama = sc.next();
                    Pasien p = new Pasien(noAntre, nama);
                    dll.addLast(p);
                    break;
                case 2:
                    dll.removeFirst();
                    System.out.println("Pasien pertama berhasil di hapus");
                    System.out.println("Sisa Antrean "+dll.size());
                    break;
                case 3:
                    dll.print();
                    System.out.println("Sisa Antrean "+dll.size());
                    break;
                case 4:
                    exit = true;
                    System.out.println("Terima kasih telah menggunakan sistem antrean");
                    break;
                default:
                    System.out.println("Menu tidak ditemukan. Silahkan pilih kembali.");
                    break;
            }
            System.out.println();
        }
    }

    public static void menu() {
        System.out.println("+++++++++++++++++");
        System.out.println("Sistem Antrean Vaksin");
        System.out.println("+++++++++++++++++");
        System.out.println("1. Tambah Data \n2. Hapus Data\n3. Tampil Data\n4. Keluar");
        System.out.println("+++++++++++++++++");
        System.out.print("Pilih menu (1/2/3/4) : ");
    }
}
