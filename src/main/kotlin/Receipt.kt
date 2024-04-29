import java.util.*

class Receipt(
    val items: List<Item>,
    val employee: Employee,
    val transactionDate: Date
) {
    // Function to calculate the total price of the receipt
    fun calculateTotalPrice(): Double {
        // TODO implement

        return 0.0
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