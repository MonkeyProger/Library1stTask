package TailBuilder;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.Argument;

import java.io.IOException;
import java.util.ArrayList;

public class TailBuilder {

    @Option(name = "-c", metaVar = "NumC")
    private Integer numC;

    @Option(name = "-n", metaVar = "NumS")
    private Integer numS;

    @Option(name = "-o", metaVar = "OutputName", usage = "Output file name")
    private String outputFileName;

    @Argument(metaVar = "InputName", usage = "Input file name")
    private ArrayList<String> inputFileNames;

    public static void main(String[] args) {
        new TailBuilder().launch(args);
    }

    private void launch(String[] args){
        CmdLineParser parser = new CmdLineParser(this);
            try {
                parser.parseArgument(args);
            } catch (CmdLineException e) {
                e.printStackTrace();
            }
        Tail tail = new Tail(numC,numS,inputFileNames,outputFileName);
        try {
            tail.toTail();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
