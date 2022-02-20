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
package com.fasohlabs.unrd.domain.models

import com.google.gson.annotations.SerializedName

data class Story(
    @SerializedName("story_id")
    var storyId: Long? = null,

    @SerializedName("characters")
    var characters: List<Character>? = null,

    @SerializedName("full_summary")
    var fullSummary: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("preview_media")
    var previewMedia: List<PreviewMedia>? = null,

    @SerializedName("short_summary")
    var shortSummary: String? = null,
)