//Programa que calcula el IMC (peso/altura)
fun calculoIMC(peso:Float,altura:Float):Float{
    return peso/(altura * altura)
}

fun categoryIMC(imc:Float){
    if(imc in (0.0..18.4)){
        println("Peso Bajo")
    }
    if(imc in (18.5..24.9)){
        println("Peso Normal")
    }
    if(imc in (25.0..29.9)){
        println("Sobrepeso")
    }
    if(imc>30.0){
        println("Obesidad")
    }
}
fun printline(saludo:String){
    for (i in saludo){
        print(i)
        Thread.sleep(200)
    }
    println(" ")
}

fun main(){

    val saludo = "Bienvenido..."
    printline(saludo)
    do {
        println("Ingresa tu peso en Kg: ")
        val peso = readln().toFloat()
        println("Ingresa tu altura en mts: ")
        val altura = readln().toFloat()
        val imc=calculoIMC(peso,altura)
        categoryIMC(imc)
        println("Calcular de nuevo? (y/n)")
        val opcion = readln()
    }while (opcion!="n")
    println("Saliendo...")

}
