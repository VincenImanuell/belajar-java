package com.ug7.soal1;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        User U_pengguna1 = new User("Plana", "plana@ti.ukdw.ac.id",50000);
        User U_pengguna2 = new User("Arona", "arona@ti.ukdw.ac.id", 30000);


        ShopeePay E_pengguna1 = new ShopeePay(U_pengguna1);
        GoPay E_pengguna2 = new GoPay(U_pengguna2);

        System.out.println("\n========== AWAL ==========");
        E_pengguna1.getInfo();
        E_pengguna2.getInfo();

        System.out.println("\n========== TOP UP #1 ==========");
        System.out.print("["+E_pengguna2.getUser().getNama()+"] - ");
        E_pengguna2.topup(10000);
        E_pengguna2.getInfo();

        System.out.println("\n========== TOP UP #2 ==========");
        System.out.print("["+E_pengguna1.getUser().getNama()+"] - ");
        E_pengguna1.topup(5000);
        E_pengguna1.getInfo();

        System.out.println("\n========== TOP UP #3 ==========");
        System.out.print("["+E_pengguna2.getUser().getNama()+"] - ");
        E_pengguna2.topup(50000);
        System.out.print("["+E_pengguna2.getUser().getNama()+"] - ");
        E_pengguna2.topup(9000);

        System.out.println("\n========== TRANSFER #1 ==========");
        System.out.print("["+E_pengguna1.getUser().getNama()+"] - ");
        E_pengguna1.transfer(E_pengguna2, 2500);

        System.out.println("\n========== KONFIRMASI EMAIL ==========");
        System.out.print("["+E_pengguna1.getUser().getNama()+"] - ");
        E_pengguna1.getUser().emailConfirmation();

        System.out.println("\n========== TRANSFER #2 ==========");
        System.out.print("["+E_pengguna1.getUser().getNama()+"] - ");
        E_pengguna1.transfer(E_pengguna2, 2500);

        System.out.println("\n========== TRANSFER #3 ==========");
        System.out.print("["+E_pengguna2.getUser().getNama()+"] - ");
        E_pengguna2.transfer(E_pengguna1, 9500);

        System.out.println("\n========== WITHDRAW #1 ==========");
        System.out.print("["+E_pengguna1.getUser().getNama()+"] - ");
        E_pengguna1.withdraw(1100);
        System.out.print("["+E_pengguna2.getUser().getNama()+"] - ");
        E_pengguna2.withdraw(1100);

        System.out.println("\n========== AKHIR ==========");
        E_pengguna1.getInfo();
        E_pengguna2.getInfo();
    }

    public static void tunggu(int detik)
    {
        try
        {
            for (int i = 0; i < detik; i++) {
                System.out.print(".");
                if(i == detik-1) System.out.println();
                Thread.sleep(detik * 1000);
            }
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static String formatRupiah(int nominal) {
        String str = String.valueOf(nominal);
        Double rupiah = Double.parseDouble(str);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(rupiah);
    }
}
