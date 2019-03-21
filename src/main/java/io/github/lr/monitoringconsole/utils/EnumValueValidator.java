package io.github.lr.monitoringconsole.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

/**
 * Validador para el tipo de dato Enum.
 * 
 * @author lravanal
 *
 */
public class EnumValueValidator implements ConstraintValidator<Enum, String> {
    
	private Enum annotation;
 
    @Override
    public void initialize(Enum annotation) {
        this.annotation = annotation;
    }
 
	@Override
	@SuppressWarnings("rawtypes")
    public boolean isValid(String valueForValidation, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;
         
        java.lang.Enum[] enumValues = this.annotation.enumClass().getEnumConstants();
         
        if (enumValues != null && !StringUtils.isEmpty(valueForValidation)) {
            for (java.lang.Enum enumValue : enumValues) {
                String value = enumValue instanceof EnumValue ? ((EnumValue) enumValue).getEnumValue() : enumValue.name();
            	
            	if (valueForValidation.equalsIgnoreCase(value)) {
                    result = true; 
                    break;
                }
            }
        }
         
        return result;
    }
    
}
