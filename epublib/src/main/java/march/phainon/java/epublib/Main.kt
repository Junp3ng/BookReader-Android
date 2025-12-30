package march.phainon.java.epublib

import java.io.File
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    var index = 0
    var inputFile: File? = null
    var outputFile: File? = null
    while (index < args.size) {
        val arg = args[index++]
        when (arg) {
            "-i" -> {
                if (index < args.size && !args[index].startsWith("-")) {
                    inputFile = File(args[index++])
                } else {
                    println("you need to set input file with -i option")
                    exitProcess(1)
                }
            }
            "-o" -> {
                if (index < args.size && !args[index].startsWith("-")) {
                    outputFile = File(args[index++])
                } else {
                    println("you need to set output dir with -i option")
                    exitProcess(2)
                }
            }
        }
    }
    if (inputFile == null || outputFile == null) {
        println("-i <input file> and -o <output file> must be set")
        exitProcess(3)
    }
    EpubHelper.unzip(inputFile, outputFile)
}

