package lesson1.lambdaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface Runnable {
    int run(int x);
}

class TestRunnable {
    public void doIt(Runnable runnable) {
        System.out.println(runnable.run(10));
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>(10);
        initArr(arr);
        initList(list);
        System.out.println(list);
        System.out.println(Arrays.toString(arr));

        arr = Arrays.stream(arr).map((x)-> x+10).toArray();
        list = list.stream().map((x) -> x+10).collect(Collectors.toList());
        arr = Arrays.stream(arr).filter(x -> x%2==0).toArray();


        list.forEach(System.out::println);


    }

    private static void initList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void initArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }
}
