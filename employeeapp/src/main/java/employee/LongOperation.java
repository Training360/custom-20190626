package employee;

public class LongOperation {

    public String doLongOperations() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "kutykurutty";
    }
}
