import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dataUser user = new dataUser();
        mainTicket ticket = new mainTicket();
        boolean start = true;
        int choice;
        try {
            do {
                if (start) {
                    System.out.println("===================================================");
                    System.out.println("             Coldplay World Tour 2023");
                    System.out.println("               Music Of The Spheres");
                    System.out.println("      GBK Stadium, Jakarta | 15 November 2023");
                    System.out.println("---------------------------------------------------");
                    System.out.println("         RueTix - Online Ticketing Platform");
                    System.out.println("===================================================");
                    start = false;
                }
                System.out.println("Menu:");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Keluar");
                System.out.print("Masukkan pilihan Anda: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 0:
                        continue;
                    case 1:
                        user.sukses = true;
                        System.out.println("\n---------------------------------------------------");
                        System.out.println("                       Login ");
                        System.out.println("---------------------------------------------------\n");
                        user.login();
                        if (user.sukses) {
                            System.out.println("Pilih Batch : \n1." + ticket.listBatch.get(1) + "\n2." + ticket.listBatch.get(2));// Beli Tiket nanti di sini
                            ticket.pilihBatch = scanner.nextInt();
                            System.out.println("\n");
                            if (ticket.pilihBatch != 1 && ticket.pilihBatch != 2) {
                                System.out.println("Inputan Salah");
                                System.out.println("\n\n");
                                continue;
                            }
                            ticket.inputVerifikasi = 2;
                            while (ticket.inputVerifikasi == 2) {
                                System.out.print("Jumlah Kursi : ");
                                ticket.inputJumKursi = scanner.nextInt();
                                System.out.println("\n");
                                if (ticket.inputJumKursi > 2) {
                                    System.out.println("Jumlah kursi tidak boleh lebih dari 2!");
                                    System.out.println("\n");
                                } else if (ticket.inputJumKursi < 0) {
                                    System.out.println("Inputan Salah!");
                                    System.out.println("\n");
                                }else {
                                    if (ticket.inputJumKursi == 1) {
                                        ticket.pesanTicket();
                                        System.out.println("\n");
                                    } else if (ticket.inputJumKursi == 2) {
                                        ticket.pesanTicket(ticket.inputJumKursi);
                                        System.out.println("\n");
                                    }
                                    ticket.printVerifikasi();
                                }
                            }
                            ticket.Pembayaran();
                            ticket.printBukti(user);
                        }
                        continue;
                    case 2:
                        System.out.println("\n---------------------------------------------------");
                        System.out.println("                     Register ");
                        System.out.println("---------------------------------------------------\n");
                        user.register();
                        continue;
                    case 3:
                        System.out.println("\nTerima kasih. Program berakhir.");
                        choice = 0;
                        System.out.println("\n");
                        break;
                    default:
                        System.out.println("\nPilihan tidak valid. Silakan coba lagi.");
                        System.out.println("\n");
                        break;
                }
            }
            while (choice != 0);
        } catch (InputMismatchException e) {
            System.out.println("Terjadi Error karena input yang diberikan bukan angka. Silahkan memulai Program kembali.");
            System.out.println("\n");
        }
    }
}
