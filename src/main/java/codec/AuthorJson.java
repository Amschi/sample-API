package codec;

import DataFixtures.AuthorFixtures;
import domain.Author;
import java.util.Optional;

public class AuthorJson {

    private static JsonCodec<Author> jsonCodec = new JsonCodec<>();

    public static Optional<String> getOneAuthor(String id) {
        final Optional<Author> authorOpts = AuthorFixtures.getAuthorList().stream().
                filter(author -> author.getAuthorId().equals(id)).
                findFirst();

        return authorOpts.flatMap(author -> jsonCodec.serialize(author));

    }

    public static Optional<String> getAllAuthor() {
        return jsonCodec.serializeList(AuthorFixtures.getAuthorList());
    }


}
