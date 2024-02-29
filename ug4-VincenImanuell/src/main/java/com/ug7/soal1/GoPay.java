package com.ug7.soal1;
import java.util.Scanner;  // Import the Scanner class
public class GoPay extends eWallet{
    public GoPay(User user) {
        super(user);
    }

    public String topup(int jumlah){
        feeTP = 1000;
        if (jumlah>=10000 && (user.getUang() >= jumlah)) {
            if ((jumlah >= 0) && (user.getUang() >= jumlah)) {
                this.saldo += jumlah - feeTP;
                user.topup(jumlah);
                String pesan = "Halo " + user.getNama() + "! Top up saldo sebesar Rp" + jumlah + " berhasil!";
                return pesan;
            } else {
                return " - Maaf, uang cash kamu tidak mencukupi! (-Rp" + (jumlah - (user.getUang() + feeTP)) + ")";
            }
        } else {
            return "TopUp minimal 10.000";
        }
    }

    public void withdraw(int jumlah){
        feeWD = 2500;
        if ((jumlah >= 0) && (this.saldo >= jumlah+feeWD)){
            this.saldo -= (jumlah+feeWD);
            user.withdraw(jumlah);
        }
    }

    public String transfer(eWallet eWallet, int jumlah){
        feeTF = 500;
        Scanner a = new Scanner(System.in);
        String inputPin = "";

        System.out.println("Input PIN: ");
        inputPin = a.next();

        String PIN = user.getPIN();

        if (inputPin.equals(PIN)) {
            if ((jumlah >= 0) && (this.saldo >= jumlah + feeTF)) {
                this.saldo -= (jumlah + feeTF);
                eWallet.saldo += jumlah;
                return "transfer berhasil";
            } else {
                return "saldo kurang";
            }
        } else {
            return "pin salah";
        }
    }

    public void getInfo(){
        keterangan = "[GoPay e-wallet]";
        String nama = user.getNama();
        String pin = user.getPIN();
        String email = user.getEmail();
        int uang = user.getUang();
        String hasil = keterangan+"\nNama: "+nama+" [PIN: "+pin+"]\nEmail: "+email+"\nUang cash: Rp"+uang+"\nSaldo e-wallet: Rp"+this.saldo;
        System.out.println(hasil);
    }

}
