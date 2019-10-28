fun main() {
    val employees = listOf(
        SalariedEmployee("Matt", "prez", 6),
        SalariedEmployee("Ben", "senior prez", 6),
        SalariedEmployee("Brad", "super senior prez", 6),
        SalariedEmployee("Ryan", "associate prez", 6)
    )
    employees.forEach { (name, title, _) ->
        println("Employee: $title $name")
    }

    val employeesB = mutableListOf<Employee>()
    employeesB.addAll(employees)
    employeesB.add(Contractor("Mohit", "contractor", "berk"))
    employeesB.add(Manager("Jane", "grandmaster", employees))
    employeesB.forEach { employee ->
        when (employee) {
            is SalariedEmployee -> println(employee.salary)
            is Contractor -> println(employee.location)
            is Manager -> println(employee.employees.size)
        }
    }
}

sealed class Employee(open val name: String, open val title: String)

data class SalariedEmployee(
    override val name: String,
    override val title: String,
    val salary: Int
) : Employee(name, title)

data class Contractor(
    override val name: String,
    override val title: String,
    val location: String
) : Employee(name, title)

data class Manager(
    override val name: String,
    override val title: String,
    val employees: List<Employee>
) : Employee(name, title)
