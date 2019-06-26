package employee;

import java.util.function.Supplier;

public class EmployeeDebugger {

    private boolean debug = false;


    public void debug(Supplier<String> s) {
        if (debug) {
            System.out.println(s.get());
        }
    }

    public static void main(String[] args) {
        new EmployeeDebugger().debug(() -> new LongOperation().doLongOperations());
    }
}
