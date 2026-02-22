import java.util.*;

public class OnboardingService {
    private final StudentDB db;

    public OnboardingService(StudentDB db) { this.db = db; }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        //Parse input
        StringParser parser = new StringParser();
        Student st = parser.parse(raw);

        //Validate student
        ValidateStudent validator = new ValidateStudent();
        List<String> errors = validator.validate(st);

        //log errors
        ErrorPrinter err = new ErrorPrinter();
        if(err.printErrors(errors)) return;

        //Make a record
        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, st);

        //save to db
        db.save(rec);

        //print success
        SuccessPrinter printer = new SuccessPrinter();
        printer.printSuccess(db.count(), rec);
    }
}
