package DataFixtures;

import domain.Author;

import java.util.Arrays;
import java.util.List;

public class AuthorFixtures {
    static Author author = new Author("1", "Roger Zelazny", Arrays.asList("livre1, livre2"));
    static Author author1 = new Author("2", "Amaury1", Arrays.asList("livre1, livre2"));
    static Author author2 = new Author("3", "Amaury2", Arrays.asList("livre1, livre2"));
    static Author author3 = new Author("4", "Amaury3", Arrays.asList("livre1, livre2"));

    static List<Author> authorList = Arrays.asList(author, author1, author2, author3);

    public static Author getAuthor() {
        return author;
    }

    public static Author getAuthor1() {
        return author1;
    }

    public static Author getAuthor2() {
        return author2;
    }

    public static Author getAuthor3() {
        return author3;
    }

    public static List<Author> getAuthorList() {
        return authorList;
    }
}
