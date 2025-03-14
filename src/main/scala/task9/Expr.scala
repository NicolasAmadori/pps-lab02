package task9


object Task9:

  enum Expr:
    case Literal(value: Int)
    case Add(e1: Expr, e2: Expr)
    case Multiply(e1: Expr, e2: Expr)

  object Expressions:
    def evaluate(expr: Expr): Int = expr match
      case Expr.Literal(v) => v
      case Expr.Add(e1, e2) => evaluate(e1) + evaluate(e2)
      case Expr.Multiply(e1, e2) => evaluate(e1) * evaluate(e2)

    def show(expr: Expr): String = expr match
      case Expr.Literal(v) => "" + v
      case Expr.Add(e1, e2) => "(" + show(e1) + " + " + show(e2) + ")"
      case Expr.Multiply(e1, e2) => "(" + show(e1) + " * " + show(e2) + ")"

