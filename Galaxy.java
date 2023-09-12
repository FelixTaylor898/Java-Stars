import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Galaxy {
    private String full;
    String name;
    static List<Star> starList;
    static Set<String> syllables;

    public Galaxy(Culture cult, int num) {
        starList = new ArrayList<>();
        syllables = new HashSet<>();
        switch (cult) {
            case IRO:
                syllables = Sets.iro;
                name = "Irö stars";
                break;
            case AEVAR:
                syllables = Sets.aevar;
                name = "Ævar stars";
                break;
            case YSS:
                syllables = Sets.yssyki;
                name = "Yssyki stars";
                break;
            case IKTI:
                syllables = Sets.ikti;
                name = "Iktijur stars";
            default:
                break;
        }
        for (int k = 0; k < num; k++) {
            starList.add(createStar());
        }
        full = name;
        for (Star star : starList) {
            full += "\n" + star.toString();
        }
    }

    public String toString() {
        return full;
    }

    private static Star createStar() {
        String name = "";
        int syll = new Random().nextInt(4);
        for (int s = 0; s < syll; s++) {
            name += genSyllable();
        }
        while (name.length() < 4) {
            name += genSyllable();
        }
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        String type;
        int r = (int) (Math.random() * (99)) + 1;
        if (r < 6)
            type = "O-type (Blue supergiant)";
        else if (r < 11)
            type = "B-type (Blue giant)";
        else if (r < 16)
            type = "A-type (Blue dwarf)";
        else if (r < 21)
            type = "F-type (Light yellow dwarf)";
        else if (r < 31)
            type = "G-type (Yellow dwarf)";
        else if (r < 41)
            type = "K-type (Orange dwarf)";
        else
            type = "M-type (Red dwarf)";
        return new Star(name, type);
    }

    private static String genSyllable() {
        int i = 0;
        int num = new Random().nextInt(syllables.size());
        for (String item : syllables) {
            if (i == num) {
                return item;
            }
            i++;
        }
        return null;
    }
}