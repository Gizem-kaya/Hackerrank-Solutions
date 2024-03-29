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

/*
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 */

fun minimumBribes(q: Array<Int>): Unit {
    
    val queueSize = q.size
    var numOfBribes = 0
    var isChaotic = false
    
    for(i in 0..queueSize-1 ){
        if(q[i] - (i+1) > 2 ) { isChaotic = true }
        val maximum = if (q[i]-2 >0) q[i]-2 else 0
        for(j in maximum..i-1){
            if(q[j] > q[i]) numOfBribes++
        }
    }
    
    
    if(isChaotic) println("Too chaotic") else println(numOfBribes)
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val q = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        minimumBribes(q)
    }
}