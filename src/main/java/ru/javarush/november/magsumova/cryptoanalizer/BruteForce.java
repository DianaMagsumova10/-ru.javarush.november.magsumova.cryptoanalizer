package ru.javarush.november.magsumova.cryptoanalizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BruteForce {
    public static void decoding() throws IOException {
        String alphabetString = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"\":-!? ";
        List<Character> charactersEncryFile = new ArrayList<>();

        int encryKey = 0;
        List<Character> alphabet = Arrays.asList('а', 'б', 'в',
                'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
                'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '\"', '\"',
                ':', '!', '?', ' ');


        try {
            System.out.println("Please, enter the file name:");
            Scanner fileInConsole = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new FileReader(fileInConsole.nextLine()));

            Map<Character, Integer> integerTreeMap = new TreeMap<>();

            while (reader.ready()) {
                char symbol = (char) reader.read();
                if (integerTreeMap.containsKey(symbol)) {
                    int count = integerTreeMap.get(symbol);
                    count++;
                    integerTreeMap.put((char) symbol, count);
                } else {
                    integerTreeMap.put((char) symbol, 1);
                }
            }

            int maxChar = Collections.max(integerTreeMap.values());
            char repeatedCharMax = ' ';

            for (Map.Entry<Character, Integer> pair : integerTreeMap.entrySet()) {
                if (pair.getValue() == maxChar) {
                    repeatedCharMax = pair.getKey();
                    break;
                }
            }


            while (reader.ready()) {
                char charFile = (char) reader.read();
                if (charFile == repeatedCharMax) {
                    int index = alphabet.indexOf(charFile);
                    int indexOfSpace = alphabet.indexOf(' ');
                    encryKey = alphabet.size() - (indexOfSpace - index);
                    FileWriter out = new FileWriter("src\\Brute.txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(out);
                    while (reader.ready()) {
                        int ch = reader.read();

                        if (alphabetString.indexOf(ch) != -1) {
                            ch = alphabetString.charAt(((((alphabetString.indexOf(ch) - encryKey) % alphabetString.length())) + alphabetString.length()) % alphabetString.length());

                        } else {
                            ch = (char) ch;
                        }
                        charactersEncryFile.add((char) ch);
                    }
                    reader.close();
                    for (Character character : charactersEncryFile) {
                        bufferedWriter.write((char) character);

                    }

                    out.flush();
                    bufferedWriter.close();
                    System.out.println("Decryption is done, your file is saved in the src folder.");
                    break;

                }
            }
            reader.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Empty file");
        }


    }
}
