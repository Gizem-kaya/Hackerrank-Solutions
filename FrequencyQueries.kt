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


fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    
    var outputArray: MutableList<Int> = arrayListOf()
    var operationArray: MutableList<Int> = arrayListOf()
    
    for (i in queries){
        when(i[0]){
            1 -> operationArray.add(i[1])
            2 -> operationArray.remove(i[1])
            3 ->{
                var found = 0
                for(j in operationArray){
                   if(Collections.frequency(operationArray, j) == i[1]){
                       operationArray.remove(i[1])
                       found = 1
                       break
                   }                       
                }
                outputArray.add(found)
            } 
        }
    }

    return outputArray.toTypedArray()
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    val queries = Array<Array<Int>>(q, { Array<Int>(2, { 0 }) })

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val ans = freqQuery(queries)

    println(ans.joinToString("\n"))
}
