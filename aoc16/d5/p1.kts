import java.io.File
import java.math.BigInteger
import java.nio.charset.Charset
import java.security.MessageDigest

val input = File("input.txt")

val doorId = input.readText()

val doorIdBytes = doorId.toByteArray(Charset.defaultCharset())
val digest = MessageDigest.getInstance("MD5").digest(doorIdBytes)
val bigInt = BigInteger(1, digest)
val hashtext = "0".repeat(32 - bigInt.toString(16).length) + bigInt.toString(16);

val hashSequence = generateSequence(0, Int::inc).map {  }

println(hashtext)