
import kotlin.math.*


// defines a class
class complex( var x : Double=0.0, var y : Double=0.0){

    init {
        println("this is one way to define a class")
    }
    fun modulus():Double {
        return sqrt(this.x*this.x+ this.y*this.y)
    }

}


// also defines a class
class complex2 {

    var x : Double = 0.0
    var y : Double = 0.0

    init {
        println("defautl values are $x and $y")
    }

    constructor(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    fun modulus():Double {
        return  hypot(this.x, this.y )
    }
}

fun square(x:Double):Double{
    return x.pow(2)
}


fun dervative(f: (Double)->Double, x:Double ):Double{
    val h = 1e-6
    return (f(x+h)-f(x-h))/(2*h)
}

fun newton( f: (x:Double)->Double, x0:Double):Unit{
    var prev = 0.0
    var x  = x0
    do {
        prev = x
        x -= f(x)/dervative( f, x )
        println(x)
    } while (abs(x-prev)>=1e-4)
}


fun main(arg : Array<String>){
    val a = complex(2.0,3.0)

    val b = complex2(2.0, 3.0)
    println(a.modulus())
    println(b.modulus())
    println(square(3.2))
    println("\nNewton-Raphson method:")
    val fn2: (Double)->Double = { x -> x*x-2 }
    newton(fn2, 0.3)
}