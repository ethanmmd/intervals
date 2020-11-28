package usantatecla;

public class Max extends Bound {

	public Max(double value) {
		super(value);
	}

	public boolean isWithin(double value) {
		return this.value > value;
	}

	public String toString() {
		return this.value + ")";
	}

}
