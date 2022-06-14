package com.pets.petsapi.api.pet.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PetExistsByIdValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PetExistsById {
  String message() default "pet com id ${validatedValue} não existe";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
