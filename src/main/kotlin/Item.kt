class Item(
    val id: Int,
    val name: String,
    val category: String,
    val price: Double,
    val weightInGrams: Int,
    var quantityInStock: Int
) {
    // Function to update the quantity of the item in stock
    fun updateStock(quantity: Int) {
        quantityInStock += quantity
        if (quantityInStock < 0) {
            quantityInStock = 0
        }
    }

    // Function to display item information
    fun displayInfo() {
        println("Item ID: $id")
        println("Name: $name")
        println("Category: $category")
        println("Price: $$price")
        println("Quantity in stock: $quantityInStock")
    }
}