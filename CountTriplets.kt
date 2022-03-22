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

// Complete the countTriplets function below.
fun countTriplets(arr: Array<Long>, r: Long): Long {

 var tripletCount = 0.toLong()
 
    for(i in 0..arr.size-1){
        var result1 = findNext(arr.sliceArray(i+1..arr.size-1), r, arr[i])
        if(result1.size > 0 ){
            var result2 = findNext(arr.sliceArray(result1[0]+i+2..arr.size-1), r, arr.sliceArray(i+1..arr.size-1)[result1[0]])
            if(result2.size > 0){
                tripletCount = tripletCount + result2.size-1 + result1.size-1 + 1
            }
        }     
    } 
    
    return tripletCount

}

fun findNext(array: Array<Long>, r: Long, n: Long): MutableList<Int>{
    var list = mutableListOf<Int>()
    var i = 0
    while(i < array.size){
        if(n*r == array[i]) {
            while(i < array.size && (n*r) == array[i]){
                list.add(i)
                i++
            }
            return list
        }
        i++
    }
    return list
}

fun main(args: Array<String>) {
    val nr = readLine()!!.trimEnd().split(" ")

    val n = nr[0].toInt()

    val r = nr[1].toLong()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toLong() }.toTypedArray()

    val ans = countTriplets(arr, r)

    println(ans)
}
