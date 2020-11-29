package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {
  
  private Point left;
  private Point right;

  @BeforeEach
  public void before(){
    this.left = new Point(-2.2);
    this.right = new Point(4.4);
  }

  static IntervalBuilder generateIntervalBuilder(){
    return new IntervalBuilder();
  }

  @Test
  public void givenIntervalOpenOpenWhenIncludeWithIncludedValueThenTrue() {
    Interval interval = generateIntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    assertIncludeWhenLeftOpen(interval);
    assertIncludeWhenRightOpen(interval);
  }

  @Test
  public void givenIntervalClosedOpenWhenIncludeWithIncludedValueThenTrue() {
    Interval interval = generateIntervalBuilder().closed(left.getEquals()).open(right.getEquals()).build();
    assertIncludeWhenLeftClosed(interval);
    assertIncludeWhenRightOpen(interval);
  }

  @Test
  public void givenIntervalOpenClosedWhenIncludeWithIncludedValueThenTrue() {
    Interval interval = generateIntervalBuilder().open(left.getEquals()).closed(right.getEquals()).build();
    assertIncludeWhenLeftOpen(interval);
    assertIncludeWhenRightClosed(interval);
  }

  @Test
  public void givenIntervalClosedCloseWhenIncludeWithIncludedValueThenTrue() {
    Interval interval = generateIntervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();
    assertIncludeWhenLeftClosed(interval);
    assertIncludeWhenRightClosed(interval);
  }

  @Test
  public void givenIntervalOpenOpenWhenExistIntersectionWithAnotherIntervalOpenOpenOnTheLeftThenReturnTrue(){
    Interval interval = generateIntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    Interval intersectedInterval = generateIntervalBuilder().open(left.getLess()).open(right.getLess()).build();
    assertTrue(interval.existsIntersection(intersectedInterval));
  }

  @Test
  public void givenIntervalOpenOpenWhenExistIntersectionWithAnotherIntervalOpenOpenOnTheRightThenReturnTrue(){
    Interval interval = generateIntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    Interval intersectedInterval = generateIntervalBuilder().open(right.getLess()).open(right.getGreater()).build();
    assertTrue(interval.existsIntersection(intersectedInterval));

  }

  @Test
  public void giveIntervalOpenOpenWhenNotExistIntersectionWithAnotherIntervalOpenOpenOnTheLeftThenReturnFalse(){
    Interval interval = generateIntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    Interval intersectedInterval = generateIntervalBuilder().open(left.getLess()).open(left.getEquals()).build();
    assertFalse(interval.existsIntersection(intersectedInterval));
  }

  @Test
  public void giveIntervalOpenOpenWhenNotExistIntersectionWithAnotherIntervalOpenOpenOnTheRightThenReturnFalse(){
    Interval interval = generateIntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    Interval intersectedInterval = generateIntervalBuilder().open(right.getEquals()).open(right.getGreater()).build();
    assertFalse(interval.existsIntersection(intersectedInterval));
  }

  @Test
  public void givenIntervalOpenOpenWhenExistIntersectionWithAnotherIntervalOpenClosedOnTheLeftThenReturnFalse(){
    Interval interval = generateIntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    Interval intersectedInterval = generateIntervalBuilder().open(left.getLess()).closed(left.getEquals()).build();
    assertTrue(interval.existsIntersection(intersectedInterval));
  }

  @Test
  public void givenIntervalOpenOpenWhenExistIntersectionWithAnotherIntervalClosedOpendOnTheRightThenReturnFalse(){
    Interval interval = generateIntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    Interval intersectedInterval = generateIntervalBuilder().closed(right.getEquals()).open(right.getGreater()).build();
    assertTrue(interval.existsIntersection(intersectedInterval));
  }



  private void assertIncludeWhenLeftClosed(Interval interval) {
    assertFalse(interval.include(left.getLess()));
    assertTrue(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));
  }

  private void assertIncludeWhenRightClosed(Interval interval) {
    assertTrue(interval.include(right.getLess()));
    assertTrue(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  private void assertIncludeWhenLeftOpen(Interval interval) {
    assertFalse(interval.include(left.getLess()));
    assertFalse(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));
  }

  private void assertIncludeWhenRightOpen(Interval interval) {
    assertTrue(interval.include(right.getLess()));
    assertFalse(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }
}