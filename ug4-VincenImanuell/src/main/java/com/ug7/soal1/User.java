package com.ug7.soal1;

public class User {
    private String nama;
    private String email;
    private boolean isEmailConfirmed;
    private String PIN;
    private int uang;

    public User(String nama, String email, int uang) {
        this.nama = nama;
        this.email = email;
        this.uang = uang;
        this.PIN = generatePIN();
    }

    private String generatePIN() {
        String PIN = this.nama.substring(0,3) + this.nama.substring(0,3) + "369";
        return PIN;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getPIN() {
        return PIN;
    }

    public boolean isEmailConfirmed() {
        return isEmailConfirmed;
    }

    public void emailConfirmation() {
        this.isEmailConfirmed = true;
        System.out.println("Halo, " + this.getNama() + "! Email kamu (" + this.getEmail() + ") berhasil dikonfirmasi!");
    }

    public int getUang() {
        return uang;
    }

    public void withdraw(int jumlah) {
        this.uang += jumlah;
    }

    public void topup(int jumlah) {
        this.uang -= jumlah;
    }


}
