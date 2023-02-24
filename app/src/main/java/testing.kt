
interface Observering{
    fun update()
}

class Test: Observering{
    override fun update() {
        TODO("Not yet implemented")
    }

}


class MainData(){
    lateinit var list: MutableList<Observering>


    fun notifyObservers(){
        for ( item in list){
            item.update()
        }
    }
}