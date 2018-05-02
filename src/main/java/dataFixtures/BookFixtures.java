package DataFixtures;

import domain.Book;

import java.util.Arrays;
import java.util.List;

public class BookFixtures {
    static Book book = new Book("1", "le prince d'ambre", "1", "1900");
    static Book book1 = new Book("2", "le héros eternel", "1", "1900");
    static Book book2 = new Book("3", "Les montagnes hallucinés", "1", "1900");
    static Book book3 = new Book("4", "Monster", "1", "1900");

    static List<Book> bookList = Arrays.asList(book, book1, book2, book3);

    public static Book getBook() {
        return book;
    }

    public static Book getBook1() {
        return book1;
    }

    public static Book getBook2() {
        return book2;
    }

    public static Book getBook3() {
        return book3;
    }

    public static List<Book> getBookList() {
        return bookList;
    }
}
