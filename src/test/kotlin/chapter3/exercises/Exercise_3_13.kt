package chapter3.exercises

import chapter3.Cons
import chapter3.List
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

// tag::append[]
fun <A> append(a1: List<A>, a2: List<A>): List<A> =
    foldRight(a1, a2, { a1Head, a2AsAcc -> Cons(a1Head, a2AsAcc) })
// end::append[]

// tag::appendL[]
fun <A> appendL(a1: List<A>, a2: List<A>): List<A> =
    foldLeft(reverse(a1), a2, { a2AsAcc, a1Head -> Cons(a1Head, a2AsAcc) })
// end::appendL[]

class Exercise_3_13 : WordSpec({
    "list append" should {
        "append two lists to each other using foldRight" {
            append(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
        }
    }

    "list appendL" should {
        "append two lists to each other using foldLeft" {
            appendL(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
        }
    }
})
