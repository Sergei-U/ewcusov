import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.TreeSet;

/**
 *
 */
public class IpAddrCount {
    public static void main(String[] args) {


        TreeSet<List<String>> treeSet = new TreeSet<>();
        try {
            treeSet.add(Files.readAllLines(Path.of("c:/ip_address.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(treeSet.size());
    }
}

