package gr.ktsitsas.workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author ktsitsas
 */
public class Workshop {

    /**
     * Has three arguments, input file A path, input file B path and output file
     * path It reads the two files, intersects and sorts their contents into an
     * output file
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileInputA = args.length > 0 ? args[0] : "C:\\projects\\workshop\\files\\inputA.txt";
        String fileInputB = args.length > 1 ? args[1] : "C:\\projects\\workshop\\files\\inputB.txt";
        String fileOutput = args.length > 2 ? args[2] : "C:\\projects\\workshop\\files\\output.txt";
        //get both files as sets
        Set a = getFileAsSet(fileInputA);
        Set b = getFileAsSet(fileInputB);
        //intersect the two sets
        List intersect = (ArrayList) a.stream().filter(b::contains).collect(Collectors.toList());
        //alphabetically sort the intersected list
        Collections.sort(intersect);
        System.out.println("The size of the intersected list is " + intersect.size());
        //intersect.forEach(System.out::println);
        try {
            Files.write(Paths.get(fileOutput), (Iterable<String>) intersect.stream()::iterator);
            System.out.println("File was successfully written to " + fileOutput);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    /**
     * Each line of the file is added to a set, to avoid duplicate strings
     *
     * @param fileInput the input file path
     */
    private static Set getFileAsSet(String fileName) {
        Set<String> set = new HashSet<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            set = br.lines().collect(Collectors.toSet());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        return set;
    }

    /**
     * The contents of the file as a stream
     *
     * @param fileInput the input file path
     */
    /*private static Stream getFileAsStream(String fileInput) {
        try (Stream<String> stream = Files.lines(Paths.get(fileInput))) {
            return stream;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }*/
}
