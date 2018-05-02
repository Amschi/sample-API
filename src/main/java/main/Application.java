package main;


public class Application {
    public static void main(String[] args) {
        Server server = new Server("127.0.0.1", 9000);
        server.startSync();
    }
}
