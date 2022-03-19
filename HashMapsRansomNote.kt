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

fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {
    
    val magazineMap = hashMapOf<String, Int?>()
    
    for(i in magazine){
        if(magazineMap.containsKey(i)) magazineMap[i] = magazineMap[i]?.plus(1) 
        else magazineMap[i] = 1
    }
    
    var answer = "Yes"
    
    for (i in note){
        if(!magazineMap.containsKey(i)) answer = "No"
        else{
            magazineMap[i] = magazineMap[i]?.minus(1)
            if(magazineMap[i] == 0) magazineMap.remove(i)
        }
    }
    println(answer)
    
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val m = first_multiple_input[0].toInt()

    val n = first_multiple_input[1].toInt()

    val magazine = readLine()!!.trimEnd().split(" ").toTypedArray()

    val note = readLine()!!.trimEnd().split(" ").toTypedArray()

    checkMagazine(magazine, note)
}
