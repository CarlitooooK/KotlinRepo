//Programa que simula una agenda de contactos
data class Agenda(var name:String, var contact:String, var email:String)
val contacts = mutableListOf<Agenda>()

fun addContact():Agenda{
    print("Nombre del contacto: ")
    val name = readln()
    print("Telefono del contacto: ")
    val contact = readln()
    print("Email del contacto: ")
    val email = readln()
    return Agenda(name,contact,email)
}

fun editContact(){
    print("Nombre del contacto: ")
    val name = readln()
    val contact = contacts.find { it.name == name}
    if (contact!=null){
        println("Ingresa al nuevo contacto: ")
        print("Nombre: ")
        val newName = readln()
        print("Telefono: ")
        val newContact = readln()
        print("Email: ")
        val newEmail = readln()
        contact.name = newName
        contact.contact = newContact
        contact.email = newEmail
    }
}
fun searchContact(){
    println("1. Busqueda por nombre")
    println("2. Busqueda por telefono")
    println("3. Busqueda por Email")
    val option = readlnOrNull()?.toInt()
    when(option){
        1->{
            print("Nombre del contacto: ")
            val name = readln()
            val contact = contacts.find { it.name == name}
            if (contact!=null) println(contact)
        }

        2->{
            print("Telefono del contacto: ")
            val contactNumber = readln()
            val contact = contacts.find { it.contact == contactNumber}
            if (contact!=null) println(contact)

        }

        3->{
            print("Email del contacto: ")
            val contactEmail = readln()
            val contact = contacts.find { it.email== contactEmail }
            if(contact!=null) println(contact)
        }
    }

}
fun deleteContact(){
    print("Nombre del contacto: ")
    val name = readln()
    val contact = contacts.removeIf { it.name == name}
    println("Contacto eliminado")
}



fun main(){

    val saludo = "MI AGENDA..."
    val despedida = "Adios!!"
    imprimir(saludo)

    do{
        println("........................")
        println("1. Agregar Contacto")
        println("2. Editar Contacto")
        println("3. Buscar Contacto")
        println("4. Eliminar Contacto")
        println("5. Mostrar Mis Contactos")
        println("6. Salir")
        println("..........................")
        println("Elige tu opcion: ")
        val option = readlnOrNull()?.toInt()

        when(option){
            1-> contacts.add(addContact())
            2-> editContact()
            3-> searchContact()
            4-> deleteContact()
            5-> contacts.forEach { println(it) }
        }

    }while (option!=6)

    imprimir(despedida)


}