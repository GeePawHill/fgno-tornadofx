package org.geepawhill.starter

import tornadofx.*

class MakerMain : App(MakerView::class)

fun main(args:Array<String>) {
    launch<MakerMain>(args)
}