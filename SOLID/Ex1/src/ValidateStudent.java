import java.util.ArrayList;
import java.util.List;

public class ValidateStudent {
    public List<String> validate(Student st) {
        List<String> errors = new ArrayList<>();
        if (st.name.isBlank()) errors.add("name is required");
        if (st.email.isBlank() || !st.email.contains("@")) errors.add("email is invalid");
        if (st.phone.isBlank() || !st.phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(st.program.equals("CSE") || st.program.equals("AI") || st.program.equals("SWE"))) errors.add("program is invalid");

        return errors;
    }
}
