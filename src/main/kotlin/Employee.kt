class Employee(
    val id: Int,
    val name: String,
    val position: String,
    var department: String,
    var salary: Double
) {
    // Function to give a raise to the employee
    fun giveRaise(raiseAmount: Double) {
        salary += raiseAmount
    }

    // Function to display employee information
    fun displayInfo() {
        println("Employee ID: $id")
        println("Name: $name")
        println("Position: $position")
        println("Department: $department")
        println("Salary: $$salary")
    }
}