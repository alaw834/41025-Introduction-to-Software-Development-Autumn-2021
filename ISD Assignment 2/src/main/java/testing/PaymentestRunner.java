package testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author alaw8
 */
public class PaymentestRunner {
    public static void main(String[] args) {

    System.out.println("- Testing Payment: ");

    Result result = JUnitCore.runClasses(PaymentTest.class);

    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }

    String status = result.wasSuccessful() ? "Passed" : "Failed";
    System.out.println(" Test status = "+status);
    System.out.println(" Number of Tests Passed = "+result.getRunCount());
    System.out.println(" Number of Tests Ignored = "+result.getIgnoreCount());
    System.out.println(" Number of Tests Failed = "+result.getFailureCount());
    System.out.println(" Time = "+result.getRunTime()/1000.0+"s");

  }
}