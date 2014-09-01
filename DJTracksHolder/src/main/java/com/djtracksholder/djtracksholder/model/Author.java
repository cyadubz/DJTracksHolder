package com.djtracksholder.djtracksholder.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Вадим on 21.08.2014.
 */
@DatabaseTable(tableName = "author")
public class Author {

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
