import kotlin.system.exitProcess
//Programa que simula cajero jeje
const val Contra = "9003"
fun ingresaDinero(saldo:Float,ingreso:Float):Float{
    println("Ingresando $ingreso a la cuenta.")
    Thread.sleep(500)
    return saldo+ingreso
}

fun retiraDinero(saldo: Float,retirar:Float): Float {
    if(retirar>saldo){
        println("Cantidad Insuficiente de fondos para retirar")
        return saldo
    }
    println("Retirando $retirar pesos")
    Thread.sleep(500)
    return saldo-retirar
}

fun validacion(contra:String){
    val procesando = "PROCESANDO NIP ....."
    var i = 4
    do{
        println("Ingresa tu NIP: ")
        val key= readlnOrNull()
        for(j in procesando){
            print(j)
            Thread.sleep(200)
        }
        println()
        if(key!=contra){
            println("NIP INVALIDO")
            i--
            println("Te quedan $i intentos")
        }else{
            println("NIP CORRECTO")
            return
        }
    }while (i>0)
    println("INTENTOS AGOTADOS")
    exitProcess(1)


}



fun main(){
    var saldo = 0.0F
    val saludo="Ingresando al Sistema...."
    println("Bienvenido")
    imprimir(saludo)
    validacion(Contra)
    do {
        println()
        println("...Menu de Opciones...")
        println("1. Ingresar Dinero")
        println("2. Retirar Dinero")
        println("3. Consultar Saldo")
        println("4. Salir")

        val opcion = readlnOrNull()?.toIntOrNull()
        when (opcion){
            1 -> {
                println("Cantidad a Ingresar: ")
                val ingreso = readlnOrNull()?.toFloat() ?: 0.0f
                saldo=ingresaDinero(saldo,ingreso)

            }
            2 -> {
                println("Cantidad de Retiro: ")
                val retirar = readlnOrNull()?.toFloat() ?: 0.0f
                saldo = retiraDinero(saldo,retirar)
            }
            3 -> println(saldo)
        }

    }while (opcion!=4)
    println("Saliendo del Programa")
}


