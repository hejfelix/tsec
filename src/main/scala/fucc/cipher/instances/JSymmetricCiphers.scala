package fucc.cipher.instances

import fucc.cipher.core._
import fucc.core.CryptoTag
import cats.instances.either._
import javax.crypto.{Cipher => JCipher, SecretKey => JSecretKey}

import com.softwaremill.tagging.@@

class JSymmetricCiphers[A: CipherAlgo, M: CMode, P: Padding](
    algebra: JSymmetricCipherInterpreter[A, M, P])
    extends CipherPrograms[Either[CipherError, ?], A, M, P, JSecretKey @@ A](
      algebra)

object JSymmetricCiphers {
  def getCipher[A: CipherAlgo, M: CMode, P: Padding] = new JSymmetricCiphers[A, M, P](new JSymmetricCipherInterpreter[A, M, P])
}