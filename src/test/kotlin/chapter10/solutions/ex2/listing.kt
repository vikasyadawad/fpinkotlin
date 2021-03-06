package chapter10.solutions.ex2

import arrow.core.None
import arrow.core.Option
import arrow.core.orElse
import chapter10.Monoid

//tag::init1[]
fun <A> optionMonoid(): Monoid<Option<A>> = object : Monoid<Option<A>> {

    override fun op(a1: Option<A>, a2: Option<A>): Option<A> =
        a1.orElse { a2 }

    override val zero: Option<A> = None
}

fun <A> dual(m: Monoid<A>): Monoid<A> = object : Monoid<A> {

    override fun op(a1: A, a2: A): A = m.op(a2, a1)

    override val zero: A = m.zero
}

fun <A> firstOptionMonoid() = optionMonoid<A>()

fun <A> lastOptionMonoid() = dual(firstOptionMonoid<A>())
//end::init1[]
