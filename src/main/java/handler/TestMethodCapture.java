package handler;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import static com.google.common.base.Preconditions.checkNotNull;
//Found this class online. It is required so the LoggerFactory class can get the test name in a non-static context - I use it in quite a few places now.

public class TestMethodCapture implements IInvokedMethodListener {
    private static ThreadLocal<ITestNGMethod> currentMethods = new ThreadLocal<>();
    private static ThreadLocal<ITestResult> currentResults = new ThreadLocal<>();

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        currentMethods.set(method.getTestMethod());
        currentResults.set(testResult);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        currentMethods.remove();
        currentResults.remove();
    }

    public static ITestNGMethod getTestMethod() {
        return checkNotNull(currentMethods.get(),
                "Did you forget to register the %s listener?", TestMethodCapture.class.getName());
    }

    public static ITestResult getTestResult() {
        return checkNotNull(currentResults.get(),
                "Did you forget to register the %s listener?", TestMethodCapture.class.getName());
    }
}