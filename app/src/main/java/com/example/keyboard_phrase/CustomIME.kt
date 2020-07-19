package com.example.keyboard_phrase

import android.annotation.SuppressLint
import android.inputmethodservice.InputMethodService
import android.view.MotionEvent
import android.view.View
import android.widget.Button

class CustomIME : InputMethodService(), View.OnTouchListener {
    private val keymap: KeymapHolder = Keymap()
    private var currentKeyId = 0

    @SuppressLint("InflateParams")
    override fun onCreateInputView(): View {
        return layoutInflater.inflate(R.layout.keyboard, null).also { view ->
            keymap.keys.map { id ->
                view.findViewById<Button>(id).also { it.setOnTouchListener(this) }
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return if (v is Button && event is MotionEvent) {
            when (event.action and MotionEvent.ACTION_MASK) {
                MotionEvent.ACTION_DOWN -> {
                    // 押下したボタンのandroid:idを保持
                    currentKeyId = v.id
                    false
                }
                MotionEvent.ACTION_UP -> {
                    // 押下ボタンに基づいた文字を入力
                    sendKeyEvent(currentKeyId)
                    currentKeyId = 0
                    false
                }
                // タッチ位置が変わったり、複数指でタッチしても
                // 見た目の変化が発生しないようにする
                else -> true
            }
        } else {
            true
        }
    }

    // キー入力。本来はもっとごちゃごちゃするので簡略化。
    private fun sendKeyEvent(id: Int) {
        if (id !in keymap.keys) {
            return
        }

        val keyInfo = keymap.getKeyInfo(id)
        if (keyInfo is KeyInfo.AsciiKeyInfo) {
            sendKeyChar(keyInfo.char)
        }
    }
}