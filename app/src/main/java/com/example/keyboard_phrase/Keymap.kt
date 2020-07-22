//package com.example.keyboard_phrase
//
//interface KeymapHolder {
//    val keys: Set<Int>
//    fun getKeyInfo(indexId: Int): KeyInfo
//}
//
//class Keymap : KeymapHolder {
//    private val list: Map<Int, KeyInfo> = mapOf(
//        R.id.key_1 to KeyInfo.Num1,
//        R.id.key_2 to KeyInfo.Num2,
//        R.id.key_3 to KeyInfo.Num3,
//        R.id.key_4 to KeyInfo.Num4,
//        R.id.key_5 to KeyInfo.Num5,
//        R.id.key_6 to KeyInfo.Num6,
//        R.id.key_7 to KeyInfo.Num7,
//        R.id.key_8 to KeyInfo.Num8,
//        R.id.key_9 to KeyInfo.Num9,
//        R.id.key_10 to KeyInfo.Num0,
//        R.id.key_11 to KeyInfo.Num1,
//        R.id.key_12 to KeyInfo.Num2,
//        R.id.key_13 to KeyInfo.Num3,
//        R.id.key_14 to KeyInfo.Num4,
//        R.id.key_15 to KeyInfo.Num5,
//        R.id.key_16 to KeyInfo.Num6,
//        R.id.key_17 to KeyInfo.Num7,
//        R.id.key_18 to KeyInfo.Num8,
//        R.id.key_19 to KeyInfo.Num9,
//        R.id.key_20 to KeyInfo.Num0
//    )
//
//    override val keys = list.keys
//
//    override fun getKeyInfo(indexId: Int): KeyInfo {
//        return list.getOrDefault(indexId, KeyInfo.Null)
//    }
//}