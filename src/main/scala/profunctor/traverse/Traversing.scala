package profunctor.traverse

import applicative.ApplicativeSimpleImpl.Applicative
import profunctor.choice.Choice
import profunctor.strong.Strong
import traverse.TraverseSimpleImpl.Traverse


/** Traversing Profunctor
  * Hasekll impl: // http://hackage.haskell.org/package/profunctors/docs/Data-Profunctor-Traversing.html
  **
  *TODO is this the same as Walk ? (what about step from superclass ?)
  **
  *TODO Laws:
  *traverse' ≡ wander traverse
  *traverse' . rmap f ≡ rmap (fmap f) . traverse'
  *traverse' . traverse' ≡ dimap Compose getCompose . traverse'
  *dimap Identity runIdentity . traverse' ≡ id
  */
trait Traversing[P[_,_]] extends Choice[P] with Strong[P] {
  def traverse[A,B,F[_]](pab: P[A,B])(implicit FT: Traverse[F]): P[F[A], F[B]] =
    ??? // TODO implement using wander
  def wander[A,B,S,T,F[_]](f: A => F[B], s: S, ft: F[T], pab: P[A,B])(AF: Applicative[F]): P[S,T] =
    ??? // TODO implement using walk
}

object TraversingInstances {
  // TODO Traversing Profunctor instances https://hackage.haskell.org/package/profunctors-5.3/docs/Data-Profunctor-Traversing.html#i:Traversing
}
