package com.plantify.funding.global.exception.errorcode;

import com.plantify.funding.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum MyFundingErrorCode implements ErrorCode {

    FUNDING_NOT_FOUND(HttpStatus.NOT_FOUND, "펀딩 참여 정보를 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),
    INVALID_FUNDING_AMOUNT(HttpStatus.BAD_REQUEST, "유효하지 않은 펀딩 금액입니다."),
    ALREADY_COMPLETED(HttpStatus.CONFLICT, "이미 완료된 펀딩입니다."),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "접근 권한이 없습니다.");

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
