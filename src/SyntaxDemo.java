import java.util.ArrayList;

public class SyntaxDemo {
    public static void main(String[] args) {
        System.out.println(foo1("Hello world!"));
        System.out.println(greeting("Josh Hug"));
        System.out.println(getMessage(404));
    }

    private static int foo1(String argument1) {
        int length;
        length = argument1.length(); // this *should* be final, but no one does that
        int sum = 0;
        for (int i = 0; i < length; i += 1) {
            sum += argument1.charAt(i); // "strongly typed" lmao
        }
        return sum;
    }

    // can get super tedious with lots of little string insertions like this
    private static String greeting(String name) {
        return "Hello, " + name + "!";
    }

    // switch statements are verbose
    private static String getMessage(int responseCode) {
        String message;
        switch (responseCode) {
            case 200:
            case 201:
                message = "u good";
                break;
            case 404:
                message = "page not found";
                break;
            case 500:
                message = "rip";
                break;
            default:
                message = "Unexpected error";
                break;
        }
        return "Response " + responseCode + ": " + message;
    }

    private static ArrayList<String> bar() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        return strings;
    }

    private static void printBar() {
        ArrayList<String> strings = bar();

        // someone else can mess with your list!
        strings.clear();
        strings.add("four");
        System.out.println(strings.get(0));
    }
}
