package employee;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class EmployeeWithNameMatcher extends TypeSafeMatcher<Employee> {

    private Matcher<String> matcher;

    public EmployeeWithNameMatcher(Matcher<String> matcher) {
        this.matcher = matcher;
    }

    @Override
    protected void describeMismatchSafely(Employee item, Description mismatchDescription) {
        mismatchDescription.appendText(" employee with name ").appendValue(item.getName());
    }

    @Override
    protected boolean matchesSafely(Employee item) {
        return matcher.matches(item.getName());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(" employee with name ").appendDescriptionOf(matcher);
    }

    public static Matcher employeeWithName(Matcher<String> matcher) {
        return new EmployeeWithNameMatcher(matcher);
    }
}
