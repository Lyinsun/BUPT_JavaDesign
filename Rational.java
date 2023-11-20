import java.math.BigInteger;
import java.util.BitSet;

public class Rational extends Number implements Comparable<Rational> {
  // Data fields for numerator and denominator
  private BigInteger numerator = new BigInteger("0");
  private BigInteger denominator = new BigInteger("1");

  /** Construct a rational with default properties */
//  public Rational() {
//    this(0, 1);
//  }

  /** Construct a rational with specified numerator and denominator */
/*  public Rational(long numerator, long denominator) {
    long gcd = gcd(numerator, denominator);
    this.numerator = ((denominator > 0) ? 1 : -1) * numerator / gcd;
    this.denominator = Math.abs(denominator) / gcd;
  }*/

  public Rational(BigInteger numerator, BigInteger denominator) {
    BigInteger gcd =  numerator.gcd(denominator);
    int temp = denominator.compareTo(new BigInteger("0"));
    this.numerator = numerator.divide(gcd).multiply(new BigInteger(String.valueOf(temp)));
    this.denominator = denominator.abs().divide(gcd);
  }

  /** Find GCD of two numbers */
  private static long gcd(long n, long d) {
    long n1 = Math.abs(n);
    long n2 = Math.abs(d);
    int gcd = 1;
    
    for (int k = 1; k <= n1 && k <= n2; k++) {
      if (n1 % k == 0 && n2 % k == 0) 
        gcd = k;
    }
    return gcd;
  }

  /** Return numerator */
  public BigInteger getNumerator() {
    return numerator;
  }

  /** Return denominator */
  public BigInteger getDenominator() {
    return denominator;
  }

  /** Add a rational number to this rational */
  public Rational add(Rational secondRational) {
    BigInteger n1 = this.numerator.multiply(secondRational.getDenominator());
    BigInteger n2 = this.denominator.multiply(secondRational.getNumerator());
    BigInteger n = n1.add(n2) ;
    BigInteger d = this.denominator.multiply(secondRational.getDenominator());
    return new Rational(n, d);
  }

  /** Subtract a rational number from this rational */
  public Rational subtract(Rational secondRational) {
//    long n = numerator * secondRational.getDenominator()
//      - denominator * secondRational.getNumerator();
//    long d = denominator * secondRational.getDenominator();
    BigInteger n1 = this.numerator.multiply(secondRational.getDenominator());
    BigInteger n2 = this.denominator.multiply(secondRational.getNumerator());
    BigInteger n = n1.subtract(n2) ;
    BigInteger d = this.denominator.multiply(secondRational.getDenominator());
    return new Rational(n, d);
  }

  /** Multiply a rational number to this rational */
  public Rational multiply(Rational secondRational) {
//    long n = numerator * secondRational.getNumerator();
//    long d = denominator * secondRational.getDenominator();
    BigInteger n = this.numerator.multiply(secondRational.getNumerator());
    BigInteger d = this.denominator.multiply(secondRational.getDenominator());
    return new Rational(n, d);
  }

  /** Divide a rational number from this rational */
  public Rational divide(Rational secondRational) {
//    long n = numerator * secondRational.getDenominator();
//    long d = denominator * secondRational.numerator;
    BigInteger n = this.numerator.multiply(secondRational.getDenominator());
    BigInteger d = this.denominator.multiply(secondRational.getNumerator());
    return new Rational(n, d);
  }

  @Override  
  public String toString() {
//    if (denominator == 1)
//      return numerator + "";
//    else
//      return numerator + "/" + denominator;
    if(this.denominator.compareTo(new BigInteger("1")) == 0)
      return numerator + "";
    else
      return numerator + "/" + denominator;
  }

//  @Override // Override the equals method in the Object class
//  public boolean equals(Object other) {
//    if ((this.subtract((Rational)(other))).getNumerator() == 0)
//      return true;
//    else
//      return false;
//  }

  @Override // Implement the abstract intValue method in Number
  public int intValue() {
    return (int)doubleValue();
  }

  @Override // Implement the abstract floatValue method in Number 
  public float floatValue() {
    return (float)doubleValue();
  }

  @Override // Implement the doubleValue method in Number 
  public double doubleValue() {
//    return numerator * 1.0 / denominator;

//    return this.numerator.divide(this.denominator).doubleValue();
    return numerator.doubleValue() / denominator.doubleValue();
  }

  @Override // Implement the abstract longValue method in Number
  public long longValue() {
    return (long)doubleValue();
  }

  @Override // Implement the compareTo method in Comparable
  public int compareTo(Rational o) {
//    if (this.subtract(o).getNumerator() > 0)
//      return 1;
//    else if (this.subtract(o).getNumerator() < 0)
//      return -1;
//    else
//      return 0;
    Rational temp = this.subtract(o);
  return temp.getNumerator().compareTo(new BigInteger("0"));


  }
}