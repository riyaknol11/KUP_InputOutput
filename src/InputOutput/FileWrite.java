package InputOutput;

import java.io.*;
import java.util.Scanner;

class FileWrite {
    private String filename;
    private String outputFile;
    private Integer entries;

    public FileWrite(String filename, String outputFile, Integer entries) {
        this.filename = filename;
        this.outputFile = outputFile;
        this.entries = entries;
    }

    //writing the user input to input-file
    public void writeToInputFile() throws IOException {
        Scanner input = new Scanner(System.in);

        FileWriter inputWriter = new FileWriter(filename);

        for (int index = 0; index < entries; index++) {
            System.out.println("Enter the name : ");
            String name = input.next();
            System.out.println("Enter the age : ");
            int age = input.nextInt();
            inputWriter.write(name + ", " + age + "\n");
        }
        inputWriter.close();
    }


    //method to write the content of the input file in output file
    public void writeToOutputFile() {
        try {
        FileReader fileReader = new FileReader(filename);
        BufferedReader read_inputFile = new BufferedReader(fileReader);

        FileWriter outputWriter = new FileWriter(outputFile);
        String line;
            //logic to store in file output file after manipulation
            while ((line = read_inputFile.readLine()) != null) {
                line = line.replaceAll(",", "(");
                line = line.concat(") \n");
                outputWriter.write(line);
            }
            outputWriter.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("File does not exists!");
        }
        catch (IOException exception)
        {
            System.out.println("IO exception occurred!");
        }
        }
    }




