package com.delphiclab.damfu.domain.usecase

import com.delphiclab.damfu.data.repo.EmojiRepository
import javax.inject.Inject

class GetAllEmojiUseCase @Inject constructor(
    private val emojiRepository: EmojiRepository
) {

    suspend operator fun invoke() =
        emojiRepository.getAllEmoji()

}