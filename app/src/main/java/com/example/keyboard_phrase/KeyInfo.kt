package com.example.keyboard_phrase

import android.view.KeyEvent

sealed class KeyInfo {
    object Null : KeyInfo()

    abstract class AsciiKeyInfo : KeyInfo() {
        abstract val char: Char
        abstract val code: Int
    }

    object Num0 : AsciiKeyInfo() {
        override val char = '0'
        override val code = KeyEvent.KEYCODE_0
    }

    object Num1 : AsciiKeyInfo() {
        override val char = '1'
        override val code = KeyEvent.KEYCODE_1
    }

    object Num2 : AsciiKeyInfo() {
        override val char = '0'
        override val code = KeyEvent.KEYCODE_0
    }

    object Num3 : AsciiKeyInfo() {
        override val char = '1'
        override val code = KeyEvent.KEYCODE_1
    }

    object Num4 : AsciiKeyInfo() {
        override val char = '0'
        override val code = KeyEvent.KEYCODE_0
    }

    object Num5 : AsciiKeyInfo() {
        override val char = '1'
        override val code = KeyEvent.KEYCODE_1
    }

    object Num6 : AsciiKeyInfo() {
        override val char = '0'
        override val code = KeyEvent.KEYCODE_0
    }

    object Num7 : AsciiKeyInfo() {
        override val char = '1'
        override val code = KeyEvent.KEYCODE_1
    }

    object Num8 : AsciiKeyInfo() {
        override val char = '0'
        override val code = KeyEvent.KEYCODE_0
    }

    object Num9 : AsciiKeyInfo() {
        override val char = '1'
        override val code = KeyEvent.KEYCODE_1
    }
}