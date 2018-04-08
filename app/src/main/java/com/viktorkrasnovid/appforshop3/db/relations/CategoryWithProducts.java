package com.viktorkrasnovid.appforshop3.db.relations;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.viktorkrasnovid.appforshop3.db.Entity.Category;
import com.viktorkrasnovid.appforshop3.db.Entity.Product;

import java.util.List;

public class CategoryWithProducts {

    @Embedded
    public Category category;

    @Relation(parentColumn = "id", entityColumn = "category_id")
    public List<Product> products;
}
