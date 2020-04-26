package chapter3.exercises

import chapter3.Cons
import chapter3.List
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

// tag::init[]
fun <A> concat(xxs: List<List<A>>): List<A> =
    foldRight(
        xxs,
        List.empty(),
        { headList, acc ->
            foldRight(
                headList,
                acc,
                { head, acc -> Cons(head, acc) })
        })

fun <A> concat2(xxs: List<List<A>>): List<A> =
    foldRight(
        xxs,
        List.empty(),
        { head, acc ->
            append(head, acc)
        })
// end::init[]

class Exercise_3_14 : WordSpec({
    "list concat" should {
        "oncatenate a list of lists into a single list" {
            concat(
                List.of(
                    List.of(1, 2, 3),
                    List.of(4, 5, 6)
                )
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)

            concat2(
                List.of(
                    List.of(1, 2, 3),
                    List.of(4, 5, 6)
                )
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
        }
    }
})
