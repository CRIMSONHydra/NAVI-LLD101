import java.util.*;

public class OnboardingService {
    private final StudentDB db;

    public OnboardingService(StudentDB db) { this.db = db; }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        StringParser parser = new StringParser();
        Map<String, String> kv = parser.parse(raw);

        
        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");


        ValidateStudent validator = new ValidateStudent();
        List<String> errors = validator.validate(name, email, phone, program);

        ErrorPrinter err = new ErrorPrinter();
        if(err.printErrors(errors)) return;


        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        db.save(rec);



        SuccessPrinter printer = new SuccessPrinter();
        printer.printSuccess(db.count(), rec);
    }
}
