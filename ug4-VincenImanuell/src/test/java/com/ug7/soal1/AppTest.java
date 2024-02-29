package com.ug7.soal1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class AppTest {
    private User user1;
    private User user2;
    private GoPay gopay;
    private ShopeePay spay;

    @BeforeEach
    void setUp() throws Exception {
        user1 = new User("Kaedehara", "kaedehara@example.com", 50000);
        user2 = new User("Kazuha", "kazuha@example.com", 100000);
        gopay = new GoPay(user1);
        spay = new ShopeePay(user2);
    }

    @Test
    void testTopup() {
        gopay.topup(10000);
        assertEquals(9000, gopay.getSaldo());
        assertEquals(40000, gopay.getUser().getUang());

        spay.topup(10000);
        assertEquals(9500, spay.getSaldo());
        assertEquals(90000, spay.getUser().getUang());
    }

    @Test
    void testInsufficientTopup() {
        gopay.topup(100000);
        assertEquals(0, gopay.getSaldo());

        spay.topup(1000000);
        assertEquals(0, spay.getSaldo());
    }

    @Test
    void testEmail() {
        gopay.getUser().emailConfirmation();
        assertEquals(true, gopay.getUser().isEmailConfirmed());
    }

    @Test
    void testInsufficientPay() {
        gopay.pay(50000);
        assertEquals(0, gopay.getSaldo());
    }

    @Test
    void testTransferGoPay() {
        gopay.topup(10000);
        String input = "KaeKae369";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        gopay.transfer(spay, 5000);
        assertEquals(5000, spay.getSaldo());
        assertEquals(5000, spay.getSaldo());
    }

    @Test
    void testTransferSPay() {
        spay.topup(10000);
        spay.getUser().emailConfirmation();
        assertEquals(true, spay.getUser().isEmailConfirmed());
        spay.transfer(gopay, 5000);
        assertEquals(5000, gopay.getSaldo());
        assertEquals(4500, spay.getSaldo());
    }

    @Test
    void testWithdraw() {
        gopay.topup(10000);
        gopay.withdraw(1000);
        assertEquals(5500, gopay.getSaldo());

        spay.topup(10000);
        spay.withdraw(1000);
        assertEquals(7500, spay.getSaldo());
    }
}
