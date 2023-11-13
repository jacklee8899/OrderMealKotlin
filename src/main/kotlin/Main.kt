import java.io.*

var menu: HashMap<String, Item> = HashMap()

data class Item(val id:String, val name:String, val calorie: Int,val price: Int) {
    override fun toString(): String {
        return id + "\t" + name + "\t" + calorie + "\t" + price
    }
}

fun main() {
    mcdonalds()
    printMenu()
}

fun mcdonalds(){
    File("mcdonalds.txt").bufferedReader().lines().forEach {
        val tokens: Array<String> = it.split(",".toRegex()).toTypedArray()
        val item = Item(
            tokens[0],
            tokens[1],
            tokens[2].toInt(),
            tokens[3].toInt())
        menu.put(item.id, item)
    }
}

fun printMenu(){
    for (key in menu.values)
        println(key)
}
