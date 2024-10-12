package com.backend.utils.paging;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Data
public class ListContent<T> {

    private final List<T> content;

    public ListContent(List<T> content) {
        this.content = CollectionUtils.isEmpty(content) ? Collections.emptyList() : content;
    }

}

