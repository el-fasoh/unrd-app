package com.fasohlabs.unrd.domain.models

import com.google.gson.annotations.SerializedName

data class ApiResult(
    @SerializedName("age_from")
    var ageFrom: Int? = null
//    @SerializedName("age_to")
//    var ageTo: Int? = null,
//    @SerializedName("background_image")
//    var backgroundImage: List<BackgroundImage>? = null,
//    @SerializedName("characters")
//    var characters: List<Character>? = null,
//    @SerializedName("contacts")
//    var contacts: List<Any>? = null,
//    @SerializedName("created")
//    var created: String? = null,
//    @SerializedName("duration")
//    var duration: String? = null,
//    @SerializedName("full_summary")
//    var fullSummary: String? = null,
//    @SerializedName("genre_id")
//    var genreId: Int? = null,
//    @SerializedName("intro_video")
//    var introVideo: List<IntroVideo>? = null,
//    @SerializedName("intro_video_sequence")
//    var introVideoSequence: Int? = null,
//    @SerializedName("is_coming_soon")
//    var isComingSoon: Boolean? = null,
//    @SerializedName("is_early_access")
//    var isEarlyAccess: Boolean? = null,
//    @SerializedName("is_featured")
//    var isFeatured: Boolean? = null,
//    @SerializedName("is_in_testing")
//    var isInTesting: Boolean? = null,
//    @SerializedName("is_owned")
//    var isOwned: Boolean? = null,
//    @SerializedName("is_published")
//    var isPublished: Boolean? = null,
//    @SerializedName("language_id")
//    var languageId: Int? = null,
//    @SerializedName("last_progress_report")
//    var lastProgressReport: Any? = null,
//    @SerializedName("list_image")
//    var listImage: List<ImageX>? = null,
//    @SerializedName("main_character_id")
//    var mainCharacterId: Int? = null,
//    @SerializedName("name")
//    var name: String? = null,
//    @SerializedName("passcode_clue")
//    var passcodeClue: Any? = null,
//    @SerializedName("passcode_value")
//    var passcodeValue: Any? = null,
//    @SerializedName("preview_media")
//    var previewMedia: List<PreviewMedia>? = null,
//    @SerializedName("price")
//    var price: Int? = null,
//    @SerializedName("progress")
//    var progress: Int? = null,
//    @SerializedName("publication_status")
//    var publicationStatus: String? = null,
//    @SerializedName("purchase_date")
//    var purchaseDate: String? = null,
//    @SerializedName("purchased_items")
//    var purchasedItems: List<PurchasedItem>? = null,
//    @SerializedName("release_date")
//    var releaseDate: Any? = null,
//    @SerializedName("release_timezone")
//    var releaseTimezone: Any? = null,
//    @SerializedName("short_summary")
//    var shortSummary: String? = null,
//    @SerializedName("story_end_sequence")
//    var storyEndSequence: Int? = null,
//    @SerializedName("story_id")
//    var storyId: Int? = null,
//    @SerializedName("story_start_sequence")
//    var storyStartSequence: Int? = null,
//    @SerializedName("timelines")
//    var timelines: List<Timeline>? = null,
//    @SerializedName("updated")
//    var updated: String? = null
)