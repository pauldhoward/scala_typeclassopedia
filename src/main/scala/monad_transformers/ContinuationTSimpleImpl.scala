package monad_transformers

import monad.MonadSimpleImplementation.Monad

import scala.language.higherKinds

object ContinuationTSimpleImpl {

  /** Continutation monad */
  trait Cont[M[_],A] {
    def run[Z](f: A => M[Z]): M[Z]
  }

  def contInstance[M[_]]: Monad[Cont[M, ?]] = new Monad[Cont[M, ?]] {
    def pure[A](a: A): Cont[M, A] = new Cont[M,A] {
      def run[Z](f: A => M[Z]): M[Z] = f(a)
    }

    def map[A, B](x: Cont[M, A])(f: A => B): Cont[M, B] = new Cont[M, B] {
      def run[Z](ff: B => M[Z]): M[Z] = x.run(f andThen ff)
    }
  }

  /** Continutation monad transformer */
  trait ContT[R, M[_], A] {
    def runContT(amr: A => M[R]): M[R]
  }

  object ContT {
    def apply[A,R](f: A => R) = ???
  }
}
