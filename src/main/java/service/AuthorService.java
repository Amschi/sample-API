package service;

import codec.AuthorJson;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import reactor.ipc.netty.http.server.HttpServerRequest;
import reactor.ipc.netty.http.server.HttpServerResponse;

import java.util.Optional;

public class AuthorService {

    public static Publisher<Void> allAuthors(HttpServerRequest request, HttpServerResponse response) {
        System.out.println(request.uri());
        Optional<String> allAuthors = AuthorJson.getAllAuthor();
        return allAuthors.
                map((r) -> response.sendString(Mono.just(r))).
                orElseGet(() -> response.status(500).sendString(Mono.just("Error while Parsing")));
    }

    public static Publisher<Void> oneAuthor(HttpServerRequest request, HttpServerResponse response) {
        return Optional.ofNullable(request.param("id")).
                flatMap(AuthorJson::getOneAuthor).
                map((author) -> response.sendString(Mono.just(author))).
                orElseGet(() -> response.status(500).sendString(Mono.just("Error when parsing")));

    }

}
