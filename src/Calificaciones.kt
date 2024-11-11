//Programa que gestiona las calificaciones de un alumno
data class Estudiante(val name:String, val scores:List<Float>)
val estudiantes = mutableListOf<Estudiante>()
fun registerStudent():Estudiante{
    val scores = mutableListOf<Float>()
    println("Nombre del estudiante: ")
    val name = readln()
    println("Ingresar Calificaciones")
    for(i in 1..3){
        print("Calificacion $i:")
        val score = readlnOrNull()?.toFloat()
        if (score != null) {
            scores.add(score)
        }
    }

    return Estudiante(name,scores)
}

fun averageScores():Double?{
    println("Nombre de Estudiante: ")
    val name = readln()
    val student = estudiantes.find { it.name == name }
    val average: Double? = student?.scores?.average()
    return average
}

fun totalAverage():Double {
    val TotalAvarege = estudiantes.flatMap { it.scores }
    val avarage:Double = TotalAvarege.average()
    return avarage
}

fun main(){
    do{
        println("Menu de Opciones")
        println("1. Agregar estudiante con calificaciones")
        println("2. Calcular Promedio de algun Estudiante")
        println("3. Calcular Promedio general")
        println("4. Salir")
    val option = readlnOrNull()?.toInt()
    when(option){
        1 -> estudiantes.add(registerStudent())
        2 -> println(averageScores())
        3 -> println(totalAverage())
    }
    }while (option!=4)

}