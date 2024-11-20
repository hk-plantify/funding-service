package com.plantify.funding.global.exception.errorcode;

import com.plantify.funding.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum OrganizationErrorCode implements ErrorCode {
    ORGANIZATION_NOT_FOUND(HttpStatus.NOT_FOUND, "조직을 찾을 수 없습니다."),
    INVALID_ORGANIZATION_DATA(HttpStatus.BAD_REQUEST, "유효하지 않은 조직 데이터입니다."),
    ORGANIZATION_ALREADY_EXISTS(HttpStatus.CONFLICT, "조직이 이미 존재합니다.");

    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public HttpStatus getHttpStatus() {
        return null;
    }

    @Override
    public String getMessage() {
        return "";
    }
}
