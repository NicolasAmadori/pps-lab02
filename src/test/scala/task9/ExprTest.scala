

package task9

import org.junit.*
import org.junit.Assert.*
import Task9.*

val random_value_1 = 5
val random_value_2 = 2

class ExprTest:
  @Test def LiteralEvaluationTest(): Unit = {
    val literal = Expr.Literal(random_value_1)

    assertEquals(random_value_1, Expressions.evaluate(literal))
  }

  @Test def SumEvaluationTest(): Unit = {
    val l1 = Expr.Literal(random_value_1)
    val l2 = Expr.Literal(random_value_2)
    val sum = Expr.Add(l1, l2)
    assertEquals(7, Expressions.evaluate(sum))
  }

  @Test def MultiplicationEvaluationTest(): Unit = {
    val l1 = Expr.Literal(random_value_1)
    val l2 = Expr.Literal(random_value_2)
    val multiplication = Expr.Multiply(l1, l2)
    assertEquals(10, Expressions.evaluate(multiplication))
  }

  @Test def CombinationEvaluationTest(): Unit = {
    val l1 = Expr.Literal(random_value_1)
    val l2 = Expr.Literal(random_value_2)
    val sum = Expr.Add(l1, l2)
    assertEquals(49, Expressions.evaluate(Expr.Multiply(sum, sum)))
  }

  @Test def SumShowTest(): Unit = {
    val l1 = Expr.Literal(random_value_1)
    val l2 = Expr.Literal(random_value_2)
    val sum = Expr.Add(l1, l2)
    assertEquals("(5 + 2)", Expressions.show(sum))
  }

  @Test def MultiplicationShowTest(): Unit = {
    val l1 = Expr.Literal(random_value_1)
    val l2 = Expr.Literal(random_value_2)
    val multiplication = Expr.Multiply(l1, l2)
    assertEquals("(5 * 2)", Expressions.show(multiplication))
  }

  @Test def ConbinationShowTest(): Unit = {
    val l1 = Expr.Literal(random_value_1)
    val l2 = Expr.Literal(random_value_2)
    val sum = Expr.Add(l1, l2)
    assertEquals("((5 + 2) * (5 + 2))", Expressions.show(Expr.Multiply(sum, sum)))
  }