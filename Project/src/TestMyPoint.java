import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMyPoint {
	MyPoint point;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMyPoint() {
		point = new MyPoint();
		assertEquals(0d, point.getX(), 0.0001);
		assertEquals(0d, point.getY(), 0.0001);
	}

	@Test
	public void testMyPointDoubleDouble() {
		point = new MyPoint(1d, 3d);
		assertEquals(1d, point.getX(), 0.0001);
		assertEquals(3d, point.getY(), 0.0001);
	}
	
	@Test
	public void testMyPointMyPointNull() {
		point = new MyPoint(null);
		assertEquals(0d, point.getX(), 0.0001);
		assertEquals(0d, point.getY(), 0.0001);
	}
	
	@Test
	public void testMyPointMyPoint() {
		point = new MyPoint(new MyPoint(1d, 3d));
		assertEquals(1d, point.getX(), 0.0001);
		assertEquals(3d, point.getY(), 0.0001);
	}
	
	@Test
	public void testGetXSetX() {
		point = new MyPoint();
		point.setX(3d);
		assertEquals(3d, point.getX(), 0.0001);
		
	}
	
	@Test
	public void testGetYSetY() {
		point = new MyPoint();
		point.setY(3d);
		assertEquals(3d, point.getY(), 0.0001);
		
	}
	
	@Test
	public void testSetXNaN() {
		point = new MyPoint();
		point.setX(Double.NaN);
		assertEquals(0d, point.getX(), 0.0001);
		
	}
	
	@Test
	public void testSetYNaN() {
		point = new MyPoint();
		point.setY(Double.NaN);
		assertEquals(0d, point.getY(), 0.0001);
		
	}

}
