package chapter3.exercises

import chapter3.Cons
import chapter3.List
import chapter3.Nil
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.WordSpec

// tag::setHead[]
fun <A> setHead(xs: List<A>, x: A): List<A> = when (xs) {
    is Nil -> throw IllegalStateException()
    is Cons -> Cons(x, xs.tail)
}
// end::setHead[]

class Exercise_3_2 : WordSpec({
    "list setHead" should {
        "return a new List with a replaced head" {
            setHead(List.of(1, 2, 3, 4, 5), 6) shouldBe
                List.of(6, 2, 3, 4, 5)
        }

        "rethrow an illegal state exception when no head is present" {
            shouldThrow<IllegalStateException> {
                setHead(Nil, 6)
            }
        }
    }
})
