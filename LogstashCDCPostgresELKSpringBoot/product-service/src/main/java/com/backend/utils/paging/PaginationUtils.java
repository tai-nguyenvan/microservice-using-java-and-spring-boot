package com.backend.utils.paging;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public final class PaginationUtils {
    private static final String HEADER_X_TOTAL_COUNT = "X-Total-Count";
    private static final String HEADER_LINK_FORMAT = "<{0}>; rel=\"{1}\"";

    private PaginationUtils() {
    }

    public static <T> HttpHeaders generatePaginationHttpHeaders(UriComponentsBuilder uriBuilder, Page<T> page) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HEADER_X_TOTAL_COUNT, Long.toString(page.getTotalElements()));
        int pageNumber = page.getNumber();
        int pageSize = page.getSize();
        StringBuilder link = new StringBuilder();
        if (pageNumber < page.getTotalPages() - 1) {
            link.append(prepareLink(uriBuilder, pageNumber + 1, pageSize, "next"))
                    .append(",");
        }
        if (pageNumber > 0) {
            link.append(prepareLink(uriBuilder, pageNumber - 1, pageSize, "prev"))
                    .append(",");
        }
        link.append(prepareLink(uriBuilder, page.getTotalPages() - 1, pageSize, "last"))
                .append(",")
                .append(prepareLink(uriBuilder, 0, pageSize, "first"));
        headers.add(HttpHeaders.LINK, link.toString());
        return headers;
    }

    public static <T> Paging<T> generatePage(Page<T> page) {
        return new Paging<>(page);
    }

    public static <T> ListContent<T> generateListContent(List<T> list) {
        return new ListContent<>(list);
    }

    private static String prepareLink(UriComponentsBuilder uriBuilder, int pageNumber, int pageSize, String relType) {
        return MessageFormat.format(HEADER_LINK_FORMAT, preparePageUri(uriBuilder, pageNumber, pageSize), relType);
    }

    private static String preparePageUri(UriComponentsBuilder uriBuilder, int pageNumber, int pageSize) {
        return uriBuilder.replaceQueryParam("page", Integer.toString(pageNumber))
                .replaceQueryParam("size", Integer.toString(pageSize))
                .toUriString()
                .replace(",", "%2C")
                .replace(";", "%3B");
    }

    public static Pageable buildPageable(Pageable pageable, boolean isGetAll) {
        return isGetAll ? PageRequest.of(0, Integer.MAX_VALUE, pageable.getSort()) : pageable;
    }

    public static Integer buildVarBooleanInOracleDB(Boolean isTrue) {
        if (isTrue == null) {
            return null;
        }
        return isTrue ? 1 : 0;
    }

    public static Pageable buildPageable(int page, int size) {
        return PageRequest.of(page, size);
    }

    public static Pageable buildPageable(Map<String, String> parameters) {
        return buildPageable(
                buildPageable(
                        Integer.parseInt(parameters.getOrDefault("page", "0"))
                        , Integer.parseInt(parameters.getOrDefault("size", "2147483647"))
                )
                , Boolean.parseBoolean(parameters.getOrDefault("isGetAll", "false"))
        );
    }

}
