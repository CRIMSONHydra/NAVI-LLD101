
import java.util.LinkedHashSet;
import java.util.Set;

public class Programs implements ProgramProvider {
    private Set<String> programs;
    
    public Programs() {
        programs = new LinkedHashSet<>();
        programs.add("CSE");
        programs.add("ECE");
        programs.add("MECH");
        programs.add("AIML");
    }

    @Override
    public Set<String> allowedPrograms() {
        return programs;
    }
}
