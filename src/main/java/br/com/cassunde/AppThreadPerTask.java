package br.com.cassunde;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class AppThreadPerTask {

    private static final Logger logger = LoggerFactory.getLogger(AppThreadPerTask.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Instant start = Instant.now();

        MDC.put("test", "121212");
        logger.info("init");
//      String tasksConcatenated = startTraditionalThreadsOld();
        String tasksConcatenated = startVirtualThreads();
        logger.info(tasksConcatenated);

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        logger.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        Thread.sleep(12000);
        logger.info("end");
    }

    private static String startVirtualThreads() throws InterruptedException, ExecutionException {

        try(var executor = Executors.newVirtualThreadPerTaskExecutor()){

            var task1 = executor.submit(AppThreadPerTask::executeTask1);
            var task2 = executor.submit(AppThreadPerTask::executeTask2);

            return task1.get() + task2.get();
        }
    }

    private static String startTraditionalThreadsOld() throws Exception {
        System.out.println(Thread.currentThread());
        String task2 = executeTask2();
        return task1+task2;
    }

    private static String executeTask2() throws InterruptedException {
        logger.info("task 2");
        Thread.sleep(5000);

        return "task2";
    }
    private static String executeTask1() throws Exception {
        logger.info("task 1");
        Thread.sleep(5000);

        if(true){
            throw new Exception("rapido");
        }

        return "task1";
    }
}
