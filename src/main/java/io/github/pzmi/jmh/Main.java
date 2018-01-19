package io.github.pzmi.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    @Benchmark
    public void someBenchmark() {
        int i = ThreadLocalRandom.current().nextInt(0, 10);
        System.out.println(i);
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(Main.class.getSimpleName())
                .forks(2)
                .warmupIterations(10)
                .measurementIterations(10)
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.NANOSECONDS)
                .build();
        new Runner(options).run();
    }
}
