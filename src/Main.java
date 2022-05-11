public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(i, i);
        }
    }
}
