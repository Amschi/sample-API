package main;

import reactor.ipc.netty.http.server.HttpServer;
import reactor.ipc.netty.http.server.HttpServerRoutes;
import reactor.ipc.netty.tcp.BlockingNettyContext;
import service.AuthorService;
import service.BookService;

public class Server {

    private final HttpServer httpServer;
    private final HttpServerRoutes routes;

    Server(String host, int port) {
        this.routes = HttpServerRoutes.newRoutes().
                get("/books", BookService::allBooks).
                get("/books/{id}", BookService::oneBook).
                get("/authors", AuthorService::allAuthors).
                get("/authors/{id}", AuthorService::oneAuthor);

        this.httpServer = HttpServer.create(host, port);
    }

    void startSync() {
        this.httpServer.startAndAwait(this.routes, this::onStart);
    }

    BlockingNettyContext startAsync() {
        return this.httpServer.start(this.routes);
    }

    Thread start() {
        Thread t = new Thread(() -> this.startSync());
        t.start();
        return t;
    }

    private void onStart(BlockingNettyContext context) {
        System.out.println("main.Server started on Host: " + context.getHost() + ":" + context.getPort());
    }

}