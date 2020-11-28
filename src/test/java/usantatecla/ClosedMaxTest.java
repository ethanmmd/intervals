package usantatecla;

public class ClosedMaxTest extends MaxTest {

	@Override
	protected Bound createBound() {
		return new ClosedMax(this.point.getEquals());
	}

	@Override
	protected boolean isWithInWithEqualsValue() {
		return true;
	}


}
