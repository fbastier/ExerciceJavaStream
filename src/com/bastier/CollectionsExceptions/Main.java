package com.bastier.CollectionsExceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        // Exercice 1
        System.out.println("Exercice 1");

        Random rand = new Random();
        int[] myArray = rand.ints(0, 20)
                            .limit(6)
                            .sorted()
                            .toArray();

        Arrays.stream(myArray)
                .forEach(System.out::println);


        OptionalInt firstNumber = Arrays.stream(myArray).findFirst();
        System.out.println(firstNumber.getAsInt());

        Integer mySum = IntStream.of(myArray)
                                .filter(value -> value>3)
                                .sum();
        System.out.println(mySum);

        System.out.println("###########");


        //
        System.out.println("Exercice 2");
        int[] tab ={-9, 3, -8, 7, -6, 2, 1 };


        System.out.println("Les nombres positifs :");
      //  affichagePositif(tab, ee -> ee > 0);


        System.out.println("###########");


        //Exercice 3
        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne("Laure", "BARBE", "F",1995));
        personnes.add(new Personne("Jean", "SIRBE", "H",1997));
        personnes.add(new Personne("Laurent", "TARBO", "H",1989));
        personnes.add(new Personne("Julien", "JAO", "F",1979));
        personnes.add(new Personne("Jean", "SARBE", "H",1997));

        // Afficher les personnes nées avant 1991
        List<Personne> lesVieux = personnes.stream()
                                    .filter(an -> an.getAnnee_naissance()<1991)
                                    .collect(Collectors.toList());
        System.out.println(lesVieux);

        System.out.println("##2##");
        // Afficher les personnes nées en 1995
        List<Personne> twentyFive = personnes.stream()
                .filter(an -> an.getAnnee_naissance()==1995)
                .collect(Collectors.toList());
        System.out.println(twentyFive);

        System.out.println("##3##");
        // Afficher le nom des personnes nées avant 1990, triès par ordre alphabétique sur nom, afficher le nombre
        //List<Personne> question3 =
        personnes.stream()
                .filter(an -> an.getAnnee_naissance()<1990)
                .forEachOrdered(personne -> System.out.println(personne.getNom()));

        Long nb = personnes.stream()
                .filter(an -> an.getAnnee_naissance()<1990)
                .count();

        System.out.println(nb);

        System.out.println("##4##");
        // Afficher tous les noms & prenoms triés sur le nom puis le prénom

        personnes.stream()
               .sorted(Comparator.comparing(Personne::getPrenom))
                .sorted(Comparator.comparing(Personne::getNom))
                .forEach(personne -> System.out.println(personne.getNom() + " " + personne.getPrenom()));

        System.out.println("##5##");
        // Afficher les personnes ayant un genre F et un nom commençant par la lettre J
        personnes.stream()
                .filter(personne -> personne.getGenre().equals("F"))
                .filter(personne -> personne.getNom().startsWith("J"))
                .forEachOrdered(System.out::println);

        System.out.println("##6##");
        // Transformer le genre en minuscule, afficher les personnes ayant un genre h.
        personnes.stream()
                .peek(u -> u.setGenre(u.getGenre().toLowerCase()))
                .filter(v -> v.getGenre().equals("h"))
                .forEach(System.out::println);


        // import du fichier txt
        Pattern pattern = Pattern.compile(", ");

        try(Stream<String> lines = Files.lines(Path.of("/Users/java/Desktop/personnes.txt"))) {
          List<Personne> personneList = lines.skip(9)
                                            .skip(1)
                                            .map( line -> { String[] arr = pattern.split(line);
                                                            return new Personne(
                                                                    arr[1],
                                                                    arr[0],
                                                                    arr[4],
                                                                    Integer.parseInt(arr[2]));
                                                                    })
                                            .collect(Collectors.toList());
            System.out.println("Lecture file : " + personneList);
        } catch (IOException ioException) {
        }
    }


}
