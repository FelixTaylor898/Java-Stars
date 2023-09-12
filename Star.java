public class Star {
    String name;
    String type;
    public Star(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String toString() {
        return "\n" + name + "\n" + type;
    }

}
