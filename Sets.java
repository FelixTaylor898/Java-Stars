import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sets {
    final static Set<String> iro = new HashSet<>();
    final static Set<String> aevar = new HashSet<>();
    final static Set<String> yssyki = new HashSet<>();
    public static Set<String> ikti = new HashSet<>();
    public static void generateSets() {
        Scanner iroScan = null;
        Scanner aevarScan = null;
        Scanner yssykiScan = null;
        Scanner iktiScan = null;
        File iroFile = new File("iro.txt");
        File aevarFile = new File("aevar.txt");
        File yssykiFile = new File("yssyki.txt");
        File iktiFile = new File("iktijur.txt");
        try {
            iroScan = new Scanner(iroFile);
            aevarScan = new Scanner(aevarFile);
            yssykiScan = new Scanner(yssykiFile);
            iktiScan = new Scanner(iktiFile);
        } catch (FileNotFoundException e) {
            System.out.print("File failure.");
            System.exit(0);
        }
        while (iroScan.hasNextLine()) {
            iro.add(iroScan.nextLine());
        }
        while (aevarScan.hasNextLine()) {
            aevar.add(aevarScan.nextLine());
        }
        while (yssykiScan.hasNextLine()) {
            yssyki.add(yssykiScan.nextLine());
        }
        while (iktiScan.hasNextLine()) {
            ikti.add(iktiScan.nextLine());
        }
        iroScan.close();
        aevarScan.close();
        yssykiScan.close();
        iktiScan.close();
    }
}
