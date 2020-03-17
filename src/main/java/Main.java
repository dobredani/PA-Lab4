import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;

public class Main {
    private static List<Resident> residentList = new ArrayList<>();
    private static Set<Hospital> hospitalSet = new TreeSet<>();
    public static void main(String[] args){
        Resident[] r = IntStream.rangeClosed(0,3).mapToObj(i -> new Resident("R" + i)).toArray(Resident[]::new);
        Hospital[] h = IntStream.rangeClosed(0,2).mapToObj(i -> new Hospital("H" + i)).toArray(Hospital[]::new);

        residentList.addAll(Arrays.asList(r));
        hospitalSet.addAll(Arrays.asList(h));

        Collections.sort(residentList, ((r1, r2) -> r1.getName().compareTo(r2.getName())));

        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();

        resPrefMap.put(r[0], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[2], Arrays.asList(h[0], h[1]));
        resPrefMap.put(r[3], Arrays.asList(h[0], h[2]));

        Map<Hospital, List<Resident>> hosPrefMap = new HashMap<>();

        hosPrefMap.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hosPrefMap.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hosPrefMap.put(h[2], Arrays.asList(r[0], r[1], r[3]));

        List<Hospital> target = Arrays.asList(h[0], h[2]);
        residentList.stream().filter(res -> resPrefMap.get(res).containsAll(target)).forEach(System.out::println);

        hospitalSet.stream().filter(hos ->hosPrefMap.get(hos).contains(r[0])).forEach(System.out::println);
    }
}
