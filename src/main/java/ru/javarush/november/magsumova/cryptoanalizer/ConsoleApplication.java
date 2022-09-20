package ru.javarush.november.magsumova.cryptoanalizer;

import java.io.IOException;
import java.util.Scanner;

import static ru.javarush.november.magsumova.cryptoanalizer.BruteForce.decoding;
import static ru.javarush.november.magsumova.cryptoanalizer.CesarEncryption.encryption;
import static ru.javarush.november.magsumova.cryptoanalizer.DecryptionCes.decryption;

public class ConsoleApplication {
    public static void main(String[] args) throws IOException {

        System.out.println(" ");
        System.out.println("*----------------------------------------------*");
        System.out.println("*--------Welcome to cryptoanalizer-------------*");
        System.out.println("*----------------------------------------------*");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Please, select an option:");
        System.out.println("1. File encryption by caesar method.");
        System.out.println("2. Decryption of the file by Caesar's method.");
        System.out.println("3. Decryption of the file by Brute Force. ");

        Scanner inputUser = new Scanner(System.in);
        int userChoose = inputUser.nextInt();

        switch (userChoose) {
            case 1:
                encryption();
                break;
            case 2:
                decryption();
                break;
            case 3:
                decoding();
                break;

        }


    }
}
