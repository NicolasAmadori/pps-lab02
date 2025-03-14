object Lab2 extends App:
  //Task 1
  def div(a: Double, b: Double): Double = a / b

  def curriedDiv(a: Double)(b: Double): Double = a / b

  //Task 3.a
  def positive(x: Int): String = x match
    case n if n > 0 => "positive"
    case n if n < 0 => "negative"

  val x = 10

  val positive = x match
    case x if x > 0 => "positive"
    case x if x < 0 => "negative"

  //Task 2
  //Metodo
  def neg(p: String => Boolean): String => Boolean = s => !p(s)

  //Val
  val neg2: (String => Boolean) => (String => Boolean) = p => s => !p(s)

  def neg3[A](p: A => Boolean): (A => Boolean) = s => !p(s)
  val pos: Int => Boolean = _ > 0

  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z

  val p2: (Int, Int, Int) => Boolean = (x,y,z) => x <= y && y == z

  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z

  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

  def compose2[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))

  def composeThree[A,B,C,D](f: C => D, g: B => C, h: A => B): A => D = x => f(g(h(x)))

  //Task 3
  //Non-tail
  def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case n if n > 0 => power(base, exponent-1) * base

  //Tail
  def power2(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def _power(b: Double, e: Int, acc: Double): Double = e match
      case 0 => acc
      case n if n > 0 => _power(b, e-1, acc * b)
    _power(base, exponent, 1)

  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def _reverse(n: Int, acc: Int): Int = n match
      case 0 => acc
      case n => _reverse(n / 10, acc * 10 + (n % 10))
    _reverse(n, 0)

  //Task 4

  enum Expr:
    case Literal(value: Int)
    case Add(e1: Expr, e2: Expr)
    case Multiply(e1: Expr, e2: Expr)

  def evaluate(expr: Expr): Int = expr match
    case Expr.Literal(v) => v
    case Expr.Add(e1, e2) => evaluate(e1) + evaluate(e2)
    case Expr.Multiply(e1, e2) => evaluate(e1) * evaluate(e2)

  def show(expr: Expr): String = expr match
    case Expr.Literal(v) => "" + v
    case Expr.Add(e1, e2) => "(" + show(e1) + " + " + show(e2) + ")"
    case Expr.Multiply(e1, e2) => "(" + show(e1) + " * " + show(e2) + ")"

  //Task 5
  enum Optional[A]:
    case Maybe(value: A)
    case Empty()

  import Optional.*

  def map[A, B](optional: Optional[A], f: A => B): Optional[B] = optional match
    case Empty() => Empty()
    case Maybe(v) => Maybe(f.apply(v))

  def filter[A](optional: Optional[A], p: A => Boolean): Optional[A] = optional match
    case Empty() => Empty()
    case Maybe(v) if !p.apply(v) => Empty()
    case Maybe(v) => Maybe(v)