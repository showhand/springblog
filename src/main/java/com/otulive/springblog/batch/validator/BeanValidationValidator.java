package com.otulive.springblog.batch.validator;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

/**
 * Batch validator to perform validation using Bean Validation API.
 *
 * Created by roger on 14-2-23.
 */
public class BeanValidationValidator<Entry> implements Validator<Entry> {

  @Autowired
  private javax.validation.Validator validator;

  public void validate(Entry value) throws ValidationException {

    Set<ConstraintViolation<Entry>> violations = new HashSet<ConstraintViolation<Entry>>();
    violations = validator.validate(value);
    if (!violations.isEmpty()) {
      throw new ValidationException("Validation failed for " + value + ": " +
                                    violationsToString(violations));
    }
  }

  private String violationsToString(Set<ConstraintViolation<Entry>> violations) {

    StringBuilder violationMessage = new StringBuilder();

    for (ConstraintViolation<Entry> violation : violations) {
      violationMessage.append(violation.getMessage() + "|");
    }

    return violationMessage.toString();
  }

}
