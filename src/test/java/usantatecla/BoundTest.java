package usantatecla;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class BoundTest {

	protected Bound bound;
	protected Point point;

	@BeforeEach
	protected void before() {
		this.point = new Point(4.4);
		this.bound = this.createBound();
	}

	protected abstract Bound createBound();

	protected abstract boolean isWithinWithLessValue();

	protected abstract boolean isWithInWithEqualsValue();

	protected abstract boolean isWithinWithGreaterValue();

	@Test
	public void givenBoundWhenIsWithinWithLessValueThenTrue() {
		assertThat(this.isWithinWithLessValue(), equalTo(this.bound.isWithin(this.point.getLess())));
	}

	@Test
	public void givenBoundWhenIsWithinWithEqualsValue() {
		assertThat(this.isWithInWithEqualsValue(), equalTo(this.bound.isWithin(this.point.getEquals())));
	}

	@Test
	public void givenBoundWhenIsWithinWithGreaterValueThenTrue() {
		assertThat(this.isWithinWithGreaterValue(), equalTo(this.bound.isWithin(this.point.getGreater())));
	}

}
