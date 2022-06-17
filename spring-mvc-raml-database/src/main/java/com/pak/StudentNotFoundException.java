package com.pak;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author OM PRAKASH
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Student with given id found")
public class StudentNotFoundException extends RuntimeException {

}
