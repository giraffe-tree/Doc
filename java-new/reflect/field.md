# Field

## Class.getDeclaredFields() / Class.getFields()

https://stackoverflow.com/questions/16966629/what-is-the-difference-between-getfields-and-getdeclaredfields-in-java-reflectio

```java
public static Iterable<Field> getFieldsUpTo(@Nonnull Class<?> startClass, 
	@Nullable Class<?> exclusiveParent) {

	List<Field> currentClassFields = Lists.newArrayList(startClass.getDeclaredFields());
	Class<?> parentClass = startClass.getSuperclass();

	if (parentClass != null && !parentClass.equals(exclusiveParent)) {
		List<Field> parentClassFields = 
		(List<Field>) getFieldsUpTo(parentClass, exclusiveParent);
		currentClassFields.addAll(parentClassFields);
	}

	return currentClassFields;
}
```






