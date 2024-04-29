import java.util.*

class Receipt(
    val items: List<Item>,
    val employee: Employee,
    val transactionDate: Date
) {
    // Function to calculate the total price of the receipt
    fun calculateTotalPrice(): Double {
        var priceCalculated: Double  = 0.0
        for(i in items){
            priceCalculated += i.price
        }
        return priceCalculated
    }

    // Function to display receipt information
    fun displayInfo() {
        println("Receipt Date: $transactionDate")
        println("Sold by: ${employee.name}")
        println("Items:")
        for (item in items) {
            println("- ${item.name}, Quantity: ${item.quantityInStock}, Price: $${item.price}")
        }
        println("Total Price: $${calculateTotalPrice()}")
    }
}