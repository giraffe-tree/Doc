# 深入思考 JPA


## CrudRepository

## PagingAndSortingRepository


## @RepositoryDefinition

## 思考


1. 解释为什么 repository 不用写实现类

	SimpleJpaRepository

2. 为什么可以通过名称来进行查询

	例如:

	```
		User findByName(String name);
	```
	
	spring-data-jpa会根据方法的名字来自动生成sql语句

3. 关于 in 效率不高

	在日常手动写sql的时候有in这种查询是比较多的，比如select * from user t where t.id in (1, 2, 3)；有人说in的效率不高，要少用，但是其实只要in是主键，或者说是带有索引的，效率是很高的

4. repository 的返回类型

5. repository 中只有 save 方法, 那么 spring data jpa 是怎么区分插入和更新的呢?

[How do I update an entity using spring-data-jpa?](https://stackoverflow.com/questions/11881479/how-do-i-update-an-entity-using-spring-data-jpa)



https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.multiple-modules.types






