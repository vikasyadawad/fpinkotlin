package chapter5.exercises

import chapter3.List
import chapter3.Nil
import chapter3.exercises.reverse
import chapter5.Cons
import chapter5.Empty
import chapter5.Stream
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

/**
 * Re-enable the tests by removing the `!` prefix!
 */
class Exercise_5_1 : WordSpec({
    //tag::init[]
    fun <A> Stream<A>.toList(): List<A> =
            when (this) {
                is Empty -> Nil
                is Cons -> chapter3.Cons(this.h(), this.t().toList())
            }

    fun <A> Stream<A>.safeToList(): List<A> {
        tailrec fun go(stream: Stream<A>, acc: List<A>): List<A> =
                when (stream) {
                    is Empty -> acc
                    is Cons ->
                        go(stream.t(), chapter3.Cons(stream.h(), acc))
                }
        return reverse(go(this, Nil))
    }
    //end::init[]

    "Stream.toList" should {
        "force the stream into an evaluated list" {
            val s = Stream.of(1, 2, 3, 4, 5)
            s.toList() shouldBe List.of(1, 2, 3, 4, 5)
        }
    }
})
