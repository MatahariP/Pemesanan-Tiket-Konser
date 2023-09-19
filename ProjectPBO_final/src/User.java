import java.util.*;

abstract class user {
    private String email;
    private String password;
    private String Nama;
    private String NoTelp;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public void setNoTelp(String NoTelp) {
        this.NoTelp = NoTelp;
    }

    public String getPassword() {// apus ga ya?
        return password;
    }
}

class dataUser extends user {
    List<String> listEmail = new ArrayList<>(Collections.singletonList(""));
    List<String> listPassword = new ArrayList<>(Collections.singletonList(""));
    List<String> listNama = new ArrayList<>(Collections.singletonList(""));
    List<String> listNoTelp = new ArrayList<>(Collections.singletonList(""));
    Scanner scanner = new Scanner(System.in);
    String inputEmail;
    String inputPassword;
    String inputPassword2;

    String inputNama;
    String inputNoTelp;
    boolean sukses = true;

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
        listEmail.add(email);

    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
        listPassword.add(password);
    }

    @Override
    public void setNama(String Nama) {
        super.setNama(Nama);
        listNama.add(Nama);
    }

    @Override
    public void setNoTelp(String NoTelp) {
        super.setNoTelp(NoTelp);
        listNoTelp.add(NoTelp);
    }

    public void register() {
        sukses = false;
        while (!sukses) {
            System.out.print("Email \t\t\t\t: ");
            inputEmail = scanner.nextLine();
            if (!inputEmail.contains("@")&&!inputEmail.contains(".com")) {
                System.out.println("Masukkan email yang valid. Contoh = hadi@gmail.com");
                sukses = false;
            } else if (listEmail.contains(inputEmail)) {
                System.out.println("Email sudah terdaftar.");
                System.out.println("\n\n");
                sukses = false;
            } else {
                setEmail(inputEmail);
                sukses = false;
                while (!sukses) {
                    System.out.print("Nama \t\t\t\t: ");
                    inputNama = scanner.nextLine();
                    if (inputNama.matches(".*\\d.*")) {
                        System.out.println("Nama tidak boleh Angka");
                        sukses = false;
                    } else if (inputNama.length()<3) {
                        System.out.println("Masukkan nama dengan jelas");
                    } else {
                        setNama(inputNama);
                        while (!sukses) {
                            System.out.print("No.Telp \t\t\t: ");
                            inputNoTelp = scanner.nextLine();
                            if (!inputNoTelp.matches("\\d+")) {
                                System.out.println("Harus Angka");
                                sukses = false;
                            } else if (inputNoTelp.length()<10) {
                                System.out.println("No Telpon tidak valid");
                                sukses = false;
                            } else {
                                setNoTelp(inputNoTelp);
                                sukses = false;
                                while (!sukses) {
                                    System.out.print("Password \t\t\t: ");
                                    inputPassword = scanner.nextLine();
                                    System.out.print("Konfirmasi Password : ");
                                    inputPassword2 = scanner.nextLine();
                                    if (inputPassword.equals(inputPassword2)) {
                                        sukses = true;
                                        setPassword(inputPassword);
                                        System.out.println("\n\n");
                                    } else {
                                        System.out.println("Password Salah! Silahkan ulangi lagi!");
                                    }
                                }
                            }
                        }
                    }
                }

            }

        }
    }

    public void login() {
        System.out.println("Email \t\t: ");
        inputEmail = scanner.nextLine();
        if (!listEmail.contains(inputEmail)) {
            System.out.println("Email tidak terdaftar!");
            System.out.println("\n\n");
            sukses = false;
        } else {
            super.setEmail(inputEmail);
            System.out.print("Password \t: ");
            inputPassword = scanner.nextLine();
            //System.out.println("\n");
            int indexEmail = listEmail.indexOf(inputEmail);
//            System.out.println(listPassword.get(indexEmail) + "=" + inputPassword);
            if (!listPassword.get(indexEmail).equals(inputPassword)) {
                System.out.println("Password Salah!");
                System.out.println("\n\n");
                sukses = false;
            } else {
                super.setPassword(inputPassword);
                System.out.println("\n\n");
            }
        }
    }
}
