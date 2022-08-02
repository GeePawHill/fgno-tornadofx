package org.geepawhill.starter

import javafx.event.EventHandler
import javafx.scene.image.Image
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.paint.Color
import tornadofx.*

const val SCREEN_WIDTH = 800.0
const val SCREEN_HALF = SCREEN_WIDTH / 2.0
const val SCREEN_HEIGHT = 480.0
const val BUCKET_WIDTH = 64.0
const val BUCKET_HEIGHT = 64.0
const val BUCKET_HALF = BUCKET_WIDTH / 2.0

class MakerView : View("Raindrops") {

    val bucket = imageview {
        x = SCREEN_HALF - BUCKET_HALF
        y = SCREEN_HEIGHT - BUCKET_HEIGHT
        image = Image("/bucket.png")
    }

    val keyHandler = EventHandler<KeyEvent> {
        handleKey(it)
    }

    override val root = pane {
        minWidth = SCREEN_WIDTH
        maxWidth = SCREEN_WIDTH
        minHeight = SCREEN_HEIGHT
        maxHeight = SCREEN_HEIGHT
        background = Background(BackgroundFill(Color.LIGHTBLUE, null, null))
        isFocusTraversable = true
        addEventHandler(KeyEvent.KEY_PRESSED) { e: KeyEvent ->
            handleKey(e)
        }
        addEventHandler(MouseEvent.MOUSE_CLICKED) { e: MouseEvent ->
            requestFocus()
        }
        this += bucket
    }

    init {
        root.requestFocus()
    }

    private fun handleKey(event: KeyEvent) {
        when (event.code) {
            KeyCode.A, KeyCode.LEFT -> left()
            KeyCode.D, KeyCode.RIGHT -> right()
            else -> {}
        }
    }

    private fun left() {
        println("l")
    }

    private fun right() {
        println("r")
    }
}