package usantatecla;

public class Min extends Bound {

	public Min(double value) {
		super(value);
	}

	public boolean isWithin(double value) {
		return this.value < value;
	}


	public String toString() {
		return "(" + this.value;
	}

}
