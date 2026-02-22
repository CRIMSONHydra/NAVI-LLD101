
import java.util.List;

public interface StudentDB {
    void save(StudentRecord rec);
    int count();
    List<StudentRecord> all();
}
