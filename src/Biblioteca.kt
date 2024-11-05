//Programa que simula una biblioteca
data class Libro(val nombre:String,val autor:String,val editorial:String,var disponible: Boolean = true)
val listadoLibros = mutableListOf<Libro>()

fun registrarLibros():Libro{
    println("Ingresa los datos de registro: ")
    print("Titulo: ")
    val titulo = readln()
    print("Autor: ")
    val autor = readln()
    print("Editorial: ")
    val editorial = readln()
    return Libro(titulo,autor,editorial)
}


fun prestamoLibros(nombre:String){
    val libro = listadoLibros.find { it.nombre == nombre && it.disponible }
    if(libro!=null){
        libro.disponible = false
        println("Has tomado el libro")
    }else{
        println("El libro $nombre no esta disponible")
    }

}

fun devolverLibros(nombre:String){
    val libro = listadoLibros.find { it.nombre == nombre && !it.disponible}
    if(libro!=null){
        libro.disponible = true
        println("Libro devuelto")
    }else{
        println("El libro $nombre no esta disponible")
    }

}


fun main(){

    val saludo="Bienvenido al Sistema...."
    val despedida = "Saliendo del Sistema....."
    imprimir(saludo)

    do {
        println("Menu de Opciones")
        println("1. Registrar Libro")
        println("2. Prestamo de Libros")
        println("3. Devolucion de Libros")
        println("4. Consulta de Stock")
        println("5. Salir")
        val opcion = readlnOrNull()?.toInt()
        when (opcion){
            1->{
                val nuevoLibro = registrarLibros()
                listadoLibros.add(nuevoLibro)
            }
            2 ->{
                println("Ingresa el nombre del Libro: ")
                val nombre = readln()
                prestamoLibros(nombre)

            }
            3->{
                println("Ingresa el nombre del libro: ")
                val nombre = readln()
                devolverLibros(nombre)
            }
            4->{
                listadoLibros.forEach { i ->
                    println(i)
                }
            }
        }
    }while (opcion!=5)
    imprimir(despedida)
    Thread.sleep(100)
}