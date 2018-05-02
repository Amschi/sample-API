package service;


import codec.BookJson;

import org.reactivestreams.Publisher;

import reactor.core.publisher.Mono;
import reactor.ipc.netty.http.server.HttpServerRequest;
import reactor.ipc.netty.http.server.HttpServerResponse;

import java.util.Optional;

public class BookService {


    public static Publisher<Void> allBooks(HttpServerRequest request, HttpServerResponse response) {
        final Optional<String> allBooks = BookJson.getAllBook();
        return allBooks.
                map(r -> response.sendString(Mono.just(r))).
                orElseGet(() -> response.status(500).sendString(Mono.just("Error when parsing")));
    }

    public static Publisher<Void> oneBook(HttpServerRequest request, HttpServerResponse response) {
        return Optional.ofNullable(request.param("id")).
                flatMap(BookJson::getOneBook).
                map(book -> response.sendString(Mono.just(book))).
                orElseGet(() -> response.status(500).sendString(Mono.just("Error when parsing")));
    }
}

