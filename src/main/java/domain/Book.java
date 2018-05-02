package domain;

public class Book {
    String bookId;
    String title;
    String authorId;
    String nbPages;

    public Book(String bookId, String title, String authorId, String nbPages) {
        this.bookId = bookId;
        this.title = title;
        this.authorId = authorId;
        this.nbPages = nbPages;
    }


    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getNbPages() {
        return nbPages;
    }
}
