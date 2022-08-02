package org.geepawhill.starter

import javafx.animation.AnimationTimer
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

    inner class Timer : AnimationTimer() {
        private var lastFrame = System.nanoTime()
        public var deltaTime = 0.0

        override fun handle(now: Long) {
            deltaTime = (now - lastFrame).toDouble() / 1000000.0
            lastFrame = now
            pulse(deltaTime)
        }
    }

    val timer = Timer()

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
        addEventHandler(KeyEvent.KEY_PRESSED) { event: KeyEvent ->
            handleKey(event)
        }
        addEventHandler(MouseEvent.MOUSE_CLICKED) { _ ->
            requestFocus()
        }
        this += bucket
    }

    init {
        timer.start()
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

    private fun pulse(deltaTime: Double) {
        println(deltaTime)
    }
}