package InputOutput;

import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        try {
            Scanner input = new Scanner(System.in);
        /*
          Creating an input and output file with the names entered by user.
          Taking the number of entries to be stored in input file
         */

            System.out.println("Enter the name of the input file : ");
            File inputFile = new File(input.next());
            if (inputFile.createNewFile()) {
                System.out.println("File created : " + inputFile.getName());
            }
            else {
                System.out.println("File already exists! ");
            }

            System.out.println("Enter the name of the output file : ");
            File outputFile = new File(input.next());
            //logic to either create a new output file or overwrite the file if it exists already, according to user's choice
            while(outputFile.exists()){
                System.out.println("File already exits!! Do you want to overwrite the file?(1 or 0)");
                int permit= input.nextInt();

                if(permit==1){
                    outputFile.createNewFile();
                    break;
                }
                else if(permit==0){
                    System.out.println("File not overwritten!! please enter a different name");
                    String file=input.next();
                    outputFile = new File(file);
                }
            }

            System.out.println("Enter the number of entries you want to store in input file : ");
            int entries = input.nextInt();

            FileWrite filewrite = new FileWrite(inputFile.getName(), outputFile.getName(), entries);
            //writeToFile function of FileWrite is called to write the input from user into the input file.
            filewrite.writeToInputFile();
            System.out.println("Average age of the students is : " + CalculateAverage.calculateAverage(inputFile, entries));

            //writeToOutput function is called to add the data to the output file from input file after performing manipulations and formatting it.
            filewrite.writeToOutputFile();
        }
        catch (IOException e)
        {
            System.out.println("File creation interrupted abruptly!");
        }
        }
    }

