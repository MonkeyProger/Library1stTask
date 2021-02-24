import static org.junit.Assert.*;
import org.junit.Test;

import java.util.LinkedList;

public class Tests {

    @Test
    public void testAddingComponent(){
        Library.Book book = new Library.Book("10 tips to earn EASY MONEY", "Grigory Bingo",
                "Business literature", "B2");
        Library testLibrary = new Library();
        testLibrary.add(book);
        assertEquals(book,testLibrary.searchByTitle("10 tips to earn EASY MONEY"));
    }

    @Test
    public void testDeletingComponent(){
        Library testLibrary = new Library();
        testLibrary.add(new Library.Book("10 tips to earn EASY MONEY", "Grigory Bingo",
                "Business literature", "B1"));
        testLibrary.add(new Library.Book("10 tips to NOT earn EASY MONEY", "Grigory Gringo",
                "AntiBusiness literature", "G1"));
        testLibrary.delete("10 tips to NOT earn EASY MONEY");
        assertNull(testLibrary.searchByTitle("10 tips to NOT earn EASY MONEY"));
    }

    @Test
    public void testChangingBook(){
        Library.Book oldBook = new Library.Book("IT is Mario", "Kteven Sing",
                "Hororr", "S1");
        Library.Book newBook = new Library.Book("IT", "Steven King",
                "Horror", "K1");

        Library testLibrary = new Library();
        testLibrary.add(oldBook);
        testLibrary.change("IT is Mario",newBook);
        assertEquals(newBook,testLibrary.searchByAuthor("King"));
    }

    @Test
    public void testChangingShelf(){
        Library testLibrary = new Library();
        testLibrary.add(new Library.Book("IT", "Steven King",
                "Horror", "K1"));
        testLibrary.add(new Library.Book("Critique of Pure Reason","Immanuel Kant",
                "philosophical books","K2"));
        testLibrary.searchByAuthor("Kant").setLocation("K1");
        testLibrary.searchByAuthor("King").setLocation("K2");
        assertEquals("K1",testLibrary.searchByAuthor("Kant").getLocation());
        assertEquals("K2",testLibrary.searchByAuthor("King").getLocation());
    }

    ////  \/ Searchers \/  //////

    @Test
    public void testSearchingByWordInTitle(){
        Library.Book expected = new Library.Book("10 tips to earn EASY MONEY", "Grigory Bingo",
                "Business literature", "B1");
        Library testLibrary = new Library();
        testLibrary.add(new Library.Book("Something boring","Somebody boring",
                "Something genred","Smth"));
        testLibrary.add(expected);
        assertEquals(expected,testLibrary.searchByTitle("money"));
    }

    @Test
    public void testSearchingBy1or2Name(){
        Library.Book expected = new Library.Book("IT", "Steven King",
                "Horror", "K1");
        Library testLibrary = new Library();
        testLibrary.add(new Library.Book("It is it -_-","Kevin Quinn",
                "Cringe","Q1"));
        testLibrary.add(expected);
        assertEquals(expected,testLibrary.searchByAuthor("King"));
    }

    @Test
    public void testSearchingByWordInGenre(){
        Library.Book expected = new Library.Book("30 Days of Night", "Steve Niles",
                "Horror comics", "N1");
        Library testLibrary = new Library();
        testLibrary.add(new Library.Book("IT", "Steven King",
                "Horror", "K1"));
        testLibrary.add(expected);
        assertEquals(expected,testLibrary.searchByGenre("comics"));
    }

    @Test
    public void testSearchingByLocation(){
        Library.Book expected = new Library.Book("I, Robot","Isaac Asimov",
                "science fiction","A10");
        Library testLibrary = new Library();
        testLibrary.add(new Library.Book("Robot and me","Anatoliy Azimov",
                "science fiction","A101"));
        testLibrary.add(expected);
        assertEquals(expected,testLibrary.searchByLoc("A10"));
    }

    /////Additional
    @Test
    public void testMultiplySearcher(){
        Library.Book book1 = new Library.Book("IT", "Steven King",
                "Horror", "K1");
        Library.Book book2 = new Library.Book("30 Days of Night", "Steve Niles",
                "Horror comics", "N1");
        Library.Book book3 = new Library.Book("Dead Zombie Creepy Man", "Alexey Cennoy",
                "Horror manga", "C1");
        Library.Book book4= new Library.Book("Not scary at all","Cute author",
                "Cute doggy story","C2");

        Library testLibrary = new Library();
        testLibrary.add(book1); testLibrary.add(book2); testLibrary.add(book3); testLibrary.add(book4);

        LinkedList<Library.Book> expected = new LinkedList<>();
        expected.add(book1);expected.add(book2);expected.add(book3);

        assertEquals(expected, testLibrary.multipleGenreSearch("Horror"));
    }
}