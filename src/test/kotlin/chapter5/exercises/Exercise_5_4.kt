package chapter5.exercises

import chapter5.Boilerplate.foldRight
import chapter5.Cons
import chapter5.Empty
import chapter5.Stream
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

//tag::init[]
fun <A> Stream<A>.forAll(p: (A) -> Boolean): Boolean =
    foldRight({ true }, { a, b -> p(a) && b() })
//end::init[]

fun <A> Stream<A>.forAll2(p: (A) -> Boolean): Boolean =
    when (this) {
        is Empty -> true
        is Cons -> p(this.h()) && this.forAll(p)
    }

/**
 * Re-enable the tests by removing the `` prefix
 */
class Exercise_5_4 : WordSpec({

    "Stream.forAll" should {
        "ensure that all elements match the predicate" {
            val s = Stream.of(1, 2, 3, 4, 5)
            s.forAll { it < 6 } shouldBe true
            s.forAll2 { it < 6 } shouldBe true
        }
        """stop evaluating if one element does not satisfy
            the predicate""" {
            val s = Stream.of(1, 2, 3, 4, 5)
            s.forAll { it != 3 } shouldBe false
            s.forAll2 { it != 3 } shouldBe false
        }
    }
})
