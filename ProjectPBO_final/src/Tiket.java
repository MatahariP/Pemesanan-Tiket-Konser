import java.text.SimpleDateFormat;
import java.util.*;

abstract class dataTicket implements ketentuan {
    List<String> listKategori = new ArrayList<>(Arrays.asList(null, "Ultimate Experience (Cat 1)",
            "My Universe (Festival)     ", "Cat 1 (Numbered Seating)   ", "Festival (Free Standing)   ",
            "Cat 2 (Numbered Seating)   ", "Cat 3 (Numbered Seating)   ", "Cat 4 (Numbered Seating)   ",
            "Cat 5 (Numbered Seating)   ", "Cat 6 (Numbered Seating)   ", "Cat 7 (Numbered Seating)   ",
            "Cat 8 (Numbered Seating)   "));
    List<Integer> listHarga = new ArrayList<>(Arrays.asList(null, 11000000, 5700000, 5000000, 3500000, 4000000,
            3250000, 2500000, 1750000, 1250000, 1250000, 800000));

    List<String> listBatch = new ArrayList<>(Arrays.asList(null, "6/Juni/2023 (Pre-Sale)", "7/Juni/2023 (Regular)"));

    public void jeda() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printBukti(dataUser user) {
        System.out.println("\n===================================================");
        System.out.println("Ticket Coldplay - Music of the Spheres World Tour");
        System.out.println("===================================================\n");
        System.out.println("Nama            : ");
        System.out.println("No. Telpon      : ");
        System.out.println("Email           : ");
        System.out.println("Customer #      : ");
        System.out.println("Nomor Transaksi : CD" );
        System.out.println("Waktu Transaksi : ");
        System.out.println("Kategori Kursi  : ");
        System.out.println("Harga           : ");
        System.out.println("Gate            : ");
        System.out.println("Row             : ");
        System.out.println("Seat            : ");
        System.out.println("\n!! Tiket bisa diunduh melalui email kalian !!");
        System.out.println("\n");

    }
}

class mainTicket extends dataTicket {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Date waktuSekarang = new Date();
    SimpleDateFormat formatWaktu = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    String waktuPemasanan;
    int inputKategori1;
    int inputKategori2;
    int inputMetode = 1;
    int inputVerifikasi = 2;
    int inputJumKursi;
    int pilihBatch;
    boolean sukses = true;

    public void printVerifikasi() {
        System.out.println("\n=================================================");
        System.out.println("      Verifikasi Pemesanan Tiket Coldplay");
        System.out.println("=================================================\n");

        if (inputJumKursi == 1) {
            System.out.println("Kategori kursi \t: " + listKategori.get(inputKategori1));
            if (pilihBatch == 1) {
                System.out.println("Harga \t\t\t: " + mataUang + (listHarga.get(inputKategori1) - preSale));
            } else if (pilihBatch == 2) {
                System.out.println("Harga \t\t\t: " + mataUang + listHarga.get(inputKategori1));
            }
        } else if (inputJumKursi == 2) {
            System.out.println("Kategori kursi ke-1\t: " + listKategori.get(inputKategori1));
            if (pilihBatch == 1) {
                System.out.println("Harga \t\t\t\t: " + mataUang + (listHarga.get(inputKategori1) - preSale));
            } else if (pilihBatch == 2) {
                System.out.println("Harga \t\t\t\t: " + mataUang + listHarga.get(inputKategori1));
            }
            System.out.println("Kategori kursi ke-2\t: " + listKategori.get(inputKategori2));
            if (pilihBatch == 1) {
                System.out.println("Harga \t\t\t\t: " + mataUang + (listHarga.get(inputKategori2) - preSale));
            } else if (pilihBatch == 2) {
                System.out.println("Harga \t\t\t\t: " + mataUang + listHarga.get(inputKategori2));
            }
            if (pilihBatch == 1)
                System.out.println("Total Harga \t\t: " + mataUang + ((listHarga.get(inputKategori1) - preSale) + (listHarga.get(inputKategori2) - preSale)));
            else if (pilihBatch == 2)
                System.out.println("Total Harga \t\t: " + mataUang + (listHarga.get(inputKategori1) + listHarga.get(inputKategori2)));

        }
        System.out.println("Apakah sudah benar?\n1.Ya\n2.Tidak");
        inputVerifikasi = scanner.nextInt();
        if (inputVerifikasi < 1 || inputVerifikasi > 2) {
            System.out.println("Inputan Salah!");
            System.out.println("\n");
            inputVerifikasi = 2;
        }

    }

    public void printBukti(dataUser user) {

        System.out.println("\n===================================================");
        System.out.println(" Ticket Coldplay - Music of the Spheres World Tour");
        System.out.println("         15 November 2023 at GBK Stadium");
        System.out.println("===================================================\n");
        System.out.println("Nama            : " + user.listNama.get(user.listEmail.indexOf(user.getEmail())));
        System.out.println("No Telpon       : " + user.listNoTelp.get(user.listEmail.indexOf(user.getEmail())));
        System.out.println("Email           : " + user.getEmail());
        System.out.println("Customer #      : " + user.listEmail.indexOf(user.getEmail()));
        System.out.println("Nomor Transaksi : CD" + random.nextInt(99) + ":" + random.nextInt(999999));
        System.out.println("Waktu Transaksi : " + waktuPemasanan);
        System.out.println("Kategori Kursi  : " + listKategori.get(inputKategori1));
        if (pilihBatch == 1) {
            System.out.println("Harga \t\t\t: " + mataUang + (listHarga.get(inputKategori1) - preSale));
        } else if (pilihBatch == 2) {
            System.out.println("Harga \t\t\t: " + mataUang + listHarga.get(inputKategori1));
        }
        System.out.println("Gate            : " + (random.nextInt(5) + 1));
        System.out.println("Row             : " + (random.nextInt(5) + 1));
        System.out.println("Seat            : " + (random.nextInt(40)) + 1);

        if (inputJumKursi == 2) {
            System.out.println("\n===================================================");
            System.out.println(" Ticket Coldplay - Music of the Spheres World Tour");
            System.out.println("         15 November 2023 at GBK Stadium");
            System.out.println("===================================================\n");
            System.out.println("Nama            : " + user.listNama.get(user.listEmail.indexOf(user.getEmail())));
            System.out.println("No Telpon       : " + user.listNoTelp.get(user.listEmail.indexOf(user.getEmail())));
            System.out.println("Email           : " + user.getEmail());
            System.out.println("Customer #      : " + user.listEmail.indexOf(user.getEmail()));
            System.out.println("Nomor Transaksi : CD" + random.nextInt(99) + ":" + random.nextInt(999999));
            System.out.println("Waktu Transaksi : " + waktuPemasanan);
            System.out.println("Kategori Kursi  : " + listKategori.get(inputKategori2));
            if (pilihBatch == 1) {
                System.out.println("Harga \t\t\t: " + mataUang + (listHarga.get(inputKategori2) - preSale));
            } else if (pilihBatch == 2) {
                System.out.println("Harga \t\t\t: " + mataUang + listHarga.get(inputKategori2));
            }//beda disini doang
            System.out.println("Gate            : " + (random.nextInt(5) + 1));
            System.out.println("Row             : " + (random.nextInt(5) + 1));
            System.out.println("Seat            : " + (random.nextInt(40) + 1));
        }
        System.out.println("\n!! Tiket bisa diunduh melalui email kalian !!");
        System.out.println("\n");
        jeda();

    }

    public void Pembayaran() {
        String kodeBank = null;
        inputMetode = 0;
        System.out.println("===================================================");
        System.out.println("                    Pembayaran");
        System.out.println("===================================================");
        while (inputMetode < 1 || inputMetode > 2) {
            System.out.println("\nPilih Metode Pembayaran : \n1.BCA\n2.BRI");
            inputMetode = scanner.nextInt();
            if (inputMetode < 1 || inputMetode > 2) {
                inputMetode = 0;
                System.out.println("Inputan salah silahkan ulangin kembali");
                System.out.println("\n");
            }
            System.out.println("Silahkan Transfer ke Rekening di bawah :");
            if (inputMetode == 1) {
                kodeBank = "621-360-6249 RUETIX";
            } else if (inputMetode == 2) {
                kodeBank = "5382-82-977388-94-8 RUETIX";
            }
        }
        System.out.println(kodeBank);
        jeda();

        waktuPemasanan = formatWaktu.format(waktuSekarang);
//        System.out.println("Waktu saat ini: " + waktuPemasanan);
        System.out.println("\n!! PEMBAYARAN BERHASIL !!\n");
    }

    public void pesanTicket() {
        sukses = false;
        while (!sukses) {

            if (pilihBatch == 1) {
                System.out.println("---------------------------------------------------");
                System.out.println("       Kategori Kursi dan Harga Tiket Pre Sale");
                System.out.println("---------------------------------------------------\n");
                for (int i = 1; i <= 11; i++) {
                    System.out.println(i + ". " + listKategori.get(i) + "\t|" + mataUang + (listHarga.get(i) - preSale) + "|");
                }

            } else if (pilihBatch == 2) {
                System.out.println("---------------------------------------------------");
                System.out.println("          Kategori Kursi dan Harga Tiket");
                System.out.println("---------------------------------------------------\n");
                for (int i = 1; i <= 11; i++) {
                    System.out.println(i + ". " + listKategori.get(i) + "\t|" + mataUang + (listHarga.get(i)) + "|");
                }
            }

            System.out.println("Pilih kategori : ");

            inputKategori1 = scanner.nextInt();
            if (inputKategori1 >= 12 || inputKategori1 <= 0) {
                System.out.println("Inputan salah!");
                System.out.println("\n");
                sukses = false;
            } else {
                sukses = true;
            }

        }
    }

    public void pesanTicket(int inputJumKursi) {
        sukses = false;
        while (!sukses) {

            if (pilihBatch == 1) {
                System.out.println("---------------------------------------------------");
                System.out.println("      Kategori Kursi dan Harga Tiket Pre Sale");
                System.out.println("---------------------------------------------------\n");
                for (int i = 1; i <= 11; i++) {
                    System.out.println(i + ". " + listKategori.get(i) + "\t|" + mataUang + (listHarga.get(i) - preSale) + "|");
                }

            } else if (pilihBatch == 2) {
                System.out.println("---------------------------------------------------");
                System.out.println("           Kategori Kursi dan Harga Tiket");
                System.out.println("---------------------------------------------------\n");
                for (int i = 1; i <= 11; i++) {
                    System.out.println(i + ". " + listKategori.get(i) + "\t|" + mataUang + (listHarga.get(i)) + "|");
                }
            }

            System.out.println("Pilih kategori kursi ke-" + (inputJumKursi - 1) + " :");
            inputKategori1 = scanner.nextInt();
            if (inputKategori1 >= 12 || inputKategori1 <= 0) {
                System.out.println("Inputan salah!");
                System.out.println("\n");
                sukses = false;
            } else {
                sukses = true;
            }
            System.out.println("Pilih kategori kursi ke-" + (inputJumKursi) + " :");
            inputKategori2 = scanner.nextInt();
            if (inputKategori2 >= 12 || inputKategori2 <= 0) {
                System.out.println("Inputan salah!");
                System.out.println("\n");
                sukses = false;
            } else {
                sukses = true;
            }
        }

    }
}
