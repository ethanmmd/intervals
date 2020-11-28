package usantatecla;

public class ClosedMinTest extends MinTest {

	@Override
	protected Bound createBound() {
		return new ClosedMin(this.point.getEquals());
	}

	@Override
	protected boolean isWithInWithEqualsValue() {
		return true;
	}


}
