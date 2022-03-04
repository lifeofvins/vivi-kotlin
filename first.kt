public class Person(){
    var name:String?
    var age:Int
    init{
        this.name = null
        this.age = -1
    }
    constructor(name: String?, age: Int) : this(){
        this.name = name
        this.age = age
    }
    override fun equals(other: Any?) : Boolean{
        return other is Person && (this.name == other.name && this.age == other.age)
    }
    operator fun compareTo(other: Person): Int {
        return this.age - other.age
    }
    
    val newToString : ()->String = {this.name + " - " + this.age}
    override fun toString() = this.newToString()
    
    fun counterFun(f:(Int)->Int, x:Int):() -> String {
        var count : Int = 0
        println(this.name + " expects " + x + " and provided " + f(x))
        return fun():String {count++; return "${this.name}> count_x is now ${count}"}        
    }
}

fun<T> printT(item: T) : T {
    println(item)
    return item
}

fun nameSize(p:Person) : Int {
    return p.name!!.length
}

fun ff(n: Int) : Int {
    return n;
}

fun main() {
   var yumi = Person("yumi", 25)
   var vivi = Person("vivi", 24)
   println("yumi.namesize is " + nameSize(yumi))
   val fy: () -> String = yumi.counterFun(::ff, 0)
   val fv: () -> String = vivi.counterFun(::ff, 1)
   println(fy())
   println(fy())
   println(fv())
   println(fv())
   println(fy())
   println(fy())
   println(fv())
   println(fv())
   if(yumi > vivi){
       println("correct #1")
   }
   else{
       println("error #1")
   }
   printT<Person>(yumi)
   if(yumi.equals(vivi)){
       println("error #2")
   }
   else{
       println("correct #2")
   }
   
}
