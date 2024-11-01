//Programa que simula juego Piedra Papel o Tijera
import kotlin.random.Random
fun turnoMaquina(juego:String, azar:Int):Int{
    var maquina = ""
    var usuario = 0
    when(azar){
        1->maquina="Piedra"
        2->maquina="Papel"
        3->maquina="Tijeras"
    }
    println("Elegi $maquina")
    when (juego){
        "Piedra"-> usuario=1
        "Papel"-> usuario=2
        "Tijeras"-> usuario=3
    }
    if (usuario==azar){
        return 0
    }
    if(usuario == 1){
        when(azar){
            2->return 2
            3->return 1
        }
    }
    if (usuario==2){
        when(azar){
            1->return 1
            3->return 2
        }
    }

    if (usuario==3){
        when(azar){
            1->return 2
            2->return 1
        }
    }

    return -1
}

fun imprimir(saludo:String){
    for (i in saludo){
        print(i)
        Thread.sleep(100)
    }
    println(" ")
}

fun main(){
    var azar:Int
    var puntajeUsuario=0
    var puntajeMaquina=0
    var resultado:Int
    val saludo = "Piedra, Papel o Tijeras con KOTLIN!"
    imprimir(saludo)
    var opcion:String
    val despedida = "Gracias por Jugar"
    do {

        println("Elige, Piedra, Papel o Tijeras")
        val juego = readln()
        azar = Random.nextInt(1,4)
        resultado=turnoMaquina(juego,azar)
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