import java.text.SimpleDateFormat
import java.util.*

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

    val receipts = arrayListOf<Receipt>()

    receipts.add(receipt1)
    receipts.add(receipt2)
    receipts.add(receipt3)
    receipts.add(receipt4)
    receipts.add(receipt5)

    //introduce new class containing date and sum amount
    class DateWithAmount(
        val date: Date? = null,
        var amountSum: Double = 0.0
    ){
        fun addAmt(amt: Double){
            amountSum += amt
        }
    }

    //introduce new class containing date and sum amount
    class EmployeeWithAmount(
        val empId: Int = 0,
        val empName: String? = null,
        var amountSum: Double = 0.0
    ){
        fun addAmt(amt: Double){
            amountSum += amt
        }
    }

    //introduce new class containing date and sum amount
    class ItemsWithPieces(
        val itemId: Int = 0,
        val itemName: String? = null,
        var amountSum: Double = 0.0,
        var pieces: Int = 0
    ){
        fun addPcs(amt: Double){
            pieces ++
            amountSum += amt
        }
    }

    val datesWithAmount = arrayListOf<DateWithAmount>()
    val employeesWithAmount = arrayListOf<EmployeeWithAmount>()
    val itemsWithPieces = arrayListOf<ItemsWithPieces>()

    //create and fill groups
    for (r in receipts){
        //add date with amount
        if (datesWithAmount.firstOrNull { it.date == r.transactionDate } == null){
            val x = DateWithAmount(r.transactionDate, r.calculateTotalPrice())
            datesWithAmount.add(x)
        }
        else{
            datesWithAmount.firstOrNull { it.date == r.transactionDate }?.addAmt(r.calculateTotalPrice())
        }

        //add employee with amount
        if (employeesWithAmount.firstOrNull { it.empId == r.employee.id } == null){
            val x = EmployeeWithAmount(r.employee.id, r.employee.name, r.calculateTotalPrice())
            employeesWithAmount.add(x)
        }
        else{
            employeesWithAmount.firstOrNull { it.empId == r.employee.id }?.addAmt(r.calculateTotalPrice())
        }

        //add items with pieces
        for (i in r.items){
            if (itemsWithPieces.firstOrNull { it.itemId == i.id } == null){
                val x = ItemsWithPieces(i.id, i.name, i.price, 1)
                itemsWithPieces.add(x)
            }
            else{
                itemsWithPieces.firstOrNull { it.itemId == i.id }?.addPcs(i.price)
            }
        }


    }

    datesWithAmount.sortByDescending { it.amountSum  }
    /*
        //print group by date in descending order
        for (da in datesWithAmount){
            println("Receipts at date ${da.date}, sum amount is ${da.amountSum}:")
            for(r in receipts){
                if (r.transactionDate == da.date){
                    r.displayInfo()
                }
            }
            println("---------------------------------")
        }
    */
    println("Date ${datesWithAmount[0].date} was with the biggest daily amount (${datesWithAmount[0].amountSum})!")

    employeesWithAmount.sortByDescending { it.amountSum  }
/*
    //print group by employees in descending order
    for (ea in employeesWithAmount){
        println("Employee #${ea.empId}, sum amount is ${ea.amountSum}:")
        for(r in receipts){
            if (r.employee.id == ea.empId){
                r.displayInfo()
            }
        }
        println("---------------------------------")
    }
*/

    println("Employee ${employeesWithAmount[0].empName} (id:${employeesWithAmount[0].empId}) managed to have the biggest amount (${employeesWithAmount[0].amountSum}) so far!")

    itemsWithPieces.sortByDescending { it.pieces  }
/*
    //print items with number of pieces in descending order
    for (ip in itemsWithPieces){
        println("Item #${ip.itemId} (${ip.itemName}), with pieces of ${ip.pieces}:")
        println("---------------------------------")
    }
 */

    println("Item ${itemsWithPieces[0].itemName} (id:${itemsWithPieces[0].itemId}) has the highest number of pieces sold (${itemsWithPieces[0].pieces}) so far!")

    itemsWithPieces.sortByDescending { it.amountSum  }
    println("Item ${itemsWithPieces[0].itemName} (id:${itemsWithPieces[0].itemId}) has the highest combined amount (${itemsWithPieces[0].amountSum}) so far!")



}