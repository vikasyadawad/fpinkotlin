package chapter3.exercises

import chapter3.Cons
import chapter3.List
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

// tag::reverse[]
fun <A> reverse(xs: List<A>): List<A> =
    foldLeft(xs, List.empty(), { a, b -> Cons(b, a) })
// end::reverse[]

class Exercise_3_11 : WordSpec({
    "list reverse" should {
        "reverse list elements" {
            reverse(List.of(1, 2, 3, 4, 5)) shouldBe
                List.of(5, 4, 3, 2, 1)
        }
    }
})
