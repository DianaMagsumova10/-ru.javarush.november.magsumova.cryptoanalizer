package ru.javarush.november.magsumova.cryptoanalizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CesarEncryption {
    public static void encryption() throws IOException {
        String alphabetString = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"\":!? ";
        List<Character> characters = new ArrayList<>();
        String s = "Encryption is done, your file is saved in the src folder.";
        FileWriter out = new FileWriter("src\\fileC.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(out);

        try {
            System.out.println("Please, enter the key (any positive number):");
            Scanner scanner = new Scanner(System.in);
            int key = scanner.nextInt();
            System.out.println("Please, enter the file name:");
            Scanner scanner1 = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new FileReader(scanner1.nextLine()));

            while (reader.ready()) {
                int ch = reader.read();

                if (alphabetString.indexOf(ch) != -1) {
                    ch = alphabetString.charAt((alphabetString.indexOf(ch) + key) % alphabetString.length());

                } else {
                    ch = (char) ch;
                }
                characters.add((char) ch);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            new RuntimeException(e);
        }

        for (Character character : characters) {
            bufferedWriter.write((char) character);

        }

        out.flush();
        bufferedWriter.close();
        System.out.println(s);

    }



}
