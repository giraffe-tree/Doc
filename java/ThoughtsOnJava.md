# Thoughts On Java

## 30. how to persist localdatetime 



```
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-java8</artifactId>
    <version>5.2.12.Final</version>
</dependency>

```

## 31. 提升 hibernate 的性能

1. add generate_statistics

2. 使用 native sql query

3. choose a fetchtype -- lazy

	1. fetch join
	2. named entity graph
	3. entityGraph

4. let the database handle data-heavy operations

5. use caches

6. perform updates and deletes in bulks 
 
## 32 how to persist localdate and localdatetime with jpa













