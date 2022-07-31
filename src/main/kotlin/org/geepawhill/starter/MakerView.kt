package org.geepawhill.starter

import tornadofx.*

class MakerView : View("Hello World (Making)") {
    override val root = stackpane {
        minWidth = 300.0
        minHeight = 250.0
        button("Say 'Hello World'") {
            action {
                println("Hello World!")
            }
        }
    }
}