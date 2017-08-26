package random;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PythonRange{
    public static void main(String[] args){
        List<Integer> list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        System.out.println(list);
        list = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
}
