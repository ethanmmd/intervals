package usantatecla;

import org.junit.jupiter.api.BeforeEach;

public class MaxTest extends BoundTest {

	protected Bound createBound() {
		return new Max(this.point.getEquals());
	}

	protected boolean isWithinWithLessValue() {
		return true;
	}

	protected boolean isWithInWithEqualsValue() {
		return false;
	}

	protected boolean isWithinWithGreaterValue() {
		return false;
	}


}
