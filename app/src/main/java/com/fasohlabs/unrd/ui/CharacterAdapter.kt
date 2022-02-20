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

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fasohlabs.unrd.databinding.ListItemCharacterBinding
import com.fasohlabs.unrd.domain.models.Character

class CharacterAdapter(private val characters: List<Character>) : RecyclerView.Adapter<CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ListItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size
}

class CharacterViewHolder(private val listItem: ListItemCharacterBinding) : RecyclerView.ViewHolder(listItem.root) {

    fun bind(character: Character) {
        listItem.apply {
            characterName.text = character.name.orEmpty().split(" ").first()
            Glide.with(icon)
                .load(character.image?.resourceUri)
                .into(icon)
        }
    }
}