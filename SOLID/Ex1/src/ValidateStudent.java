import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ValidateStudent {
    private final Set<String> allowedPrograms;

    public ValidateStudent(ProgramProvider provider) {
        allowedPrograms = provider.allowedPrograms();
    }

    public List<String> validate(Student st) {
        List<String> errors = new ArrayList<>();
        if (st.name.isBlank()) errors.add("name is required");
        if (st.email.isBlank() || !st.email.contains("@")) errors.add("email is invalid");
        if (st.phone.isBlank() || !st.phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(allowedPrograms.contains(st.program))) errors.add("program is invalid");

        return errors;
    }
}
