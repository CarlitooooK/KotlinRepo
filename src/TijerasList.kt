//Programa que simula juego Piedra Papel o Tijera
val games = listOf("Piedra","Papel","Tijeras")
fun machine(juego:String):Int{
    val machine = games.random()
    if (juego == machine){
        return 0
    }
    if((juego == "Piedra")&&(machine == "Tijeras") || (juego=="Tijeras")&&(machine=="Papel")||
        (juego=="Papel")&& machine=="Piedra"){
        return 1
    }

    return 2

}

fun layout(saludo:String){
    for (i in saludo){
        print(i)
        Thread.sleep(100)
    }
    println(" ")
}

fun main(){

    var puntajeUsuario=0
    var puntajeMaquina=0
    var resultado:Int
    val saludo = "Piedra, Papel o Tijeras con KOTLIN!"
    layout(saludo)
    var opcion:String
    val despedida = "Gracias por Jugar"
    do {

        println("Elige, Piedra, Papel o Tijeras")
        val juego = readln()
        resultado=machine(juego)
        when(resultado){
            0->{
                println("Empate!")
                println("Ninguno suma puntos!")
            }
            1-> {
                println("Ganaste")
                println("Sumas un Punto!")
                puntajeUsuario += 1
            }
            2->{
                println("Perdiste")
                println("Genial punto para mi!")
                puntajeMaquina += 1
            }

        }
        println("Jugar de nuevo? (y/n)")
        opcion = readln()
    }while (opcion == "y")
    println("........Puntaje General........")
    println("Tu puntaje: $puntajeUsuario")
    println("Puntaje de la Maquina: $puntajeMaquina")
    println("...............................")
    imprimir(despedida)
}