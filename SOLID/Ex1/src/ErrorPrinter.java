import java.util.List;

public class ErrorPrinter {
    public boolean printErrors(List<String> errors) {
        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return true;
        }
        return false;
    }
}
