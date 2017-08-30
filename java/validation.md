# javax 自定义注解

```
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NullValidator.class)
@Documented
public @interface NullCheck {}

public class NullValidator extends BaseValidator implements ConstraintValidator<NullCheck, Object> {
        initialize(nullcheck)
public boolean isValid(obj,context)
}




```