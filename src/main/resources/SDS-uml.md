#Fitness Booking App UML - Component Diagram

```plantuml

package "Front-end"{


    



}

package "Fitness-API"{


    package "Service Layer"{
        [Booking Controller]
        [Fitness Class Controller]
        [Search Controller]

    }

    package "Database layer"{
        [Fitness Data DB]
    }



}

```