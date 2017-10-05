import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMyPoint {
	MyPoint point;
	MyPoint pointconstruct;
	
	@Before
	public void setUp() throws Exception {
		point = new MyPoint(1d,1d);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMyPoint() {
		pointconstruct = new MyPoint();
		assertEquals(0d, pointconstruct.getX(), 0.0001);
		assertEquals(0d, pointconstruct.getY(), 0.0001);
	}

	@Test
	public void testMyPointDoubleDouble() {
		pointconstruct = new MyPoint(1d, 3d);
		assertEquals(1d, pointconstruct.getX(), 0.0001);
		assertEquals(3d, pointconstruct.getY(), 0.0001);
	}
	
	@Test
	public void testMyPointMyPointNull() {
		pointconstruct = new MyPoint(null);
		assertEquals(0d, pointconstruct.getX(), 0.0001);
		assertEquals(0d, pointconstruct.getY(), 0.0001);
	}
	
	@Test
	public void testMyPointMyPoint() {
		pointconstruct = new MyPoint(new MyPoint(1d, 3d));
		assertEquals(1d, pointconstruct.getX(), 0.0001);
		assertEquals(3d, pointconstruct.getY(), 0.0001);
	}
	
	@Test
	public void testGetXSetX() {
		point.setX(3d);
		assertEquals(3d, point.getX(), 0.0001);
		
	}
	
	@Test
	public void testGetYSetY() {
		point.setY(3d);
		assertEquals(3d, point.getY(), 0.0001);
		
	}
	
	@Test
	public void testSetXNaN() {
		point.setX(Double.NaN);
		assertEquals(1d, point.getX(), 0.0001);
		
	}
	
	@Test
	public void testSetYNaN() {
		point.setY(Double.NaN);
		assertEquals(1d, point.getY(), 0.0001);
		
	}
	
	@Test
	public void testScale(){
		point = point.scale(3);
		assertEquals(3d, point.getX(), 0.0001);
		assertEquals(3d, point.getY(), 0.0001);
	}
	
	@Test
	public void testHorizontalSymmetry(){
		point = point.horizontalSymmetry(new MyPoint(2d, 2d));
		assertEquals(3d, point.getX(), 0.0001);
		assertEquals(1d, point.getY(), 0.0001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHorizontalSymmetryIllegalArgExep(){
		point = point.horizontalSymmetry(null);
	}

}
