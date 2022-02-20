/*
 * Copyright 2021 Unrd
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

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.fasohlabs.unrd.MainViewModel
import com.fasohlabs.unrd.core.zeroIfNull
import com.fasohlabs.unrd.databinding.ActivityMainBinding
import com.fasohlabs.unrd.domain.models.Story
import com.fasohlabs.unrd.domain.utils.UnrdRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    private var story: Story? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            play.setOnClickListener {
                startActivity(
                    MediaPreviewActivity.getIntent(
                        this@MainActivity,
                        story?.storyId.zeroIfNull()
                    )
                )
            }
        }
        setContentView(binding.root)

        supportActionBar?.hide()
        viewModel.stories.observe(this) {
            binding.shimmerLayout.stopShimmer()
            when (it) {
                is UnrdRequest.Error -> {
                    // Show some user error
                }
                is UnrdRequest.Loading -> {
                    binding.shimmerLayout.startShimmer()
                }
                is UnrdRequest.Success -> {
                    story = it.data
                    binding.bind(it.data)
                }
            }
        }
    }
}