package br.com.cassunde;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static java.lang.Thread.startVirtualThread;

/**
 * Hello world!
 *
 */
public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException, InterruptedException {

        ThreadContext.put("test", "ttttt");
        logger.info("Test");
//        startTraditionalThreadsOld();
        startVirtualThreads();
//        test();
//        System.out.println("end process");

//        var people = new People(null, "");
//        System.out.println(people.name());
        Thread.sleep(10000);


//        System.out.println(new Address("","10"));
    }

    private static void startVirtualThreads() {
        for (int i = 0; i < 10; i++) {
            startVirtualThread(() -> {
                try {
                    logger.info(Thread.currentThread().getName());
//                    System.out.println(Thread.currentThread());
                    test();
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private static void startTraditionalThreadsOld() throws IOException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread());
            test();
        }
    }

    private static void test() throws IOException, InterruptedException {
//        var client = HttpClient.newHttpClient();
//        var request = HttpRequest.newBuilder(URI.create("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"))
//                .header("accept", "application/json")
//                .build();
//
//        var response = client.send(request, new JsonBodyHandler<>(Response.class));
//        System.out.println(response.body().get());

//        System.out.println("test");
        logger.info("unit");
        Thread.sleep(1000);
    }
}
