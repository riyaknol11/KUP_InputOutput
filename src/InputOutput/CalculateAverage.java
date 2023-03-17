package InputOutput;

import java.util.Scanner;
import java.io.*;

class CalculateAverage {
    //method to calculate the Average of total entered age in input file
    public static double calculateAverage(File filename, Integer entries ) throws IOException {
        BufferedReader read_inputFile = null;
        try {
            FileReader fileReader = new FileReader(filename);
            read_inputFile = new BufferedReader(fileReader);
        }
        catch(Exception catchException) {
        catchException.printStackTrace();
        }
            int sum_of_age = 0;
            String data;
            while ((data = read_inputFile.readLine()) != null) {
                String[] details = data.split(",");
                String name = details[0].trim();
                int age = Integer.parseInt(details[1].trim());
                sum_of_age += age;
            }
            double average = sum_of_age / entries;
            return average;
        }
    }


