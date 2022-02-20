/*
 * Copyright 2022 Unrd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fasohlabs.unrd.ui

import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.fasohlabs.unrd.databinding.ActivityMainBinding
import com.fasohlabs.unrd.domain.models.Story

fun ActivityMainBinding.bind(story: Story) {
    Glide.with(videoPreview)
        .load(story.previewMedia.orEmpty().first().resourceUri)
        .into(videoPreview)
    recyclerView.apply {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter = CharacterAdapter(story.characters.orEmpty())
    }
    shortSummary.text = story.shortSummary
    storyName.text = story.name
    shimmerLayout.isVisible = false
    mainView.isVisible = true
}