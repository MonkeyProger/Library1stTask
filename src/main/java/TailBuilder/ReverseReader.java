package TailBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReverseReader {
//Чтение numS строк файла с конца
    public static void reverseReadStr(String inputFileName,String outputFileName, int numS)
            throws IOException {
        try (Scanner sc = new Scanner(new File(inputFileName))) {
            try (OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(outputFileName, true))) {
                ArrayList<String> read = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                int del = 0;
                while(sc.hasNext()){
                    read.add(sc.nextLine());
                    del++;
                }
                if (del - numS > 0) {
                    read.subList(0, del - numS).clear();
                }
                for(int i = 0; i < read.size(); i++) {
                    sb.append(read.get(i));
                    if (i != read.size()-1) sb.append("\n");
                }
                outputStream.write(sb.toString());
            }
        }
    }

//Чтение numC символов файла с конца
    public static void reverseReadChar(String inputFileName,String outputFileName, int numC) {
        try {
            try (OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(outputFileName, true))) {
                StringBuilder sb = new StringBuilder();
                File file = new File(inputFileName);
                long length = file.length()-1;
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                randomAccessFile.seek(length);
                for (long pointer = length; pointer >= length - numC; pointer--) {
                    randomAccessFile.seek(pointer);
                    char c = (char) randomAccessFile.read();
                    sb.append(c);
                }
                outputStream.write(sb.reverse().toString());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void primitiveReverseC(String text, int numC) {
        String res = text.substring(text.length()-numC,text.length()-1);
        System.out.println(res);
    }

    public static void primitiveReverseS(String text, int numS) {
        StringBuilder res = new StringBuilder();
        StringBuilder wayOut = new StringBuilder();
        wayOut.append(text);
        for (int i = 0; i < numS; i++){
            res.append(wayOut.substring(wayOut.lastIndexOf("\n")));
            wayOut.delete(wayOut.lastIndexOf("\n"),wayOut.length());
        }
        System.out.println(res.toString());
    }

}
