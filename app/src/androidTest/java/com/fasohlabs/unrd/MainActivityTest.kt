package com.fasohlabs.unrd

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.fasohlabs.unrd.data.testPreviewMediaData
import com.fasohlabs.unrd.domain.repositories.StoryRepository
import com.fasohlabs.unrd.ui.MainActivity
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private val storyRepository: StoryRepository = mockk()

    @After
    fun teardown() {
        clearMocks(storyRepository)
    }

    @Test
    fun testData_isDisplayed_whenPositiveResults_areReturned(): Unit = runBlocking {
        coEvery { storyRepository.fetchMedia(any()) } returns flowOf(testPreviewMediaData)

        // TODO Declare viewmodel dependency with Hilt

        ActivityScenario.launch(MainActivity::class.java)


        Screen.onScreen<MainActivityScreen> {
            txtCharacterName {
                isDisplayed()
            }

            txtCharacterSummary {
                isDisplayed()
            }

            recyclerView {
                isDisplayed()
                firstChild<ItemCharacter> {
                    isDisplayed()
                    iconImg {
                        isDisplayed()
                    }
                    txtName {
                        isDisplayed()

                    }
                }
            }
        }
    }

    class MainActivityScreen: Screen<MainActivityScreen> () {
        val txtCharacterName = KTextView { withId(R.id.story_name)}
        val txtCharacterSummary = KTextView { withId(R.id.short_summary)}
        val recyclerView = KRecyclerView(
            {
                withId(R.id.recyclerView)
            },
            itemTypeBuilder = {
                itemType(MainActivityTest::ItemCharacter)
            }
        )

    }

    class ItemCharacter(parent: Matcher<View>): KRecyclerItem<ItemCharacter>(parent) {
        val iconImg = KImageView {withId(R.id.icon)  }
        val txtName = KImageView {withId(R.id.character_name)  }

    }

}