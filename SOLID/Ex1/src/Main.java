public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        StudentDB db = new FakeDb();
        ProgramProvider programs = new Programs();
        OnboardingService svc = new OnboardingService(db, programs);

        String good = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(good);

        String bad = "name=Reeya;email=reeya@sst.edu;phone=9876544580;program=DSML";
        svc.registerFromRawInput(bad);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}
