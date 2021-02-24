import java.util.LinkedList;

public class Library {

    static class Book {
        String title, author, genre, location;

        public Book(String title, String author, String genre, String location) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.location = location;
        }

        String getTitle() {
            return title;
        }

        String getAuthor() {
            return author;
        }

        String getGenre() {
            return genre;
        }

        String getLocation() {
            return location;
        }

        public void setLocation(String pos) {
            this.location = pos;
        }
    }


    static public LinkedList<Book> library;

    public Library() {
        library = new LinkedList<>();
    }

    ////////////////////
    public void add(Book book) {
        library.add(book);
    }

    ////////////////////
    public void delete(String title) {
        Book book = searchByTitle(title);
        library.remove(book);
    }

    public void delete(Book book) {
        library.remove(book);
    }

    //////Изменение книги
    public void change(String title,Book newBook) {
        for (int i = 0; i < library.size(); i++) if (library.get(i).getTitle().equalsIgnoreCase(title))
            library.set(i ,newBook);
    }

    //////Реализация поиска
    Book searchByTitle(String title) {
        for (Book it : library) {
            if (it.getTitle() != null && it.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return it;
            }
        }
        return null;
    }

    Book searchByAuthor(String author) {
        for (Book it : library) {
            if (it.getAuthor() != null && it.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                return it;
            }
        }
        return null;
    }

    Book searchByGenre(String genre) {
        for (Book it : library) {
            if (it.getGenre() != null && it.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                return it;
            }
        }
        return null;
    }

    Book searchByLoc(String location) {
        for (Book it : library) {
            if (it.getLocation() != null && it.getLocation().toLowerCase().equalsIgnoreCase(location)) {
                return it;
            }
        }
        return null;
    }

    /////Experimental - множественный поиск/////
    LinkedList<Book> multipleGenreSearch(String genre) {
        LinkedList<Book> found = new LinkedList<>();
        for (Book book : library) if (book.getGenre().toLowerCase().contains(genre.toLowerCase()))
            found.add(book);
        if (found.isEmpty()) return null;
        return found;
    }
}