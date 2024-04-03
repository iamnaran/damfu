package com.delphiclab.damfu.core

class DamfuConfig private constructor(builder: Builder) {
    var showPicker: Boolean = true
        private set

    var recentEmojiSize: Int = 30
        private set

    init {
        showPicker = builder.showPicker
        recentEmojiSize = builder.recentEmojiSize
    }

    // Builder class for DamfuConfig
    class Builder {
        var showPicker: Boolean = true
            private set

        var recentEmojiSize: Int = 30
            private set

        fun showPicker(showPicker: Boolean) = apply { this.showPicker = showPicker }

        fun recentEmojiSize(recentEmojiSize: Int) = apply { this.recentEmojiSize = recentEmojiSize }

        // Build method to create a DamfuConfig instance
        fun build() = DamfuConfig(this)
    }
}