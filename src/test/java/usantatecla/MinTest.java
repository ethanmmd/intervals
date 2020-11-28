package usantatecla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinTest extends BoundTest {


  protected Bound createBound() {
    return new Min(this.point.getEquals());
  }

  protected boolean isWithinWithLessValue() {
    return false;
  }

  protected boolean isWithInWithEqualsValue() {
    return false;
  }

  protected boolean isWithinWithGreaterValue() {
    return true;
  }
}

