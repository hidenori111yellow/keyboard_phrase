package com.example.keyboard_phrase

import android.annotation.SuppressLint
import android.content.ClipDescription
import android.inputmethodservice.InputMethodService
import android.os.Build
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import androidx.core.view.inputmethod.InputConnectionCompat
import androidx.core.view.inputmethod.InputContentInfoCompat


class CustomIME : InputMethodService(), View.OnTouchListener {
    private var currentKeyId = 0

    @SuppressLint("InflateParams")
    override fun onCreateInputView(): View {
        return layoutInflater.inflate(R.layout.keyboard, null)
    }

    override fun onStartInputView(info: EditorInfo?, restarting: Boolean) {
        super.onStartInputView(info, restarting)


    }

    private fun commitText(
        contentUri: Uri,
        imageDescription: String,
        linkUri: Uri
    ) {
        val inputContentInfo = InputContentInfoCompat(
            contentUri,
            ClipDescription(imageDescription, arrayOf("image/png")),
            linkUri
        )
        val inputConnection = currentInputConnection
        val editorInfo = currentInputEditorInfo
        var flags = 0
        if (Build.VERSION.SDK_INT >= 25) {
            flags = flags or InputConnectionCompat.INPUT_CONTENT_GRANT_READ_URI_PERMISSION
        }
        InputConnectionCompat.commitContent(
            inputConnection,
            editorInfo,
            inputContentInfo,
            flags,
            null
        )
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
}