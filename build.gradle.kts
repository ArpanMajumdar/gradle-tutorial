// Tasks are actions that execute some code
tasks.register("helloworld") {
    doLast {
        println("Hello World !")
    }
}

tasks.register("upper") {
    doLast {
        val someString = "arpan majumdar"
        println("Original: $someString")
        println("Upper case: ${someString.toUpperCase()}")
    }
}

tasks.register("count") {
    doLast {
        repeat(4) {
            print("$it ")
        }
    }
}

// Declare tasks that depend on other tasks
tasks.register("intro") {
    dependsOn("hello")
    doLast {
        println("I am Gradle")
    }
}

// To add a dependency, the corresponding task doesn't need to exist
tasks.register("taskX") {
    dependsOn("taskY")
    doLast {
        println("taskX")
    }
}

tasks.register("taskY") {
    doLast {
        println("taskY")
    }
}

// Creating tasks dynamically
repeat(4) { index ->
    tasks.register("task$index") {
        doLast {
            println("I am task number $index")
        }
    }
}

tasks.named("task0") { dependsOn("task2", "task3") }


// Adding behaviour to existing tasks
val hello by tasks.registering {
    doLast {
        println("Hello Earth")
    }
}

hello {
    doFirst {
        println("Hello Venus")
    }
}

hello {
    doLast {
        println("Hello Mars")
    }
}

hello {
    doLast {
        println("Hello Jupiter")
    }
}
