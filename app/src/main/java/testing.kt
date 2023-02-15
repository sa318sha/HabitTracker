
interface Test{
    fun hi()
}

class Testing: Test {

    var hello: String = "abc"
    override fun hi() {
        TODO("Not yet implemented")
    }


}

fun hello(){
    var temp: Test = Testing()
    temp.hi()

}