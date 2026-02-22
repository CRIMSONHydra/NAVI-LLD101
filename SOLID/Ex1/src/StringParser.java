
import java.util.LinkedHashMap;
import java.util.Map;

public class StringParser {
    
    public Map<String, String> parse(String input) {
        Map<String, String> kv = new LinkedHashMap<>();
        String[] parts = input.split(";");
        for(String pair : parts) {
            String[] p = pair.split("=", 2);
            if(p.length == 2) {
                kv.put(p[0].trim(), p[1].trim());
            }
        }
        return kv;
    }
    
}
