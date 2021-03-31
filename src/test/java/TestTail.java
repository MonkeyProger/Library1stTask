import static org.junit.Assert.*;

import TailBuilder.TailBuilder;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestTail {

    // tail [-c num|-n num] [-o ofile] file0 file1

    @Test
    public void test1() throws IOException {
        String[] args = {"-o","C:/MonkeyProger/Work/Library1stTask/output/output1.txt", "C:/MonkeyProger/Work/Library1stTask/input/input1.txt", "C:/MonkeyProger/Work/Library1stTask/input/input2.txt"};
        TailBuilder.main(args);
        assertEquals(
                String.join("\n", Files.readAllLines(Path.of("C:/MonkeyProger/Work/Library1stTask/output/output1.txt"),
                        StandardCharsets.UTF_8)),
                """
                        C:/MonkeyProger/Work/Library1stTask/input/input1.txt
                        6_string
                        7_string
                        8_string
                        9_string
                        10_string
                        11_string
                        12_string
                        13_string
                        14_string
                        15_string
                        C:/MonkeyProger/Work/Library1stTask/input/input2.txt
                        4 ───█───▄▀█▀▀█▀▄▄───▐█──────▄▀█▀▀█▀▄▄
                        5 ──█───▀─▐▌──▐▌─▀▀──▐█─────▀─▐▌──▐▌─█▀
                        6 ─▐▌──────▀▄▄▀──────▐█▄▄──────▀▄▄▀──▐▌
                        7 ─█────────────────────▀█────────────█
                        8 ▐█─────────────────────█▌───────────█
                        9 ▐█─────────────────────█▌───────────█
                        10─█───────────────█▄───▄█────────────█
                        11─▐▌───────────────▀███▀────────────▐▌
                        12──█──────────▀▄───────────▄▀───────█
                        13───█───────────▀▄▄▄▄▄▄▄▄▄▀────────█"""
        );
    }

    @Test
    public void test2() throws IOException {
        String[] args = {"-n","7","-o","C:/MonkeyProger/Work/Library1stTask/output/output2.txt", "C:/MonkeyProger/Work/Library1stTask/input/input1.txt", "C:/MonkeyProger/Work/Library1stTask/input/input2.txt"};
        TailBuilder.main(args);
        assertEquals(
                String.join("\n", Files.readAllLines(Path.of("C:/MonkeyProger/Work/Library1stTask/output/output2.txt"),
                        StandardCharsets.UTF_8)),
                """
                        C:/MonkeyProger/Work/Library1stTask/input/input1.txt
                        9_string
                        10_string
                        11_string
                        12_string
                        13_string
                        14_string
                        15_string
                        C:/MonkeyProger/Work/Library1stTask/input/input2.txt
                        7 ─█────────────────────▀█────────────█
                        8 ▐█─────────────────────█▌───────────█
                        9 ▐█─────────────────────█▌───────────█
                        10─█───────────────█▄───▄█────────────█
                        11─▐▌───────────────▀███▀────────────▐▌
                        12──█──────────▀▄───────────▄▀───────█
                        13───█───────────▀▄▄▄▄▄▄▄▄▄▀────────█"""
        );
    }

    @Test
    public void test3() throws IOException {
        String[] args = {"-c","17","-o","C:/MonkeyProger/Work/Library1stTask/output/output3.txt", "C:/MonkeyProger/Work/Library1stTask/input/input1.txt", "C:/MonkeyProger/Work/Library1stTask/input/input3.txt"};
        TailBuilder.main(args);
        assertEquals(
                String.join("\n", Files.readAllLines(Path.of("C:/MonkeyProger/Work/Library1stTask/output/output3.txt"),
                        StandardCharsets.UTF_8)),
                """
                        C:/MonkeyProger/Work/Library1stTask/input/input1.txt
                        _string
                        15_string
                        C:/MonkeyProger/Work/Library1stTask/input/input3.txt
                        tring
                        15_:3 :3 :3"""
        );
    }


    @Test
    public void exceptionTest() throws IOException {
        ExpectedException exception = ExpectedException.none();
        String[] args = {"-c","17","-n","12"};
        TailBuilder.main(args);
        exception.expect(IOException.class);
    }

}
