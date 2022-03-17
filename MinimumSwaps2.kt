import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

fun minimumSwaps(arr: Array<Int>): Int {

    val size = arr.size
    var swapCount = 0
    
    for(i in (size-1) downTo 0){
        if(arr[i] != i+1){
            arr.swapInPlace(arr.indexOf(i+1), i)
            swapCount++
        }
    }
    return swapCount 
}

fun <T> Array<T>.swapInPlace(i1: Int, i2: Int){
  this[i1] = this[i2].also{ this[i2] = this[i1] }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}
