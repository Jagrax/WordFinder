package com.lexicon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordFinder {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.err.println("No se especificaron las letras.");
            System.exit(0);
        }

        char[] chars = args[0].toCharArray();
        Scanner s = new Scanner(new File("C:\\Lexicon.txt"));
        List<String> diccionario = new ArrayList<>();
        while (s.hasNext()){
            diccionario.add(s.next());
        }
        s.close();

        List<String> words = diccionario;
        if (args.length == 2) {
            int wordLength = Integer.parseInt(args[1]);
            List<String> aux = new ArrayList<>();
            for (String word : words) {
                if (word.length() <= wordLength) aux.add(word);
            }
            words = aux;
        }
        StringBuilder letras = new StringBuilder();
        for(char letra : chars) {
            letras.append(letra);

            List<String> aux = new ArrayList<>();
            for (String word : words) {
                if (word.indexOf(letra) != 1) aux.add(word);
            }

            words = aux;
            System.out.println("Palabras que contienen '" + letras + "': " + words.size());
        }
/*
        for (String word : words) {
            System.out.println(word);
        }*/
    }
}
