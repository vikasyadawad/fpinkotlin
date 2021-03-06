package chapter10.solutions.ex5

import arrow.core.extensions.list.foldable.foldLeft
import chapter10.sec1.Monoid

//tag::init1[]
fun <A, B> foldMap(la: List<A>, m: Monoid<B>, f: (A) -> B): B =
    la.foldLeft(m.zero, { b, a -> m.op(b, f(a)) })
//end::init1[]
