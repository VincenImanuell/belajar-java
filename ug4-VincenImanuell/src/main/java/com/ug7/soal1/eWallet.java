package com.ug7.soal1;

//import sun.security.x509.IssuerAlternativeNameExtension;

import java.sql.SQLOutput;

public class eWallet {
    protected User user;

    protected int saldo;

    protected int feeTP = 0;

    protected int feeTF = 0;

    protected int feeWD = 0;

    protected String keterangan = "";

    public eWallet(User user){
        this.user = user;
        this.saldo = 0;
    }

    public String topup(int jumlah){
        if ((jumlah >= 0) && (user.getUang() >= jumlah+feeTP)) {
            this.saldo += jumlah-feeTP;
            user.topup(jumlah);
            String pesan = "Halo "+user.getNama()+"! Top up saldo sebesar Rp"+jumlah+" berhasil!";
            return pesan;
        } else {
            return "["+user.getNama()+"]"+" - Maaf, uang cash kamu tidak mencukupi! (-Rp"+(jumlah-(user.getUang()+feeTP))+")";
        }
    }

    public String transfer(eWallet eWallet, int jumlah){
        if ((jumlah >= 0) && (this.saldo >= jumlah+feeTF)) {
            this.saldo -= (jumlah+feeTF);
            eWallet.saldo += jumlah;
            return "";
        } else {
            return "";
        }
    }

    public void withdraw(int jumlah){
        if ((jumlah >= 0) && (this.saldo >= jumlah+feeWD)){
            this.saldo -= (jumlah-feeWD);
            user.withdraw(jumlah);
        }
    }

    public void getInfo(){
        String nama = user.getNama();
        String pin = user.getPIN();
        String email = user.getEmail();
        int uang = user.getUang();
        String hasil = keterangan+"\nNama: "+nama+" [PIN: "+pin+"]\nEmail: "+email+"\nUang cash: Rp"+uang+"\nSaldo e-wallet: Rp"+this.saldo;
        System.out.println(hasil);
    }

    public void pay(int jumlah){
        this.withdraw(jumlah);
    }
    public User getUser(){
        return user;
    }

    public int getSaldo(){
        return saldo;
    }
}
