package com.juaracoding;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ATMTest {
    private ATM atm;

    @BeforeMethod
    public void setUp(){
        atm = new ATM(1000);
    }
    @Test
    //Menguji apakah metode lihatSaldo() mengembalikan saldo yang benar.
    public void testLihatSaldo(){
        Assert.assertEquals(atm.lihatSaldo(), 1000.0, "Saldo Awal harus 1000");
    }
    @Test
    //Menguji apakah metode setorUang() berfungsi dengan benar ketika jumlah yang valid disetor.
    public void testSetorUang(){
        atm.setorUang(500);
        Assert.assertEquals(atm.lihatSaldo(), 1500, "Saldo setelah setor uang harus 2500");
    }
    @Test
    //Menguji apakah metode tarikUang() berfungsi dengan benar ketika jumlah yang valid ditarik
    public void testTarikUang() {
        atm.tarikUang(500);
        Assert.assertEquals(atm.lihatSaldo(), 1000, "Saldo setelah tarik uang harus 2300");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangLebihDariSaldo() {
        atm.tarikUang(2000);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangNegatif() {
        atm.tarikUang(-200);
    }
}
