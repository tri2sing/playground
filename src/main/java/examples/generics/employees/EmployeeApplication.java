package examples.generics.employees;

public class EmployeeApplication {
    public static void main(String[] args) {
        Engineer eng = new Engineer("John Doe", "Computer Sciene");
        System.out.println(eng + " is instance of " + eng.getClass().getName());
        Manager mgr = new Manager("Jane Roe", "Artifical Intelligence Products");
        System.out.println(mgr + " is instance of " + mgr.getClass().getName());

        // When we call new for the generic class, we do not create a new instance of the
        // Employer. We just specify that it will hold a reference to  Engineer.
        Employee<Engineer> eEng = new Employee<>();
        System.out.println(eEng + " is instance of " + eEng.getClass().getName());
        eEng.setEmployee(eng);
        System.out.println(eEng + " is instance of " + eEng.getClass().getName());

        Employee<Manager> eMgr = new Employee<>();
        System.out.println(eMgr + " is instance of " + eMgr.getClass().getName());
        eMgr.setEmployee(mgr);
        System.out.println(eMgr + " is instance of " + eMgr.getClass().getName());
    }
}
