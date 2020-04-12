package com.github.vlsidlyarevich.spring5homework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {
    private String id;
    private String recipeNotes;
}