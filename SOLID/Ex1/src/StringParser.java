
import java.util.LinkedHashMap;
import java.util.Map;

public class StringParser {
    
    public Student parse(String input) {
        Map<String, String> kv = new LinkedHashMap<>();
        String[] parts = input.split(";");
        for(String pair : parts) {
            String[] p = pair.split("=", 2);
            if(p.length == 2) {
                kv.put(p[0].trim(), p[1].trim());
            }
        }
        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");
        return new Student(name, email, phone, program);
    }
    
}
