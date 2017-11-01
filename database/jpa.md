# JPA

## JPA 动态查询

https://docs.spring.io/spring-data/jpa/docs/1.11.7.RELEASE/reference/html/#specifications

## Querydsl and specification

http://blog.csdn.net/ro_wsy/article/details/51345875


## Specification

### Root

Root接口：代表Criteria查询的根对象

### CriteriaBulider

CriteriaBuilder接口：用来构建CritiaQuery的构建器对象

CriteriaBuilder也作为Predicate实例的工厂，通过调用CriteriaBuilder 的条件方法（ equal，notEqual， gt， ge，lt， le，between，like等）创建Predicate对象。


### CriteriaQuery

CriteriaQuery接口：代表一个specific的顶层查询对象，它包含着查询的各个部分，比如：select 、from、where、group by、order by等

调用CriteriaQuery的from方法可以获得Root实例

### 给findAll排序

  ```
  import org.springframework.data.domain.Sort;

@Repository
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll(sortByIdAsc());
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }
} 
  
  ```

















