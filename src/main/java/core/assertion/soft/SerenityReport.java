package core.assertion.soft;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.model.TestResult;
import net.thucydides.core.model.TestStep;
import net.thucydides.core.steps.ExecutedStepDescription;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.steps.StepFailure;

/**
 * A dirty workaround for failing a step in serenity but continuing with execution.
 * Use this with cautions as the behavior will change as per defined nested steps.
 * By default it will mark last step as failed.
 */
public class SerenityReport {

	private static final Logger log = LoggerFactory.getLogger(SerenityReport.class);

	private static SerenityReport report;

	//This is singleton class for marking step, test etc as failure hence
	//making constructor private for preventing users to create new instance
	private SerenityReport() {}

	/**
	 * syntactical sugar. It returns singleton instance of {@link SerenityReport} class.
	 * 
	 * @return singleton instance of {@link SerenityReport} class
	 */
	public static SerenityReport should() {
		if(report == null) {
			report = new SerenityReport();
		}
		return report;
	}
	
	/**
	 * Mark current step as failed and logs it into the report.
	 * 
	 * @param <T> - expected and actual type parameter
	 * @param validationDescription - high level failure reason
	 * @param actual - actual value
	 * @param matcher - hamcrest matcher instance for getting failure description
	 */
	public <T> void failStep(String validationDescription, T actual, Matcher<?> matcher) {
		try {
			Description description = new StringDescription();
			description.appendText(validationDescription)
			.appendText("\nExpected: ")
			.appendDescriptionOf(matcher)
			.appendText("\n     but: ");
			matcher.describeMismatch(actual, description);
			String descriptionString = description.toString();

			AssertionError assertion = new AssertionError(descriptionString);
			//"ExecutedStepDescription.withTitle" does not appear in report or console log
			StepFailure sf = new StepFailure(ExecutedStepDescription.withTitle("ExecutedStepDescription.withTitle"), assertion);
			StepEventBus seb = StepEventBus.getEventBus();
			TestStep step = new TestStep("new TestStep"); // "new TestStep" text does not appear in report or console log
			step.failedWith(assertion);
			step.setResult(TestResult.FAILURE);

			TestOutcome outcome = TestOutcome.forTest("", SerenityReport.class);
			outcome.recordStep(step);
			outcome.setAnnotatedResult(TestResult.FAILURE);
			outcome.setTestFailureMessage(descriptionString);

			seb.stepFailed(sf);
			seb.testFinished(outcome);
		} catch (Exception e) {
			log.error("Error while marking step as FAILED", e);
		}
	}

	/**
	 * Mark current step as failed and logs it into the report.
	 * 
	 * @param <T> - expected and actual type parameter
	 * @param validationDescription - high level failure reason
	 * @param expected - expected value
	 * @param actual - actual value
	 */
	public <T> void failStep(String validationDescription, T expected, T actual) {
		try {
			Description description = new StringDescription();
			description.appendText(validationDescription)
			.appendText("\nExpected: ")
			.appendValue(expected)
			.appendText("\n  Actual: ")
			.appendValue(actual);
			String descriptionString = description.toString();

			AssertionError assertion = new AssertionError(descriptionString);
			//"ExecutedStepDescription.withTitle" does not appear in report or console log
			StepFailure sf = new StepFailure(ExecutedStepDescription.withTitle("ExecutedStepDescription.withTitle"), assertion);
			StepEventBus seb = StepEventBus.getEventBus();
			TestStep step = new TestStep("new TestStep"); // "new TestStep" text does not appear in report or console log
			step.failedWith(assertion);
			step.setResult(TestResult.FAILURE);

			TestOutcome outcome = TestOutcome.forTest("", SerenityReport.class);
			outcome.recordStep(step);
			outcome.setAnnotatedResult(TestResult.FAILURE);
			outcome.setTestFailureMessage(descriptionString);

			seb.stepFailed(sf);
			seb.testFinished(outcome);
		} catch (Exception e) {
			log.error("Error while marking step as FAILED", e);
		}
	}
	
	/**
	 * Mark current step as failed and logs it into the report.
	 * 
	 * @param <T> - expected and actual type parameter
	 * @param validationDescription - high level failure reason
	 * @param value - value to log
	 */
	public <T> void failStep(String validationDescription, T value) {
		try {
			Description description = new StringDescription();
			description.appendText(validationDescription)
			.appendText("\nValue: ")
			.appendValue(value);
			String descriptionString = description.toString();

			AssertionError assertion = new AssertionError(descriptionString);
			//"ExecutedStepDescription.withTitle" does not appear in report or console log
			StepFailure sf = new StepFailure(ExecutedStepDescription.withTitle("ExecutedStepDescription.withTitle"), assertion);
			StepEventBus seb = StepEventBus.getEventBus();
			TestStep step = new TestStep("new TestStep"); // "new TestStep" text does not appear in report or console log
			step.failedWith(assertion);
			step.setResult(TestResult.FAILURE);

			TestOutcome outcome = TestOutcome.forTest("", SerenityReport.class);
			outcome.recordStep(step);
			outcome.setAnnotatedResult(TestResult.FAILURE);
			outcome.setTestFailureMessage(descriptionString);

			seb.stepFailed(sf);
			seb.testFinished(outcome);
		} catch (Exception e) {
			log.error("Error while marking step as FAILED", e);
		}
	}
	
	/**
	 * Mark current step as failed and logs it into the report.
	 * 
	 * @param <T> - expected and actual type parameter
	 * @param validationDescription - high level failure reason
	 */
	public <T> void failStep(String validationDescription) {
		try {
			Description description = new StringDescription();
			description.appendText(validationDescription);
			String descriptionString = description.toString();

			AssertionError assertion = new AssertionError(descriptionString);
			//"ExecutedStepDescription.withTitle" does not appear in report or console log
			StepFailure sf = new StepFailure(ExecutedStepDescription.withTitle("ExecutedStepDescription.withTitle"), assertion);
			StepEventBus seb = StepEventBus.getEventBus();
			TestStep step = new TestStep("new TestStep"); // "new TestStep" text does not appear in report or console log
			step.failedWith(assertion);
			step.setResult(TestResult.FAILURE);

			TestOutcome outcome = TestOutcome.forTest("", SerenityReport.class);
			outcome.recordStep(step);
			outcome.setAnnotatedResult(TestResult.FAILURE);
			outcome.setTestFailureMessage(descriptionString);

			seb.stepFailed(sf);
			seb.testFinished(outcome);
		} catch (Exception e) {
			log.error("Error while marking step as FAILED", e);
		}
	}
}