import java.text.SimpleDateFormat

fun main() {
    // Create some sample employees
    val employee1 = Employee(1, "John Doe", "Cashier", "Checkout", 2500.0)
    val employee2 = Employee(2, "Jane Smith", "Sales Associate", "Electronics", 2800.0)
    val employee3 = Employee(3, "Emily Johnson", "Store Manager", "Management", 3500.0)
    val employee4 = Employee(4, "Michael Williams", "Sales Manager", "Sales", 3200.0)

    // Create some sample items
    val item1 = Item(1, "T-shirt", "Clothing", 15.99, 100, 10)
    val item2 = Item(2, "Laptop", "Electronics", 999.99, 500, 50)
    val item3 = Item(3, "Book", "Books", 9.99, 150, 100)
    val item4 = Item(4, "Sneakers", "Clothing", 49.99, 300, 30)
    val item5 = Item(5, "Smartphone", "Electronics", 699.99, 750, 15)
    val item6 = Item(6, "Headphones", "Electronics", 99.99, 600, 10)

    val dateFormat = SimpleDateFormat("dd/MM/yyyy")

    val receipt1 = Receipt(listOf(item1, item2), employee1, dateFormat.parse("15/04/2024"))
    val receipt2 = Receipt(listOf(item3), employee2, dateFormat.parse("13/04/2024"))
    val receipt3 = Receipt(listOf(item4, item5), employee3, dateFormat.parse("10/04/2024"))
    val receipt4 = Receipt(listOf(item6), employee4, dateFormat.parse("29/03/2024"))
    val receipt5 = Receipt(listOf(item1, item3, item5), employee1, dateFormat.parse("13/04/2024"))


    //pbkav
    receipt1.displayInfo()

    // TODO -> wrangling data! :]
    /**
     * Put together all the receipts. Then perform the following operations:
     * - Group up all receipts by their date.
     * - In another group, group up all receipts by their employee
     *
     * - From each group, find which entry in the group has the highest amount of money received.
     * For example if it's a group by date, which date had the most sales in money. Alternatively, for grouping by
     * employees, which employees earned the most.
     *
     * - Find which item/items were sold the most (in quantity), or count how many items were sold from each item type
     * - Finally find which items earned the most money
     */
}