package com.ug7.soal1;

public class ShopeePay extends eWallet{

    public ShopeePay(User user) {
        super(user);
    }

    public String topup(int jumlah){
        feeTP = 500;
        if ((jumlah >= 0) && (user.getUang() >= jumlah+feeTP)) {
            this.saldo += jumlah-feeTP;
            user.topup(jumlah);
            String pesan = "Halo "+user.getNama()+"! Top up saldo sebesar Rp"+jumlah+" berhasil!";
            return pesan;
        } else {
            return "["+user.getNama()+"]"+" - Maaf, uang cash kamu tidak mencukupi! (-Rp"+(jumlah-(user.getUang()+feeTP))+")";
        }
    }

    public void getInfo(){
        keterangan = "[ShopeePay e-wallet]";
        String nama = user.getNama();
        String pin = user.getPIN();
        String email = user.getEmail();
        int uang = user.getUang();
        String hasil = keterangan+"\nNama: "+nama+" [PIN: "+pin+"]\nEmail: "+email+"\nUang cash: Rp"+uang+"\nSaldo e-wallet: Rp"+this.saldo;
        System.out.println(hasil);
    }
    public String transfer(eWallet eWallet, int jumlah){
        boolean x = user.isEmailConfirmed();
        if (x == true) {
            if ((jumlah >= 0) && (this.saldo >= jumlah + feeTF)) {
                this.saldo -= (jumlah + feeTF);
                eWallet.saldo += jumlah;
                return "transfer berhasil";
            } else {
                return "saldo kurang";
            }
        } else {
            return "konfirmasi email dulu";
        }
    }

    public void withdraw(int jumlah){
        feeWD = 1000;
        if ((jumlah >= 0) && (this.saldo >= jumlah+feeWD)){
            this.saldo -= (jumlah+feeWD);
            user.withdraw(jumlah);
        }
    }

}
