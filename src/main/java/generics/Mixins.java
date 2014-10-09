package generics;

/*
 * Exercise 37: (2) 
 * Add a new mixin class Colored to Mixins.java, mix it into Mixin,
 *	and show that it works.
 */

import java.awt.Color;
import java.util.Date;
import java.util.Random;

interface Colorfull {
	Color getColor();
}

class ColorfullImpl implements Colorfull {

	private static Random rnd = new Random(47);
	private final Color clr = new Color(rnd.nextInt(16777216)); // 2^24

	@Override
	public Color getColor() {
		return clr;
	}

}

interface TimeStamped {
	long getStamp();
}

class TimeStampedImp implements TimeStamped {
	private final long timeStamp;

	public TimeStampedImp() {
		timeStamp = new Date().getTime();
	}

	public long getStamp() {
		return timeStamp;
	}
}

interface SerialNumbered {
	long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
	private static long counter = 1;
	private final long serialNumber = counter++;

	public long getSerialNumber() {
		return serialNumber;
	}
}

interface Basic {
	public void set(String val);

	public String get();
}

class BasicImp implements Basic {
	private String value;

	public void set(String val) {
		value = val;
	}

	public String get() {
		return value;
	}
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered {

	private TimeStamped timeStamp = new TimeStampedImp();
	private SerialNumbered serialNumber = new SerialNumberedImp();
	private Colorfull colorfull = new ColorfullImpl();

	public long getStamp() {
		return timeStamp.getStamp();
	}

	public long getSerialNumber() {
		return serialNumber.getSerialNumber();
	}

	public Color getColor() {
		return colorfull.getColor();
	}
}

public class Mixins {

	public static void main(String[] args) {

		Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
		mixin1.set("test string 1");
		mixin2.set("test string 2");
		
		System.out.printf("%s %d %d %s%n", mixin1.get(), mixin1.getStamp(),
				mixin1.getSerialNumber(), mixin1.getColor());
		System.out.printf("%s %d %d %s%n", mixin2.get(), mixin2.getStamp(),
				mixin2.getSerialNumber(), mixin2.getColor());
	}
}