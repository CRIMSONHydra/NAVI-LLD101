public class StudentRecord {
    public final String id;
    public final String name;
    public final String email;
    public final String phone;
    public final String program;

    public StudentRecord(String id, Student st) {
        this.id = id; this.name = st.name; this.email = st.email; this.phone = st.phone; this.program = st.program;
    }

    @Override
    public String toString() {
        return "StudentRecord{id='" + id + "', name='" + name + "', email='" + email + "', phone='" + phone + "', program='" + program + "'}";
    }
}
