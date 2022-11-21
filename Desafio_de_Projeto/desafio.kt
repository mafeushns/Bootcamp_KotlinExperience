enum class Level { BASIC, INTERMEDIARY, ADVANCED }
enum class Post { STUDENT, TEACHER }

data class Users(val fNome: String, val lNome: String, val email: String, val post: Post)

data class EducationalContent(val name: String, val duration: Int, val level: Level)

data class Formation(val nome: String, val contents: List<EducationalContent>, val level: Level) {

    val registered = mutableListOf<Users>()
   
    fun addUser(user: Users) {
         registered.add(user)
    }
   
    fun getAddUser(){
        for(user in registered){
            println("|Nome: ${user.fNome+" "+user.lNome}| - |Email: ${user.email}| - (${user.post})")
        }
    }
   
    fun printEducationalContent(){
        for(cont in contents){
            println("${cont.name} - ${cont.duration}min - (${cont.level})")
        }
    }
}

fun main() {
 	val moduleKotlinB = EducationalContent("Linguagem Kotlin", 120, Level.BASIC)
   val moduleAndroidStudioB = EducationalContent("Fundamentos Android Studio", 120, Level.BASIC)
  	val moduleKotlinI = EducationalContent("Linguagem Kotlin", 180, Level.INTERMEDIARY)
  	val moduleAndroidStudioI = EducationalContent("Fundamentos Multiscreen", 180, Level.INTERMEDIARY)
   
	val contentList = mutableListOf<EducationalContent>()
  		contentList.add(moduleKotlinB)
  		contentList.add(moduleAndroidStudioB)
    	contentList.add(moduleKotlinI)
  		contentList.add(moduleAndroidStudioI)
   
    val luan = Users("Luan","Moraes", "luanmoraes@gmail.com", Post.STUDENT)
    val camili = Users("Camili","Compagnoni", "camilicompagnoni@gmail.com", Post.STUDENT)
    val venilton = Users("Venilto","Falvo", "veniltonfalvo@gmail.com", Post.TEACHER)
   
    val androidTraining = Formation("Formação Android Developer", contentList, Level.INTERMEDIARY)
     
    androidTraining.addUser(luan)
    androidTraining.addUser(camili)
    androidTraining.addUser(venilton)
   
  	println(" -----------------------------------------")
    println("|${androidTraining.nome} - ${androidTraining.level}|")
    println(" -----------------------------------------")
   
    println("Grade do curso")
    println(androidTraining.printEducationalContent())
    println("******************************************")
   
    println("Usuarios cadastrados no curso")
    println(androidTraining.getAddUser())
}