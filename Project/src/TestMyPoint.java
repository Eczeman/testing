import static org.junit.Assert.*;

import java.util.Random;

import org.easymock.EasyMock;
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
	
	@Test
	public void testTranslate(){
		point.translate(2d,5d);
		assertEquals(3d, point.getX(), 0.0001);
		assertEquals(6d, point.getY(), 0.0001);
	}

	@Test
	public void testTranslateDoubleNaNY(){
		point.translate(2d,Double.NaN);
		assertEquals(1d, point.getX(), 0.0001);
		assertEquals(1d, point.getY(), 0.0001);
	}
	
	@Test
	public void testTranslateDoubleNaNX(){
		point.translate(Double.NaN,2d);
		assertEquals(1d, point.getX(), 0.0001);
		assertEquals(1d, point.getY(), 0.0001);
	}
	
	@Test
	public void testTranslateDoubleNaNXY(){
		point.translate(Double.NaN,Double.NaN);
		assertEquals(1d, point.getX(), 0.0001);
		assertEquals(1d, point.getY(), 0.0001);
	}
	
	@Test
	public void testGetMiddlePoint(){
		point = point.getMiddlePoint(new MyPoint(3d, 5d));
		assertEquals(2d, point.getX(), 0.0001);
		assertEquals(3d, point.getY(), 0.0001);
	}
	
	@Test
	public void testCentralSymmetry(){
	    point = point.centralSymmetry(new MyPoint(2d, 2d));
	    assertEquals(3d, point.getX(), 0.0001);
	    assertEquals(3d, point.getY(), 0.0001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCentralSymmetryNULL(){
	    new MyPoint(10, 20).centralSymmetry(null);
	}
	
	@Test
	public void testSetPoint(){
		Random mock1 = EasyMock.createMock(Random.class);
		Random mock2 = EasyMock.createMock(Random.class);
		EasyMock.expect(mock1.nextInt()).andReturn(42);		
		EasyMock.expect(mock2.nextInt()).andReturn(57);
		EasyMock.replay(mock1);
		EasyMock.replay(mock2);
		point.setPoint(mock1, mock2);
		assertEquals(42, point.getX(), 0.0001);
		assertEquals(57, point.getY(), 0.0001);
	}
	
	@Test
	public void testTranslateITranslation(){
		ITranslation mock1 = EasyMock.createMock(ITranslation.class);
		EasyMock.expect(mock1.getTx()).andReturn(35);		
		EasyMock.expect(mock1.getTy()).andReturn(18);
		EasyMock.replay(mock1);
		point.translate(mock1);
		assertEquals(36d, point.getX(), 0.0001);
		assertEquals(19d, point.getY(), 0.0001);
	}
	
	@Test
	public void testTranslateITranslationNull(){
		point.translate(null);
		assertEquals(1d, point.getX(), 0.0001);
		assertEquals(1d, point.getY(), 0.0001);
	}
	
	@Test
	public void testRotatePointNull(){
	    assertNull(point.rotatePoint(null, -Math.PI));
	}
	
	@Test
	public void testRotatePointNegAngle(){
	    point = point.rotatePoint(new MyPoint(2d, 2d), -Math.PI);
	    assertEquals(3d, point.getX(), 0.0001);
		assertEquals(3d, point.getY(), 0.0001);
	}
	
	@Test
	public void testRotatePointNulAngle(){
	    point = point.rotatePoint(new MyPoint(2d, 2d), 0);
	    assertEquals(1d, point.getX(), 0.0001);
		assertEquals(1d, point.getY(), 0.0001);
	}
	
	@Test
	public void testRotatePointPIOf2(){
	    point = point.rotatePoint(new MyPoint(2d, 2d), Math.PI/2);
	    assertEquals(3d, point.getX(), 0.0001);
		assertEquals(1d, point.getY(), 0.0001);
	}
	
	@Test
	public void testRotatePoint3PIOf2(){
	    point = point.rotatePoint(new MyPoint(2d, 2d), 3*Math.PI/2);
	    assertEquals(1d, point.getX(), 0.0001);
		assertEquals(3d, point.getY(), 0.0001);
	}
	
	@Test
	public void testRotatePoint5PIOf6(){
		point = new MyPoint(1d ,0d);
	    point = point.rotatePoint(new MyPoint(0d, 0d), 5*Math.PI/6);
	    assertEquals(-Math.sqrt(3)/2d, point.getX(), 0.0001);
		assertEquals(0.5, point.getY(), 0.0001);
	}
	
	@Test
	public void testComputeAngleNul(){
		point = new MyPoint();
		assertEquals(0d, point.computeAngle(new MyPoint(1d, 0d)), 0.0001);
	}
	
	@Test
	public void testComputeAnglePI(){
		point = new MyPoint();
		assertEquals(Math.PI, point.computeAngle(new MyPoint(-1d, 0d)), 0.0001);
	}
	
	@Test
	public void testComputeAnglePiOf2(){
		point = new MyPoint();
		assertEquals(Math.PI/2, point.computeAngle(new MyPoint(0d, 1d)), 0.0001);
	}
	
	@Test
	public void testComputeAngle3PiOf2(){
		point = new MyPoint();
		assertEquals(3*Math.PI/2, point.computeAngle(new MyPoint(0d, -1d)), 0.0001);
	}
}
