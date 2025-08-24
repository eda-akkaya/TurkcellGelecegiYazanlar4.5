// Takım 9 - Ödev 1 :  Mini-ATM (menü tabanlı konsol uygulaması)
// Eda Akkaya - Utku Kağan Yavuzdoğan - Özgür Durak

package com.turkcell;

import java.util.Scanner;

public class miniATM {
    static double amount = 0;
    static Scanner myObj = new Scanner(System.in); // Scanner objesi oluşturma
    static double bakiye = 0;
    static double komisyon = 0;
    //static int billType = 1; // 1-elektrik, 2-su, 3-internet
    static double totalDeposit = 0;
    static double totalWithdraw = 0;
    static double totalBillsPaidCount = 0;
    //static boolean girisYap = true ;
    static boolean isContinue = true;
    static double billAmount = 0;


    public static void main(String[] args) {

        String USERNAME = "user";
        String PASSWORD = "1234";
        int numOfAttempts = 0;


        System.out.println("Mini-ATM'ye hoşgeldiniz !");

        while (numOfAttempts < 3 && isContinue){

            System.out.print("Kullanıcı adı giriniz: ");
            String userName = myObj.nextLine();  // User input okuma

            System.out.print("Şifrenizi giriniz: ");
            String password = myObj.nextLine();  // User input okuma

            if (userName.equals(USERNAME) && password.equals(PASSWORD)){
                System.out.println("Giriş başarılı! Menüye yönlendiriliyorsunuz...");

                while (isContinue) {
                    System.out.println("___MENU___");
                    System.out.println(
                            "1- Para Yatır\n" +
                                    "2- Para Çek\n" +
                                    "3- Bakiye Görüntüle\n" +
                                    "4- Fatura Öde (Elektrik/Su/İnternet)\n" +
                                    "5- Çıkış");
                    System.out.print("yapmak istediğiniz işlem için numara giriniz: ");
                    int menuIslemNo = myObj.nextInt();

                    if (menuIslemNo == 1 || menuIslemNo == 2 || menuIslemNo == 4) {
                        System.out.print("işlem yapılacak tutarı giriniz: ");
                        //Scanner myObjAmount = new Scanner(System.in);
                        amount = myObj.nextDouble();

                    }
                    menu(menuIslemNo);
                    /*
                    if (menuIslemNo == 5){
                        isContinue=false;
                        break;
                    }
                    */

                    //break;
                }


            }else{
                System.out.println("Kullanıcı adı veya şifre hatalı!");
                numOfAttempts++;
            }
            if (numOfAttempts == 3){
                System.out.println("3 kere yanlış girdiniz. Programdan çıkış yapılıyor...");
            }
        } // end of while



    } // end of main


    public static void menu(int islemNo){

            switch (islemNo) {
                case 1: // Para Yatır
                    deposit(amount);
                    //girisYap=false;
                    break;
                case 2: // Para Çek
                    withdraw(amount);
                    break;
                case 3: // Bakiye Görüntüle
                    viewBalance();
                    break;
                case 4: // Fatura Öde (Elektrik/Su/İnternet)
                    System.out.println("Fatura tipi no'ları: \n" +
                            "1-elektrik, 2-su, 3-internet\n" +
                            "Fatura tipini giriniz: ");
                    //Scanner myObjBillType = new Scanner(System.in);
                    int billType = myObj.nextInt();
                    payBill(billType, amount);
                    break;
                case 5: // Çıkış
                    printSummary();
                    isContinue=false;
                    break;
                default:
                    System.out.println("Geçerli bir seçim yapın!");
                    break;
            }


    }

    public static void deposit (double amount){
        if (amount <= 0){
            System.out.println("Sıfır ya da negatif tutar girdiniz!");
        }

        bakiye += amount;
        totalDeposit += amount;
        System.out.println("bakiyeye " + amount + " eklendi. Yeni bakiye: " + bakiye);
    }


    public static void withdraw (double amount){
        double toplamDusus = 0;



        if (amount <= 0){
            System.out.println("Sıfır ya da negatif tutar girdiniz!");
        }else if (amount > bakiye){
            if (amount > 5000){
                komisyon = amount * 0.02;
            }
            System.out.println("komisyon: " + komisyon);
            toplamDusus = amount + komisyon;
            System.out.println("toplam düşüş: " + toplamDusus);
            System.out.println("Yetersiz bakiye!");
        }else { // amount <= bakiye : geçerli işlem
            if (amount > 5000){
                komisyon = amount * 0.02;
            }
            System.out.println("komisyon: " + komisyon);
            toplamDusus = amount + komisyon;
            System.out.println("toplam düşüş: " + toplamDusus);

            bakiye -= toplamDusus;
            System.out.println("bakiyeden toplam " + toplamDusus + " çıkarıldı. Komisyon: " + komisyon +
                    " Yeni bakiye: " + bakiye);
        }

        totalWithdraw += toplamDusus ;
    }




    public static void viewBalance(){
        System.out.println("güncel bakiye: " + bakiye);
    }


    public static void payBill(int billType, double amount){
        // 1-elektrik, 2-su, 3-internet



        if (billType == 1){
            if (amount * 0.95 > bakiye){
                System.out.println("yetersiz bakiye");
                System.out.println("bakiye: " + bakiye);
            }else{
                bakiye = bakiye - (amount * 0.95);
                System.out.println((amount * 0.95) + " elektrik faturası ödendi. İndirim tutarı: " + amount * 0.05);
                billAmount += amount * 0.95;
                totalBillsPaidCount++;

            }

        }else if (billType == 2){
            if (amount * 0.97 > bakiye) {
                System.out.println("yetersiz bakiye");
                System.out.println("bakiye: " + bakiye);
            }else{
                bakiye = bakiye - (amount * 0.97);
                System.out.println( (amount * 0.97) + " su faturası ödendi. İndirim tutarı: " + amount * 0.03);
                billAmount += amount * 0.97;
                totalBillsPaidCount++;
            }

        }else if (billType == 3){
            if (amount * 0.98 > bakiye){
                System.out.println("yetersiz bakiye");
                System.out.println("bakiye: " + bakiye);
            }else{
                bakiye = bakiye - (amount * 0.98);
                System.out.println( (amount * 0.98) + " internet faturası ödendi. İndirim tutarı: " + amount * 0.02);
                billAmount += amount * 0.95;
                totalBillsPaidCount++;
            }

        }else{
            System.out.println("hatalı fatura türü girdiniz!");
        }

    }


    public static void printSummary(){
        System.out.println("bakiye: " + bakiye);
        System.out.println("toplam yatırılan: " + totalDeposit);
        System.out.println("toplam çekilen " + totalWithdraw);
        System.out.println("ödenen fatura adedi: " + totalBillsPaidCount);
        System.out.print("net hareket: ");
        System.out.println((totalWithdraw + billAmount));
        System.out.println("çıkış yapılıyor...");
    }


}
