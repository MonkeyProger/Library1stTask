package TailBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tail {

    private static Integer numC;
    private static Integer numS;
    private static ArrayList<String> inputFileNames;
    private static String outputFileName;

    public Tail(Integer numC, Integer numS, ArrayList<String> inputFileNames,String outputFileName){
        this.numC = numC;
        this.numS = numS;
        this.inputFileNames = inputFileNames;
        this.outputFileName = outputFileName;
    }
    public static void toTail() throws IOException {

        //Throw IOException flag.set(-c, -n) -> expected flag.set(-c)||(flag.set(-n)
        if(numC != null && numS != null){
            throw new IOException("Одновременно введены флаги -c и -n");
        }


        if (inputFileNames == null) {
            Scanner in  = new Scanner(System.in);
            StringBuilder text = new StringBuilder();
            System.out.print("Введите количество строк: ");
            int i = in.nextInt();
            System.out.print("\n");
            System.out.print("Вводите текст построчно:\n");
            for (int k = 0; k < i; k++){
                text.append(in.nextLine()).append("\n");
            }
            text.deleteCharAt(text.length());
            in.close();
            if (numS != null){
                    ReverseReader.primitiveReverseS(text.toString(),numS);
            }
            else{
                if (numC != null){
                    ReverseReader.primitiveReverseC(text.toString(),numC);
                } else {
                    ReverseReader.primitiveReverseS(text.toString(),10);
                }
            }


        } else {
            int m = inputFileNames.size();
            if (numS != null) { //numS usage
                    if (m == 0) {
                        ReverseReader.reverseReadStr(inputFileNames.get(0), outputFileName, numS);
                    } else {
                        for (int i = 0; i < inputFileNames.size(); i++) {
                            try (FileOutputStream outputStream = new FileOutputStream(outputFileName, true)) {
                                byte[] sym = (inputFileNames.get(i) + "\n").getBytes();
                                outputStream.write(sym);
                                ReverseReader.reverseReadStr(inputFileNames.get(i), outputFileName, numS);
                                if (i != inputFileNames.size() - 1) outputStream.write("\n".getBytes());
                            }
                        }
                }
            } else {
                if (numC != null) { //numC usage
                    if (m == 0) {
                        ReverseReader.reverseReadChar(inputFileNames.get(0), outputFileName, numC);
                    } else {
                        for (int i = 0; i < inputFileNames.size(); i++) {
                            try (FileOutputStream outputStream = new FileOutputStream(outputFileName, true)) {
                                byte[] name = (inputFileNames.get(i) + "\n").getBytes();
                                outputStream.write(name);
                                ReverseReader.reverseReadChar(inputFileNames.get(i), outputFileName, numC);
                                if (i != inputFileNames.size() - 1) outputStream.write("\n".getBytes());
                            }
                        }
                    }
                } else { //Both null usage
                    if (m == 0) {
                        ReverseReader.reverseReadStr(inputFileNames.get(0), outputFileName, 10);
                    } else {
                        for (int i = 0; i < inputFileNames.size(); i++) {
                            try (FileOutputStream outputStream = new FileOutputStream(outputFileName, true)) {
                                byte[] name = (inputFileNames.get(i) + "\n").getBytes();
                                outputStream.write(name);
                                ReverseReader.reverseReadStr(inputFileNames.get(i), outputFileName, 10);
                                if (i != inputFileNames.size() - 1) outputStream.write("\n".getBytes());
                            }
                        }
                    }
                }
            }
        }
    }
}
