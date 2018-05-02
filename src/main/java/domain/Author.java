package domain;

import java.util.List;

public class Author {
    String authorId;
    String name;
    List<String> bookId;

    public Author(String authorId, String name, List<String> bookId) {
        this.authorId = authorId;
        this.name = name;
        this.bookId = bookId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public List<String> getBookId() {
        return bookId;
    }
}
