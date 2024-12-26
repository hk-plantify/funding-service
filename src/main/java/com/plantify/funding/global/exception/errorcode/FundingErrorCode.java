package com.plantify.funding.global.exception.errorcode;

import com.plantify.funding.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum FundingErrorCode implements ErrorCode {

    FUNDING_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 펀딩을 찾을 수 없습니다."),
    FUNDING_ACCESS_DENIED(HttpStatus.FORBIDDEN, "펀딩에 대한 접근 권한이 없습니다."),
    INVALID_FUNDING_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 펀딩 요청입니다."),
    FUNDING_CREATION_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "펀딩 생성에 실패했습니다."),
    FUNDING_UPDATE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "펀딩 수정에 실패했습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
