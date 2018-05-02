package codec;

import DataFixtures.BookFixtures;
import domain.Book;

import java.util.Optional;


public class BookJson {
    private static JsonCodec<Book> jsonCodec = new JsonCodec<>();

    public static Optional<String> getOneBook(String id) {
        final Optional<Book> bookOpts = BookFixtures.getBookList().stream().
                filter(book -> book.getBookId().equals(id)).
                findFirst();

        return bookOpts.flatMap((book) -> jsonCodec.serialize(book));
    }

    public static Optional<String> getAllBook() {
        return jsonCodec.serializeList(BookFixtures.getBookList());
    }


}
